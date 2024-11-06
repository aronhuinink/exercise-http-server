package nl.han.dea.http;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer implements Runnable {

    private int tcpPort;

    private Socket acceptedSocket;

    public HttpServer(Socket acceptedSocket) {
        this.acceptedSocket = acceptedSocket;
    }

    public HttpServer(int tcpPort) {
        this.tcpPort = tcpPort;
    }

    public static void main(String[] args) {
        new HttpServer(8383).startServer();
    }

    public void startServer() {

        HttpServer server = new HttpServer(tcpPort);


        while(true) {

            try (
                    var serverSocket = new ServerSocket(this.tcpPort);
            ) {


                System.out.println("Server accepting requests on port " + tcpPort);

                Socket clientSocket = serverSocket.accept();

                Thread t = new Thread(new HttpServer(clientSocket));
                t.start();


            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public void run() {
        System.out.println("running thread " + Thread.currentThread().getId());

        var connectionHandler = new ConnectionHandler(acceptedSocket);
        connectionHandler.handle();
    }
}
