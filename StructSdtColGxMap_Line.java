package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColGxMap.Line", namespace ="ProjectThani")
public final  class StructSdtColGxMap_Line implements Cloneable, java.io.Serializable
{
   public StructSdtColGxMap_Line( )
   {
      this( -1, new ModelContext( StructSdtColGxMap_Line.class ));
   }

   public StructSdtColGxMap_Line( int remoteHandle ,
                                  ModelContext context )
   {
   }

   public  StructSdtColGxMap_Line( java.util.Vector<StructSdtGxMap_Line> value )
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

   @javax.xml.bind.annotation.XmlElement(name="GxMap.Line",namespace="ProjectThani")
   public java.util.Vector<StructSdtGxMap_Line> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtGxMap_Line> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtGxMap_Line> item = new java.util.Vector<>();
}

