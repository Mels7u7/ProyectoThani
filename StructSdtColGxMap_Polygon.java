package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColGxMap.Polygon", namespace ="ProjectThani")
public final  class StructSdtColGxMap_Polygon implements Cloneable, java.io.Serializable
{
   public StructSdtColGxMap_Polygon( )
   {
      this( -1, new ModelContext( StructSdtColGxMap_Polygon.class ));
   }

   public StructSdtColGxMap_Polygon( int remoteHandle ,
                                     ModelContext context )
   {
   }

   public  StructSdtColGxMap_Polygon( java.util.Vector<StructSdtGxMap_Polygon> value )
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

   @javax.xml.bind.annotation.XmlElement(name="GxMap.Polygon",namespace="ProjectThani")
   public java.util.Vector<StructSdtGxMap_Polygon> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtGxMap_Polygon> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtGxMap_Polygon> item = new java.util.Vector<>();
}

