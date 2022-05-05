package C20424096;

// This visualizer was created by Dominika Adamczewska C20422036

// The inspiration for this was the circles on a classic speaker, made reactive and funky
// NOTE : If audio is paused, the main visualizer will disappear !! Just unpause to see it !!

import ie.tudublin.Visual;

// declare class for my visualizer
public class Domi extends Visual {

    // intialize variables needed
    float n6;
    int hVal = 0;
    float sizes = 0;

    // initialize minim variable, and audio variable
    public void render(VisualSetup v) {

        v.colorMode(RGB);
        v.fill(0); // fill the space in black each time so drawings dont overlap
        v.stroke(random(255), random(255), random(255)); // rainbow colours
        v.strokeWeight((float) 1.7);
        v.rect(0, 0, v.width, v.height); // placement of visualizer
        v.translate(v.width / 2, v.height / 2); // translate to middle

        for (int i = 0; i < v.ap.bufferSize() - 1; i++) {
            float angle2 = sin(i + n6) * 300;

            // x and y axis placement
            float x = sin(radians(i)) * (angle2 + 30);
            float y = cos(radians(i)) * (angle2 + 30);

            // colours i experimented with :)
            // fill(255, 128, 255); // pink
            // fill(255, 255, 255); // white
            // fill(random(255), random(255), random(255)); // rainbow colours !!

            // I decided to not fill these with colour, as I feel it looks cooler/ more
            // trippy that way.
            // But I left the commented code in, in case you'd like to compare :)

            // first sphere of circle particles
            v.circle(x, y, v.ap.right.get(i) * 10);
            v.circle(x, y, v.ap.left.get(i) * 10);

            // second sphere of circle particles
            v.circle(-x, -y, v.ap.right.get(i) * 20);
            // circle(-x, -y, mp3.right.get(i) * 10);

            // third inner sphere of circle particles
            v.circle(-x / 2, -y / 2, v.ap.right.get(i) * 20);

        }

        n6 += 0.04;

        // call on spirals function to draw spirals
        spirals(v);
    }

    public void spirals(VisualSetup v) {
        // I made some spiral type circles to match the theme
        // these do not react to the music themselves, but give that illusion
        sizes = v.random(90); // randomise the circle sizes from 0 - 89

        // top right corner
        v.ellipse(350, -350, sizes, sizes);
        // bottom right corner
        v.ellipse(350, 350, sizes, sizes);
        // top left corner
        v.ellipse(-350, -350, sizes, sizes);
        // bottom left corner
        v.ellipse(-350, 350, sizes, sizes);
        // middle
        v.ellipse(0, 0, sizes, sizes);
    }

}