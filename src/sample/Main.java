package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Field;

public class Main extends Application {

  private static Stage primaryStage;

  @Override
  public void start(Stage primaryStage) throws Exception {
    Main.primaryStage = primaryStage;
    switchScene("sample.fxml");
  }

  private static class Foo {
    final int i;

    public Foo(int i) {
      this.i = i;
    }
  }

  public static void switchScene(String fxmlName) {
    Parent root = null;
    try {
      root = FXMLLoader.load(Main.class.getResource(fxmlName));
      primaryStage.setTitle("Hello World");
      Scene scene = new Scene(root, 300, 275);
      scene.getStylesheets().add("sample/example.css");
      primaryStage.setScene(scene);
      primaryStage.show();
    } catch (IOException e) {
      e.printStackTrace();
    }

    try {
      final Foo foo = new Foo(1);
      Field i = Foo.class.getDeclaredField("i");
      i.setAccessible(true);
      i.set(foo, 2);
      System.out.println(foo.i);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static void printI(int i) {
    System.out.println(i);
  }


  public static void main(String[] args) {
    launch(args);
  }
}
