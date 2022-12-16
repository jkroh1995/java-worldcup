package worldcup;

import worldcup.controller.SystemController;

public class Application {
    public static void main(String[] args) {
        System.out.println("카타르 월드컵 조별리그 결과\n");
        new SystemController().run();
    }
}