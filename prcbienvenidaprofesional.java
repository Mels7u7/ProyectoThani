package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcbienvenidaprofesional extends GXProcedure
{
   public prcbienvenidaprofesional( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcbienvenidaprofesional.class ), "" );
   }

   public prcbienvenidaprofesional( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( int aP0 )
   {
      prcbienvenidaprofesional.this.AV15ProfesionalId = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV21subject = "Alertas Thani Salud - Creación de cuenta" ;
      GXt_char1 = "" ;
      GXv_char2[0] = GXt_char1 ;
      new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "DFSendMailAddress", GXv_char2) ;
      prcbienvenidaprofesional.this.GXt_char1 = GXv_char2[0] ;
      AV10MailRecipient.setAddress( GXt_char1 );
      AV10MailRecipient.setName( "Alertas Thani Salud" );
      AV20SMTPSession.setHost( "mail.thanitech.pe" );
      GXt_char1 = "" ;
      GXv_char2[0] = GXt_char1 ;
      new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "DFSendMailAddress", GXv_char2) ;
      prcbienvenidaprofesional.this.GXt_char1 = GXv_char2[0] ;
      AV20SMTPSession.setUserName( GXt_char1 );
      GXt_char1 = "" ;
      GXv_char2[0] = GXt_char1 ;
      new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "DFSendMailPassword", GXv_char2) ;
      prcbienvenidaprofesional.this.GXt_char1 = GXv_char2[0] ;
      AV20SMTPSession.setPassword( GXt_char1 );
      AV20SMTPSession.setPort( 465 );
      AV20SMTPSession.setSender( AV10MailRecipient );
      AV20SMTPSession.setAuthentication( (short)(1) );
      AV20SMTPSession.setSecure( (short)(1) );
      AV20SMTPSession.login();
      if ( GXutil.strcmp(AV20SMTPSession.getErrDescription(), "OK") == 0 )
      {
         AV8Log = (byte)(1) ;
      }
      AV11Profesional.Load(AV15ProfesionalId);
      AV14ProfesionalCorreo = AV11Profesional.getgxTv_SdtProfesional_Profesionalcorreo() ;
      AV15ProfesionalId = AV11Profesional.getgxTv_SdtProfesional_Profesionalid() ;
      AV16ProfesionalNombres = AV11Profesional.getgxTv_SdtProfesional_Profesionalnombres() ;
      AV13ProfesionalApellidoPaterno = AV11Profesional.getgxTv_SdtProfesional_Profesionalapellidopaterno() ;
      AV12ProfesionalApellidoMaterno = AV11Profesional.getgxTv_SdtProfesional_Profesionalapellidomaterno() ;
      AV17ProfesionalUserId = AV11Profesional.getgxTv_SdtProfesional_Secuserid() ;
      AV19SecUser.Load(AV17ProfesionalUserId);
      if ( ! (GXutil.strcmp("", AV14ProfesionalCorreo)==0) && ( AV15ProfesionalId > 0 ) )
      {
         AV9MailMsg.getTo().addNew("Usuario: ", AV14ProfesionalCorreo) ;
         AV9MailMsg.getBcc().addNew("Audit: ", new com.projectthani.prcgetconfigvalue(remoteHandle, context).executeUdp( "DFSendMailAuditAddress")) ;
         AV9MailMsg.setSubject( AV21subject );
         GXt_char1 = AV22TemplateContent ;
         GXv_char2[0] = GXt_char1 ;
         new com.projectthani.prcgettemplatecontent(remoteHandle, context).execute( "CorreoActivarCuentaProfesional", GXv_char2) ;
         prcbienvenidaprofesional.this.GXt_char1 = GXv_char2[0] ;
         AV22TemplateContent = GXt_char1 ;
         GXt_char1 = AV22TemplateContent ;
         GXv_char2[0] = GXt_char1 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char2) ;
         prcbienvenidaprofesional.this.GXt_char1 = GXv_char2[0] ;
         AV22TemplateContent = GXutil.strReplace( AV22TemplateContent, "@LogoThaniCabecera", GXt_char1+httpContext.convertURL( context.getHttpContext().getImagePath( "c8c30f84-9005-482a-bb17-74652747025d", "", context.getHttpContext().getTheme( )))) ;
         GXt_char1 = AV22TemplateContent ;
         GXv_char2[0] = GXt_char1 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char2) ;
         prcbienvenidaprofesional.this.GXt_char1 = GXv_char2[0] ;
         AV22TemplateContent = GXutil.strReplace( AV22TemplateContent, "@LogoThaniFooter", GXt_char1+httpContext.convertURL( context.getHttpContext().getImagePath( "047f0769-6930-4583-9765-5b17fd99b6fa", "", context.getHttpContext().getTheme( )))) ;
         GXt_char1 = AV22TemplateContent ;
         GXv_char2[0] = GXt_char1 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char2) ;
         prcbienvenidaprofesional.this.GXt_char1 = GXv_char2[0] ;
         AV22TemplateContent = GXutil.strReplace( AV22TemplateContent, "@ImagenFondoThani", GXt_char1+httpContext.convertURL( context.getHttpContext().getImagePath( "8d3498a5-334e-489e-a9e2-8efd202f869b", "", context.getHttpContext().getTheme( )))) ;
         AV22TemplateContent = GXutil.strReplace( AV22TemplateContent, "@ProfesionalNombresApellidos", ""+AV16ProfesionalNombres+" "+AV13ProfesionalApellidoPaterno+" "+AV12ProfesionalApellidoMaterno+"") ;
         AV22TemplateContent = GXutil.strReplace( AV22TemplateContent, "@ProfesionalUsuarioAcceso", AV19SecUser.getgxTv_SdtSecUser_Secuseremail()) ;
         AV22TemplateContent = GXutil.strReplace( AV22TemplateContent, "@ProfesionalPasswordAcceso", AV19SecUser.getgxTv_SdtSecUser_Secuserpassword()) ;
         GXt_char1 = AV22TemplateContent ;
         GXv_char2[0] = GXt_char1 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char2) ;
         prcbienvenidaprofesional.this.GXt_char1 = GXv_char2[0] ;
         AV22TemplateContent = GXutil.strReplace( AV22TemplateContent, "@Youtube", GXt_char1+httpContext.convertURL( context.getHttpContext().getImagePath( "c549c01a-fd39-47bd-b976-e58ed8f85372", "", context.getHttpContext().getTheme( )))) ;
         GXt_char1 = AV22TemplateContent ;
         GXv_char2[0] = GXt_char1 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char2) ;
         prcbienvenidaprofesional.this.GXt_char1 = GXv_char2[0] ;
         AV22TemplateContent = GXutil.strReplace( AV22TemplateContent, "@Twitter", GXt_char1+httpContext.convertURL( context.getHttpContext().getImagePath( "a77b9490-9a4a-47f0-857a-4296100fbdf5", "", context.getHttpContext().getTheme( )))) ;
         GXt_char1 = AV22TemplateContent ;
         GXv_char2[0] = GXt_char1 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char2) ;
         prcbienvenidaprofesional.this.GXt_char1 = GXv_char2[0] ;
         AV22TemplateContent = GXutil.strReplace( AV22TemplateContent, "@Facebook", GXt_char1+httpContext.convertURL( context.getHttpContext().getImagePath( "206fb0de-bd89-4de1-84a0-bfad4cce7b67", "", context.getHttpContext().getTheme( )))) ;
         GXt_char1 = AV22TemplateContent ;
         GXv_char2[0] = GXt_char1 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char2) ;
         prcbienvenidaprofesional.this.GXt_char1 = GXv_char2[0] ;
         AV22TemplateContent = GXutil.strReplace( AV22TemplateContent, "@Linkedin", GXt_char1+httpContext.convertURL( context.getHttpContext().getImagePath( "daacd302-7a77-4964-8792-040593138f5e", "", context.getHttpContext().getTheme( )))) ;
         GXt_char1 = AV22TemplateContent ;
         GXv_char2[0] = GXt_char1 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char2) ;
         prcbienvenidaprofesional.this.GXt_char1 = GXv_char2[0] ;
         AV22TemplateContent = GXutil.strReplace( AV22TemplateContent, "@Instagram", GXt_char1+httpContext.convertURL( context.getHttpContext().getImagePath( "1bf3bbfb-471f-4eff-8f20-0b2de7cdf917", "", context.getHttpContext().getTheme( )))) ;
         AV9MailMsg.setHtmltext( AV22TemplateContent );
         GXt_dtime3 = GXutil.resetTime( GXutil.serverDate( context, remoteHandle, pr_default) );
         AV9MailMsg.setDateSent( GXt_dtime3 );
         AV20SMTPSession.send(AV9MailMsg);
         AV20SMTPSession.logout();
      }
      else
      {
         httpContext.GX_msglist.addItem("error envio correo");
      }
      cleanup();
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV21subject = "" ;
      AV10MailRecipient = new com.genexus.internet.MailRecipient();
      AV20SMTPSession = new com.genexus.internet.GXSMTPSession();
      AV11Profesional = new com.projectthani.SdtProfesional(remoteHandle);
      AV14ProfesionalCorreo = "" ;
      AV16ProfesionalNombres = "" ;
      AV13ProfesionalApellidoPaterno = "" ;
      AV12ProfesionalApellidoMaterno = "" ;
      AV19SecUser = new com.projectthani.wwpbaseobjects.SdtSecUser(remoteHandle);
      AV9MailMsg = new com.genexus.internet.GXMailMessage();
      AV22TemplateContent = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      GXt_dtime3 = GXutil.resetTime( GXutil.nullDate() );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcbienvenidaprofesional__default(),
         new Object[] {
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV8Log ;
   private short AV17ProfesionalUserId ;
   private short Gx_err ;
   private int AV15ProfesionalId ;
   private String AV21subject ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private java.util.Date GXt_dtime3 ;
   private String AV22TemplateContent ;
   private String AV14ProfesionalCorreo ;
   private String AV16ProfesionalNombres ;
   private String AV13ProfesionalApellidoPaterno ;
   private String AV12ProfesionalApellidoMaterno ;
   private com.genexus.internet.MailRecipient AV10MailRecipient ;
   private com.genexus.internet.GXMailMessage AV9MailMsg ;
   private com.genexus.internet.GXSMTPSession AV20SMTPSession ;
   private IDataStoreProvider pr_default ;
   private com.projectthani.SdtProfesional AV11Profesional ;
   private com.projectthani.wwpbaseobjects.SdtSecUser AV19SecUser ;
}

final  class prcbienvenidaprofesional__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
      }
   }

}

