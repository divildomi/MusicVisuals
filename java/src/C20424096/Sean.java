package C20424096;

import ie.tudublin.Visual;

public class Sean {

    // Global session variables
    int width;
    float[] lerpedBuffer;
    float y;
    float smtz;
    float Amp;

    // Assign variables
    public Sean(int width) {
        this.width = width;

        lerpedBuffer = new float[width];

        y = 0;
        smtz = 0;
        Amp = 0;

    }

    public void render(VisualSetup v) {
        // Set smoothness of waves
        v.strokeWeight(17f);

        // Choose colour mode
        v.colorMode(Visual.HSB);

        // Variables for drawing
        float halfheight = v.height / 2;
        float avg = 0;
        float sum = 0;
        Amp = Visual.lerp(Amp, avg, 0.1f);

        for (int i = 0; i < v.getAudioBuffer().size(); i++) {

            sum += Visual.abs(v.getAudioBuffer().get(i));

            lerpedBuffer[i] = Visual.lerp(lerpedBuffer[i], v.getAudioBuffer().get(i), 0.05f);

        }

        // Audio buffer variables
        avg = sum / (float) v.getAudioBuffer().size();
        sum = 0;

        // Make background grey
        v.background(200);

        for (int i = 0; i < v.getAudioBuffer().size(); i++) {

            // Variable to map audio frequency to colours
            float AudioMap = Visual.map(i, 0, v.getAudioBuffer().size(), 150, 255);

            v.stroke(AudioMap, 200, 200);

            float f1 = lerpedBuffer[i] * halfheight * 2.5f;

            // Draw bottom bar
            v.rect(i * 2, halfheight * 1.95f + f1, i, halfheight - f1);

            float f2 = lerpedBuffer[i] * halfheight * 2.5f;

            // Draw top bar
            v.rect(i * 2, 0 + f2, i, 0 - f2);

        }
    }
}