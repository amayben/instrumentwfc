# Timbral Generator
By Tamara Duplantis, Alexander Mayben, and Celeste Jewett

This program generates bitmaps that are locally similar to the input bitmap.  Base code by [Maxim Gumin](https://github.com/mxgmn).

Presentation available [here](https://docs.google.com/presentation/d/1ZgaelACxehbGvmVQtzQAKckEuWAsjyviJKJuH4M4Spw/edit?usp=sharing).

Developed for CMPM 202, Winter 2020, UCSC.

![WFC/PureData](https://i.imgur.com/mgCeSg9.png "Raw WFC output and accompanying Pure Data patch.")

## Directions
1. From the command line, run ```dotnet run WaveFunctionCollapse.csproj```.  The resulting code should generate an image using WFC for encodings of several different synthesized instruments.
2. Go into the directory wfcMatrixGen.  Then, depending on whether you are running 32-bit or 64-bit Windows, go into the application.windows[32/64] directory and run wfcMatrixGen.exe.
3. You will receive a prompt to import an image.  Navigate to the appropriate image and submit it.  Afterward, you should be given a .txt file in the same directory labeled velocityMatrix.txt.
4. Using the Pure Data patch labeled wfc.pd, import the velocity matrix text file to generate your instrument as audio.
