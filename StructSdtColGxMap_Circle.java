package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColGxMap.Circle", namespace ="ProjectThani")
public final  class StructSdtColGxMap_Circle implements Cloneable, java.io.Serializable
{
   public StructSdtColGxMap_Circle( )
   {
      this( -1, new ModelContext( StructSdtColGxMap_Circle.class ));
   }

   public StructSdtColGxMap_Circle( int remoteHandle ,
                                    ModelContext context )
   {
   }

   public  StructSdtColGxMap_Circle( java.util.Vector<StructSdtGxMap_Circle> value )
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

   @javax.xml.bind.annotation.XmlElement(name="GxMap.Circle",namespace="ProjectThani")
   public java.util.Vector<StructSdtGxMap_Circle> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtGxMap_Circle> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtGxMap_Circle> item = new java.util.Vector<>();
}

