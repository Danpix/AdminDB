package com.ProyectoDB.AdminDB;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
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

	@Override
	public void start(Stage stage) throws Exception {
		context = SpringApplication.run(Main.class);
		FXMLLoader fxml= new FXMLLoader(getClass().getResource("/java/com/ProyectoDB/AdminDBI/InicioSesionB.fxml"));
		fxml.setControllerFactory(context::getBean);
		Scene scene = new Scene(fxml.load());
		stage.initStyle(StageStyle.UNDECORATED); // <------ quitamos la barra por defecto de arriba del panel
		stage.setScene(scene);
		stage.centerOnScreen(); //<-------------- Obligamos al panel a aparecer en medio de la pantalla
		stage.show();
	}
}
