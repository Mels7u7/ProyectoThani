package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prccreaciontoken extends GXProcedure
{
   public prccreaciontoken( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prccreaciontoken.class ), "" );
   }

   public prccreaciontoken( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( String[] aP0 ,
                            String[] aP1 )
   {
      prccreaciontoken.this.aP2 = new short[] {0};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( String[] aP0 ,
                        String[] aP1 ,
                        short[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( String[] aP0 ,
                             String[] aP1 ,
                             short[] aP2 )
   {
      prccreaciontoken.this.aP0 = aP0;
      prccreaciontoken.this.aP1 = aP1;
      prccreaciontoken.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = "" ;
      GXv_char2[0] = GXt_char1 ;
      new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "hostNiubiz", GXv_char2) ;
      prccreaciontoken.this.GXt_char1 = GXv_char2[0] ;
      AV8HttpClient.setHost( GXt_char1 );
      AV8HttpClient.setPort( 443 );
      AV8HttpClient.setSecure( (byte)(1) );
      GXt_char1 = "" ;
      GXv_char2[0] = GXt_char1 ;
      new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "baseUrlCreacionTokenNiubiz", GXv_char2) ;
      prccreaciontoken.this.GXt_char1 = GXv_char2[0] ;
      AV8HttpClient.setBaseURL( GXt_char1 );
      GXt_char1 = AV13Cadena ;
      GXv_char2[0] = GXt_char1 ;
      new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "autenticacionNiubiz", GXv_char2) ;
      prccreaciontoken.this.GXt_char1 = GXv_char2[0] ;
      AV13Cadena = GXt_char1 ;
      AV8HttpClient.addHeader("Authorization", AV13Cadena);
      AV8HttpClient.execute("GET", new com.projectthani.prcgetconfigvalue(remoteHandle, context).executeUdp( "methodCreacionTokenNiubiz"));
      AV10AccessToken = AV8HttpClient.getString() ;
      AV11HttpStatus = (short)(GXutil.Int( AV8HttpClient.getStatusCode())) ;
      AV12ErrorMessage = "" ;
      if ( AV11HttpStatus != 201 )
      {
         AV12ErrorMessage = GXutil.str( AV11HttpStatus, 4, 0) + " - Error de autenticación. Comuniquese con un administrador." ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = prccreaciontoken.this.AV10AccessToken;
      this.aP1[0] = prccreaciontoken.this.AV12ErrorMessage;
      this.aP2[0] = prccreaciontoken.this.AV11HttpStatus;
      CloseOpenCursors();
      AV8HttpClient.cleanup();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10AccessToken = "" ;
      AV12ErrorMessage = "" ;
      AV8HttpClient = new com.genexus.internet.HttpClient();
      AV13Cadena = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11HttpStatus ;
   private short Gx_err ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private String AV10AccessToken ;
   private String AV12ErrorMessage ;
   private String AV13Cadena ;
   private com.genexus.internet.HttpClient AV8HttpClient ;
   private short[] aP2 ;
   private String[] aP0 ;
   private String[] aP1 ;
}

