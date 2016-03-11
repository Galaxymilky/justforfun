package com.httpdemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;

/**
 * @author by niu_ben on 2016/3/11.
 */
public class HttpServer {
    public static void main(String[] args) {
        try {
            //����ServerSocketChannel������8080�˿�
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.socket().bind(new InetSocketAddress(8080));
            //����Ϊ������ģʽ
            ssc.configureBlocking(false);
            //Ϊsscע��ѡ����
            Selector selector = Selector.open();
            ssc.register(selector, SelectionKey.OP_ACCEPT);
            //����������
            while (true) {
                //�ȴ�����ÿ�εȴ�����3s������3s���̼߳�������ִ�У��������0���߲����������һֱ����
                if (selector.select(3000) == 0) {
                    continue;
                }
                //��ȡ�������SelectionKey
                Iterator<SelectionKey> keyIter = selector.selectedKeys().iterator();

                while (keyIter.hasNext()) {
                    SelectionKey key = keyIter.next();
                    //�������̴߳���SelectionKey
                    new Thread(new HttpHandler(key)).run();
                    //������ϣ��Ӵ������SelectionKey���������Ƴ���ǰ��ʹ�õ�key
                    keyIter.remove();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static class HttpHandler implements Runnable {
        private int bufferSize = 1024;
        private String localCharset = "UTF-8";
        private SelectionKey key;

        public HttpHandler(SelectionKey key) {
            this.key = key;
        }

        public void handleAccept() {
            try {
                SocketChannel clientChannel = ((ServerSocketChannel) key.channel()).accept();
                clientChannel.configureBlocking(false);
                clientChannel.register(key.selector(), SelectionKey.OP_READ, ByteBuffer.allocate(bufferSize));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void handleRead() throws IOException {
            //��ȡchannel
            SocketChannel sc = (SocketChannel) key.channel();
            //��ȡbuffer������
            ByteBuffer buffer = (ByteBuffer) key.attachment();
            buffer.clear();
            //û�ж���������ر�
            if (sc.read(buffer) == -1) {
                sc.close();
            } else {
                //������������
                buffer.flip();
                String receivedString = Charset.forName(localCharset).newDecoder().decode(buffer).toString();
                //����̨��ӡ������ͷ
                String[] requestMessage = receivedString.split("\r\n");
                for (String a : requestMessage) {
                    System.out.println(a);
                    //��������˵������ͷ�Ѵ�ӡ��
                    if (a.isEmpty()) {
                        break;
                    }
                }

                //����̨��ӡ������Ϣ
                String[] firstLine = requestMessage[0].split(" ");
                System.out.println();
                System.out.println("Method:\t" + firstLine[0]);
                System.out.println("url:\t" + firstLine[1]);
                System.out.println("HTTP Version:\t" + firstLine[2]);
                System.out.println();
                //���ؿͻ���
                StringBuffer sendString = new StringBuffer();
                sendString.append("HTTP/1.1 200 OK\r\n");//��Ӧ�������С�200��ʾ����ɹ�
                sendString.append("Content-Type:text/html;charset=").append(localCharset).append("\r\n");
                sendString.append("\r\n");//����ͷ�������һ������

                sendString.append("<html><head><title>��ʾ����</title></head><body>");
                sendString.append("���յ��ı����ǣ�<br/>");
                for (String s : requestMessage) {
                    sendString.append(s).append("<br/>");
                }
                sendString.append("</body></html>");

                buffer = ByteBuffer.wrap(sendString.toString().getBytes(localCharset));
                sc.write(buffer);
                sc.close();

            }
        }

        @Override
        public void run() {
            try {
                //���յ���������ʱ
                if (key.isAcceptable()) {
                    handleAccept();
                }

                //������
                if (key.isReadable()) {
                    handleRead();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
