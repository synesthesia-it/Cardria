/*===============================================================================
Copyright (c) 2012-2014 Qualcomm Connected Experiences, Inc. All Rights Reserved.

Vuforia is a trademark of QUALCOMM Incorporated, registered in the United States 
and other countries. Trademarks of QUALCOMM Incorporated are used with permission.
===============================================================================*/

package com.qualcomm.vuforia.samples.SampleApplication.utils;

import android.content.Context;

import java.nio.Buffer;

import it.synesthesia.cardboard.R;


public class BugDroid extends MeshObject {

    private Buffer mVertBuff;
    private Buffer mTexCoordBuff;
    private Buffer mNormBuff;
    private Buffer mIndBuff;

    private int indicesNumber = 0;
    private int verticesNumber = 0;

    private Context mContext;

    public BugDroid(Context context) {
        mContext = context;
        setVerts();
        setTexCoords();
        setNorms();
        setIndices();
    }


    private void setVerts() {
//        double[] TEAPOT_VERTS = {
//        };
        String[] data = mContext.getResources().getStringArray(R.array.bugdroid_verts);
        mVertBuff = fillBufferFloatFromString(data);
        verticesNumber = data.length / 3;
    }


    private void setTexCoords() {
//        double[] TEAPOT_TEX_COORDS = {
//        };
        String[] data = mContext.getResources().getStringArray(R.array.bugdroid_coords);
        mTexCoordBuff = fillBufferFloatFromString(data);

    }


    private void setNorms() {
//        double[] TEAPOT_NORMS = {
//        };
        String[] data = mContext.getResources().getStringArray(R.array.bugdroid_norms);
        mNormBuff = fillBufferFloatFromString(data);
    }


    private void setIndices() {
//        short[] TEAPOT_INDICES = {
//        };
        String[] data = mContext.getResources().getStringArray(R.array.bugdroid_indices);
        mIndBuff = fillBufferShortFromString(data);
        indicesNumber = data.length;
    }


    public int getNumObjectIndex() {
        return indicesNumber;
    }


    @Override
    public int getNumObjectVertex() {
        return verticesNumber;
    }


    @Override
    public Buffer getBuffer(BUFFER_TYPE bufferType) {
        Buffer result = null;
        switch (bufferType) {
            case BUFFER_TYPE_VERTEX:
                result = mVertBuff;
                break;
            case BUFFER_TYPE_TEXTURE_COORD:
                result = mTexCoordBuff;
                break;
            case BUFFER_TYPE_NORMALS:
                result = mNormBuff;
                break;
            case BUFFER_TYPE_INDICES:
                result = mIndBuff;
            default:
                break;

        }

        return result;
    }

}
