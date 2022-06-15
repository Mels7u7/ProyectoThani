package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class encriptpassword extends GXProcedure
{
   public encriptpassword( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( encriptpassword.class ), "" );
   }

   public encriptpassword( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String aP1 )
   {
      encriptpassword.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             String[] aP2 )
   {
      encriptpassword.this.Gx_mode = aP0;
      encriptpassword.this.AV10SecUserPassword = aP1;
      encriptpassword.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         if ( GXutil.len( AV10SecUserPassword) > 32 )
         {
            AV8Key = GXutil.substring( AV10SecUserPassword, 1, 32) ;
            AV11SecUserPasswordDes = GXutil.substring( AV10SecUserPassword, 33, GXutil.len( AV10SecUserPassword)-32) ;
            AV11SecUserPasswordDes = httpContext.decrypt64( AV11SecUserPasswordDes, AV8Key) ;
            AV8Key = com.genexus.util.Encryption.getNewKey( ) ;
            AV9PasswordEncript = GXutil.lower( AV8Key) + httpContext.encrypt64( AV11SecUserPasswordDes, AV8Key) ;
         }
         else
         {
            AV8Key = com.genexus.util.Encryption.getNewKey( ) ;
            AV9PasswordEncript = GXutil.lower( AV8Key) + httpContext.encrypt64( AV10SecUserPassword, AV8Key) ;
         }
      }
      else
      {
         AV8Key = com.genexus.util.Encryption.getNewKey( ) ;
         AV9PasswordEncript = GXutil.lower( AV8Key) + httpContext.encrypt64( AV10SecUserPassword, AV8Key) ;
      }
      AV12SecUserPasswordEncript = AV9PasswordEncript ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = encriptpassword.this.AV12SecUserPasswordEncript;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12SecUserPasswordEncript = "" ;
      AV8Key = "" ;
      AV11SecUserPasswordDes = "" ;
      AV9PasswordEncript = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String Gx_mode ;
   private String AV10SecUserPassword ;
   private String AV12SecUserPasswordEncript ;
   private String AV8Key ;
   private String AV11SecUserPasswordDes ;
   private String AV9PasswordEncript ;
   private String[] aP2 ;
}

