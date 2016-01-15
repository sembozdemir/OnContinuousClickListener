# OnContinuousClickListener
Very simple continuous click listener implementation for Android

### Screenshots

Coming soon...

## How to add
OnContinuousClickListener is published with [JitPack.io](https://jitpack.io).
To add this library to your project, add these lines to your build.gradle

```
repositories {
  maven { url "https://jitpack.io" }
}

dependencies {
  // ... other dependencies
  compile 'com.github.sembozdemir:OnContinuousClickListener:1.0.0'
}
```

## How to use
It is so simple, just set a long click listener like other click events.

```
button.setOnLongClickListener(new OnContinuousClickListener() {
            @Override
            public void onContinuousClick(View v) {
                // do something here,
                // it will be handled every 500 milliseconds (by default)
            }
        });
```

If you want to change delay time, just give an integer parameter

```
int delay = 100 // 100 milliseconds
button.setOnLongClickListener(new OnContinuousClickListener(delay) {
            @Override
            public void onContinuousClick(View v) {
                // do something here,
                // it will be handled every 100 milliseconds
            }
        });
```

####You can check sample project for better understanding as well.


## Licence
The MIT License (MIT)

Copyright (c) 2015 Semih Bozdemir

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
