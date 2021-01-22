package com.aditya.sinewave;

import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;

public class PlayWave {
    private final int SAMPLE_RATE=44100;
    private AudioTrack audioTrack;
    private int SampleCount;

    int bufferSize= AudioTrack.getMinBufferSize(SAMPLE_RATE,AudioFormat.CHANNEL_OUT_MONO,AudioFormat.ENCODING_PCM_16BIT);
    public PlayWave(){

        audioTrack= new AudioTrack(AudioManager.STREAM_MUSIC,SAMPLE_RATE, AudioFormat.CHANNEL_OUT_MONO,AudioFormat.ENCODING_PCM_16BIT,bufferSize,AudioTrack.MODE_STATIC);
    }

    public void SetWave(int Frequency){
        SampleCount= (int)((float)SAMPLE_RATE/Frequency);
        short samples[]= new short[SampleCount];
        int amplitude= 32767;
        double twoPi= 8. * Math.atan(1.);
        double phase=0.0;
        for (int i=0;i<SampleCount;i++){
            samples[i]= (short) (amplitude*Math.sin(phase));
            phase+= twoPi * Frequency/SAMPLE_RATE;

        }
        audioTrack.write(samples,0,SampleCount);


    }

    public void StartWave(){
        audioTrack.reloadStaticData();
        audioTrack.setLoopPoints(0,SampleCount,-1);
        audioTrack.play();

    }

    public  void StopWave(){
        audioTrack.stop();
    }
}
