import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Display extends JFrame {

    private Canvas canvas;
    //private Collision collision;

    public Display(int width, int height, Input input){
        setTitle("MyFoodSolver");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setFocusable(false);
        add(canvas);
        addKeyListener(input);
        pack();

        canvas.createBufferStrategy(3);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void render(Game game){
        BufferStrategy bufferStartegy = canvas.getBufferStrategy();
        Graphics graphics = bufferStartegy.getDrawGraphics();

        //graphics.setColor(Color.BLUE);
        graphics.fillRect(0, 0, canvas.getWidth(),canvas.getHeight());

        game.getGameObject().forEach(gameObject -> graphics.drawImage(
                gameObject.getSprite(),
                gameObject.getPos().getX(),
                gameObject.getPos().getY(),null
        ));

//Dette sætter en rød firkant (player) ind som flytter sig til venstre
        game.getGameObject().forEach(gameObject -> graphics.drawImage(
                gameObject.getSprite(),
                gameObject.getPosition().getX(),
                gameObject.getPosition().getY(),
                //gameObject.getPos().getX(),
                //gameObject.getPos().getY(),
                null

        ));



        //System.out.println(game.getGameObject().toString());




        //System.out.println(game.getGameObject().);



    /*   game.getGameObject().forEach(FoodObject -> graphics.drawImage(
                FoodObject.getSprite(),
                FoodObject.getPosition().getX(),
                FoodObject.getPosition().getY(),
                //gameObject.getPos().getX(),
                //gameObject.getPos().getY(),
                null

        ));

       game.getGameObject().forEach(playerObject ->graphics.drawImage(
                playerObject.getSprite(),
                playerObject.getPos().getX(),
                playerObject.getPos().getY(),
                null
        ));*/

        //Dette sætter en rød firkant (player) ind som flytter sig til venstre
        /*game.getGameObject().forEach(gameObject ->graphics.drawImage(
                gameObject.getSprite(),
                gameObject.getPos().getX(),
                gameObject.getPos().getY(),
                null
        ));*/


        graphics.dispose();
        bufferStartegy.show();


    }


}
