PImage img;
color c;
boolean imageLoaded = false;
boolean arrayFilled = false;
boolean messageDisplayed = false;
ArrayList <ArrayList> ArrayX = new ArrayList <ArrayList>();
final String WHITE = "FFFFFFFF";
final String LIGHT_GRAY = "FFA8A8A8";
final String DARK_GRAY = "FF545454";
final String BLACK = "FF000000";
PrintWriter velocities;

void setup() {
  selectInput("Select a file to process:", "fileSelected");
  velocities = createWriter("velocityMatrix.txt");
}

void fileSelected(File selection) {
  //size(24, 24);
  if (selection == null) {
    println("Window was closed or the user hit cancel.");
  } else {
    println(selection.getAbsolutePath());
    imageLoaded = true;
  }
  img = loadImage(selection.getAbsolutePath());
}

void draw(){
  if(imageLoaded == true && img != null){
    image(img, 0, 0);
    if(arrayFilled == false){
      for(int j = 0; j <= 24; j++){
        ArrayList <Float> ArrayY = new ArrayList<Float>();
        for(int i = 0; i <= 24; i++){
          c = get(j, i);
          print(hex(c));
          if(hex(c).equals(WHITE)){
            ArrayY.add(0.0);
          }else if(hex(c).equals(LIGHT_GRAY)){
            ArrayY.add(0.25);
          }else if(hex(c).equals(DARK_GRAY)){
            ArrayY.add(0.75);
          }else if(hex(c).equals(BLACK)){
            ArrayY.add(1.0);
          }else{
            ArrayY.add(0.5);
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
