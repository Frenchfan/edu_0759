import java.io.*;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;


public class Main {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("D://DesktopFiles//Eduproject//edu_0759//" +
                    "6.2_proxy_checker_muti2//ip.txt");
            int i;
            String proxy = "";
            while((i=fis.read()) != -1){
                if(i==13) continue;
                else if(i==10){
                    String ip = proxy.split(":")[0];
                    String port = proxy.split(":")[1];
                    CheckProxy checkProxy = new CheckProxy(ip, Integer.parseInt(port));;
                    checkProxy.start();
                    proxy = "";
                }else if(i!=9){
                    proxy += (char) i;
                }else{
                    proxy += ":";
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static class CheckProxy extends Thread {
        String ip;
        int port;

        public CheckProxy(String ip, int port) {
            super();
            this.ip = ip;
            this.port = port;
        }

        @Override
        public void run(){
            try {
                Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ip, port));
                URLConnection url = new URL("https://vozhzhaev.ru/test.php").openConnection(proxy);
                url.setConnectTimeout(5000);//максимальный таймаут для установления связи
                InputStream is = url.getInputStream();
                InputStreamReader reader = new InputStreamReader(is);
                int i;
                StringBuilder result = new StringBuilder();
                while ((i = reader.read()) != -1) {
                    result.append((char) i);
                }
                System.out.println(result);
                goodiplist(result.toString() + ":" + port);
            } catch (IOException exception) {
                System.out.println(ip + " - не работает!");
            }
        }
    }
    private static void goodiplist(String ipPort) {
        try (FileOutputStream fos = new FileOutputStream("D://DesktopFiles//Eduproject//edu_0759//" +
                "6.2_proxy_checker_muti2//good_ip.txt", true)) {
            String text = ipPort + "\n";
            byte[] buffer = text.getBytes();
            fos.write(buffer);

        }catch (IOException ioException) {
            ioException.printStackTrace();
        }


    }
}

