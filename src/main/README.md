# Window Graphics

This assignment begins to make programs that are more like what you are used to seeing on computers. Command line interface is still used - and in fact happens invisibly when computers interact - but modern users expect a Graphical User Interface (GUI). 

In this assignment, you will 

- create your own Java file & class
- use inheritance to create a `JFrame` and `JPanel`
- override the `paintComponent` method
- specify locations using coordinates
- draw several basic shapes
- change drawing colors between shapes

## Sample program

Open `JFrameGraphics.java` and run it. You should get a simple window with some shapes and a few words. Nothing fancy, but it illustrates a *lot* of basic concepts.

Read the comments and while you have the window open. We'll go through some of the big ideas here, but you really need to try to puzzle out what things do based on their names.

`public class JFrameGraphics extends JFrame`

You've seen most of this before. The new part is "extends JFrame".

All of Java is built with the notion of *inheritance* and *extension*. Every class is a type of object, in the same sense that in geometry every square, triangle, rectangle, and circle is a type of shape. While squares aren't triangles, they are rectangles. So a square "extends" the properties of rectangles. This is, it has four sides which meet at right angles. And a rectangle "extends" the properties of polygons, etc.

So we're building a new class called `JFrameGraphics` that is a type of `JFrame`. And a `JFrame` is just a name for the type of windows we're used to seeing in computer programs. It has all kinds of things built into it - and unless you need to change that particular thing, there's no need to mess with it!

`public JFrameGraphics()`

In the project that built the Dice class, we learned about constructors. Here, we're creating a constructor that overrides the default one. If we don't change it, `JFrameGraphics` will build a window that is 0 pixels wide and 0 pixels tall, has no title, has a background set by your operating system, and... is invisible.

The method call to `setTitle` does what you think it does. Pass it a string and it will display that string on the title bar.

- This would be a good point to experiment with. Close the window, change the title, and run it again.

The method call to `setSize` also does what you think, but it takes the width first, then the height. The measurement units are pixels. Older computers will have a screen about 1000 pixels wide. Newer computers will have 2000-4000, depending on your settings (setting a laptop to lower resolution should use less power, extending your battery life).

- This would be a good point to experiment with. Close the window, then experiment with different values other than 400.

The method call `setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)` tells Java to close the window when someone closes the window... I've never seen anyone use a different option here, but I'm sure there are some.

The method call `setLocationRelativeTo(null)` tells the `JFrame` to appear centered on the screen. If you have multiple windows open, you can center one inside another using this. If you leave this method call out, Java should default to centering the new window.

`DrawingPanel panel = new DrawingPanel();`

This is probably confusing, as we've never encountered a `DrawingPanel` object before. That's because it's a brand new thing we're defining later in the program. Look down to line 32 or so. That's an example of a local or private class. It is only available inside this program.

In any case, this just instantiates a `DrawingPanel`, which we'll see is a type of `JPanel`. All the action for this project actually takes place inside the methods of `DrawingPanel`.

`panel.setBackground(Color.LIGHT_GRAY);`

This does exactly what it sounds like because someone chose the name of the method well. The `Color` class defines a bunch of values for colors, and you'll need to call them in that format and make sure you import them as shown in the import section.

Among the colors you may use are: BLACK, WHITE, RED, BLUE, GREEN, PINK, ORANGE, CYAN, MAGENTA, DARK_GRAY, GRAY, YELLOW. If you want anything fancier, you'll need to learn how to define custom colors.

`JFrameGraphics frame = new JFrameGraphics();`

Just creates the window from within the `main` method. 

`frame.setVisible(true);`

Until this method call, the window is not visible. It is common practice to set various options for the window before making it visible.

`class DrawingPanel extends JPanel`

Like the `JFrame`, the `JPanel` is a predefined component. Whereas the `JFrame` mostly just has components added to it and figures out how to lay them out, the `JPanel` has actual drawing capabilities.

`@Override`

This notifies the `JPanel` that it should completely ignore any predefined instance of the method that follows in favor of what we're writing.

`protected void paintComponent(Graphics g)`

The only important part of this is that `paintComponent` will be passed a `Graphics` object with the name `g`. This means all of our drawing must be done from the object `g`.

`g.setColor(Color.BLUE)`

We know the background has been set to LIGHT_GRAY. But the color we will "paint" with is set by `setColor`.

`g.fillOval(50, 50, 100, 100)`

There are a large number of methods for drawing. Those that start with "draw" will create the outline of a shape, while those that start with "fill" will color the shape in. An oval is like a circle that can have different height & width.

The 50, 50 gives the x (horizontal) and y (vertical down from the top) coordinates of the upper left corner of the bounding box. The 100, 100 gives the width and height.

`g.fillRoundRect(100, 200, 200, 100, 50, 50)`

Here, the 50, 50 gives the size of the rounding on the corners.

`g.drawString("your name here", 150, 350)`

This will write a string on the component in the current color, with the upper left corner going at 150, 350. If you have time, you may want to experiment with changing the font face and size.

## Making Your Own

That was a lot! But now you're going to duplicate it.

### A New File

Start by creating a new file: in Explorer, right click on the folder JFrameGraphics.java is in, then choose New File. Give the new file a name of the form `MarlinGraphics.java` - but use your last name, of course.

VSCode will add the package & class stuff for you, but you're going to copy a lot from JFrameGraphics.java and then adapt it.

### Top Matter

Put your name & date comment in. Copy the import statements over. Tell it your class `extends JFrame`.

### Constructor & main

Copy the constructor across. Rename it appropriately. 

Copy the main method across. Make sure your new class is not called `JFrameGraphics`, but whatever your new file is called.

Note: Both of those methods should be inside the body of your new class.

### DrawingPanel

Copy the `DrawingPanel` class across after the end of your JFrame code. It has to be outside the last curly brace. This is a `private` class that is used directly by the class above it. In order to avoid conflicts with the original code, we're going to change the name. Double click the word `DrawingPanel`, then right click to get the pop-up menu. Choose the option that says something like "change all occurences". Now make a new name like MyDrawingPanel or NamePanel or whatever. This should change every occurrence in the file.

### Test it!

This should have managed an almost exact copy of the program. Run it to make sure it works. If it doesn't, we'll have to look over it.

## Making It Your Own

Pick an appropriate title for the window. Set the size to something other than 400 x 400. Choose a color for the background.

## Start with a Rectangle

The remaining code is all about changing the method paintComponent! 

Delete the contents of paintComponent after the blue rectangle. It should now look like this.

```
@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    
    // Draw a blue rectangle 
    g.setColor(Color.BLUE);
    g.fillRect(50, 50, 100, 100);
}
```
Experiment with changing the 50, 50 to 0, 0 and 0, 50 and 50, 0 and other values. After each change, test the program to see where it draws the rectangle. Close the window after running it.

Once you have an idea of where this will end up, make a rectangle near the upper right corner. Then experiment with changing the 100, 100 to 50, 50 and 50, 100 and 100, 50 to see what difference each makes. 

When you feel comfortable with that, change it to make a rectangle that is longer than it is tall, but does not run off the side of the window. This may require adjusting the first entries as well. Make note of the values you used for x, y (the position) and w, h (the width & height).

Once you have done that, change `g.fillRect(blah)` to `g.fillRoundRect(50, 50, 100, 100, 25, 25)`. Run this to make sure it works, then change 50, 50 and 100, 100 to  values that look good for your new window size. Experiment with changing 25, 25 to values as low as 5, 5 and as high as 50, 50 to see what difference it makes.

## Signing Your Artwork

Now insert something like this.

```
// Print text in black
g.setColor(Color.BLACK);
g.drawString("your name here", 150, 350);
```

Change "your name here" appropriately. Then change the 150, 350 until you place your name into the rounded rectangle. Increasing or decreasing the first number moves it left & right. Increasing or decreasing the second number moves it up & down. If the rectangle is too small, go back and change the size and position as needed.

Experiment with changing `Color.BLACK` to other colors to see what shows up well on the blue background. Alternately, you could change the color of the rectangle.

## Smiley Face

Add the following code.

```
// Draw a red circle
g.setColor(Color.RED);
g.fillOval(200, 50, 150, 150);

// Draw an arc
g.setColor(Color.WHITE);
g.drawArc(200 + 10, 50 + 10, 150 - 20, 150 - 20, 0, 90);
```
When you run this, it should draw a circle and a quarter circle arc inside it. The 0, 90 refers to positions on the circle from 0 degrees to 360 degrees. By changing values, figure out where 0 is and what direction increasing the values moves it.

Modify this code by changing the 200, 50 (notice that appears more than one place) so the circle appears in the upper left corner of your window. Then modify the code to make the circle yellow and the arc black. Then modify the 0, 90 to get something that looks like a smiley face.

Finally, add two more black ovals to make eyes. The resulty should look like a smiley face. Please note that I'm not being an art critic, but I expect this to look a little like a smiley face - if the eye is in the mouth or something, you could have done better...

Note: A clever way to fiddle with the 200, 50 is to add code like `int xpos = 200; ypos = 50;` and then replace all occurences of the 200 & 50 with `xpos` and `ypos`. The advantage of this is that you can then edit the 200 in one place and it will change all the other places!

## Draw a Triangle

Add the following code.

```
// Set the drawing color
g.setColor(Color.PINK);

// Define the points of the triangle
int[] xPoints = {50, 70, 110};
int[] yPoints = { 0, 30,  30};

g.drawPolygon(xPoints, yPoints, xPoints.length);
```

The arrays `xPoints` and `yPoints` hold the x and y coordinates, respectively, of vertices of a triangle.

Experiment with changing the coordinates to move the triangle to the lower right corner of the window. To do this, add the same value to all the `xPoints` and run it - this should move things to the right. Experiment with adding more or subtracting. When you have it where you want it horizontally, add a number to all the `yPoints` and run it. Experiment until you get all your points in the lower right corner and have roughly preserved the star. Again, I'm not going to play art critic, but lower right corner counts for something here.

Try changing the drawPolygon to fillPolygon.

## Open Ended

Now, let's open this up to your creativity! You know how to draw circles, rectangles, arcs, and polygons. You can also draw a line like this: `g.drawLine(startx, starty, endx, endy)`. Draw something fun! It doesn't have to be a great art project, just something you want to do. But put *something* in the lower left corner.

## Wrapping Up

That should give you a feel for the graphics. Make sure you have comments to help you remember what this did when you return to the program later. Then save it, stage it, commit it, and sync it.

Take a screenshot using Command-Control-4 and spacebar on a Mac or Alt-PrtScn on Windows. Paste this in Canvas. Also go to GitHub and copy the URL of your repo (like you did to clone a repo onto a new machine) and paste it into the window in Canvas. This helps me out in case you had trouble getting it turned in.
