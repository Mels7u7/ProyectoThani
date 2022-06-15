package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColLogAccesos", namespace ="ProjectThani")
public final  class StructSdtColLogAccesos implements Cloneable, java.io.Serializable
{
   public StructSdtColLogAccesos( )
   {
      this( -1, new ModelContext( StructSdtColLogAccesos.class ));
   }

   public StructSdtColLogAccesos( int remoteHandle ,
                                  ModelContext context )
   {
   }

   public  StructSdtColLogAccesos( java.util.Vector<StructSdtLogAccesos> value )
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

   @javax.xml.bind.annotation.XmlElement(name="LogAccesos",namespace="ProjectThani")
   public java.util.Vector<StructSdtLogAccesos> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtLogAccesos> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtLogAccesos> item = new java.util.Vector<>();
}

