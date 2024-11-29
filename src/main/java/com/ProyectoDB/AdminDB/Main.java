package com.ProyectoDB.AdminDB;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Main extends Application {
public static ConfigurableApplicationContext context;
	public static void main(String[] args) {
		launch();
		SpringApplication.run(Main.class, args);

	}
//	insert into empleado(id_empleado,password,rfc_emp,apellidos_empleado,username,puesto_emp)
//	values(1,'1234','cack030312345','Chan Chalé','kevin','admin');

//	insert into empleado(id_empleado,password,rfc_emp,apellidos_empleado,username,puesto_emp)
//	values(2,'4321','cack124231345','Chan Chin','cervantes','vendedor');
	@Override
	public void start(Stage stage) throws Exception {
		context = SpringApplication.run(Main.class);
		FXMLLoader fxml= new FXMLLoader(getClass().getResource("/java/com/ProyectoDB/AdminDB/InicioSesion.fxml"));
		fxml.setControllerFactory(context::getBean);
		Scene scene = new Scene(fxml.load());

		stage.setScene(scene);
		stage.show();
	}
}
