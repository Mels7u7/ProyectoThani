package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColEncuesta", namespace ="ProjectThani")
public final  class StructSdtColEncuesta implements Cloneable, java.io.Serializable
{
   public StructSdtColEncuesta( )
   {
      this( -1, new ModelContext( StructSdtColEncuesta.class ));
   }

   public StructSdtColEncuesta( int remoteHandle ,
                                ModelContext context )
   {
   }

   public  StructSdtColEncuesta( java.util.Vector<StructSdtEncuesta> value )
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

   @javax.xml.bind.annotation.XmlElement(name="Encuesta",namespace="ProjectThani")
   public java.util.Vector<StructSdtEncuesta> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtEncuesta> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtEncuesta> item = new java.util.Vector<>();
}

