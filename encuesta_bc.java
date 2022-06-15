package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class encuesta_bc extends GXWebPanel implements IGxSilentTrn
{
   public encuesta_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public encuesta_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( encuesta_bc.class ));
   }

   public encuesta_bc( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow0L29( ) ;
      standaloneNotModal( ) ;
      initializeNonKey0L29( ) ;
      standaloneModal( ) ;
      addRow0L29( ) ;
      Gx_mode = "INS" ;
   }

   public void afterTrn( )
   {
      if ( trnEnded == 1 )
      {
         if ( ! (GXutil.strcmp("", endTrnMsgTxt)==0) )
         {
            httpContext.GX_msglist.addItem(endTrnMsgTxt, endTrnMsgCod, 0, "", true);
         }
         /* Execute user event: After Trn */
         e110L2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z37EncuestaId = A37EncuestaId ;
            SetMode( "UPD") ;
         }
      }
      endTrnMsgTxt = "" ;
   }

   public String toString( )
   {
      return "" ;
   }

   public GXContentInfo getContentInfo( )
   {
      return (GXContentInfo)(null) ;
   }

   public boolean Reindex( )
   {
      return true ;
   }

   public void confirm_0L0( )
   {
      beforeValidate0L29( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0L29( ) ;
         }
         else
         {
            checkExtendedTable0L29( ) ;
            if ( AnyError == 0 )
            {
               zm0L29( 5) ;
               zm0L29( 6) ;
               zm0L29( 7) ;
               zm0L29( 8) ;
               zm0L29( 9) ;
               zm0L29( 10) ;
               zm0L29( 11) ;
            }
            closeExtendedTableCursors0L29( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void e120L2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXv_SdtWWPContext1[0] = AV7WWPContext;
      new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV7WWPContext = GXv_SdtWWPContext1[0] ;
      AV8IsAuthorized = true ;
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV8IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEncuesta_Insert", GXv_boolean3) ;
         encuesta_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV8IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV8IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEncuesta_Update", GXv_boolean3) ;
         encuesta_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV8IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV8IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEncuesta_Delete", GXv_boolean3) ;
         encuesta_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV8IsAuthorized = GXt_boolean2 ;
      }
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV21Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV10TrnContext.fromxml(AV11WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV10TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV21Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV22GXV1 = 1 ;
         while ( AV22GXV1 <= AV10TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV13TrnContextAtt = (com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV10TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV22GXV1));
            if ( GXutil.strcmp(AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "CitaId") == 0 )
            {
               AV12Insert_CitaId = (int)(GXutil.lval( AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
            }
            AV22GXV1 = (int)(AV22GXV1+1) ;
         }
      }
   }

   public void e110L2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
   }

   public void zm0L29( int GX_JID )
   {
      if ( ( GX_JID == 4 ) || ( GX_JID == 0 ) )
      {
         Z148EncuestaAtencion = A148EncuestaAtencion ;
         Z149EncuestaAtendido = A149EncuestaAtendido ;
         Z150EncuestaHoraAtencion = A150EncuestaHoraAtencion ;
         Z152EncuestaRecomendacion = A152EncuestaRecomendacion ;
         Z153EncuestaEstado = A153EncuestaEstado ;
         Z19CitaId = A19CitaId ;
         Z82SGCitaDisponibilidadProFullName = A82SGCitaDisponibilidadProFullName ;
      }
      if ( ( GX_JID == 5 ) || ( GX_JID == 0 ) )
      {
         Z20PacienteId = A20PacienteId ;
         Z21SGCitaDisponibilidadId = A21SGCitaDisponibilidadId ;
         Z82SGCitaDisponibilidadProFullName = A82SGCitaDisponibilidadProFullName ;
      }
      if ( ( GX_JID == 6 ) || ( GX_JID == 0 ) )
      {
         Z103PacienteApellidoPaterno = A103PacienteApellidoPaterno ;
         Z104PacienteApellidoMaterno = A104PacienteApellidoMaterno ;
         Z105PacienteNombres = A105PacienteNombres ;
         Z82SGCitaDisponibilidadProFullName = A82SGCitaDisponibilidadProFullName ;
      }
      if ( ( GX_JID == 7 ) || ( GX_JID == 0 ) )
      {
         Z72SGCitaDisponibilidadSedeId = A72SGCitaDisponibilidadSedeId ;
         Z66SGCitaDisponibilidadFecha = A66SGCitaDisponibilidadFecha ;
         Z81SGCitaDisponibilidadProfesionalId = A81SGCitaDisponibilidadProfesionalId ;
         Z70SGCitaDisponibilidadEspecialidadId = A70SGCitaDisponibilidadEspecialidadId ;
         Z82SGCitaDisponibilidadProFullName = A82SGCitaDisponibilidadProFullName ;
      }
      if ( ( GX_JID == 8 ) || ( GX_JID == 0 ) )
      {
         Z84ProfesionalNombres = A84ProfesionalNombres ;
         Z85ProfesionalApellidoPaterno = A85ProfesionalApellidoPaterno ;
         Z86ProfesionalApellidoMaterno = A86ProfesionalApellidoMaterno ;
         Z82SGCitaDisponibilidadProFullName = A82SGCitaDisponibilidadProFullName ;
      }
      if ( ( GX_JID == 9 ) || ( GX_JID == 0 ) )
      {
         Z146SGCitaDisponibilidadEspecialidadNombre = A146SGCitaDisponibilidadEspecialidadNombre ;
         Z82SGCitaDisponibilidadProFullName = A82SGCitaDisponibilidadProFullName ;
      }
      if ( ( GX_JID == 10 ) || ( GX_JID == 0 ) )
      {
         Z76SGCitaDisponibilidadClinicaId = A76SGCitaDisponibilidadClinicaId ;
         Z82SGCitaDisponibilidadProFullName = A82SGCitaDisponibilidadProFullName ;
      }
      if ( ( GX_JID == 11 ) || ( GX_JID == 0 ) )
      {
         Z78SGCitaDisponibilidadClinicaNombre = A78SGCitaDisponibilidadClinicaNombre ;
         Z82SGCitaDisponibilidadProFullName = A82SGCitaDisponibilidadProFullName ;
      }
      if ( GX_JID == -4 )
      {
         Z37EncuestaId = A37EncuestaId ;
         Z148EncuestaAtencion = A148EncuestaAtencion ;
         Z149EncuestaAtendido = A149EncuestaAtendido ;
         Z150EncuestaHoraAtencion = A150EncuestaHoraAtencion ;
         Z151EncuestaComentarios = A151EncuestaComentarios ;
         Z152EncuestaRecomendacion = A152EncuestaRecomendacion ;
         Z153EncuestaEstado = A153EncuestaEstado ;
         Z19CitaId = A19CitaId ;
         Z20PacienteId = A20PacienteId ;
         Z21SGCitaDisponibilidadId = A21SGCitaDisponibilidadId ;
         Z103PacienteApellidoPaterno = A103PacienteApellidoPaterno ;
         Z104PacienteApellidoMaterno = A104PacienteApellidoMaterno ;
         Z105PacienteNombres = A105PacienteNombres ;
         Z72SGCitaDisponibilidadSedeId = A72SGCitaDisponibilidadSedeId ;
         Z66SGCitaDisponibilidadFecha = A66SGCitaDisponibilidadFecha ;
         Z81SGCitaDisponibilidadProfesionalId = A81SGCitaDisponibilidadProfesionalId ;
         Z70SGCitaDisponibilidadEspecialidadId = A70SGCitaDisponibilidadEspecialidadId ;
         Z76SGCitaDisponibilidadClinicaId = A76SGCitaDisponibilidadClinicaId ;
         Z78SGCitaDisponibilidadClinicaNombre = A78SGCitaDisponibilidadClinicaNombre ;
         Z84ProfesionalNombres = A84ProfesionalNombres ;
         Z85ProfesionalApellidoPaterno = A85ProfesionalApellidoPaterno ;
         Z86ProfesionalApellidoMaterno = A86ProfesionalApellidoMaterno ;
         Z146SGCitaDisponibilidadEspecialidadNombre = A146SGCitaDisponibilidadEspecialidadNombre ;
      }
   }

   public void standaloneNotModal( )
   {
   }

   public void standaloneModal( )
   {
   }

   public void load0L29( )
   {
      /* Using cursor BC000L11 */
      pr_default.execute(9, new Object[] {Short.valueOf(A37EncuestaId)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         RcdFound29 = (short)(1) ;
         A72SGCitaDisponibilidadSedeId = BC000L11_A72SGCitaDisponibilidadSedeId[0] ;
         A146SGCitaDisponibilidadEspecialidadNombre = BC000L11_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         A66SGCitaDisponibilidadFecha = BC000L11_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = BC000L11_n66SGCitaDisponibilidadFecha[0] ;
         A103PacienteApellidoPaterno = BC000L11_A103PacienteApellidoPaterno[0] ;
         A104PacienteApellidoMaterno = BC000L11_A104PacienteApellidoMaterno[0] ;
         A105PacienteNombres = BC000L11_A105PacienteNombres[0] ;
         A78SGCitaDisponibilidadClinicaNombre = BC000L11_A78SGCitaDisponibilidadClinicaNombre[0] ;
         A148EncuestaAtencion = BC000L11_A148EncuestaAtencion[0] ;
         n148EncuestaAtencion = BC000L11_n148EncuestaAtencion[0] ;
         A149EncuestaAtendido = BC000L11_A149EncuestaAtendido[0] ;
         n149EncuestaAtendido = BC000L11_n149EncuestaAtendido[0] ;
         A150EncuestaHoraAtencion = BC000L11_A150EncuestaHoraAtencion[0] ;
         n150EncuestaHoraAtencion = BC000L11_n150EncuestaHoraAtencion[0] ;
         A151EncuestaComentarios = BC000L11_A151EncuestaComentarios[0] ;
         n151EncuestaComentarios = BC000L11_n151EncuestaComentarios[0] ;
         A152EncuestaRecomendacion = BC000L11_A152EncuestaRecomendacion[0] ;
         A153EncuestaEstado = BC000L11_A153EncuestaEstado[0] ;
         n153EncuestaEstado = BC000L11_n153EncuestaEstado[0] ;
         A84ProfesionalNombres = BC000L11_A84ProfesionalNombres[0] ;
         n84ProfesionalNombres = BC000L11_n84ProfesionalNombres[0] ;
         A85ProfesionalApellidoPaterno = BC000L11_A85ProfesionalApellidoPaterno[0] ;
         n85ProfesionalApellidoPaterno = BC000L11_n85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = BC000L11_A86ProfesionalApellidoMaterno[0] ;
         n86ProfesionalApellidoMaterno = BC000L11_n86ProfesionalApellidoMaterno[0] ;
         A19CitaId = BC000L11_A19CitaId[0] ;
         A20PacienteId = BC000L11_A20PacienteId[0] ;
         A21SGCitaDisponibilidadId = BC000L11_A21SGCitaDisponibilidadId[0] ;
         A81SGCitaDisponibilidadProfesionalId = BC000L11_A81SGCitaDisponibilidadProfesionalId[0] ;
         A70SGCitaDisponibilidadEspecialidadId = BC000L11_A70SGCitaDisponibilidadEspecialidadId[0] ;
         A76SGCitaDisponibilidadClinicaId = BC000L11_A76SGCitaDisponibilidadClinicaId[0] ;
         zm0L29( -4) ;
      }
      pr_default.close(9);
      onLoadActions0L29( ) ;
   }

   public void onLoadActions0L29( )
   {
      AV21Pgmname = "Encuesta_BC" ;
      A82SGCitaDisponibilidadProFullName = A84ProfesionalNombres + " " + A85ProfesionalApellidoPaterno + " " + A86ProfesionalApellidoMaterno ;
   }

   public void checkExtendedTable0L29( )
   {
      nIsDirty_29 = (short)(0) ;
      standaloneModal( ) ;
      AV21Pgmname = "Encuesta_BC" ;
      /* Using cursor BC000L12 */
      pr_default.execute(10, new Object[] {Integer.valueOf(A19CitaId)});
      if ( (pr_default.getStatus(10) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Cita'.", "ForeignKeyNotFound", 1, "CITAID");
         AnyError = (short)(1) ;
      }
      A20PacienteId = BC000L12_A20PacienteId[0] ;
      A21SGCitaDisponibilidadId = BC000L12_A21SGCitaDisponibilidadId[0] ;
      pr_default.close(10);
      /* Using cursor BC000L13 */
      pr_default.execute(11, new Object[] {Integer.valueOf(A20PacienteId)});
      if ( (pr_default.getStatus(11) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Paciente'.", "ForeignKeyNotFound", 1, "PACIENTEID");
         AnyError = (short)(1) ;
      }
      A103PacienteApellidoPaterno = BC000L13_A103PacienteApellidoPaterno[0] ;
      A104PacienteApellidoMaterno = BC000L13_A104PacienteApellidoMaterno[0] ;
      A105PacienteNombres = BC000L13_A105PacienteNombres[0] ;
      pr_default.close(11);
      /* Using cursor BC000L14 */
      pr_default.execute(12, new Object[] {Integer.valueOf(A21SGCitaDisponibilidadId)});
      if ( (pr_default.getStatus(12) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'SGCita Disponibilidad'.", "ForeignKeyNotFound", 1, "SGCITADISPONIBILIDADID");
         AnyError = (short)(1) ;
      }
      A72SGCitaDisponibilidadSedeId = BC000L14_A72SGCitaDisponibilidadSedeId[0] ;
      A66SGCitaDisponibilidadFecha = BC000L14_A66SGCitaDisponibilidadFecha[0] ;
      n66SGCitaDisponibilidadFecha = BC000L14_n66SGCitaDisponibilidadFecha[0] ;
      A81SGCitaDisponibilidadProfesionalId = BC000L14_A81SGCitaDisponibilidadProfesionalId[0] ;
      A70SGCitaDisponibilidadEspecialidadId = BC000L14_A70SGCitaDisponibilidadEspecialidadId[0] ;
      pr_default.close(12);
      /* Using cursor BC000L15 */
      pr_default.execute(13, new Object[] {Short.valueOf(A72SGCitaDisponibilidadSedeId)});
      if ( (pr_default.getStatus(13) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Sede'.", "ForeignKeyNotFound", 1, "SGCITADISPONIBILIDADSEDEID");
         AnyError = (short)(1) ;
      }
      A76SGCitaDisponibilidadClinicaId = BC000L15_A76SGCitaDisponibilidadClinicaId[0] ;
      pr_default.close(13);
      /* Using cursor BC000L16 */
      pr_default.execute(14, new Object[] {Short.valueOf(A76SGCitaDisponibilidadClinicaId)});
      if ( (pr_default.getStatus(14) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Clinica'.", "ForeignKeyNotFound", 1, "SGCITADISPONIBILIDADCLINICAID");
         AnyError = (short)(1) ;
      }
      A78SGCitaDisponibilidadClinicaNombre = BC000L16_A78SGCitaDisponibilidadClinicaNombre[0] ;
      pr_default.close(14);
      /* Using cursor BC000L17 */
      pr_default.execute(15, new Object[] {Integer.valueOf(A81SGCitaDisponibilidadProfesionalId)});
      if ( (pr_default.getStatus(15) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'SGCita Disponibilidad'.", "ForeignKeyNotFound", 1, "SGCITADISPONIBILIDADPROFESIONALID");
         AnyError = (short)(1) ;
      }
      A84ProfesionalNombres = BC000L17_A84ProfesionalNombres[0] ;
      n84ProfesionalNombres = BC000L17_n84ProfesionalNombres[0] ;
      A85ProfesionalApellidoPaterno = BC000L17_A85ProfesionalApellidoPaterno[0] ;
      n85ProfesionalApellidoPaterno = BC000L17_n85ProfesionalApellidoPaterno[0] ;
      A86ProfesionalApellidoMaterno = BC000L17_A86ProfesionalApellidoMaterno[0] ;
      n86ProfesionalApellidoMaterno = BC000L17_n86ProfesionalApellidoMaterno[0] ;
      pr_default.close(15);
      nIsDirty_29 = (short)(1) ;
      A82SGCitaDisponibilidadProFullName = A84ProfesionalNombres + " " + A85ProfesionalApellidoPaterno + " " + A86ProfesionalApellidoMaterno ;
      /* Using cursor BC000L18 */
      pr_default.execute(16, new Object[] {Short.valueOf(A70SGCitaDisponibilidadEspecialidadId)});
      if ( (pr_default.getStatus(16) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'SGCita Disponibilidad'.", "ForeignKeyNotFound", 1, "SGCITADISPONIBILIDADESPECIALIDADID");
         AnyError = (short)(1) ;
      }
      A146SGCitaDisponibilidadEspecialidadNombre = BC000L18_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
      pr_default.close(16);
   }

   public void closeExtendedTableCursors0L29( )
   {
      pr_default.close(10);
      pr_default.close(11);
      pr_default.close(12);
      pr_default.close(13);
      pr_default.close(14);
      pr_default.close(15);
      pr_default.close(16);
   }

   public void enableDisable( )
   {
   }

   public void getKey0L29( )
   {
      /* Using cursor BC000L19 */
      pr_default.execute(17, new Object[] {Short.valueOf(A37EncuestaId)});
      if ( (pr_default.getStatus(17) != 101) )
      {
         RcdFound29 = (short)(1) ;
      }
      else
      {
         RcdFound29 = (short)(0) ;
      }
      pr_default.close(17);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC000L20 */
      pr_default.execute(18, new Object[] {Short.valueOf(A37EncuestaId)});
      if ( (pr_default.getStatus(18) != 101) )
      {
         zm0L29( 4) ;
         RcdFound29 = (short)(1) ;
         A37EncuestaId = BC000L20_A37EncuestaId[0] ;
         A148EncuestaAtencion = BC000L20_A148EncuestaAtencion[0] ;
         n148EncuestaAtencion = BC000L20_n148EncuestaAtencion[0] ;
         A149EncuestaAtendido = BC000L20_A149EncuestaAtendido[0] ;
         n149EncuestaAtendido = BC000L20_n149EncuestaAtendido[0] ;
         A150EncuestaHoraAtencion = BC000L20_A150EncuestaHoraAtencion[0] ;
         n150EncuestaHoraAtencion = BC000L20_n150EncuestaHoraAtencion[0] ;
         A151EncuestaComentarios = BC000L20_A151EncuestaComentarios[0] ;
         n151EncuestaComentarios = BC000L20_n151EncuestaComentarios[0] ;
         A152EncuestaRecomendacion = BC000L20_A152EncuestaRecomendacion[0] ;
         A153EncuestaEstado = BC000L20_A153EncuestaEstado[0] ;
         n153EncuestaEstado = BC000L20_n153EncuestaEstado[0] ;
         A19CitaId = BC000L20_A19CitaId[0] ;
         Z37EncuestaId = A37EncuestaId ;
         sMode29 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load0L29( ) ;
         if ( AnyError == 1 )
         {
            RcdFound29 = (short)(0) ;
            initializeNonKey0L29( ) ;
         }
         Gx_mode = sMode29 ;
      }
      else
      {
         RcdFound29 = (short)(0) ;
         initializeNonKey0L29( ) ;
         sMode29 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode29 ;
      }
      pr_default.close(18);
   }

   public void getEqualNoModal( )
   {
      getKey0L29( ) ;
      if ( RcdFound29 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
      }
      getByPrimaryKey( ) ;
   }

   public void insert_check( )
   {
      confirm_0L0( ) ;
      IsConfirmed = (short)(0) ;
   }

   public void update_check( )
   {
      insert_check( ) ;
   }

   public void delete_check( )
   {
      insert_check( ) ;
   }

   public void checkOptimisticConcurrency0L29( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000L21 */
         pr_default.execute(19, new Object[] {Short.valueOf(A37EncuestaId)});
         if ( (pr_default.getStatus(19) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Encuesta"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(19) == 101) || ( GXutil.strcmp(Z148EncuestaAtencion, BC000L21_A148EncuestaAtencion[0]) != 0 ) || ( GXutil.strcmp(Z149EncuestaAtendido, BC000L21_A149EncuestaAtendido[0]) != 0 ) || !( GXutil.dateCompare(Z150EncuestaHoraAtencion, BC000L21_A150EncuestaHoraAtencion[0]) ) || ( Z152EncuestaRecomendacion != BC000L21_A152EncuestaRecomendacion[0] ) || ( GXutil.strcmp(Z153EncuestaEstado, BC000L21_A153EncuestaEstado[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z19CitaId != BC000L21_A19CitaId[0] ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Encuesta"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0L29( )
   {
      beforeValidate0L29( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0L29( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0L29( 0) ;
         checkOptimisticConcurrency0L29( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0L29( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0L29( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000L22 */
                  pr_default.execute(20, new Object[] {Boolean.valueOf(n148EncuestaAtencion), A148EncuestaAtencion, Boolean.valueOf(n149EncuestaAtendido), A149EncuestaAtendido, Boolean.valueOf(n150EncuestaHoraAtencion), A150EncuestaHoraAtencion, Boolean.valueOf(n151EncuestaComentarios), A151EncuestaComentarios, Byte.valueOf(A152EncuestaRecomendacion), Boolean.valueOf(n153EncuestaEstado), A153EncuestaEstado, Integer.valueOf(A19CitaId)});
                  A37EncuestaId = BC000L22_A37EncuestaId[0] ;
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Encuesta");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
         else
         {
            load0L29( ) ;
         }
         endLevel0L29( ) ;
      }
      closeExtendedTableCursors0L29( ) ;
   }

   public void update0L29( )
   {
      beforeValidate0L29( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0L29( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0L29( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0L29( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0L29( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000L23 */
                  pr_default.execute(21, new Object[] {Boolean.valueOf(n148EncuestaAtencion), A148EncuestaAtencion, Boolean.valueOf(n149EncuestaAtendido), A149EncuestaAtendido, Boolean.valueOf(n150EncuestaHoraAtencion), A150EncuestaHoraAtencion, Boolean.valueOf(n151EncuestaComentarios), A151EncuestaComentarios, Byte.valueOf(A152EncuestaRecomendacion), Boolean.valueOf(n153EncuestaEstado), A153EncuestaEstado, Integer.valueOf(A19CitaId), Short.valueOf(A37EncuestaId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Encuesta");
                  if ( (pr_default.getStatus(21) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Encuesta"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0L29( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey( ) ;
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                        endTrnMsgCod = "SuccessfullyUpdated" ;
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
         }
         endLevel0L29( ) ;
      }
      closeExtendedTableCursors0L29( ) ;
   }

   public void deferredUpdate0L29( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0L29( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0L29( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0L29( ) ;
         afterConfirm0L29( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0L29( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000L24 */
               pr_default.execute(22, new Object[] {Short.valueOf(A37EncuestaId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Encuesta");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucdeleted") ;
                     endTrnMsgCod = "SuccessfullyDeleted" ;
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
      }
      sMode29 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel0L29( ) ;
      Gx_mode = sMode29 ;
   }

   public void onDeleteControls0L29( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV21Pgmname = "Encuesta_BC" ;
         /* Using cursor BC000L25 */
         pr_default.execute(23, new Object[] {Integer.valueOf(A19CitaId)});
         A20PacienteId = BC000L25_A20PacienteId[0] ;
         A21SGCitaDisponibilidadId = BC000L25_A21SGCitaDisponibilidadId[0] ;
         pr_default.close(23);
         /* Using cursor BC000L26 */
         pr_default.execute(24, new Object[] {Integer.valueOf(A20PacienteId)});
         A103PacienteApellidoPaterno = BC000L26_A103PacienteApellidoPaterno[0] ;
         A104PacienteApellidoMaterno = BC000L26_A104PacienteApellidoMaterno[0] ;
         A105PacienteNombres = BC000L26_A105PacienteNombres[0] ;
         pr_default.close(24);
         /* Using cursor BC000L27 */
         pr_default.execute(25, new Object[] {Integer.valueOf(A21SGCitaDisponibilidadId)});
         A72SGCitaDisponibilidadSedeId = BC000L27_A72SGCitaDisponibilidadSedeId[0] ;
         A66SGCitaDisponibilidadFecha = BC000L27_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = BC000L27_n66SGCitaDisponibilidadFecha[0] ;
         A81SGCitaDisponibilidadProfesionalId = BC000L27_A81SGCitaDisponibilidadProfesionalId[0] ;
         A70SGCitaDisponibilidadEspecialidadId = BC000L27_A70SGCitaDisponibilidadEspecialidadId[0] ;
         pr_default.close(25);
         /* Using cursor BC000L28 */
         pr_default.execute(26, new Object[] {Short.valueOf(A72SGCitaDisponibilidadSedeId)});
         A76SGCitaDisponibilidadClinicaId = BC000L28_A76SGCitaDisponibilidadClinicaId[0] ;
         pr_default.close(26);
         /* Using cursor BC000L29 */
         pr_default.execute(27, new Object[] {Short.valueOf(A76SGCitaDisponibilidadClinicaId)});
         A78SGCitaDisponibilidadClinicaNombre = BC000L29_A78SGCitaDisponibilidadClinicaNombre[0] ;
         pr_default.close(27);
         /* Using cursor BC000L30 */
         pr_default.execute(28, new Object[] {Integer.valueOf(A81SGCitaDisponibilidadProfesionalId)});
         A84ProfesionalNombres = BC000L30_A84ProfesionalNombres[0] ;
         n84ProfesionalNombres = BC000L30_n84ProfesionalNombres[0] ;
         A85ProfesionalApellidoPaterno = BC000L30_A85ProfesionalApellidoPaterno[0] ;
         n85ProfesionalApellidoPaterno = BC000L30_n85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = BC000L30_A86ProfesionalApellidoMaterno[0] ;
         n86ProfesionalApellidoMaterno = BC000L30_n86ProfesionalApellidoMaterno[0] ;
         pr_default.close(28);
         A82SGCitaDisponibilidadProFullName = A84ProfesionalNombres + " " + A85ProfesionalApellidoPaterno + " " + A86ProfesionalApellidoMaterno ;
         /* Using cursor BC000L31 */
         pr_default.execute(29, new Object[] {Short.valueOf(A70SGCitaDisponibilidadEspecialidadId)});
         A146SGCitaDisponibilidadEspecialidadNombre = BC000L31_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         pr_default.close(29);
      }
   }

   public void endLevel0L29( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(19);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0L29( ) ;
      }
      if ( AnyError == 0 )
      {
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart0L29( )
   {
      /* Scan By routine */
      /* Using cursor BC000L32 */
      pr_default.execute(30, new Object[] {Short.valueOf(A37EncuestaId)});
      RcdFound29 = (short)(0) ;
      if ( (pr_default.getStatus(30) != 101) )
      {
         RcdFound29 = (short)(1) ;
         A72SGCitaDisponibilidadSedeId = BC000L32_A72SGCitaDisponibilidadSedeId[0] ;
         A37EncuestaId = BC000L32_A37EncuestaId[0] ;
         A146SGCitaDisponibilidadEspecialidadNombre = BC000L32_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         A66SGCitaDisponibilidadFecha = BC000L32_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = BC000L32_n66SGCitaDisponibilidadFecha[0] ;
         A103PacienteApellidoPaterno = BC000L32_A103PacienteApellidoPaterno[0] ;
         A104PacienteApellidoMaterno = BC000L32_A104PacienteApellidoMaterno[0] ;
         A105PacienteNombres = BC000L32_A105PacienteNombres[0] ;
         A78SGCitaDisponibilidadClinicaNombre = BC000L32_A78SGCitaDisponibilidadClinicaNombre[0] ;
         A148EncuestaAtencion = BC000L32_A148EncuestaAtencion[0] ;
         n148EncuestaAtencion = BC000L32_n148EncuestaAtencion[0] ;
         A149EncuestaAtendido = BC000L32_A149EncuestaAtendido[0] ;
         n149EncuestaAtendido = BC000L32_n149EncuestaAtendido[0] ;
         A150EncuestaHoraAtencion = BC000L32_A150EncuestaHoraAtencion[0] ;
         n150EncuestaHoraAtencion = BC000L32_n150EncuestaHoraAtencion[0] ;
         A151EncuestaComentarios = BC000L32_A151EncuestaComentarios[0] ;
         n151EncuestaComentarios = BC000L32_n151EncuestaComentarios[0] ;
         A152EncuestaRecomendacion = BC000L32_A152EncuestaRecomendacion[0] ;
         A153EncuestaEstado = BC000L32_A153EncuestaEstado[0] ;
         n153EncuestaEstado = BC000L32_n153EncuestaEstado[0] ;
         A84ProfesionalNombres = BC000L32_A84ProfesionalNombres[0] ;
         n84ProfesionalNombres = BC000L32_n84ProfesionalNombres[0] ;
         A85ProfesionalApellidoPaterno = BC000L32_A85ProfesionalApellidoPaterno[0] ;
         n85ProfesionalApellidoPaterno = BC000L32_n85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = BC000L32_A86ProfesionalApellidoMaterno[0] ;
         n86ProfesionalApellidoMaterno = BC000L32_n86ProfesionalApellidoMaterno[0] ;
         A19CitaId = BC000L32_A19CitaId[0] ;
         A20PacienteId = BC000L32_A20PacienteId[0] ;
         A21SGCitaDisponibilidadId = BC000L32_A21SGCitaDisponibilidadId[0] ;
         A81SGCitaDisponibilidadProfesionalId = BC000L32_A81SGCitaDisponibilidadProfesionalId[0] ;
         A70SGCitaDisponibilidadEspecialidadId = BC000L32_A70SGCitaDisponibilidadEspecialidadId[0] ;
         A76SGCitaDisponibilidadClinicaId = BC000L32_A76SGCitaDisponibilidadClinicaId[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0L29( )
   {
      /* Scan next routine */
      pr_default.readNext(30);
      RcdFound29 = (short)(0) ;
      scanKeyLoad0L29( ) ;
   }

   public void scanKeyLoad0L29( )
   {
      sMode29 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(30) != 101) )
      {
         RcdFound29 = (short)(1) ;
         A72SGCitaDisponibilidadSedeId = BC000L32_A72SGCitaDisponibilidadSedeId[0] ;
         A37EncuestaId = BC000L32_A37EncuestaId[0] ;
         A146SGCitaDisponibilidadEspecialidadNombre = BC000L32_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         A66SGCitaDisponibilidadFecha = BC000L32_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = BC000L32_n66SGCitaDisponibilidadFecha[0] ;
         A103PacienteApellidoPaterno = BC000L32_A103PacienteApellidoPaterno[0] ;
         A104PacienteApellidoMaterno = BC000L32_A104PacienteApellidoMaterno[0] ;
         A105PacienteNombres = BC000L32_A105PacienteNombres[0] ;
         A78SGCitaDisponibilidadClinicaNombre = BC000L32_A78SGCitaDisponibilidadClinicaNombre[0] ;
         A148EncuestaAtencion = BC000L32_A148EncuestaAtencion[0] ;
         n148EncuestaAtencion = BC000L32_n148EncuestaAtencion[0] ;
         A149EncuestaAtendido = BC000L32_A149EncuestaAtendido[0] ;
         n149EncuestaAtendido = BC000L32_n149EncuestaAtendido[0] ;
         A150EncuestaHoraAtencion = BC000L32_A150EncuestaHoraAtencion[0] ;
         n150EncuestaHoraAtencion = BC000L32_n150EncuestaHoraAtencion[0] ;
         A151EncuestaComentarios = BC000L32_A151EncuestaComentarios[0] ;
         n151EncuestaComentarios = BC000L32_n151EncuestaComentarios[0] ;
         A152EncuestaRecomendacion = BC000L32_A152EncuestaRecomendacion[0] ;
         A153EncuestaEstado = BC000L32_A153EncuestaEstado[0] ;
         n153EncuestaEstado = BC000L32_n153EncuestaEstado[0] ;
         A84ProfesionalNombres = BC000L32_A84ProfesionalNombres[0] ;
         n84ProfesionalNombres = BC000L32_n84ProfesionalNombres[0] ;
         A85ProfesionalApellidoPaterno = BC000L32_A85ProfesionalApellidoPaterno[0] ;
         n85ProfesionalApellidoPaterno = BC000L32_n85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = BC000L32_A86ProfesionalApellidoMaterno[0] ;
         n86ProfesionalApellidoMaterno = BC000L32_n86ProfesionalApellidoMaterno[0] ;
         A19CitaId = BC000L32_A19CitaId[0] ;
         A20PacienteId = BC000L32_A20PacienteId[0] ;
         A21SGCitaDisponibilidadId = BC000L32_A21SGCitaDisponibilidadId[0] ;
         A81SGCitaDisponibilidadProfesionalId = BC000L32_A81SGCitaDisponibilidadProfesionalId[0] ;
         A70SGCitaDisponibilidadEspecialidadId = BC000L32_A70SGCitaDisponibilidadEspecialidadId[0] ;
         A76SGCitaDisponibilidadClinicaId = BC000L32_A76SGCitaDisponibilidadClinicaId[0] ;
      }
      Gx_mode = sMode29 ;
   }

   public void scanKeyEnd0L29( )
   {
      pr_default.close(30);
   }

   public void afterConfirm0L29( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0L29( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0L29( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0L29( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0L29( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0L29( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0L29( )
   {
   }

   public void send_integrity_lvl_hashes0L29( )
   {
   }

   public void addRow0L29( )
   {
      VarsToRow29( bcEncuesta) ;
   }

   public void readRow0L29( )
   {
      RowToVars29( bcEncuesta, 1) ;
   }

   public void initializeNonKey0L29( )
   {
      A72SGCitaDisponibilidadSedeId = (short)(0) ;
      A19CitaId = 0 ;
      A81SGCitaDisponibilidadProfesionalId = 0 ;
      A82SGCitaDisponibilidadProFullName = "" ;
      A70SGCitaDisponibilidadEspecialidadId = (short)(0) ;
      A146SGCitaDisponibilidadEspecialidadNombre = "" ;
      A21SGCitaDisponibilidadId = 0 ;
      A66SGCitaDisponibilidadFecha = GXutil.nullDate() ;
      n66SGCitaDisponibilidadFecha = false ;
      A20PacienteId = 0 ;
      A103PacienteApellidoPaterno = "" ;
      A104PacienteApellidoMaterno = "" ;
      A105PacienteNombres = "" ;
      A76SGCitaDisponibilidadClinicaId = (short)(0) ;
      A78SGCitaDisponibilidadClinicaNombre = "" ;
      A148EncuestaAtencion = "" ;
      n148EncuestaAtencion = false ;
      A149EncuestaAtendido = "" ;
      n149EncuestaAtendido = false ;
      A150EncuestaHoraAtencion = GXutil.resetTime( GXutil.nullDate() );
      n150EncuestaHoraAtencion = false ;
      A151EncuestaComentarios = "" ;
      n151EncuestaComentarios = false ;
      A152EncuestaRecomendacion = (byte)(0) ;
      A153EncuestaEstado = "" ;
      n153EncuestaEstado = false ;
      A84ProfesionalNombres = "" ;
      n84ProfesionalNombres = false ;
      A85ProfesionalApellidoPaterno = "" ;
      n85ProfesionalApellidoPaterno = false ;
      A86ProfesionalApellidoMaterno = "" ;
      n86ProfesionalApellidoMaterno = false ;
      Z148EncuestaAtencion = "" ;
      Z149EncuestaAtendido = "" ;
      Z150EncuestaHoraAtencion = GXutil.resetTime( GXutil.nullDate() );
      Z152EncuestaRecomendacion = (byte)(0) ;
      Z153EncuestaEstado = "" ;
      Z19CitaId = 0 ;
   }

   public void initAll0L29( )
   {
      A37EncuestaId = (short)(0) ;
      initializeNonKey0L29( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public boolean isIns( )
   {
      return ((GXutil.strcmp(Gx_mode, "INS")==0) ? true : false) ;
   }

   public boolean isDlt( )
   {
      return ((GXutil.strcmp(Gx_mode, "DLT")==0) ? true : false) ;
   }

   public boolean isUpd( )
   {
      return ((GXutil.strcmp(Gx_mode, "UPD")==0) ? true : false) ;
   }

   public boolean isDsp( )
   {
      return ((GXutil.strcmp(Gx_mode, "DSP")==0) ? true : false) ;
   }

   public void VarsToRow29( com.projectthani.SdtEncuesta obj29 )
   {
      obj29.setgxTv_SdtEncuesta_Mode( Gx_mode );
      obj29.setgxTv_SdtEncuesta_Citaid( A19CitaId );
      obj29.setgxTv_SdtEncuesta_Sgcitadisponibilidadprofesionalid( A81SGCitaDisponibilidadProfesionalId );
      obj29.setgxTv_SdtEncuesta_Sgcitadisponibilidadprofullname( A82SGCitaDisponibilidadProFullName );
      obj29.setgxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadid( A70SGCitaDisponibilidadEspecialidadId );
      obj29.setgxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadnombre( A146SGCitaDisponibilidadEspecialidadNombre );
      obj29.setgxTv_SdtEncuesta_Sgcitadisponibilidadid( A21SGCitaDisponibilidadId );
      obj29.setgxTv_SdtEncuesta_Sgcitadisponibilidadfecha( A66SGCitaDisponibilidadFecha );
      obj29.setgxTv_SdtEncuesta_Pacienteid( A20PacienteId );
      obj29.setgxTv_SdtEncuesta_Pacienteapellidopaterno( A103PacienteApellidoPaterno );
      obj29.setgxTv_SdtEncuesta_Pacienteapellidomaterno( A104PacienteApellidoMaterno );
      obj29.setgxTv_SdtEncuesta_Pacientenombres( A105PacienteNombres );
      obj29.setgxTv_SdtEncuesta_Sgcitadisponibilidadclinicaid( A76SGCitaDisponibilidadClinicaId );
      obj29.setgxTv_SdtEncuesta_Sgcitadisponibilidadclinicanombre( A78SGCitaDisponibilidadClinicaNombre );
      obj29.setgxTv_SdtEncuesta_Encuestaatencion( A148EncuestaAtencion );
      obj29.setgxTv_SdtEncuesta_Encuestaatendido( A149EncuestaAtendido );
      obj29.setgxTv_SdtEncuesta_Encuestahoraatencion( A150EncuestaHoraAtencion );
      obj29.setgxTv_SdtEncuesta_Encuestacomentarios( A151EncuestaComentarios );
      obj29.setgxTv_SdtEncuesta_Encuestarecomendacion( A152EncuestaRecomendacion );
      obj29.setgxTv_SdtEncuesta_Encuestaestado( A153EncuestaEstado );
      obj29.setgxTv_SdtEncuesta_Encuestaid( A37EncuestaId );
      obj29.setgxTv_SdtEncuesta_Encuestaid_Z( Z37EncuestaId );
      obj29.setgxTv_SdtEncuesta_Citaid_Z( Z19CitaId );
      obj29.setgxTv_SdtEncuesta_Sgcitadisponibilidadprofesionalid_Z( Z81SGCitaDisponibilidadProfesionalId );
      obj29.setgxTv_SdtEncuesta_Sgcitadisponibilidadprofullname_Z( Z82SGCitaDisponibilidadProFullName );
      obj29.setgxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadid_Z( Z70SGCitaDisponibilidadEspecialidadId );
      obj29.setgxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadnombre_Z( Z146SGCitaDisponibilidadEspecialidadNombre );
      obj29.setgxTv_SdtEncuesta_Sgcitadisponibilidadid_Z( Z21SGCitaDisponibilidadId );
      obj29.setgxTv_SdtEncuesta_Sgcitadisponibilidadfecha_Z( Z66SGCitaDisponibilidadFecha );
      obj29.setgxTv_SdtEncuesta_Pacienteid_Z( Z20PacienteId );
      obj29.setgxTv_SdtEncuesta_Pacienteapellidopaterno_Z( Z103PacienteApellidoPaterno );
      obj29.setgxTv_SdtEncuesta_Pacienteapellidomaterno_Z( Z104PacienteApellidoMaterno );
      obj29.setgxTv_SdtEncuesta_Pacientenombres_Z( Z105PacienteNombres );
      obj29.setgxTv_SdtEncuesta_Sgcitadisponibilidadclinicaid_Z( Z76SGCitaDisponibilidadClinicaId );
      obj29.setgxTv_SdtEncuesta_Sgcitadisponibilidadclinicanombre_Z( Z78SGCitaDisponibilidadClinicaNombre );
      obj29.setgxTv_SdtEncuesta_Encuestaatencion_Z( Z148EncuestaAtencion );
      obj29.setgxTv_SdtEncuesta_Encuestaatendido_Z( Z149EncuestaAtendido );
      obj29.setgxTv_SdtEncuesta_Encuestahoraatencion_Z( Z150EncuestaHoraAtencion );
      obj29.setgxTv_SdtEncuesta_Encuestarecomendacion_Z( Z152EncuestaRecomendacion );
      obj29.setgxTv_SdtEncuesta_Encuestaestado_Z( Z153EncuestaEstado );
      obj29.setgxTv_SdtEncuesta_Sgcitadisponibilidadfecha_N( (byte)((byte)((n66SGCitaDisponibilidadFecha)?1:0)) );
      obj29.setgxTv_SdtEncuesta_Encuestaatencion_N( (byte)((byte)((n148EncuestaAtencion)?1:0)) );
      obj29.setgxTv_SdtEncuesta_Encuestaatendido_N( (byte)((byte)((n149EncuestaAtendido)?1:0)) );
      obj29.setgxTv_SdtEncuesta_Encuestahoraatencion_N( (byte)((byte)((n150EncuestaHoraAtencion)?1:0)) );
      obj29.setgxTv_SdtEncuesta_Encuestacomentarios_N( (byte)((byte)((n151EncuestaComentarios)?1:0)) );
      obj29.setgxTv_SdtEncuesta_Encuestaestado_N( (byte)((byte)((n153EncuestaEstado)?1:0)) );
      obj29.setgxTv_SdtEncuesta_Mode( Gx_mode );
   }

   public void KeyVarsToRow29( com.projectthani.SdtEncuesta obj29 )
   {
      obj29.setgxTv_SdtEncuesta_Encuestaid( A37EncuestaId );
   }

   public void RowToVars29( com.projectthani.SdtEncuesta obj29 ,
                            int forceLoad )
   {
      Gx_mode = obj29.getgxTv_SdtEncuesta_Mode() ;
      A19CitaId = obj29.getgxTv_SdtEncuesta_Citaid() ;
      A81SGCitaDisponibilidadProfesionalId = obj29.getgxTv_SdtEncuesta_Sgcitadisponibilidadprofesionalid() ;
      A82SGCitaDisponibilidadProFullName = obj29.getgxTv_SdtEncuesta_Sgcitadisponibilidadprofullname() ;
      A70SGCitaDisponibilidadEspecialidadId = obj29.getgxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadid() ;
      A146SGCitaDisponibilidadEspecialidadNombre = obj29.getgxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadnombre() ;
      A21SGCitaDisponibilidadId = obj29.getgxTv_SdtEncuesta_Sgcitadisponibilidadid() ;
      A66SGCitaDisponibilidadFecha = obj29.getgxTv_SdtEncuesta_Sgcitadisponibilidadfecha() ;
      n66SGCitaDisponibilidadFecha = false ;
      A20PacienteId = obj29.getgxTv_SdtEncuesta_Pacienteid() ;
      A103PacienteApellidoPaterno = obj29.getgxTv_SdtEncuesta_Pacienteapellidopaterno() ;
      A104PacienteApellidoMaterno = obj29.getgxTv_SdtEncuesta_Pacienteapellidomaterno() ;
      A105PacienteNombres = obj29.getgxTv_SdtEncuesta_Pacientenombres() ;
      A76SGCitaDisponibilidadClinicaId = obj29.getgxTv_SdtEncuesta_Sgcitadisponibilidadclinicaid() ;
      A78SGCitaDisponibilidadClinicaNombre = obj29.getgxTv_SdtEncuesta_Sgcitadisponibilidadclinicanombre() ;
      A148EncuestaAtencion = obj29.getgxTv_SdtEncuesta_Encuestaatencion() ;
      n148EncuestaAtencion = false ;
      A149EncuestaAtendido = obj29.getgxTv_SdtEncuesta_Encuestaatendido() ;
      n149EncuestaAtendido = false ;
      A150EncuestaHoraAtencion = obj29.getgxTv_SdtEncuesta_Encuestahoraatencion() ;
      n150EncuestaHoraAtencion = false ;
      A151EncuestaComentarios = obj29.getgxTv_SdtEncuesta_Encuestacomentarios() ;
      n151EncuestaComentarios = false ;
      A152EncuestaRecomendacion = obj29.getgxTv_SdtEncuesta_Encuestarecomendacion() ;
      A153EncuestaEstado = obj29.getgxTv_SdtEncuesta_Encuestaestado() ;
      n153EncuestaEstado = false ;
      A37EncuestaId = obj29.getgxTv_SdtEncuesta_Encuestaid() ;
      Z37EncuestaId = obj29.getgxTv_SdtEncuesta_Encuestaid_Z() ;
      Z19CitaId = obj29.getgxTv_SdtEncuesta_Citaid_Z() ;
      Z81SGCitaDisponibilidadProfesionalId = obj29.getgxTv_SdtEncuesta_Sgcitadisponibilidadprofesionalid_Z() ;
      Z82SGCitaDisponibilidadProFullName = obj29.getgxTv_SdtEncuesta_Sgcitadisponibilidadprofullname_Z() ;
      Z70SGCitaDisponibilidadEspecialidadId = obj29.getgxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadid_Z() ;
      Z146SGCitaDisponibilidadEspecialidadNombre = obj29.getgxTv_SdtEncuesta_Sgcitadisponibilidadespecialidadnombre_Z() ;
      Z21SGCitaDisponibilidadId = obj29.getgxTv_SdtEncuesta_Sgcitadisponibilidadid_Z() ;
      Z66SGCitaDisponibilidadFecha = obj29.getgxTv_SdtEncuesta_Sgcitadisponibilidadfecha_Z() ;
      Z20PacienteId = obj29.getgxTv_SdtEncuesta_Pacienteid_Z() ;
      Z103PacienteApellidoPaterno = obj29.getgxTv_SdtEncuesta_Pacienteapellidopaterno_Z() ;
      Z104PacienteApellidoMaterno = obj29.getgxTv_SdtEncuesta_Pacienteapellidomaterno_Z() ;
      Z105PacienteNombres = obj29.getgxTv_SdtEncuesta_Pacientenombres_Z() ;
      Z76SGCitaDisponibilidadClinicaId = obj29.getgxTv_SdtEncuesta_Sgcitadisponibilidadclinicaid_Z() ;
      Z78SGCitaDisponibilidadClinicaNombre = obj29.getgxTv_SdtEncuesta_Sgcitadisponibilidadclinicanombre_Z() ;
      Z148EncuestaAtencion = obj29.getgxTv_SdtEncuesta_Encuestaatencion_Z() ;
      Z149EncuestaAtendido = obj29.getgxTv_SdtEncuesta_Encuestaatendido_Z() ;
      Z150EncuestaHoraAtencion = obj29.getgxTv_SdtEncuesta_Encuestahoraatencion_Z() ;
      Z152EncuestaRecomendacion = obj29.getgxTv_SdtEncuesta_Encuestarecomendacion_Z() ;
      Z153EncuestaEstado = obj29.getgxTv_SdtEncuesta_Encuestaestado_Z() ;
      n66SGCitaDisponibilidadFecha = (boolean)((obj29.getgxTv_SdtEncuesta_Sgcitadisponibilidadfecha_N()==0)?false:true) ;
      n148EncuestaAtencion = (boolean)((obj29.getgxTv_SdtEncuesta_Encuestaatencion_N()==0)?false:true) ;
      n149EncuestaAtendido = (boolean)((obj29.getgxTv_SdtEncuesta_Encuestaatendido_N()==0)?false:true) ;
      n150EncuestaHoraAtencion = (boolean)((obj29.getgxTv_SdtEncuesta_Encuestahoraatencion_N()==0)?false:true) ;
      n151EncuestaComentarios = (boolean)((obj29.getgxTv_SdtEncuesta_Encuestacomentarios_N()==0)?false:true) ;
      n153EncuestaEstado = (boolean)((obj29.getgxTv_SdtEncuesta_Encuestaestado_N()==0)?false:true) ;
      Gx_mode = obj29.getgxTv_SdtEncuesta_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A37EncuestaId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.SHORT)).shortValue() ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey0L29( ) ;
      scanKeyStart0L29( ) ;
      if ( RcdFound29 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z37EncuestaId = A37EncuestaId ;
      }
      zm0L29( -4) ;
      onLoadActions0L29( ) ;
      addRow0L29( ) ;
      scanKeyEnd0L29( ) ;
      if ( RcdFound29 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void Load( )
   {
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      RowToVars29( bcEncuesta, 0) ;
      scanKeyStart0L29( ) ;
      if ( RcdFound29 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z37EncuestaId = A37EncuestaId ;
      }
      zm0L29( -4) ;
      onLoadActions0L29( ) ;
      addRow0L29( ) ;
      scanKeyEnd0L29( ) ;
      if ( RcdFound29 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0L29( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert0L29( ) ;
      }
      else
      {
         if ( RcdFound29 == 1 )
         {
            if ( A37EncuestaId != Z37EncuestaId )
            {
               A37EncuestaId = Z37EncuestaId ;
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "");
               AnyError = (short)(1) ;
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               /* Update record */
               update0L29( ) ;
            }
         }
         else
         {
            if ( isDlt( ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "");
               AnyError = (short)(1) ;
            }
            else
            {
               if ( A37EncuestaId != Z37EncuestaId )
               {
                  if ( isUpd( ) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "DuplicatePrimaryKey", 1, "");
                     AnyError = (short)(1) ;
                  }
                  else
                  {
                     Gx_mode = "INS" ;
                     /* Insert record */
                     insert0L29( ) ;
                  }
               }
               else
               {
                  if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "");
                     AnyError = (short)(1) ;
                  }
                  else
                  {
                     Gx_mode = "INS" ;
                     /* Insert record */
                     insert0L29( ) ;
                  }
               }
            }
         }
      }
      afterTrn( ) ;
   }

   public void Save( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars29( bcEncuesta, 1) ;
      saveImpl( ) ;
      VarsToRow29( bcEncuesta) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars29( bcEncuesta, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0L29( ) ;
      afterTrn( ) ;
      VarsToRow29( bcEncuesta) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void updateImpl( )
   {
      if ( isUpd( ) )
      {
         saveImpl( ) ;
      }
      else
      {
         com.projectthani.SdtEncuesta auxBC = new com.projectthani.SdtEncuesta( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A37EncuestaId);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcEncuesta);
            auxBC.Save();
         }
         LclMsgLst = auxTrn.GetMessages() ;
         AnyError = (short)(auxTrn.Errors()) ;
         httpContext.GX_msglist = LclMsgLst ;
         if ( auxTrn.Errors() == 0 )
         {
            Gx_mode = auxTrn.GetMode() ;
            afterTrn( ) ;
         }
      }
   }

   public boolean Update( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars29( bcEncuesta, 1) ;
      updateImpl( ) ;
      VarsToRow29( bcEncuesta) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public boolean InsertOrUpdate( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars29( bcEncuesta, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0L29( ) ;
      if ( AnyError == 1 )
      {
         if ( GXutil.strcmp(httpContext.GX_msglist.getItemValue((short)(1)), "DuplicatePrimaryKey") == 0 )
         {
            AnyError = (short)(0) ;
            httpContext.GX_msglist.removeAllItems();
            updateImpl( ) ;
         }
      }
      else
      {
         afterTrn( ) ;
      }
      VarsToRow29( bcEncuesta) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars29( bcEncuesta, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey0L29( ) ;
      if ( RcdFound29 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( A37EncuestaId != Z37EncuestaId )
         {
            A37EncuestaId = Z37EncuestaId ;
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( isDlt( ) )
         {
            delete_check( ) ;
         }
         else
         {
            Gx_mode = "UPD" ;
            update_check( ) ;
         }
      }
      else
      {
         if ( A37EncuestaId != Z37EncuestaId )
         {
            Gx_mode = "INS" ;
            insert_check( ) ;
         }
         else
         {
            if ( isUpd( ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "");
               AnyError = (short)(1) ;
            }
            else
            {
               Gx_mode = "INS" ;
               insert_check( ) ;
            }
         }
      }
      pr_default.close(1);
      pr_default.close(0);
      pr_default.close(23);
      pr_default.close(2);
      pr_default.close(24);
      pr_default.close(3);
      pr_default.close(25);
      pr_default.close(4);
      pr_default.close(28);
      pr_default.close(5);
      pr_default.close(29);
      pr_default.close(6);
      pr_default.close(26);
      pr_default.close(7);
      pr_default.close(27);
      pr_default.close(8);
      Application.rollbackDataStores(context, remoteHandle, pr_default, "encuesta_bc");
      VarsToRow29( bcEncuesta) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public int Errors( )
   {
      if ( AnyError == 0 )
      {
         return 0 ;
      }
      return 1 ;
   }

   public com.genexus.internet.MsgList GetMessages( )
   {
      return LclMsgLst ;
   }

   public String GetMode( )
   {
      Gx_mode = bcEncuesta.getgxTv_SdtEncuesta_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcEncuesta.setgxTv_SdtEncuesta_Mode( Gx_mode );
   }

   public void SetSDT( com.projectthani.SdtEncuesta sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcEncuesta )
      {
         bcEncuesta = sdt ;
         if ( GXutil.strcmp(bcEncuesta.getgxTv_SdtEncuesta_Mode(), "") == 0 )
         {
            bcEncuesta.setgxTv_SdtEncuesta_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow29( bcEncuesta) ;
         }
         else
         {
            RowToVars29( bcEncuesta, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcEncuesta.getgxTv_SdtEncuesta_Mode(), "") == 0 )
         {
            bcEncuesta.setgxTv_SdtEncuesta_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars29( bcEncuesta, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtEncuesta getEncuesta_BC( )
   {
      return bcEncuesta ;
   }


   public void webExecute( )
   {
   }

   protected void createObjects( )
   {
   }

   protected void Process( )
   {
   }

   protected void cleanup( )
   {
      super.cleanup();
      CloseOpenCursors();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Gx_mode = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV7WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV21Pgmname = "" ;
      AV10TrnContext = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11WebSession = httpContext.getWebSession();
      AV13TrnContextAtt = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      Z148EncuestaAtencion = "" ;
      A148EncuestaAtencion = "" ;
      Z149EncuestaAtendido = "" ;
      A149EncuestaAtendido = "" ;
      Z150EncuestaHoraAtencion = GXutil.resetTime( GXutil.nullDate() );
      A150EncuestaHoraAtencion = GXutil.resetTime( GXutil.nullDate() );
      Z153EncuestaEstado = "" ;
      A153EncuestaEstado = "" ;
      Z82SGCitaDisponibilidadProFullName = "" ;
      A82SGCitaDisponibilidadProFullName = "" ;
      Z103PacienteApellidoPaterno = "" ;
      A103PacienteApellidoPaterno = "" ;
      Z104PacienteApellidoMaterno = "" ;
      A104PacienteApellidoMaterno = "" ;
      Z105PacienteNombres = "" ;
      A105PacienteNombres = "" ;
      Z66SGCitaDisponibilidadFecha = GXutil.nullDate() ;
      A66SGCitaDisponibilidadFecha = GXutil.nullDate() ;
      Z84ProfesionalNombres = "" ;
      A84ProfesionalNombres = "" ;
      Z85ProfesionalApellidoPaterno = "" ;
      A85ProfesionalApellidoPaterno = "" ;
      Z86ProfesionalApellidoMaterno = "" ;
      A86ProfesionalApellidoMaterno = "" ;
      Z146SGCitaDisponibilidadEspecialidadNombre = "" ;
      A146SGCitaDisponibilidadEspecialidadNombre = "" ;
      Z78SGCitaDisponibilidadClinicaNombre = "" ;
      A78SGCitaDisponibilidadClinicaNombre = "" ;
      Z151EncuestaComentarios = "" ;
      A151EncuestaComentarios = "" ;
      BC000L11_A72SGCitaDisponibilidadSedeId = new short[1] ;
      BC000L11_A37EncuestaId = new short[1] ;
      BC000L11_A146SGCitaDisponibilidadEspecialidadNombre = new String[] {""} ;
      BC000L11_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      BC000L11_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      BC000L11_A103PacienteApellidoPaterno = new String[] {""} ;
      BC000L11_A104PacienteApellidoMaterno = new String[] {""} ;
      BC000L11_A105PacienteNombres = new String[] {""} ;
      BC000L11_A78SGCitaDisponibilidadClinicaNombre = new String[] {""} ;
      BC000L11_A148EncuestaAtencion = new String[] {""} ;
      BC000L11_n148EncuestaAtencion = new boolean[] {false} ;
      BC000L11_A149EncuestaAtendido = new String[] {""} ;
      BC000L11_n149EncuestaAtendido = new boolean[] {false} ;
      BC000L11_A150EncuestaHoraAtencion = new java.util.Date[] {GXutil.nullDate()} ;
      BC000L11_n150EncuestaHoraAtencion = new boolean[] {false} ;
      BC000L11_A151EncuestaComentarios = new String[] {""} ;
      BC000L11_n151EncuestaComentarios = new boolean[] {false} ;
      BC000L11_A152EncuestaRecomendacion = new byte[1] ;
      BC000L11_A153EncuestaEstado = new String[] {""} ;
      BC000L11_n153EncuestaEstado = new boolean[] {false} ;
      BC000L11_A84ProfesionalNombres = new String[] {""} ;
      BC000L11_n84ProfesionalNombres = new boolean[] {false} ;
      BC000L11_A85ProfesionalApellidoPaterno = new String[] {""} ;
      BC000L11_n85ProfesionalApellidoPaterno = new boolean[] {false} ;
      BC000L11_A86ProfesionalApellidoMaterno = new String[] {""} ;
      BC000L11_n86ProfesionalApellidoMaterno = new boolean[] {false} ;
      BC000L11_A19CitaId = new int[1] ;
      BC000L11_A20PacienteId = new int[1] ;
      BC000L11_A21SGCitaDisponibilidadId = new int[1] ;
      BC000L11_A81SGCitaDisponibilidadProfesionalId = new int[1] ;
      BC000L11_A70SGCitaDisponibilidadEspecialidadId = new short[1] ;
      BC000L11_A76SGCitaDisponibilidadClinicaId = new short[1] ;
      BC000L12_A20PacienteId = new int[1] ;
      BC000L12_A21SGCitaDisponibilidadId = new int[1] ;
      BC000L13_A103PacienteApellidoPaterno = new String[] {""} ;
      BC000L13_A104PacienteApellidoMaterno = new String[] {""} ;
      BC000L13_A105PacienteNombres = new String[] {""} ;
      BC000L14_A72SGCitaDisponibilidadSedeId = new short[1] ;
      BC000L14_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      BC000L14_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      BC000L14_A81SGCitaDisponibilidadProfesionalId = new int[1] ;
      BC000L14_A70SGCitaDisponibilidadEspecialidadId = new short[1] ;
      BC000L15_A76SGCitaDisponibilidadClinicaId = new short[1] ;
      BC000L16_A78SGCitaDisponibilidadClinicaNombre = new String[] {""} ;
      BC000L17_A84ProfesionalNombres = new String[] {""} ;
      BC000L17_n84ProfesionalNombres = new boolean[] {false} ;
      BC000L17_A85ProfesionalApellidoPaterno = new String[] {""} ;
      BC000L17_n85ProfesionalApellidoPaterno = new boolean[] {false} ;
      BC000L17_A86ProfesionalApellidoMaterno = new String[] {""} ;
      BC000L17_n86ProfesionalApellidoMaterno = new boolean[] {false} ;
      BC000L18_A146SGCitaDisponibilidadEspecialidadNombre = new String[] {""} ;
      BC000L19_A37EncuestaId = new short[1] ;
      BC000L20_A37EncuestaId = new short[1] ;
      BC000L20_A148EncuestaAtencion = new String[] {""} ;
      BC000L20_n148EncuestaAtencion = new boolean[] {false} ;
      BC000L20_A149EncuestaAtendido = new String[] {""} ;
      BC000L20_n149EncuestaAtendido = new boolean[] {false} ;
      BC000L20_A150EncuestaHoraAtencion = new java.util.Date[] {GXutil.nullDate()} ;
      BC000L20_n150EncuestaHoraAtencion = new boolean[] {false} ;
      BC000L20_A151EncuestaComentarios = new String[] {""} ;
      BC000L20_n151EncuestaComentarios = new boolean[] {false} ;
      BC000L20_A152EncuestaRecomendacion = new byte[1] ;
      BC000L20_A153EncuestaEstado = new String[] {""} ;
      BC000L20_n153EncuestaEstado = new boolean[] {false} ;
      BC000L20_A19CitaId = new int[1] ;
      sMode29 = "" ;
      BC000L21_A37EncuestaId = new short[1] ;
      BC000L21_A148EncuestaAtencion = new String[] {""} ;
      BC000L21_n148EncuestaAtencion = new boolean[] {false} ;
      BC000L21_A149EncuestaAtendido = new String[] {""} ;
      BC000L21_n149EncuestaAtendido = new boolean[] {false} ;
      BC000L21_A150EncuestaHoraAtencion = new java.util.Date[] {GXutil.nullDate()} ;
      BC000L21_n150EncuestaHoraAtencion = new boolean[] {false} ;
      BC000L21_A151EncuestaComentarios = new String[] {""} ;
      BC000L21_n151EncuestaComentarios = new boolean[] {false} ;
      BC000L21_A152EncuestaRecomendacion = new byte[1] ;
      BC000L21_A153EncuestaEstado = new String[] {""} ;
      BC000L21_n153EncuestaEstado = new boolean[] {false} ;
      BC000L21_A19CitaId = new int[1] ;
      BC000L22_A37EncuestaId = new short[1] ;
      BC000L25_A20PacienteId = new int[1] ;
      BC000L25_A21SGCitaDisponibilidadId = new int[1] ;
      BC000L26_A103PacienteApellidoPaterno = new String[] {""} ;
      BC000L26_A104PacienteApellidoMaterno = new String[] {""} ;
      BC000L26_A105PacienteNombres = new String[] {""} ;
      BC000L27_A72SGCitaDisponibilidadSedeId = new short[1] ;
      BC000L27_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      BC000L27_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      BC000L27_A81SGCitaDisponibilidadProfesionalId = new int[1] ;
      BC000L27_A70SGCitaDisponibilidadEspecialidadId = new short[1] ;
      BC000L28_A76SGCitaDisponibilidadClinicaId = new short[1] ;
      BC000L29_A78SGCitaDisponibilidadClinicaNombre = new String[] {""} ;
      BC000L30_A84ProfesionalNombres = new String[] {""} ;
      BC000L30_n84ProfesionalNombres = new boolean[] {false} ;
      BC000L30_A85ProfesionalApellidoPaterno = new String[] {""} ;
      BC000L30_n85ProfesionalApellidoPaterno = new boolean[] {false} ;
      BC000L30_A86ProfesionalApellidoMaterno = new String[] {""} ;
      BC000L30_n86ProfesionalApellidoMaterno = new boolean[] {false} ;
      BC000L31_A146SGCitaDisponibilidadEspecialidadNombre = new String[] {""} ;
      BC000L32_A72SGCitaDisponibilidadSedeId = new short[1] ;
      BC000L32_A37EncuestaId = new short[1] ;
      BC000L32_A146SGCitaDisponibilidadEspecialidadNombre = new String[] {""} ;
      BC000L32_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      BC000L32_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      BC000L32_A103PacienteApellidoPaterno = new String[] {""} ;
      BC000L32_A104PacienteApellidoMaterno = new String[] {""} ;
      BC000L32_A105PacienteNombres = new String[] {""} ;
      BC000L32_A78SGCitaDisponibilidadClinicaNombre = new String[] {""} ;
      BC000L32_A148EncuestaAtencion = new String[] {""} ;
      BC000L32_n148EncuestaAtencion = new boolean[] {false} ;
      BC000L32_A149EncuestaAtendido = new String[] {""} ;
      BC000L32_n149EncuestaAtendido = new boolean[] {false} ;
      BC000L32_A150EncuestaHoraAtencion = new java.util.Date[] {GXutil.nullDate()} ;
      BC000L32_n150EncuestaHoraAtencion = new boolean[] {false} ;
      BC000L32_A151EncuestaComentarios = new String[] {""} ;
      BC000L32_n151EncuestaComentarios = new boolean[] {false} ;
      BC000L32_A152EncuestaRecomendacion = new byte[1] ;
      BC000L32_A153EncuestaEstado = new String[] {""} ;
      BC000L32_n153EncuestaEstado = new boolean[] {false} ;
      BC000L32_A84ProfesionalNombres = new String[] {""} ;
      BC000L32_n84ProfesionalNombres = new boolean[] {false} ;
      BC000L32_A85ProfesionalApellidoPaterno = new String[] {""} ;
      BC000L32_n85ProfesionalApellidoPaterno = new boolean[] {false} ;
      BC000L32_A86ProfesionalApellidoMaterno = new String[] {""} ;
      BC000L32_n86ProfesionalApellidoMaterno = new boolean[] {false} ;
      BC000L32_A19CitaId = new int[1] ;
      BC000L32_A20PacienteId = new int[1] ;
      BC000L32_A21SGCitaDisponibilidadId = new int[1] ;
      BC000L32_A81SGCitaDisponibilidadProfesionalId = new int[1] ;
      BC000L32_A70SGCitaDisponibilidadEspecialidadId = new short[1] ;
      BC000L32_A76SGCitaDisponibilidadClinicaId = new short[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.encuesta_bc__default(),
         new Object[] {
             new Object[] {
            BC000L2_A37EncuestaId, BC000L2_A148EncuestaAtencion, BC000L2_n148EncuestaAtencion, BC000L2_A149EncuestaAtendido, BC000L2_n149EncuestaAtendido, BC000L2_A150EncuestaHoraAtencion, BC000L2_n150EncuestaHoraAtencion, BC000L2_A151EncuestaComentarios, BC000L2_n151EncuestaComentarios, BC000L2_A152EncuestaRecomendacion,
            BC000L2_A153EncuestaEstado, BC000L2_n153EncuestaEstado, BC000L2_A19CitaId
            }
            , new Object[] {
            BC000L3_A37EncuestaId, BC000L3_A148EncuestaAtencion, BC000L3_n148EncuestaAtencion, BC000L3_A149EncuestaAtendido, BC000L3_n149EncuestaAtendido, BC000L3_A150EncuestaHoraAtencion, BC000L3_n150EncuestaHoraAtencion, BC000L3_A151EncuestaComentarios, BC000L3_n151EncuestaComentarios, BC000L3_A152EncuestaRecomendacion,
            BC000L3_A153EncuestaEstado, BC000L3_n153EncuestaEstado, BC000L3_A19CitaId
            }
            , new Object[] {
            BC000L4_A20PacienteId, BC000L4_A21SGCitaDisponibilidadId
            }
            , new Object[] {
            BC000L5_A103PacienteApellidoPaterno, BC000L5_A104PacienteApellidoMaterno, BC000L5_A105PacienteNombres
            }
            , new Object[] {
            BC000L6_A72SGCitaDisponibilidadSedeId, BC000L6_A66SGCitaDisponibilidadFecha, BC000L6_n66SGCitaDisponibilidadFecha, BC000L6_A81SGCitaDisponibilidadProfesionalId, BC000L6_A70SGCitaDisponibilidadEspecialidadId
            }
            , new Object[] {
            BC000L7_A84ProfesionalNombres, BC000L7_n84ProfesionalNombres, BC000L7_A85ProfesionalApellidoPaterno, BC000L7_n85ProfesionalApellidoPaterno, BC000L7_A86ProfesionalApellidoMaterno, BC000L7_n86ProfesionalApellidoMaterno
            }
            , new Object[] {
            BC000L8_A146SGCitaDisponibilidadEspecialidadNombre
            }
            , new Object[] {
            BC000L9_A76SGCitaDisponibilidadClinicaId
            }
            , new Object[] {
            BC000L10_A78SGCitaDisponibilidadClinicaNombre
            }
            , new Object[] {
            BC000L11_A72SGCitaDisponibilidadSedeId, BC000L11_A37EncuestaId, BC000L11_A146SGCitaDisponibilidadEspecialidadNombre, BC000L11_A66SGCitaDisponibilidadFecha, BC000L11_n66SGCitaDisponibilidadFecha, BC000L11_A103PacienteApellidoPaterno, BC000L11_A104PacienteApellidoMaterno, BC000L11_A105PacienteNombres, BC000L11_A78SGCitaDisponibilidadClinicaNombre, BC000L11_A148EncuestaAtencion,
            BC000L11_n148EncuestaAtencion, BC000L11_A149EncuestaAtendido, BC000L11_n149EncuestaAtendido, BC000L11_A150EncuestaHoraAtencion, BC000L11_n150EncuestaHoraAtencion, BC000L11_A151EncuestaComentarios, BC000L11_n151EncuestaComentarios, BC000L11_A152EncuestaRecomendacion, BC000L11_A153EncuestaEstado, BC000L11_n153EncuestaEstado,
            BC000L11_A84ProfesionalNombres, BC000L11_n84ProfesionalNombres, BC000L11_A85ProfesionalApellidoPaterno, BC000L11_n85ProfesionalApellidoPaterno, BC000L11_A86ProfesionalApellidoMaterno, BC000L11_n86ProfesionalApellidoMaterno, BC000L11_A19CitaId, BC000L11_A20PacienteId, BC000L11_A21SGCitaDisponibilidadId, BC000L11_A81SGCitaDisponibilidadProfesionalId,
            BC000L11_A70SGCitaDisponibilidadEspecialidadId, BC000L11_A76SGCitaDisponibilidadClinicaId
            }
            , new Object[] {
            BC000L12_A20PacienteId, BC000L12_A21SGCitaDisponibilidadId
            }
            , new Object[] {
            BC000L13_A103PacienteApellidoPaterno, BC000L13_A104PacienteApellidoMaterno, BC000L13_A105PacienteNombres
            }
            , new Object[] {
            BC000L14_A72SGCitaDisponibilidadSedeId, BC000L14_A66SGCitaDisponibilidadFecha, BC000L14_n66SGCitaDisponibilidadFecha, BC000L14_A81SGCitaDisponibilidadProfesionalId, BC000L14_A70SGCitaDisponibilidadEspecialidadId
            }
            , new Object[] {
            BC000L15_A76SGCitaDisponibilidadClinicaId
            }
            , new Object[] {
            BC000L16_A78SGCitaDisponibilidadClinicaNombre
            }
            , new Object[] {
            BC000L17_A84ProfesionalNombres, BC000L17_n84ProfesionalNombres, BC000L17_A85ProfesionalApellidoPaterno, BC000L17_n85ProfesionalApellidoPaterno, BC000L17_A86ProfesionalApellidoMaterno, BC000L17_n86ProfesionalApellidoMaterno
            }
            , new Object[] {
            BC000L18_A146SGCitaDisponibilidadEspecialidadNombre
            }
            , new Object[] {
            BC000L19_A37EncuestaId
            }
            , new Object[] {
            BC000L20_A37EncuestaId, BC000L20_A148EncuestaAtencion, BC000L20_n148EncuestaAtencion, BC000L20_A149EncuestaAtendido, BC000L20_n149EncuestaAtendido, BC000L20_A150EncuestaHoraAtencion, BC000L20_n150EncuestaHoraAtencion, BC000L20_A151EncuestaComentarios, BC000L20_n151EncuestaComentarios, BC000L20_A152EncuestaRecomendacion,
            BC000L20_A153EncuestaEstado, BC000L20_n153EncuestaEstado, BC000L20_A19CitaId
            }
            , new Object[] {
            BC000L21_A37EncuestaId, BC000L21_A148EncuestaAtencion, BC000L21_n148EncuestaAtencion, BC000L21_A149EncuestaAtendido, BC000L21_n149EncuestaAtendido, BC000L21_A150EncuestaHoraAtencion, BC000L21_n150EncuestaHoraAtencion, BC000L21_A151EncuestaComentarios, BC000L21_n151EncuestaComentarios, BC000L21_A152EncuestaRecomendacion,
            BC000L21_A153EncuestaEstado, BC000L21_n153EncuestaEstado, BC000L21_A19CitaId
            }
            , new Object[] {
            BC000L22_A37EncuestaId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000L25_A20PacienteId, BC000L25_A21SGCitaDisponibilidadId
            }
            , new Object[] {
            BC000L26_A103PacienteApellidoPaterno, BC000L26_A104PacienteApellidoMaterno, BC000L26_A105PacienteNombres
            }
            , new Object[] {
            BC000L27_A72SGCitaDisponibilidadSedeId, BC000L27_A66SGCitaDisponibilidadFecha, BC000L27_n66SGCitaDisponibilidadFecha, BC000L27_A81SGCitaDisponibilidadProfesionalId, BC000L27_A70SGCitaDisponibilidadEspecialidadId
            }
            , new Object[] {
            BC000L28_A76SGCitaDisponibilidadClinicaId
            }
            , new Object[] {
            BC000L29_A78SGCitaDisponibilidadClinicaNombre
            }
            , new Object[] {
            BC000L30_A84ProfesionalNombres, BC000L30_n84ProfesionalNombres, BC000L30_A85ProfesionalApellidoPaterno, BC000L30_n85ProfesionalApellidoPaterno, BC000L30_A86ProfesionalApellidoMaterno, BC000L30_n86ProfesionalApellidoMaterno
            }
            , new Object[] {
            BC000L31_A146SGCitaDisponibilidadEspecialidadNombre
            }
            , new Object[] {
            BC000L32_A72SGCitaDisponibilidadSedeId, BC000L32_A37EncuestaId, BC000L32_A146SGCitaDisponibilidadEspecialidadNombre, BC000L32_A66SGCitaDisponibilidadFecha, BC000L32_n66SGCitaDisponibilidadFecha, BC000L32_A103PacienteApellidoPaterno, BC000L32_A104PacienteApellidoMaterno, BC000L32_A105PacienteNombres, BC000L32_A78SGCitaDisponibilidadClinicaNombre, BC000L32_A148EncuestaAtencion,
            BC000L32_n148EncuestaAtencion, BC000L32_A149EncuestaAtendido, BC000L32_n149EncuestaAtendido, BC000L32_A150EncuestaHoraAtencion, BC000L32_n150EncuestaHoraAtencion, BC000L32_A151EncuestaComentarios, BC000L32_n151EncuestaComentarios, BC000L32_A152EncuestaRecomendacion, BC000L32_A153EncuestaEstado, BC000L32_n153EncuestaEstado,
            BC000L32_A84ProfesionalNombres, BC000L32_n84ProfesionalNombres, BC000L32_A85ProfesionalApellidoPaterno, BC000L32_n85ProfesionalApellidoPaterno, BC000L32_A86ProfesionalApellidoMaterno, BC000L32_n86ProfesionalApellidoMaterno, BC000L32_A19CitaId, BC000L32_A20PacienteId, BC000L32_A21SGCitaDisponibilidadId, BC000L32_A81SGCitaDisponibilidadProfesionalId,
            BC000L32_A70SGCitaDisponibilidadEspecialidadId, BC000L32_A76SGCitaDisponibilidadClinicaId
            }
         }
      );
      AV21Pgmname = "Encuesta_BC" ;
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e120L2 ();
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private byte Z152EncuestaRecomendacion ;
   private byte A152EncuestaRecomendacion ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short Z37EncuestaId ;
   private short A37EncuestaId ;
   private short Z72SGCitaDisponibilidadSedeId ;
   private short A72SGCitaDisponibilidadSedeId ;
   private short Z70SGCitaDisponibilidadEspecialidadId ;
   private short A70SGCitaDisponibilidadEspecialidadId ;
   private short Z76SGCitaDisponibilidadClinicaId ;
   private short A76SGCitaDisponibilidadClinicaId ;
   private short RcdFound29 ;
   private short nIsDirty_29 ;
   private int trnEnded ;
   private int AV22GXV1 ;
   private int AV12Insert_CitaId ;
   private int GX_JID ;
   private int Z19CitaId ;
   private int A19CitaId ;
   private int Z20PacienteId ;
   private int A20PacienteId ;
   private int Z21SGCitaDisponibilidadId ;
   private int A21SGCitaDisponibilidadId ;
   private int Z81SGCitaDisponibilidadProfesionalId ;
   private int A81SGCitaDisponibilidadProfesionalId ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String AV21Pgmname ;
   private String Z148EncuestaAtencion ;
   private String A148EncuestaAtencion ;
   private String Z149EncuestaAtendido ;
   private String A149EncuestaAtendido ;
   private String Z153EncuestaEstado ;
   private String A153EncuestaEstado ;
   private String sMode29 ;
   private java.util.Date Z150EncuestaHoraAtencion ;
   private java.util.Date A150EncuestaHoraAtencion ;
   private java.util.Date Z66SGCitaDisponibilidadFecha ;
   private java.util.Date A66SGCitaDisponibilidadFecha ;
   private boolean returnInSub ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean n66SGCitaDisponibilidadFecha ;
   private boolean n148EncuestaAtencion ;
   private boolean n149EncuestaAtendido ;
   private boolean n150EncuestaHoraAtencion ;
   private boolean n151EncuestaComentarios ;
   private boolean n153EncuestaEstado ;
   private boolean n84ProfesionalNombres ;
   private boolean n85ProfesionalApellidoPaterno ;
   private boolean n86ProfesionalApellidoMaterno ;
   private boolean Gx_longc ;
   private boolean mustCommit ;
   private String Z151EncuestaComentarios ;
   private String A151EncuestaComentarios ;
   private String Z82SGCitaDisponibilidadProFullName ;
   private String A82SGCitaDisponibilidadProFullName ;
   private String Z103PacienteApellidoPaterno ;
   private String A103PacienteApellidoPaterno ;
   private String Z104PacienteApellidoMaterno ;
   private String A104PacienteApellidoMaterno ;
   private String Z105PacienteNombres ;
   private String A105PacienteNombres ;
   private String Z84ProfesionalNombres ;
   private String A84ProfesionalNombres ;
   private String Z85ProfesionalApellidoPaterno ;
   private String A85ProfesionalApellidoPaterno ;
   private String Z86ProfesionalApellidoMaterno ;
   private String A86ProfesionalApellidoMaterno ;
   private String Z146SGCitaDisponibilidadEspecialidadNombre ;
   private String A146SGCitaDisponibilidadEspecialidadNombre ;
   private String Z78SGCitaDisponibilidadClinicaNombre ;
   private String A78SGCitaDisponibilidadClinicaNombre ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV11WebSession ;
   private com.projectthani.SdtEncuesta bcEncuesta ;
   private IDataStoreProvider pr_default ;
   private short[] BC000L11_A72SGCitaDisponibilidadSedeId ;
   private short[] BC000L11_A37EncuestaId ;
   private String[] BC000L11_A146SGCitaDisponibilidadEspecialidadNombre ;
   private java.util.Date[] BC000L11_A66SGCitaDisponibilidadFecha ;
   private boolean[] BC000L11_n66SGCitaDisponibilidadFecha ;
   private String[] BC000L11_A103PacienteApellidoPaterno ;
   private String[] BC000L11_A104PacienteApellidoMaterno ;
   private String[] BC000L11_A105PacienteNombres ;
   private String[] BC000L11_A78SGCitaDisponibilidadClinicaNombre ;
   private String[] BC000L11_A148EncuestaAtencion ;
   private boolean[] BC000L11_n148EncuestaAtencion ;
   private String[] BC000L11_A149EncuestaAtendido ;
   private boolean[] BC000L11_n149EncuestaAtendido ;
   private java.util.Date[] BC000L11_A150EncuestaHoraAtencion ;
   private boolean[] BC000L11_n150EncuestaHoraAtencion ;
   private String[] BC000L11_A151EncuestaComentarios ;
   private boolean[] BC000L11_n151EncuestaComentarios ;
   private byte[] BC000L11_A152EncuestaRecomendacion ;
   private String[] BC000L11_A153EncuestaEstado ;
   private boolean[] BC000L11_n153EncuestaEstado ;
   private String[] BC000L11_A84ProfesionalNombres ;
   private boolean[] BC000L11_n84ProfesionalNombres ;
   private String[] BC000L11_A85ProfesionalApellidoPaterno ;
   private boolean[] BC000L11_n85ProfesionalApellidoPaterno ;
   private String[] BC000L11_A86ProfesionalApellidoMaterno ;
   private boolean[] BC000L11_n86ProfesionalApellidoMaterno ;
   private int[] BC000L11_A19CitaId ;
   private int[] BC000L11_A20PacienteId ;
   private int[] BC000L11_A21SGCitaDisponibilidadId ;
   private int[] BC000L11_A81SGCitaDisponibilidadProfesionalId ;
   private short[] BC000L11_A70SGCitaDisponibilidadEspecialidadId ;
   private short[] BC000L11_A76SGCitaDisponibilidadClinicaId ;
   private int[] BC000L12_A20PacienteId ;
   private int[] BC000L12_A21SGCitaDisponibilidadId ;
   private String[] BC000L13_A103PacienteApellidoPaterno ;
   private String[] BC000L13_A104PacienteApellidoMaterno ;
   private String[] BC000L13_A105PacienteNombres ;
   private short[] BC000L14_A72SGCitaDisponibilidadSedeId ;
   private java.util.Date[] BC000L14_A66SGCitaDisponibilidadFecha ;
   private boolean[] BC000L14_n66SGCitaDisponibilidadFecha ;
   private int[] BC000L14_A81SGCitaDisponibilidadProfesionalId ;
   private short[] BC000L14_A70SGCitaDisponibilidadEspecialidadId ;
   private short[] BC000L15_A76SGCitaDisponibilidadClinicaId ;
   private String[] BC000L16_A78SGCitaDisponibilidadClinicaNombre ;
   private String[] BC000L17_A84ProfesionalNombres ;
   private boolean[] BC000L17_n84ProfesionalNombres ;
   private String[] BC000L17_A85ProfesionalApellidoPaterno ;
   private boolean[] BC000L17_n85ProfesionalApellidoPaterno ;
   private String[] BC000L17_A86ProfesionalApellidoMaterno ;
   private boolean[] BC000L17_n86ProfesionalApellidoMaterno ;
   private String[] BC000L18_A146SGCitaDisponibilidadEspecialidadNombre ;
   private short[] BC000L19_A37EncuestaId ;
   private short[] BC000L20_A37EncuestaId ;
   private String[] BC000L20_A148EncuestaAtencion ;
   private boolean[] BC000L20_n148EncuestaAtencion ;
   private String[] BC000L20_A149EncuestaAtendido ;
   private boolean[] BC000L20_n149EncuestaAtendido ;
   private java.util.Date[] BC000L20_A150EncuestaHoraAtencion ;
   private boolean[] BC000L20_n150EncuestaHoraAtencion ;
   private String[] BC000L20_A151EncuestaComentarios ;
   private boolean[] BC000L20_n151EncuestaComentarios ;
   private byte[] BC000L20_A152EncuestaRecomendacion ;
   private String[] BC000L20_A153EncuestaEstado ;
   private boolean[] BC000L20_n153EncuestaEstado ;
   private int[] BC000L20_A19CitaId ;
   private short[] BC000L21_A37EncuestaId ;
   private String[] BC000L21_A148EncuestaAtencion ;
   private boolean[] BC000L21_n148EncuestaAtencion ;
   private String[] BC000L21_A149EncuestaAtendido ;
   private boolean[] BC000L21_n149EncuestaAtendido ;
   private java.util.Date[] BC000L21_A150EncuestaHoraAtencion ;
   private boolean[] BC000L21_n150EncuestaHoraAtencion ;
   private String[] BC000L21_A151EncuestaComentarios ;
   private boolean[] BC000L21_n151EncuestaComentarios ;
   private byte[] BC000L21_A152EncuestaRecomendacion ;
   private String[] BC000L21_A153EncuestaEstado ;
   private boolean[] BC000L21_n153EncuestaEstado ;
   private int[] BC000L21_A19CitaId ;
   private short[] BC000L22_A37EncuestaId ;
   private int[] BC000L25_A20PacienteId ;
   private int[] BC000L25_A21SGCitaDisponibilidadId ;
   private String[] BC000L26_A103PacienteApellidoPaterno ;
   private String[] BC000L26_A104PacienteApellidoMaterno ;
   private String[] BC000L26_A105PacienteNombres ;
   private short[] BC000L27_A72SGCitaDisponibilidadSedeId ;
   private java.util.Date[] BC000L27_A66SGCitaDisponibilidadFecha ;
   private boolean[] BC000L27_n66SGCitaDisponibilidadFecha ;
   private int[] BC000L27_A81SGCitaDisponibilidadProfesionalId ;
   private short[] BC000L27_A70SGCitaDisponibilidadEspecialidadId ;
   private short[] BC000L28_A76SGCitaDisponibilidadClinicaId ;
   private String[] BC000L29_A78SGCitaDisponibilidadClinicaNombre ;
   private String[] BC000L30_A84ProfesionalNombres ;
   private boolean[] BC000L30_n84ProfesionalNombres ;
   private String[] BC000L30_A85ProfesionalApellidoPaterno ;
   private boolean[] BC000L30_n85ProfesionalApellidoPaterno ;
   private String[] BC000L30_A86ProfesionalApellidoMaterno ;
   private boolean[] BC000L30_n86ProfesionalApellidoMaterno ;
   private String[] BC000L31_A146SGCitaDisponibilidadEspecialidadNombre ;
   private short[] BC000L32_A72SGCitaDisponibilidadSedeId ;
   private short[] BC000L32_A37EncuestaId ;
   private String[] BC000L32_A146SGCitaDisponibilidadEspecialidadNombre ;
   private java.util.Date[] BC000L32_A66SGCitaDisponibilidadFecha ;
   private boolean[] BC000L32_n66SGCitaDisponibilidadFecha ;
   private String[] BC000L32_A103PacienteApellidoPaterno ;
   private String[] BC000L32_A104PacienteApellidoMaterno ;
   private String[] BC000L32_A105PacienteNombres ;
   private String[] BC000L32_A78SGCitaDisponibilidadClinicaNombre ;
   private String[] BC000L32_A148EncuestaAtencion ;
   private boolean[] BC000L32_n148EncuestaAtencion ;
   private String[] BC000L32_A149EncuestaAtendido ;
   private boolean[] BC000L32_n149EncuestaAtendido ;
   private java.util.Date[] BC000L32_A150EncuestaHoraAtencion ;
   private boolean[] BC000L32_n150EncuestaHoraAtencion ;
   private String[] BC000L32_A151EncuestaComentarios ;
   private boolean[] BC000L32_n151EncuestaComentarios ;
   private byte[] BC000L32_A152EncuestaRecomendacion ;
   private String[] BC000L32_A153EncuestaEstado ;
   private boolean[] BC000L32_n153EncuestaEstado ;
   private String[] BC000L32_A84ProfesionalNombres ;
   private boolean[] BC000L32_n84ProfesionalNombres ;
   private String[] BC000L32_A85ProfesionalApellidoPaterno ;
   private boolean[] BC000L32_n85ProfesionalApellidoPaterno ;
   private String[] BC000L32_A86ProfesionalApellidoMaterno ;
   private boolean[] BC000L32_n86ProfesionalApellidoMaterno ;
   private int[] BC000L32_A19CitaId ;
   private int[] BC000L32_A20PacienteId ;
   private int[] BC000L32_A21SGCitaDisponibilidadId ;
   private int[] BC000L32_A81SGCitaDisponibilidadProfesionalId ;
   private short[] BC000L32_A70SGCitaDisponibilidadEspecialidadId ;
   private short[] BC000L32_A76SGCitaDisponibilidadClinicaId ;
   private short[] BC000L2_A37EncuestaId ;
   private String[] BC000L2_A148EncuestaAtencion ;
   private String[] BC000L2_A149EncuestaAtendido ;
   private java.util.Date[] BC000L2_A150EncuestaHoraAtencion ;
   private String[] BC000L2_A151EncuestaComentarios ;
   private byte[] BC000L2_A152EncuestaRecomendacion ;
   private String[] BC000L2_A153EncuestaEstado ;
   private int[] BC000L2_A19CitaId ;
   private short[] BC000L3_A37EncuestaId ;
   private String[] BC000L3_A148EncuestaAtencion ;
   private String[] BC000L3_A149EncuestaAtendido ;
   private java.util.Date[] BC000L3_A150EncuestaHoraAtencion ;
   private String[] BC000L3_A151EncuestaComentarios ;
   private byte[] BC000L3_A152EncuestaRecomendacion ;
   private String[] BC000L3_A153EncuestaEstado ;
   private int[] BC000L3_A19CitaId ;
   private int[] BC000L4_A20PacienteId ;
   private int[] BC000L4_A21SGCitaDisponibilidadId ;
   private String[] BC000L5_A103PacienteApellidoPaterno ;
   private String[] BC000L5_A104PacienteApellidoMaterno ;
   private String[] BC000L5_A105PacienteNombres ;
   private short[] BC000L6_A72SGCitaDisponibilidadSedeId ;
   private java.util.Date[] BC000L6_A66SGCitaDisponibilidadFecha ;
   private int[] BC000L6_A81SGCitaDisponibilidadProfesionalId ;
   private short[] BC000L6_A70SGCitaDisponibilidadEspecialidadId ;
   private String[] BC000L7_A84ProfesionalNombres ;
   private String[] BC000L7_A85ProfesionalApellidoPaterno ;
   private String[] BC000L7_A86ProfesionalApellidoMaterno ;
   private String[] BC000L8_A146SGCitaDisponibilidadEspecialidadNombre ;
   private short[] BC000L9_A76SGCitaDisponibilidadClinicaId ;
   private String[] BC000L10_A78SGCitaDisponibilidadClinicaNombre ;
   private boolean[] BC000L2_n148EncuestaAtencion ;
   private boolean[] BC000L2_n149EncuestaAtendido ;
   private boolean[] BC000L2_n150EncuestaHoraAtencion ;
   private boolean[] BC000L2_n151EncuestaComentarios ;
   private boolean[] BC000L2_n153EncuestaEstado ;
   private boolean[] BC000L3_n148EncuestaAtencion ;
   private boolean[] BC000L3_n149EncuestaAtendido ;
   private boolean[] BC000L3_n150EncuestaHoraAtencion ;
   private boolean[] BC000L3_n151EncuestaComentarios ;
   private boolean[] BC000L3_n153EncuestaEstado ;
   private boolean[] BC000L6_n66SGCitaDisponibilidadFecha ;
   private boolean[] BC000L7_n84ProfesionalNombres ;
   private boolean[] BC000L7_n85ProfesionalApellidoPaterno ;
   private boolean[] BC000L7_n86ProfesionalApellidoMaterno ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV7WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV10TrnContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV13TrnContextAtt ;
}

final  class encuesta_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC000L2", "SELECT [EncuestaId], [EncuestaAtencion], [EncuestaAtendido], [EncuestaHoraAtencion], [EncuestaComentarios], [EncuestaRecomendacion], [EncuestaEstado], [CitaId] FROM [Encuesta] WITH (UPDLOCK) WHERE [EncuestaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000L3", "SELECT [EncuestaId], [EncuestaAtencion], [EncuestaAtendido], [EncuestaHoraAtencion], [EncuestaComentarios], [EncuestaRecomendacion], [EncuestaEstado], [CitaId] FROM [Encuesta] WHERE [EncuestaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000L4", "SELECT [PacienteId], [SGCitaDisponibilidadId] AS SGCitaDisponibilidadId FROM [Cita] WHERE [CitaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000L5", "SELECT [PacienteApellidoPaterno], [PacienteApellidoMaterno], [PacienteNombres] FROM [Paciente] WHERE [PacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000L6", "SELECT [SGSedeDisponibilidadSedeId] AS SGCitaDisponibilidadSedeId, [DisponibilidadFecha] AS SGCitaDisponibilidadFecha, [ProfesionalId] AS SGCitaDisponibilidadProfesionalId, [EspecialidadId] AS SGCitaDisponibilidadEspecialidadId FROM [Disponibilidad] WHERE [DisponibilidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000L7", "SELECT [ProfesionalNombres], [ProfesionalApellidoPaterno], [ProfesionalApellidoMaterno] FROM [Profesional] WHERE [ProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000L8", "SELECT [EspecialidadNombre] AS SGCitaDisponibilidadEspecialidadNombre FROM [Especialidad] WHERE [EspecialidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000L9", "SELECT [ClinicaId] AS SGCitaDisponibilidadClinicaId FROM [Sede] WHERE [SedeId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000L10", "SELECT [ClinicaNombreAbreviado] AS SGCitaDisponibilidadClinicaNombre FROM [Clinica] WHERE [ClinicaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000L11", "SELECT T4.[SGSedeDisponibilidadSedeId] AS SGCitaDisponibilidadSedeId, TM1.[EncuestaId], T8.[EspecialidadNombre] AS SGCitaDisponibilidadEspecialidadNombre, T4.[DisponibilidadFecha] AS SGCitaDisponibilidadFecha, T3.[PacienteApellidoPaterno], T3.[PacienteApellidoMaterno], T3.[PacienteNombres], T6.[ClinicaNombreAbreviado] AS SGCitaDisponibilidadClinicaNombre, TM1.[EncuestaAtencion], TM1.[EncuestaAtendido], TM1.[EncuestaHoraAtencion], TM1.[EncuestaComentarios], TM1.[EncuestaRecomendacion], TM1.[EncuestaEstado], T7.[ProfesionalNombres], T7.[ProfesionalApellidoPaterno], T7.[ProfesionalApellidoMaterno], TM1.[CitaId], T2.[PacienteId], T2.[SGCitaDisponibilidadId] AS SGCitaDisponibilidadId, T4.[ProfesionalId] AS SGCitaDisponibilidadProfesionalId, T4.[EspecialidadId] AS SGCitaDisponibilidadEspecialidadId, T5.[ClinicaId] AS SGCitaDisponibilidadClinicaId FROM ((((((([Encuesta] TM1 INNER JOIN [Cita] T2 ON T2.[CitaId] = TM1.[CitaId]) INNER JOIN [Paciente] T3 ON T3.[PacienteId] = T2.[PacienteId]) INNER JOIN [Disponibilidad] T4 ON T4.[DisponibilidadId] = T2.[SGCitaDisponibilidadId]) INNER JOIN [Sede] T5 ON T5.[SedeId] = T4.[SGSedeDisponibilidadSedeId]) INNER JOIN [Clinica] T6 ON T6.[ClinicaId] = T5.[ClinicaId]) INNER JOIN [Profesional] T7 ON T7.[ProfesionalId] = T4.[ProfesionalId]) INNER JOIN [Especialidad] T8 ON T8.[EspecialidadId] = T4.[EspecialidadId]) WHERE TM1.[EncuestaId] = ? ORDER BY TM1.[EncuestaId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000L12", "SELECT [PacienteId], [SGCitaDisponibilidadId] AS SGCitaDisponibilidadId FROM [Cita] WHERE [CitaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000L13", "SELECT [PacienteApellidoPaterno], [PacienteApellidoMaterno], [PacienteNombres] FROM [Paciente] WHERE [PacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000L14", "SELECT [SGSedeDisponibilidadSedeId] AS SGCitaDisponibilidadSedeId, [DisponibilidadFecha] AS SGCitaDisponibilidadFecha, [ProfesionalId] AS SGCitaDisponibilidadProfesionalId, [EspecialidadId] AS SGCitaDisponibilidadEspecialidadId FROM [Disponibilidad] WHERE [DisponibilidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000L15", "SELECT [ClinicaId] AS SGCitaDisponibilidadClinicaId FROM [Sede] WHERE [SedeId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000L16", "SELECT [ClinicaNombreAbreviado] AS SGCitaDisponibilidadClinicaNombre FROM [Clinica] WHERE [ClinicaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000L17", "SELECT [ProfesionalNombres], [ProfesionalApellidoPaterno], [ProfesionalApellidoMaterno] FROM [Profesional] WHERE [ProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000L18", "SELECT [EspecialidadNombre] AS SGCitaDisponibilidadEspecialidadNombre FROM [Especialidad] WHERE [EspecialidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000L19", "SELECT [EncuestaId] FROM [Encuesta] WHERE [EncuestaId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000L20", "SELECT [EncuestaId], [EncuestaAtencion], [EncuestaAtendido], [EncuestaHoraAtencion], [EncuestaComentarios], [EncuestaRecomendacion], [EncuestaEstado], [CitaId] FROM [Encuesta] WHERE [EncuestaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000L21", "SELECT [EncuestaId], [EncuestaAtencion], [EncuestaAtendido], [EncuestaHoraAtencion], [EncuestaComentarios], [EncuestaRecomendacion], [EncuestaEstado], [CitaId] FROM [Encuesta] WITH (UPDLOCK) WHERE [EncuestaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000L22", "INSERT INTO [Encuesta]([EncuestaAtencion], [EncuestaAtendido], [EncuestaHoraAtencion], [EncuestaComentarios], [EncuestaRecomendacion], [EncuestaEstado], [CitaId]) VALUES(?, ?, ?, ?, ?, ?, ?); SELECT SCOPE_IDENTITY()", GX_NOMASK)
         ,new UpdateCursor("BC000L23", "UPDATE [Encuesta] SET [EncuestaAtencion]=?, [EncuestaAtendido]=?, [EncuestaHoraAtencion]=?, [EncuestaComentarios]=?, [EncuestaRecomendacion]=?, [EncuestaEstado]=?, [CitaId]=?  WHERE [EncuestaId] = ?", GX_NOMASK)
         ,new UpdateCursor("BC000L24", "DELETE FROM [Encuesta]  WHERE [EncuestaId] = ?", GX_NOMASK)
         ,new ForEachCursor("BC000L25", "SELECT [PacienteId], [SGCitaDisponibilidadId] AS SGCitaDisponibilidadId FROM [Cita] WHERE [CitaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000L26", "SELECT [PacienteApellidoPaterno], [PacienteApellidoMaterno], [PacienteNombres] FROM [Paciente] WHERE [PacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000L27", "SELECT [SGSedeDisponibilidadSedeId] AS SGCitaDisponibilidadSedeId, [DisponibilidadFecha] AS SGCitaDisponibilidadFecha, [ProfesionalId] AS SGCitaDisponibilidadProfesionalId, [EspecialidadId] AS SGCitaDisponibilidadEspecialidadId FROM [Disponibilidad] WHERE [DisponibilidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000L28", "SELECT [ClinicaId] AS SGCitaDisponibilidadClinicaId FROM [Sede] WHERE [SedeId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000L29", "SELECT [ClinicaNombreAbreviado] AS SGCitaDisponibilidadClinicaNombre FROM [Clinica] WHERE [ClinicaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000L30", "SELECT [ProfesionalNombres], [ProfesionalApellidoPaterno], [ProfesionalApellidoMaterno] FROM [Profesional] WHERE [ProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000L31", "SELECT [EspecialidadNombre] AS SGCitaDisponibilidadEspecialidadNombre FROM [Especialidad] WHERE [EspecialidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000L32", "SELECT T4.[SGSedeDisponibilidadSedeId] AS SGCitaDisponibilidadSedeId, TM1.[EncuestaId], T8.[EspecialidadNombre] AS SGCitaDisponibilidadEspecialidadNombre, T4.[DisponibilidadFecha] AS SGCitaDisponibilidadFecha, T3.[PacienteApellidoPaterno], T3.[PacienteApellidoMaterno], T3.[PacienteNombres], T6.[ClinicaNombreAbreviado] AS SGCitaDisponibilidadClinicaNombre, TM1.[EncuestaAtencion], TM1.[EncuestaAtendido], TM1.[EncuestaHoraAtencion], TM1.[EncuestaComentarios], TM1.[EncuestaRecomendacion], TM1.[EncuestaEstado], T7.[ProfesionalNombres], T7.[ProfesionalApellidoPaterno], T7.[ProfesionalApellidoMaterno], TM1.[CitaId], T2.[PacienteId], T2.[SGCitaDisponibilidadId] AS SGCitaDisponibilidadId, T4.[ProfesionalId] AS SGCitaDisponibilidadProfesionalId, T4.[EspecialidadId] AS SGCitaDisponibilidadEspecialidadId, T5.[ClinicaId] AS SGCitaDisponibilidadClinicaId FROM ((((((([Encuesta] TM1 INNER JOIN [Cita] T2 ON T2.[CitaId] = TM1.[CitaId]) INNER JOIN [Paciente] T3 ON T3.[PacienteId] = T2.[PacienteId]) INNER JOIN [Disponibilidad] T4 ON T4.[DisponibilidadId] = T2.[SGCitaDisponibilidadId]) INNER JOIN [Sede] T5 ON T5.[SedeId] = T4.[SGSedeDisponibilidadSedeId]) INNER JOIN [Clinica] T6 ON T6.[ClinicaId] = T5.[ClinicaId]) INNER JOIN [Profesional] T7 ON T7.[ProfesionalId] = T4.[ProfesionalId]) INNER JOIN [Especialidad] T8 ON T8.[EspecialidadId] = T4.[EspecialidadId]) WHERE TM1.[EncuestaId] = ? ORDER BY TM1.[EncuestaId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 1);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getString(3, 1);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[5])[0] = GXutil.resetDate(rslt.getGXDateTime(4));
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getLongVarchar(5);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((byte[]) buf[9])[0] = rslt.getByte(6);
               ((String[]) buf[10])[0] = rslt.getString(7, 1);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((int[]) buf[12])[0] = rslt.getInt(8);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 1);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getString(3, 1);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[5])[0] = GXutil.resetDate(rslt.getGXDateTime(4));
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getLongVarchar(5);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((byte[]) buf[9])[0] = rslt.getByte(6);
               ((String[]) buf[10])[0] = rslt.getString(7, 1);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((int[]) buf[12])[0] = rslt.getInt(8);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((int[]) buf[3])[0] = rslt.getInt(3);
               ((short[]) buf[4])[0] = rslt.getShort(4);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 7 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 8 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 9 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               ((String[]) buf[7])[0] = rslt.getVarchar(7);
               ((String[]) buf[8])[0] = rslt.getVarchar(8);
               ((String[]) buf[9])[0] = rslt.getString(9, 1);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getString(10, 1);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[13])[0] = GXutil.resetDate(rslt.getGXDateTime(11));
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((String[]) buf[15])[0] = rslt.getLongVarchar(12);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((byte[]) buf[17])[0] = rslt.getByte(13);
               ((String[]) buf[18])[0] = rslt.getString(14, 1);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((String[]) buf[20])[0] = rslt.getVarchar(15);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((String[]) buf[22])[0] = rslt.getVarchar(16);
               ((boolean[]) buf[23])[0] = rslt.wasNull();
               ((String[]) buf[24])[0] = rslt.getVarchar(17);
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               ((int[]) buf[26])[0] = rslt.getInt(18);
               ((int[]) buf[27])[0] = rslt.getInt(19);
               ((int[]) buf[28])[0] = rslt.getInt(20);
               ((int[]) buf[29])[0] = rslt.getInt(21);
               ((short[]) buf[30])[0] = rslt.getShort(22);
               ((short[]) buf[31])[0] = rslt.getShort(23);
               return;
            case 10 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               return;
            case 11 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 12 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((int[]) buf[3])[0] = rslt.getInt(3);
               ((short[]) buf[4])[0] = rslt.getShort(4);
               return;
            case 13 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 14 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 15 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               return;
            case 16 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 17 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 18 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 1);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getString(3, 1);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[5])[0] = GXutil.resetDate(rslt.getGXDateTime(4));
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getLongVarchar(5);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((byte[]) buf[9])[0] = rslt.getByte(6);
               ((String[]) buf[10])[0] = rslt.getString(7, 1);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((int[]) buf[12])[0] = rslt.getInt(8);
               return;
            case 19 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 1);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getString(3, 1);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[5])[0] = GXutil.resetDate(rslt.getGXDateTime(4));
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getLongVarchar(5);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((byte[]) buf[9])[0] = rslt.getByte(6);
               ((String[]) buf[10])[0] = rslt.getString(7, 1);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((int[]) buf[12])[0] = rslt.getInt(8);
               return;
            case 20 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 23 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               return;
            case 24 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 25 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((int[]) buf[3])[0] = rslt.getInt(3);
               ((short[]) buf[4])[0] = rslt.getShort(4);
               return;
            case 26 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 27 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 28 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               return;
            case 29 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
      }
      getresults30( cursor, rslt, buf) ;
   }

   public void getresults30( int cursor ,
                             IFieldGetter rslt ,
                             Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 30 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               ((String[]) buf[7])[0] = rslt.getVarchar(7);
               ((String[]) buf[8])[0] = rslt.getVarchar(8);
               ((String[]) buf[9])[0] = rslt.getString(9, 1);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getString(10, 1);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[13])[0] = GXutil.resetDate(rslt.getGXDateTime(11));
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((String[]) buf[15])[0] = rslt.getLongVarchar(12);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((byte[]) buf[17])[0] = rslt.getByte(13);
               ((String[]) buf[18])[0] = rslt.getString(14, 1);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((String[]) buf[20])[0] = rslt.getVarchar(15);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((String[]) buf[22])[0] = rslt.getVarchar(16);
               ((boolean[]) buf[23])[0] = rslt.wasNull();
               ((String[]) buf[24])[0] = rslt.getVarchar(17);
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               ((int[]) buf[26])[0] = rslt.getInt(18);
               ((int[]) buf[27])[0] = rslt.getInt(19);
               ((int[]) buf[28])[0] = rslt.getInt(20);
               ((int[]) buf[29])[0] = rslt.getInt(21);
               ((short[]) buf[30])[0] = rslt.getShort(22);
               ((short[]) buf[31])[0] = rslt.getShort(23);
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 6 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 7 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 8 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 9 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 11 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 13 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 14 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 16 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 17 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 18 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 19 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 20 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 1);
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[3], 1);
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.TIMESTAMP );
               }
               else
               {
                  stmt.setDateTime(3, (java.util.Date)parms[5], true);
               }
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(4, (String)parms[7]);
               }
               stmt.setByte(5, ((Number) parms[8]).byteValue());
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(6, (String)parms[10], 1);
               }
               stmt.setInt(7, ((Number) parms[11]).intValue());
               return;
            case 21 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 1);
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[3], 1);
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.TIMESTAMP );
               }
               else
               {
                  stmt.setDateTime(3, (java.util.Date)parms[5], true);
               }
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(4, (String)parms[7]);
               }
               stmt.setByte(5, ((Number) parms[8]).byteValue());
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(6, (String)parms[10], 1);
               }
               stmt.setInt(7, ((Number) parms[11]).intValue());
               stmt.setShort(8, ((Number) parms[12]).shortValue());
               return;
            case 22 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 23 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 24 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 25 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 26 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 27 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 28 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 29 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
      setparameters30( cursor, stmt, parms) ;
   }

   public void setparameters30( int cursor ,
                                IFieldSetter stmt ,
                                Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 30 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

