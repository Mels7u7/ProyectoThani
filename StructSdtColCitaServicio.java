package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColCitaServicio", namespace ="ProjectThani")
public final  class StructSdtColCitaServicio implements Cloneable, java.io.Serializable
{
   public StructSdtColCitaServicio( )
   {
      this( -1, new ModelContext( StructSdtColCitaServicio.class ));
   }

   public StructSdtColCitaServicio( int remoteHandle ,
                                    ModelContext context )
   {
   }

   public  StructSdtColCitaServicio( java.util.Vector<StructSdtCitaServicio> value )
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

   @javax.xml.bind.annotation.XmlElement(name="CitaServicio",namespace="ProjectThani")
   public java.util.Vector<StructSdtCitaServicio> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtCitaServicio> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtCitaServicio> item = new java.util.Vector<>();
}

