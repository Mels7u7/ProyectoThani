package com.projectthani.wwpbaseobjects ;
import com.genexus.*;

public final  class StructSdtSecUser implements Cloneable, java.io.Serializable
{
   public StructSdtSecUser( )
   {
      this( -1, new ModelContext( StructSdtSecUser.class ));
   }

   public StructSdtSecUser( int remoteHandle ,
                            ModelContext context )
   {
      gxTv_SdtSecUser_Secusername = "" ;
      gxTv_SdtSecUser_Secuserpassword = "" ;
      gxTv_SdtSecUser_Secuseremail = "" ;
      gxTv_SdtSecUser_Secuserestador = "A" ;
      gxTv_SdtSecUser_Mode = "" ;
      gxTv_SdtSecUser_Secusername_Z = "" ;
      gxTv_SdtSecUser_Secuserpassword_Z = "" ;
      gxTv_SdtSecUser_Secuseremail_Z = "" ;
      gxTv_SdtSecUser_Secuserestador_Z = "" ;
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

   public short getSecuserid( )
   {
      return gxTv_SdtSecUser_Secuserid ;
   }

   public void setSecuserid( short value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      gxTv_SdtSecUser_Secuserid = value ;
   }

   public String getSecusername( )
   {
      return gxTv_SdtSecUser_Secusername ;
   }

   public void setSecusername( String value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      gxTv_SdtSecUser_Secusername = value ;
   }

   public String getSecuserpassword( )
   {
      return gxTv_SdtSecUser_Secuserpassword ;
   }

   public void setSecuserpassword( String value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      gxTv_SdtSecUser_Secuserpassword = value ;
   }

   public String getSecuseremail( )
   {
      return gxTv_SdtSecUser_Secuseremail ;
   }

   public void setSecuseremail( String value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      gxTv_SdtSecUser_Secuseremail = value ;
   }

   public String getSecuserestador( )
   {
      return gxTv_SdtSecUser_Secuserestador ;
   }

   public void setSecuserestador( String value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      gxTv_SdtSecUser_Secuserestador = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtSecUser_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      gxTv_SdtSecUser_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtSecUser_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      gxTv_SdtSecUser_Initialized = value ;
   }

   public short getSecuserid_Z( )
   {
      return gxTv_SdtSecUser_Secuserid_Z ;
   }

   public void setSecuserid_Z( short value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      gxTv_SdtSecUser_Secuserid_Z = value ;
   }

   public String getSecusername_Z( )
   {
      return gxTv_SdtSecUser_Secusername_Z ;
   }

   public void setSecusername_Z( String value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      gxTv_SdtSecUser_Secusername_Z = value ;
   }

   public String getSecuserpassword_Z( )
   {
      return gxTv_SdtSecUser_Secuserpassword_Z ;
   }

   public void setSecuserpassword_Z( String value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      gxTv_SdtSecUser_Secuserpassword_Z = value ;
   }

   public String getSecuseremail_Z( )
   {
      return gxTv_SdtSecUser_Secuseremail_Z ;
   }

   public void setSecuseremail_Z( String value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      gxTv_SdtSecUser_Secuseremail_Z = value ;
   }

   public String getSecuserestador_Z( )
   {
      return gxTv_SdtSecUser_Secuserestador_Z ;
   }

   public void setSecuserestador_Z( String value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      gxTv_SdtSecUser_Secuserestador_Z = value ;
   }

   public byte getSecuserid_N( )
   {
      return gxTv_SdtSecUser_Secuserid_N ;
   }

   public void setSecuserid_N( byte value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      gxTv_SdtSecUser_Secuserid_N = value ;
   }

   protected byte gxTv_SdtSecUser_Secuserid_N ;
   private byte gxTv_SdtSecUser_N ;
   protected short gxTv_SdtSecUser_Secuserid ;
   protected short gxTv_SdtSecUser_Initialized ;
   protected short gxTv_SdtSecUser_Secuserid_Z ;
   protected String gxTv_SdtSecUser_Secuserestador ;
   protected String gxTv_SdtSecUser_Mode ;
   protected String gxTv_SdtSecUser_Secuserestador_Z ;
   protected String gxTv_SdtSecUser_Secusername ;
   protected String gxTv_SdtSecUser_Secuserpassword ;
   protected String gxTv_SdtSecUser_Secuseremail ;
   protected String gxTv_SdtSecUser_Secusername_Z ;
   protected String gxTv_SdtSecUser_Secuserpassword_Z ;
   protected String gxTv_SdtSecUser_Secuseremail_Z ;
}

