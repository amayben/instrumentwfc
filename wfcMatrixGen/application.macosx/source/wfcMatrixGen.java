import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class wfcMatrixGen extends PApplet {

PImage img;
int c;
boolean imageLoaded = false;
boolean arrayFilled = false;
boolean messageDisplayed = false;
ArrayList <ArrayList> ArrayX = new ArrayList <ArrayList>();
final String WHITE = "FFFFFFFF";
final String LIGHT_GRAY = "FFA8A8A8";
final String DARK_GRAY = "FF545454";
final String BLACK = "FF000000";
PrintWriter velocities;

public void setup() {
  selectInput("Select a file to process:", "fileSelected");
  velocities = createWriter("velocityMatrix.txt");
}

public void fileSelected(File selection) {
  //size(24, 24);
  if (selection == null) {
    println("Window was closed or the user hit cancel.");
  } else {
    println(selection.getAbsolutePath());
    imageLoaded = true;
  }
  img = loadImage(selection.getAbsolutePath());
}

public void draw(){
  if(imageLoaded == true && img != null){
    image(img, 0, 0);
    if(arrayFilled == false){
      for(int j = 0; j <= 24; j++){
        ArrayList <Float> ArrayY = new ArrayList<Float>();
        for(int i = 0; i <= 24; i++){
          c = get(j, i);
          print(hex(c));
          if(hex(c).equals(WHITE)){
            ArrayY.add(0.0f);
          }else if(hex(c).equals(LIGHT_GRAY)){
            ArrayY.add(0.25f);
          }else if(hex(c).equals(DARK_GRAY)){
            ArrayY.add(0.75f);
          }else if(hex(c).equals(BLACK)){
            ArrayY.add(1.0f);
          }else{
            ArrayY.add(0.5f);
          }
        }
        ArrayX.add(ArrayY);       
      }
      arrayFilled = true;
      imageLoaded = false;
    }
    if(arrayFilled == true && messageDisplayed == false){
      print(ArrayX);
      velocities.print(ArrayX);
      velocities.flush();
      velocities.close();
      exit();
      messageDisplayed = true;    
    }
    //print(hex(c));
  }
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "wfcMatrixGen" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
