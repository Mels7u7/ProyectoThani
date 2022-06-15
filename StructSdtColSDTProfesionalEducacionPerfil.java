package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTProfesionalEducacionPerfil", namespace ="ProjectThani")
public final  class StructSdtColSDTProfesionalEducacionPerfil implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTProfesionalEducacionPerfil( )
   {
      this( -1, new ModelContext( StructSdtColSDTProfesionalEducacionPerfil.class ));
   }

   public StructSdtColSDTProfesionalEducacionPerfil( int remoteHandle ,
                                                     ModelContext context )
   {
   }

   public  StructSdtColSDTProfesionalEducacionPerfil( java.util.Vector<StructSdtSDTProfesionalEducacionPerfil> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTProfesionalEducacionPerfil",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTProfesionalEducacionPerfil> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTProfesionalEducacionPerfil> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTProfesionalEducacionPerfil> item = new java.util.Vector<>();
}

