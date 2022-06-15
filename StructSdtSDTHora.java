package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "SDTHora", namespace ="ProjectThani")
public final  class StructSdtSDTHora implements Cloneable, java.io.Serializable
{
   public StructSdtSDTHora( )
   {
      this( -1, new ModelContext( StructSdtSDTHora.class ));
   }

   public StructSdtSDTHora( int remoteHandle ,
                            ModelContext context )
   {
   }

   public  StructSdtSDTHora( java.util.Vector<StructSdtSDTHora_SDTHoraItem> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTHoraItem",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTHora_SDTHoraItem> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTHora_SDTHoraItem> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTHora_SDTHoraItem> item = new java.util.Vector<>();
}

