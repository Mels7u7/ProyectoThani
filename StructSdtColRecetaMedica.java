package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColRecetaMedica", namespace ="ProjectThani")
public final  class StructSdtColRecetaMedica implements Cloneable, java.io.Serializable
{
   public StructSdtColRecetaMedica( )
   {
      this( -1, new ModelContext( StructSdtColRecetaMedica.class ));
   }

   public StructSdtColRecetaMedica( int remoteHandle ,
                                    ModelContext context )
   {
   }

   public  StructSdtColRecetaMedica( java.util.Vector<StructSdtRecetaMedica> value )
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

   @javax.xml.bind.annotation.XmlElement(name="RecetaMedica",namespace="ProjectThani")
   public java.util.Vector<StructSdtRecetaMedica> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtRecetaMedica> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtRecetaMedica> item = new java.util.Vector<>();
}

