package uce.edu.pa2.api;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain
public class Main {

    public static void main(String... args) {

        Quarkus.run(App.class, args);
    }

    public static class App implements QuarkusApplication{
       
        @Inject
        private ProcesadorCompraService procesadorCompraService;

        @Inject
        private ProcesadorCompraService1 procesadorCompraSerivce1;

        @Inject
        private ProcesadorPedidoService procesadorPedidoService;

        @Override
        public int run(String... args) throws Exception {

            Compra compra1 = new Compra("Jhon Córdova", 100);

            Pedido1 p1 = new Pedido1("Alex Cordova",5);
            this.procesadorPedidoService.procesar(p1);


            //Compra compra2 = new Compra("Alex Córdova", 40);
            //this.procesadorCompraService.procesar(compra1);
            //this.procesadorCompraSerivce1.procesarCompra(compra1);
          
        return 0;
        }
    }
}

