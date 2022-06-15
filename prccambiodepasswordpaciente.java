package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prccambiodepasswordpaciente extends GXProcedure
{
   public prccambiodepasswordpaciente( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prccambiodepasswordpaciente.class ), "" );
   }

   public prccambiodepasswordpaciente( int remoteHandle ,
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
      prccambiodepasswordpaciente.this.AV16PacienteId = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV21subject = "Alertas Thani Salud - Modificación de contraseña" ;
      GXt_char1 = "" ;
      GXv_char2[0] = GXt_char1 ;
      new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "DFSendMailAddress", GXv_char2) ;
      prccambiodepasswordpaciente.this.GXt_char1 = GXv_char2[0] ;
      AV12MailRecipient.setAddress( GXt_char1 );
      AV12MailRecipient.setName( "Alertas Thani Salud" );
      AV20SMTPSession.setHost( "mail.thanitech.pe" );
      GXt_char1 = "" ;
      GXv_char2[0] = GXt_char1 ;
      new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "DFSendMailAddress", GXv_char2) ;
      prccambiodepasswordpaciente.this.GXt_char1 = GXv_char2[0] ;
      AV20SMTPSession.setUserName( GXt_char1 );
      GXt_char1 = "" ;
      GXv_char2[0] = GXt_char1 ;
      new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "DFSendMailPassword", GXv_char2) ;
      prccambiodepasswordpaciente.this.GXt_char1 = GXv_char2[0] ;
      AV20SMTPSession.setPassword( GXt_char1 );
      AV20SMTPSession.setPort( 465 );
      AV20SMTPSession.setSender( AV12MailRecipient );
      AV20SMTPSession.setAuthentication( (short)(1) );
      AV20SMTPSession.setSecure( (short)(1) );
      AV20SMTPSession.login();
      if ( GXutil.strcmp(AV20SMTPSession.getErrDescription(), "OK") == 0 )
      {
         AV10Log = (byte)(1) ;
      }
      AV23Paciente.Load(AV16PacienteId);
      AV15PacienteCorreo = AV23Paciente.getgxTv_SdtPaciente_Pacientecorreo() ;
      AV16PacienteId = AV23Paciente.getgxTv_SdtPaciente_Pacienteid() ;
      AV17PacienteNombres = AV23Paciente.getgxTv_SdtPaciente_Pacientenombres() ;
      AV14PacienteApellidoPaterno = AV23Paciente.getgxTv_SdtPaciente_Pacienteapellidopaterno() ;
      AV13PacienteApellidoMaterno = AV23Paciente.getgxTv_SdtPaciente_Pacienteapellidomaterno() ;
      AV8PacienteUserId = AV23Paciente.getgxTv_SdtPaciente_Secuserid() ;
      AV9SecUser.Load((short)(AV8PacienteUserId));
      if ( ! (GXutil.strcmp("", AV15PacienteCorreo)==0) && ( AV16PacienteId > 0 ) )
      {
         AV11MailMsg.getTo().addNew("Usuario: ", AV15PacienteCorreo) ;
         AV11MailMsg.getBcc().addNew("Audit: ", new com.projectthani.prcgetconfigvalue(remoteHandle, context).executeUdp( "DFSendMailAuditAddress")) ;
         AV11MailMsg.setSubject( AV21subject );
         GXt_char1 = AV22TemplateContent ;
         GXv_char2[0] = GXt_char1 ;
         new com.projectthani.prcgettemplatecontent(remoteHandle, context).execute( "CorreoCambioPasswordPaciente", GXv_char2) ;
         prccambiodepasswordpaciente.this.GXt_char1 = GXv_char2[0] ;
         AV22TemplateContent = GXt_char1 ;
         GXt_char1 = AV22TemplateContent ;
         GXv_char2[0] = GXt_char1 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char2) ;
         prccambiodepasswordpaciente.this.GXt_char1 = GXv_char2[0] ;
         AV22TemplateContent = GXutil.strReplace( AV22TemplateContent, "@LogoThaniCabecera", GXt_char1+httpContext.convertURL( context.getHttpContext().getImagePath( "c8c30f84-9005-482a-bb17-74652747025d", "", context.getHttpContext().getTheme( )))) ;
         GXt_char1 = AV22TemplateContent ;
         GXv_char2[0] = GXt_char1 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char2) ;
         prccambiodepasswordpaciente.this.GXt_char1 = GXv_char2[0] ;
         AV22TemplateContent = GXutil.strReplace( AV22TemplateContent, "@LogoThaniFooter", GXt_char1+httpContext.convertURL( context.getHttpContext().getImagePath( "047f0769-6930-4583-9765-5b17fd99b6fa", "", context.getHttpContext().getTheme( )))) ;
         GXt_char1 = AV22TemplateContent ;
         GXv_char2[0] = GXt_char1 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char2) ;
         prccambiodepasswordpaciente.this.GXt_char1 = GXv_char2[0] ;
         AV22TemplateContent = GXutil.strReplace( AV22TemplateContent, "@ImagenFondoThani", GXt_char1+httpContext.convertURL( context.getHttpContext().getImagePath( "8d3498a5-334e-489e-a9e2-8efd202f869b", "", context.getHttpContext().getTheme( )))) ;
         AV22TemplateContent = GXutil.strReplace( AV22TemplateContent, "@PacienteNombresApellidos", ""+AV17PacienteNombres+" "+AV14PacienteApellidoPaterno+" "+AV13PacienteApellidoMaterno+"") ;
         AV22TemplateContent = GXutil.strReplace( AV22TemplateContent, "@PacienteUsuarioAcceso", AV9SecUser.getgxTv_SdtSecUser_Secuseremail()) ;
         AV22TemplateContent = GXutil.strReplace( AV22TemplateContent, "@PacientePasswordAcceso", AV9SecUser.getgxTv_SdtSecUser_Secuserpassword()) ;
         GXt_char1 = AV22TemplateContent ;
         GXv_char2[0] = GXt_char1 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char2) ;
         prccambiodepasswordpaciente.this.GXt_char1 = GXv_char2[0] ;
         AV22TemplateContent = GXutil.strReplace( AV22TemplateContent, "@Youtube", GXt_char1+httpContext.convertURL( context.getHttpContext().getImagePath( "c549c01a-fd39-47bd-b976-e58ed8f85372", "", context.getHttpContext().getTheme( )))) ;
         GXt_char1 = AV22TemplateContent ;
         GXv_char2[0] = GXt_char1 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char2) ;
         prccambiodepasswordpaciente.this.GXt_char1 = GXv_char2[0] ;
         AV22TemplateContent = GXutil.strReplace( AV22TemplateContent, "@Twitter", GXt_char1+httpContext.convertURL( context.getHttpContext().getImagePath( "a77b9490-9a4a-47f0-857a-4296100fbdf5", "", context.getHttpContext().getTheme( )))) ;
         GXt_char1 = AV22TemplateContent ;
         GXv_char2[0] = GXt_char1 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char2) ;
         prccambiodepasswordpaciente.this.GXt_char1 = GXv_char2[0] ;
         AV22TemplateContent = GXutil.strReplace( AV22TemplateContent, "@Facebook", GXt_char1+httpContext.convertURL( context.getHttpContext().getImagePath( "206fb0de-bd89-4de1-84a0-bfad4cce7b67", "", context.getHttpContext().getTheme( )))) ;
         GXt_char1 = AV22TemplateContent ;
         GXv_char2[0] = GXt_char1 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char2) ;
         prccambiodepasswordpaciente.this.GXt_char1 = GXv_char2[0] ;
         AV22TemplateContent = GXutil.strReplace( AV22TemplateContent, "@Linkedin", GXt_char1+httpContext.convertURL( context.getHttpContext().getImagePath( "daacd302-7a77-4964-8792-040593138f5e", "", context.getHttpContext().getTheme( )))) ;
         GXt_char1 = AV22TemplateContent ;
         GXv_char2[0] = GXt_char1 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char2) ;
         prccambiodepasswordpaciente.this.GXt_char1 = GXv_char2[0] ;
         AV22TemplateContent = GXutil.strReplace( AV22TemplateContent, "@Instagram", GXt_char1+httpContext.convertURL( context.getHttpContext().getImagePath( "1bf3bbfb-471f-4eff-8f20-0b2de7cdf917", "", context.getHttpContext().getTheme( )))) ;
         AV11MailMsg.setHtmltext( AV22TemplateContent );
         GXt_dtime3 = GXutil.resetTime( GXutil.serverDate( context, remoteHandle, pr_default) );
         AV11MailMsg.setDateSent( GXt_dtime3 );
         AV20SMTPSession.send(AV11MailMsg);
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
      AV12MailRecipient = new com.genexus.internet.MailRecipient();
      AV20SMTPSession = new com.genexus.internet.GXSMTPSession();
      AV23Paciente = new com.projectthani.SdtPaciente(remoteHandle);
      AV15PacienteCorreo = "" ;
      AV17PacienteNombres = "" ;
      AV14PacienteApellidoPaterno = "" ;
      AV13PacienteApellidoMaterno = "" ;
      AV9SecUser = new com.projectthani.wwpbaseobjects.SdtSecUser(remoteHandle);
      AV11MailMsg = new com.genexus.internet.GXMailMessage();
      AV22TemplateContent = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      GXt_dtime3 = GXutil.resetTime( GXutil.nullDate() );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prccambiodepasswordpaciente__default(),
         new Object[] {
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV10Log ;
   private short Gx_err ;
   private int AV16PacienteId ;
   private int AV8PacienteUserId ;
   private String AV21subject ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private java.util.Date GXt_dtime3 ;
   private String AV22TemplateContent ;
   private String AV15PacienteCorreo ;
   private String AV17PacienteNombres ;
   private String AV14PacienteApellidoPaterno ;
   private String AV13PacienteApellidoMaterno ;
   private com.genexus.internet.MailRecipient AV12MailRecipient ;
   private com.genexus.internet.GXMailMessage AV11MailMsg ;
   private com.genexus.internet.GXSMTPSession AV20SMTPSession ;
   private IDataStoreProvider pr_default ;
   private com.projectthani.wwpbaseobjects.SdtSecUser AV9SecUser ;
   private com.projectthani.SdtPaciente AV23Paciente ;
}

final  class prccambiodepasswordpaciente__default extends DataStoreHelperBase implements ILocalDataStoreHelper
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

