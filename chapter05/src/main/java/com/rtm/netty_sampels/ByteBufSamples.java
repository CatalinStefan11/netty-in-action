package com.rtm.netty_sampels;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.StandardCharsets;

public class ByteBufSamples {

  public static void main(String[] args) {
    sliceByteBuf();
    copyByteBuf();
    getAndSetByteBuf();
  }

  private static void sliceByteBuf() {
    ByteBuf buf = Unpooled.copiedBuffer("Netty in Action rocks!", StandardCharsets.UTF_8);
    ByteBuf sliced = buf.slice(0, 14);
    System.out.println(sliced.toString());
    buf.setByte(0, (byte)'J');
    System.out.println(buf.getByte(0) == sliced.getByte(0));
  }

  private static void copyByteBuf() {
    ByteBuf buf = Unpooled.copiedBuffer("Netty in Action rocks!", StandardCharsets.UTF_8);
    ByteBuf sliced = buf.copy(0, 14);
    System.out.println(sliced.toString());
    buf.setByte(0, (byte)'J');
    System.out.println(buf.getByte(0) != sliced.getByte(0));
  }
  
  private static void getAndSetByteBuf(){
    ByteBuf buf = Unpooled.copiedBuffer("Netty in Action rocks!", StandardCharsets.UTF_8);
    System.out.println((char)buf.getByte(0));
    int readerIdx = buf.readerIndex();
    int writerIdx = buf.writerIndex();
    
    buf.setByte(0, (byte)'B');
    System.out.println((char) buf.getByte(0));

    System.out.println(readerIdx == buf.readerIndex());
    System.out.println(writerIdx == buf.writerIndex());
  }
}
