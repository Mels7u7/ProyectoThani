package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColGxMap.Line.Point", namespace ="ProjectThani")
public final  class StructSdtColGxMap_Line_Point implements Cloneable, java.io.Serializable
{
   public StructSdtColGxMap_Line_Point( )
   {
      this( -1, new ModelContext( StructSdtColGxMap_Line_Point.class ));
   }

   public StructSdtColGxMap_Line_Point( int remoteHandle ,
                                        ModelContext context )
   {
   }

   public  StructSdtColGxMap_Line_Point( java.util.Vector<StructSdtGxMap_Line_Point> value )
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

   @javax.xml.bind.annotation.XmlElement(name="GxMap.Line.Point",namespace="ProjectThani")
   public java.util.Vector<StructSdtGxMap_Line_Point> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtGxMap_Line_Point> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtGxMap_Line_Point> item = new java.util.Vector<>();
}

