package com.projectthani.wwpbaseobjects ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "SplitScreenDetailInfo", namespace ="ProjectThani")
public final  class StructSdtSplitScreenDetailInfo implements Cloneable, java.io.Serializable
{
   public StructSdtSplitScreenDetailInfo( )
   {
      this( -1, new ModelContext( StructSdtSplitScreenDetailInfo.class ));
   }

   public StructSdtSplitScreenDetailInfo( int remoteHandle ,
                                          ModelContext context )
   {
   }

   public  StructSdtSplitScreenDetailInfo( java.util.Vector<StructSdtSplitScreenDetailInfo> value )
   {
      item = value;
   }

   public Object clone()
   {
      Object cloned = null;
      try
      {
         cloned = super.clone();
      }catch (CloneNotSupportedException e){ ; }
      return cloned;
   }

   @javax.xml.bind.annotation.XmlElement(name="SplitScreenDetailInfo",namespace="ProjectThani")
   public java.util.Vector<StructSdtSplitScreenDetailInfo> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSplitScreenDetailInfo> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSplitScreenDetailInfo> item = new java.util.Vector<>();
}

