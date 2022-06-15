package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prccrearusuariodoctor extends GXProcedure
{
   public prccrearusuariodoctor( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prccrearusuariodoctor.class ), "" );
   }

   public prccrearusuariodoctor( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( String aP0 ,
                        String aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             String aP1 )
   {
      prccrearusuariodoctor.this.AV15ProfesionalNroDocumento = aP0;
      prccrearusuariodoctor.this.AV14ProfesionalCorreo = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P002O3 */
      pr_default.execute(0, new Object[] {AV15ProfesionalNroDocumento});
      if ( (pr_default.getStatus(0) != 101) )
      {
         A40000ProfesionalId = P002O3_A40000ProfesionalId[0] ;
         n40000ProfesionalId = P002O3_n40000ProfesionalId[0] ;
      }
      else
      {
         A40000ProfesionalId = 0 ;
         n40000ProfesionalId = false ;
      }
      pr_default.close(0);
      GXt_char1 = AV12PasswordRandom ;
      GXv_char2[0] = GXt_char1 ;
      new com.projectthani.prcgenerarpasswordrandom(remoteHandle, context).execute( GXv_char2) ;
      prccrearusuariodoctor.this.GXt_char1 = GXv_char2[0] ;
      AV12PasswordRandom = GXt_char1 ;
      AV16SecUser.setgxTv_SdtSecUser_Secusername( GXutil.trim( AV15ProfesionalNroDocumento) );
      AV16SecUser.setgxTv_SdtSecUser_Secuserpassword( AV12PasswordRandom );
      AV16SecUser.setgxTv_SdtSecUser_Secuseremail( GXutil.trim( AV14ProfesionalCorreo) );
      AV16SecUser.Save();
      if ( AV16SecUser.Success() )
      {
         AV17SecUserRole.setgxTv_SdtSecUserRole_Secuserid( AV16SecUser.getgxTv_SdtSecUser_Secuserid() );
         AV17SecUserRole.setgxTv_SdtSecUserRole_Secroleid( (short)(2) );
         AV17SecUserRole.Save();
         if ( AV17SecUserRole.Success() )
         {
            Application.commitDataStores(context, remoteHandle, pr_default, "prccrearusuariodoctor");
            AV19subject = "Alertas Thani Salud - Creación de cuenta" ;
            GXt_char1 = "" ;
            GXv_char2[0] = GXt_char1 ;
            new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "DFSendMailAddress", GXv_char2) ;
            prccrearusuariodoctor.this.GXt_char1 = GXv_char2[0] ;
            AV10MailRecipient.setAddress( GXt_char1 );
            AV10MailRecipient.setName( "Alertas Thani Salud" );
            AV18SMTPSession.setHost( "mail.thanitech.pe" );
            GXt_char1 = "" ;
            GXv_char2[0] = GXt_char1 ;
            new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "DFSendMailAddress", GXv_char2) ;
            prccrearusuariodoctor.this.GXt_char1 = GXv_char2[0] ;
            AV18SMTPSession.setUserName( GXt_char1 );
            GXt_char1 = "" ;
            GXv_char2[0] = GXt_char1 ;
            new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "DFSendMailPassword", GXv_char2) ;
            prccrearusuariodoctor.this.GXt_char1 = GXv_char2[0] ;
            AV18SMTPSession.setPassword( GXt_char1 );
            AV18SMTPSession.setPort( 465 );
            AV18SMTPSession.setSender( AV10MailRecipient );
            AV18SMTPSession.setAuthentication( (short)(1) );
            AV18SMTPSession.setSecure( (short)(1) );
            AV18SMTPSession.login();
            if ( GXutil.strcmp(AV18SMTPSession.getErrDescription(), "OK") == 0 )
            {
               AV8Log = (byte)(1) ;
            }
            AV13Profesional.Load(A40000ProfesionalId);
            if ( ! (GXutil.strcmp("", AV14ProfesionalCorreo)==0) )
            {
               AV9MailMsg.getTo().addNew("Usuario: ", AV14ProfesionalCorreo) ;
               AV9MailMsg.getBcc().addNew("Audit: ", new com.projectthani.prcgetconfigvalue(remoteHandle, context).executeUdp( "DFSendMailAuditAddress")) ;
               AV9MailMsg.setSubject( AV19subject );
               GXt_char1 = AV20TemplateContent ;
               GXv_char2[0] = GXt_char1 ;
               new com.projectthani.prcgettemplatecontent(remoteHandle, context).execute( "CrearUsuarioDoctor", GXv_char2) ;
               prccrearusuariodoctor.this.GXt_char1 = GXv_char2[0] ;
               AV20TemplateContent = GXt_char1 ;
               AV20TemplateContent = GXutil.strReplace( AV20TemplateContent, "@IMG_HEADER", "https://www.quickanddirtytips.com/sites/default/files/styles/insert_large/public/images/12031/choosing-a-doctor.png") ;
               AV20TemplateContent = GXutil.strReplace( AV20TemplateContent, "@TIT_01", "<b>Creación de usuario: </b>") ;
               AV20TemplateContent = GXutil.strReplace( AV20TemplateContent, "@TIT_02", "<h3>Estimado/a: "+AV13Profesional.getgxTv_SdtProfesional_Profesionalapellidopaterno()+" "+AV13Profesional.getgxTv_SdtProfesional_Profesionalapellidomaterno()+", "+AV13Profesional.getgxTv_SdtProfesional_Profesionalnombres()+" </h3>") ;
               AV20TemplateContent = GXutil.strReplace( AV20TemplateContent, "@TIT_03", "Se ha creado su cuenta en Thani, sus accesos son:"+"<br>") ;
               AV20TemplateContent = GXutil.strReplace( AV20TemplateContent, "@PACIENTE_TIT", "<b>Información del Usuario</b>") ;
               AV20TemplateContent = GXutil.strReplace( AV20TemplateContent, "@USUARIO", "Usuario") ;
               AV20TemplateContent = GXutil.strReplace( AV20TemplateContent, "@TX_USUARIO", AV15ProfesionalNroDocumento) ;
               AV20TemplateContent = GXutil.strReplace( AV20TemplateContent, "@PASSWORD", "Clave") ;
               AV20TemplateContent = GXutil.strReplace( AV20TemplateContent, "@TX_PASSWORD", AV12PasswordRandom) ;
               AV9MailMsg.setHtmltext( AV20TemplateContent );
               GXt_dtime3 = GXutil.resetTime( GXutil.serverDate( context, remoteHandle, pr_default) );
               AV9MailMsg.setDateSent( GXt_dtime3 );
               AV18SMTPSession.send(AV9MailMsg);
               AV18SMTPSession.logout();
            }
         }
         else
         {
            Application.rollbackDataStores(context, remoteHandle, pr_default, "prccrearusuariodoctor");
         }
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "prccrearusuariodoctor");
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
      P002O3_A40000ProfesionalId = new int[1] ;
      P002O3_n40000ProfesionalId = new boolean[] {false} ;
      AV12PasswordRandom = "" ;
      AV16SecUser = new com.projectthani.wwpbaseobjects.SdtSecUser(remoteHandle);
      AV17SecUserRole = new com.projectthani.wwpbaseobjects.SdtSecUserRole(remoteHandle);
      AV19subject = "" ;
      AV10MailRecipient = new com.genexus.internet.MailRecipient();
      AV18SMTPSession = new com.genexus.internet.GXSMTPSession();
      AV13Profesional = new com.projectthani.SdtProfesional(remoteHandle);
      AV9MailMsg = new com.genexus.internet.GXMailMessage();
      AV20TemplateContent = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      GXt_dtime3 = GXutil.resetTime( GXutil.nullDate() );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prccrearusuariodoctor__default(),
         new Object[] {
             new Object[] {
            P002O3_A40000ProfesionalId, P002O3_n40000ProfesionalId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV8Log ;
   private short Gx_err ;
   private int A40000ProfesionalId ;
   private String scmdbuf ;
   private String AV19subject ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private java.util.Date GXt_dtime3 ;
   private boolean n40000ProfesionalId ;
   private String AV20TemplateContent ;
   private String AV15ProfesionalNroDocumento ;
   private String AV14ProfesionalCorreo ;
   private String AV12PasswordRandom ;
   private com.genexus.internet.MailRecipient AV10MailRecipient ;
   private com.genexus.internet.GXMailMessage AV9MailMsg ;
   private com.genexus.internet.GXSMTPSession AV18SMTPSession ;
   private com.projectthani.wwpbaseobjects.SdtSecUser AV16SecUser ;
   private com.projectthani.wwpbaseobjects.SdtSecUserRole AV17SecUserRole ;
   private IDataStoreProvider pr_default ;
   private int[] P002O3_A40000ProfesionalId ;
   private boolean[] P002O3_n40000ProfesionalId ;
   private com.projectthani.SdtProfesional AV13Profesional ;
}

final  class prccrearusuariodoctor__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P002O3", "SELECT COALESCE( T1.[ProfesionalId], 0) AS ProfesionalId FROM (SELECT MIN([ProfesionalId]) AS ProfesionalId FROM [Profesional] WHERE [ProfesionalNroDocumento] = ? ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
               stmt.setVarchar(1, (String)parms[0], 15);
               return;
      }
   }

}

