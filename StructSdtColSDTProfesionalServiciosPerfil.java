package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTProfesionalServiciosPerfil", namespace ="ProjectThani")
public final  class StructSdtColSDTProfesionalServiciosPerfil implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTProfesionalServiciosPerfil( )
   {
      this( -1, new ModelContext( StructSdtColSDTProfesionalServiciosPerfil.class ));
   }

   public StructSdtColSDTProfesionalServiciosPerfil( int remoteHandle ,
                                                     ModelContext context )
   {
   }

   public  StructSdtColSDTProfesionalServiciosPerfil( java.util.Vector<StructSdtSDTProfesionalServiciosPerfil> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTProfesionalServiciosPerfil",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTProfesionalServiciosPerfil> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTProfesionalServiciosPerfil> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTProfesionalServiciosPerfil> item = new java.util.Vector<>();
}

