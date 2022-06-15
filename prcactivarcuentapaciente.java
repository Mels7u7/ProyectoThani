package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcactivarcuentapaciente extends GXProcedure
{
   public prcactivarcuentapaciente( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcactivarcuentapaciente.class ), "" );
   }

   public prcactivarcuentapaciente( int remoteHandle ,
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
      prcactivarcuentapaciente.this.AV9PacienteId = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P005R3 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9PacienteId)});
      if ( (pr_default.getStatus(0) != 101) )
      {
         A40000PacienteId = P005R3_A40000PacienteId[0] ;
         n40000PacienteId = P005R3_n40000PacienteId[0] ;
      }
      else
      {
         A40000PacienteId = 0 ;
         n40000PacienteId = false ;
      }
      pr_default.close(0);
      AV8Paciente.Load(A40000PacienteId);
      AV11idPaciente = AV8Paciente.getgxTv_SdtPaciente_Pacienteid() ;
      if ( AV9PacienteId > 0 )
      {
         GXt_char1 = AV19UrlActivar ;
         GXv_char2[0] = GXt_char1 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "ThaniMainUrl", GXv_char2) ;
         prcactivarcuentapaciente.this.GXt_char1 = GXv_char2[0] ;
         GXt_char3 = AV19UrlActivar ;
         GXv_char4[0] = GXt_char3 ;
         new com.projectthani.encriptpassword(remoteHandle, context).execute( "", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11idPaciente), 8, 0), GXv_char4) ;
         prcactivarcuentapaciente.this.GXt_char3 = GXv_char4[0] ;
         AV19UrlActivar = GXt_char1 + formatLink("com.projectthani.wpverificarcuenta", new String[] {GXutil.URLEncode(GXutil.rtrim(GXt_char3))}, new String[] {"VarPacienteId"})  ;
         AV17subject = "Alertas Thani Salud - Confirmación de cuenta" ;
         GXt_char3 = "" ;
         GXv_char4[0] = GXt_char3 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "DFSendMailAddress", GXv_char4) ;
         prcactivarcuentapaciente.this.GXt_char3 = GXv_char4[0] ;
         AV14MailRecipient.setAddress( GXt_char3 );
         AV14MailRecipient.setName( "Alertas Thani Salud" );
         AV16SMTPSession.setHost( "mail.thanitech.pe" );
         GXt_char3 = "" ;
         GXv_char4[0] = GXt_char3 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "DFSendMailAddress", GXv_char4) ;
         prcactivarcuentapaciente.this.GXt_char3 = GXv_char4[0] ;
         AV16SMTPSession.setUserName( GXt_char3 );
         GXt_char3 = "" ;
         GXv_char4[0] = GXt_char3 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "DFSendMailPassword", GXv_char4) ;
         prcactivarcuentapaciente.this.GXt_char3 = GXv_char4[0] ;
         AV16SMTPSession.setPassword( GXt_char3 );
         AV16SMTPSession.setPort( 465 );
         AV16SMTPSession.setSender( AV14MailRecipient );
         AV16SMTPSession.setAuthentication( (short)(1) );
         AV16SMTPSession.setSecure( (short)(1) );
         AV16SMTPSession.login();
         httpContext.GX_msglist.addItem("Error Code:"+AV16SMTPSession.getErrCode());
         httpContext.GX_msglist.addItem("Error Descripcion:"+AV16SMTPSession.getErrDescription());
         httpContext.GX_msglist.addItem("ErrorDisplay:"+AV16SMTPSession.getErrDisplay());
         if ( GXutil.strcmp(AV16SMTPSession.getErrDescription(), "OK") == 0 )
         {
            AV12Log = (short)(1) ;
         }
         AV13MailMsg.getTo().addNew("Usuario: ", AV8Paciente.getgxTv_SdtPaciente_Pacientecorreo()) ;
         AV13MailMsg.getBcc().addNew("Audit: ", new com.projectthani.prcgetconfigvalue(remoteHandle, context).executeUdp( "DFSendMailAuditAddress")) ;
         AV13MailMsg.setSubject( AV17subject );
         GXt_char3 = AV18TemplateContent ;
         GXv_char4[0] = GXt_char3 ;
         new com.projectthani.prcgettemplatecontent(remoteHandle, context).execute( "CorreoActivarCuentaPaciente", GXv_char4) ;
         prcactivarcuentapaciente.this.GXt_char3 = GXv_char4[0] ;
         AV18TemplateContent = GXt_char3 ;
         GXt_char3 = AV18TemplateContent ;
         GXv_char4[0] = GXt_char3 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char4) ;
         prcactivarcuentapaciente.this.GXt_char3 = GXv_char4[0] ;
         AV18TemplateContent = GXutil.strReplace( AV18TemplateContent, "@LogoThaniCabecera", GXt_char3+httpContext.convertURL( context.getHttpContext().getImagePath( "c8c30f84-9005-482a-bb17-74652747025d", "", context.getHttpContext().getTheme( )))) ;
         GXt_char3 = AV18TemplateContent ;
         GXv_char4[0] = GXt_char3 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char4) ;
         prcactivarcuentapaciente.this.GXt_char3 = GXv_char4[0] ;
         AV18TemplateContent = GXutil.strReplace( AV18TemplateContent, "@LogoThaniFooter", GXt_char3+httpContext.convertURL( context.getHttpContext().getImagePath( "047f0769-6930-4583-9765-5b17fd99b6fa", "", context.getHttpContext().getTheme( )))) ;
         GXt_char3 = AV18TemplateContent ;
         GXv_char4[0] = GXt_char3 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char4) ;
         prcactivarcuentapaciente.this.GXt_char3 = GXv_char4[0] ;
         AV18TemplateContent = GXutil.strReplace( AV18TemplateContent, "@ImagenFondoThani", GXt_char3+httpContext.convertURL( context.getHttpContext().getImagePath( "8d3498a5-334e-489e-a9e2-8efd202f869b", "", context.getHttpContext().getTheme( )))) ;
         AV18TemplateContent = GXutil.strReplace( AV18TemplateContent, "@PacienteNombresApellidos", ""+AV8Paciente.getgxTv_SdtPaciente_Pacientenombres()+" "+AV8Paciente.getgxTv_SdtPaciente_Pacienteapellidopaterno()+" "+AV8Paciente.getgxTv_SdtPaciente_Pacienteapellidomaterno()+"") ;
         AV18TemplateContent = GXutil.strReplace( AV18TemplateContent, "@PacienteUrlActivarCuenta", AV19UrlActivar) ;
         GXt_char3 = AV18TemplateContent ;
         GXv_char4[0] = GXt_char3 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char4) ;
         prcactivarcuentapaciente.this.GXt_char3 = GXv_char4[0] ;
         AV18TemplateContent = GXutil.strReplace( AV18TemplateContent, "@Youtube", GXt_char3+httpContext.convertURL( context.getHttpContext().getImagePath( "c549c01a-fd39-47bd-b976-e58ed8f85372", "", context.getHttpContext().getTheme( )))) ;
         GXt_char3 = AV18TemplateContent ;
         GXv_char4[0] = GXt_char3 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char4) ;
         prcactivarcuentapaciente.this.GXt_char3 = GXv_char4[0] ;
         AV18TemplateContent = GXutil.strReplace( AV18TemplateContent, "@Twitter", GXt_char3+httpContext.convertURL( context.getHttpContext().getImagePath( "a77b9490-9a4a-47f0-857a-4296100fbdf5", "", context.getHttpContext().getTheme( )))) ;
         GXt_char3 = AV18TemplateContent ;
         GXv_char4[0] = GXt_char3 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char4) ;
         prcactivarcuentapaciente.this.GXt_char3 = GXv_char4[0] ;
         AV18TemplateContent = GXutil.strReplace( AV18TemplateContent, "@Facebook", GXt_char3+httpContext.convertURL( context.getHttpContext().getImagePath( "206fb0de-bd89-4de1-84a0-bfad4cce7b67", "", context.getHttpContext().getTheme( )))) ;
         GXt_char3 = AV18TemplateContent ;
         GXv_char4[0] = GXt_char3 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char4) ;
         prcactivarcuentapaciente.this.GXt_char3 = GXv_char4[0] ;
         AV18TemplateContent = GXutil.strReplace( AV18TemplateContent, "@Linkedin", GXt_char3+httpContext.convertURL( context.getHttpContext().getImagePath( "daacd302-7a77-4964-8792-040593138f5e", "", context.getHttpContext().getTheme( )))) ;
         GXt_char3 = AV18TemplateContent ;
         GXv_char4[0] = GXt_char3 ;
         new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "MainUrlImg", GXv_char4) ;
         prcactivarcuentapaciente.this.GXt_char3 = GXv_char4[0] ;
         AV18TemplateContent = GXutil.strReplace( AV18TemplateContent, "@Instagram", GXt_char3+httpContext.convertURL( context.getHttpContext().getImagePath( "1bf3bbfb-471f-4eff-8f20-0b2de7cdf917", "", context.getHttpContext().getTheme( )))) ;
         AV13MailMsg.setHtmltext( AV18TemplateContent );
         GXt_dtime5 = GXutil.resetTime( GXutil.serverDate( context, remoteHandle, pr_default) );
         AV13MailMsg.setDateSent( GXt_dtime5 );
         AV16SMTPSession.send(AV13MailMsg);
         AV16SMTPSession.logout();
      }
      else
      {
         httpContext.GX_msglist.addItem("Error");
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
      scmdbuf = "" ;
      P005R3_A40000PacienteId = new int[1] ;
      P005R3_n40000PacienteId = new boolean[] {false} ;
      AV8Paciente = new com.projectthani.SdtPaciente(remoteHandle);
      AV19UrlActivar = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      AV17subject = "" ;
      AV14MailRecipient = new com.genexus.internet.MailRecipient();
      AV16SMTPSession = new com.genexus.internet.GXSMTPSession();
      AV13MailMsg = new com.genexus.internet.GXMailMessage();
      AV18TemplateContent = "" ;
      GXt_char3 = "" ;
      GXv_char4 = new String[1] ;
      GXt_dtime5 = GXutil.resetTime( GXutil.nullDate() );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcactivarcuentapaciente__default(),
         new Object[] {
             new Object[] {
            P005R3_A40000PacienteId, P005R3_n40000PacienteId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV12Log ;
   private short Gx_err ;
   private int AV9PacienteId ;
   private int A40000PacienteId ;
   private int AV11idPaciente ;
   private String scmdbuf ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private String AV17subject ;
   private String GXt_char3 ;
   private String GXv_char4[] ;
   private java.util.Date GXt_dtime5 ;
   private boolean n40000PacienteId ;
   private String AV18TemplateContent ;
   private String AV19UrlActivar ;
   private com.genexus.internet.MailRecipient AV14MailRecipient ;
   private com.genexus.internet.GXMailMessage AV13MailMsg ;
   private com.genexus.internet.GXSMTPSession AV16SMTPSession ;
   private IDataStoreProvider pr_default ;
   private int[] P005R3_A40000PacienteId ;
   private boolean[] P005R3_n40000PacienteId ;
   private com.projectthani.SdtPaciente AV8Paciente ;
}

final  class prcactivarcuentapaciente__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P005R3", "SELECT COALESCE( T1.[PacienteId], 0) AS PacienteId FROM (SELECT [PacienteId] AS PacienteId FROM [Paciente] WHERE [PacienteId] = ? ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

