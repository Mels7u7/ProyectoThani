package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class disponibilidad_bc extends GXWebPanel implements IGxSilentTrn
{
   public disponibilidad_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public disponibilidad_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( disponibilidad_bc.class ));
   }

   public disponibilidad_bc( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow0J26( ) ;
      standaloneNotModal( ) ;
      initializeNonKey0J26( ) ;
      standaloneModal( ) ;
      addRow0J26( ) ;
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
         e110J2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z34DisponibilidadId = A34DisponibilidadId ;
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

   public void confirm_0J0( )
   {
      beforeValidate0J26( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0J26( ) ;
         }
         else
         {
            checkExtendedTable0J26( ) ;
            if ( AnyError == 0 )
            {
               zm0J26( 9) ;
               zm0J26( 10) ;
               zm0J26( 11) ;
               zm0J26( 12) ;
               zm0J26( 13) ;
               zm0J26( 14) ;
            }
            closeExtendedTableCursors0J26( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void e120J2( )
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
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWDisponibilidad_Insert", GXv_boolean3) ;
         disponibilidad_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV8IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV8IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWDisponibilidad_Update", GXv_boolean3) ;
         disponibilidad_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV8IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV8IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWDisponibilidad_Delete", GXv_boolean3) ;
         disponibilidad_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV8IsAuthorized = GXt_boolean2 ;
      }
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV29Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV10TrnContext.fromxml(AV11WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV10TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV29Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV30GXV1 = 1 ;
         while ( AV30GXV1 <= AV10TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV14TrnContextAtt = (com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV10TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV30GXV1));
            if ( GXutil.strcmp(AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "ProfesionalId") == 0 )
            {
               AV12Insert_ProfesionalId = (int)(GXutil.lval( AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
            }
            else if ( GXutil.strcmp(AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "EspecialidadId") == 0 )
            {
               AV13Insert_EspecialidadId = (short)(GXutil.lval( AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
            }
            else if ( GXutil.strcmp(AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "SGSedeDisponibilidadSedeId") == 0 )
            {
               AV16Insert_SGSedeDisponibilidadSedeId = (short)(GXutil.lval( AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
            }
            AV30GXV1 = (int)(AV30GXV1+1) ;
         }
      }
   }

   public void e110J2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
   }

   public void zm0J26( int GX_JID )
   {
      if ( ( GX_JID == 8 ) || ( GX_JID == 0 ) )
      {
         Z133EventId = A133EventId ;
         Z134DisponibilidadDescription = A134DisponibilidadDescription ;
         Z67DisponibilidadFecha = A67DisponibilidadFecha ;
         Z69DisponibilidadHoraInicio = A69DisponibilidadHoraInicio ;
         Z135DisponibilidadHoraFin = A135DisponibilidadHoraFin ;
         Z137DisponibilidadUser = A137DisponibilidadUser ;
         Z136DisponibilidadEstado = A136DisponibilidadEstado ;
         Z139DisponibilidadEstadoCita = A139DisponibilidadEstadoCita ;
         Z298DisponibilidadTipoCita = A298DisponibilidadTipoCita ;
         Z31ProfesionalId = A31ProfesionalId ;
         Z32EspecialidadId = A32EspecialidadId ;
         Z35SGSedeDisponibilidadSedeId = A35SGSedeDisponibilidadSedeId ;
         Z83ProfesionalNombreCompleto = A83ProfesionalNombreCompleto ;
         Z138DCitaId = A138DCitaId ;
      }
      if ( ( GX_JID == 9 ) || ( GX_JID == 0 ) )
      {
         Z85ProfesionalApellidoPaterno = A85ProfesionalApellidoPaterno ;
         Z86ProfesionalApellidoMaterno = A86ProfesionalApellidoMaterno ;
         Z84ProfesionalNombres = A84ProfesionalNombres ;
         Z88ProfesionalCOP = A88ProfesionalCOP ;
         Z83ProfesionalNombreCompleto = A83ProfesionalNombreCompleto ;
         Z138DCitaId = A138DCitaId ;
      }
      if ( ( GX_JID == 10 ) || ( GX_JID == 0 ) )
      {
         Z140EspecialidadCodigo = A140EspecialidadCodigo ;
         Z71EspecialidadNombre = A71EspecialidadNombre ;
         Z83ProfesionalNombreCompleto = A83ProfesionalNombreCompleto ;
         Z138DCitaId = A138DCitaId ;
      }
      if ( ( GX_JID == 11 ) || ( GX_JID == 0 ) )
      {
         Z83ProfesionalNombreCompleto = A83ProfesionalNombreCompleto ;
         Z138DCitaId = A138DCitaId ;
      }
      if ( ( GX_JID == 12 ) || ( GX_JID == 0 ) )
      {
         Z74SGSedeDisponibilidadSedeNombre = A74SGSedeDisponibilidadSedeNombre ;
         Z77SGSedeDisponibilidadClinicaId = A77SGSedeDisponibilidadClinicaId ;
         Z83ProfesionalNombreCompleto = A83ProfesionalNombreCompleto ;
         Z138DCitaId = A138DCitaId ;
      }
      if ( ( GX_JID == 13 ) || ( GX_JID == 0 ) )
      {
         Z79SGSedeDisponibilidadClinicaAbreviado = A79SGSedeDisponibilidadClinicaAbreviado ;
         Z83ProfesionalNombreCompleto = A83ProfesionalNombreCompleto ;
         Z138DCitaId = A138DCitaId ;
      }
      if ( ( GX_JID == 14 ) || ( GX_JID == 0 ) )
      {
         Z83ProfesionalNombreCompleto = A83ProfesionalNombreCompleto ;
         Z138DCitaId = A138DCitaId ;
      }
      if ( GX_JID == -8 )
      {
         Z34DisponibilidadId = A34DisponibilidadId ;
         Z133EventId = A133EventId ;
         Z134DisponibilidadDescription = A134DisponibilidadDescription ;
         Z67DisponibilidadFecha = A67DisponibilidadFecha ;
         Z69DisponibilidadHoraInicio = A69DisponibilidadHoraInicio ;
         Z135DisponibilidadHoraFin = A135DisponibilidadHoraFin ;
         Z137DisponibilidadUser = A137DisponibilidadUser ;
         Z136DisponibilidadEstado = A136DisponibilidadEstado ;
         Z139DisponibilidadEstadoCita = A139DisponibilidadEstadoCita ;
         Z298DisponibilidadTipoCita = A298DisponibilidadTipoCita ;
         Z31ProfesionalId = A31ProfesionalId ;
         Z32EspecialidadId = A32EspecialidadId ;
         Z35SGSedeDisponibilidadSedeId = A35SGSedeDisponibilidadSedeId ;
         Z138DCitaId = A138DCitaId ;
         Z85ProfesionalApellidoPaterno = A85ProfesionalApellidoPaterno ;
         Z86ProfesionalApellidoMaterno = A86ProfesionalApellidoMaterno ;
         Z84ProfesionalNombres = A84ProfesionalNombres ;
         Z88ProfesionalCOP = A88ProfesionalCOP ;
         Z140EspecialidadCodigo = A140EspecialidadCodigo ;
         Z71EspecialidadNombre = A71EspecialidadNombre ;
         Z74SGSedeDisponibilidadSedeNombre = A74SGSedeDisponibilidadSedeNombre ;
         Z77SGSedeDisponibilidadClinicaId = A77SGSedeDisponibilidadClinicaId ;
         Z79SGSedeDisponibilidadClinicaAbreviado = A79SGSedeDisponibilidadClinicaAbreviado ;
      }
   }

   public void standaloneNotModal( )
   {
   }

   public void standaloneModal( )
   {
   }

   public void load0J26( )
   {
      /* Using cursor BC000J12 */
      pr_default.execute(8, new Object[] {Boolean.valueOf(n34DisponibilidadId), Integer.valueOf(A34DisponibilidadId), Boolean.valueOf(n34DisponibilidadId), Integer.valueOf(A34DisponibilidadId)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         RcdFound26 = (short)(1) ;
         A133EventId = BC000J12_A133EventId[0] ;
         A134DisponibilidadDescription = BC000J12_A134DisponibilidadDescription[0] ;
         A85ProfesionalApellidoPaterno = BC000J12_A85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = BC000J12_A86ProfesionalApellidoMaterno[0] ;
         A84ProfesionalNombres = BC000J12_A84ProfesionalNombres[0] ;
         A88ProfesionalCOP = BC000J12_A88ProfesionalCOP[0] ;
         A67DisponibilidadFecha = BC000J12_A67DisponibilidadFecha[0] ;
         n67DisponibilidadFecha = BC000J12_n67DisponibilidadFecha[0] ;
         A69DisponibilidadHoraInicio = BC000J12_A69DisponibilidadHoraInicio[0] ;
         n69DisponibilidadHoraInicio = BC000J12_n69DisponibilidadHoraInicio[0] ;
         A135DisponibilidadHoraFin = BC000J12_A135DisponibilidadHoraFin[0] ;
         n135DisponibilidadHoraFin = BC000J12_n135DisponibilidadHoraFin[0] ;
         A140EspecialidadCodigo = BC000J12_A140EspecialidadCodigo[0] ;
         A71EspecialidadNombre = BC000J12_A71EspecialidadNombre[0] ;
         A74SGSedeDisponibilidadSedeNombre = BC000J12_A74SGSedeDisponibilidadSedeNombre[0] ;
         A79SGSedeDisponibilidadClinicaAbreviado = BC000J12_A79SGSedeDisponibilidadClinicaAbreviado[0] ;
         A137DisponibilidadUser = BC000J12_A137DisponibilidadUser[0] ;
         A136DisponibilidadEstado = BC000J12_A136DisponibilidadEstado[0] ;
         A139DisponibilidadEstadoCita = BC000J12_A139DisponibilidadEstadoCita[0] ;
         A298DisponibilidadTipoCita = BC000J12_A298DisponibilidadTipoCita[0] ;
         A31ProfesionalId = BC000J12_A31ProfesionalId[0] ;
         A32EspecialidadId = BC000J12_A32EspecialidadId[0] ;
         A35SGSedeDisponibilidadSedeId = BC000J12_A35SGSedeDisponibilidadSedeId[0] ;
         A77SGSedeDisponibilidadClinicaId = BC000J12_A77SGSedeDisponibilidadClinicaId[0] ;
         A138DCitaId = BC000J12_A138DCitaId[0] ;
         n138DCitaId = BC000J12_n138DCitaId[0] ;
         zm0J26( -8) ;
      }
      pr_default.close(8);
      onLoadActions0J26( ) ;
   }

   public void onLoadActions0J26( )
   {
      AV29Pgmname = "Disponibilidad_BC" ;
      A83ProfesionalNombreCompleto = A84ProfesionalNombres + " " + A85ProfesionalApellidoPaterno + " " + A86ProfesionalApellidoMaterno ;
   }

   public void checkExtendedTable0J26( )
   {
      nIsDirty_26 = (short)(0) ;
      standaloneModal( ) ;
      AV29Pgmname = "Disponibilidad_BC" ;
      /* Using cursor BC000J14 */
      pr_default.execute(9, new Object[] {Boolean.valueOf(n34DisponibilidadId), Integer.valueOf(A34DisponibilidadId), Boolean.valueOf(n34DisponibilidadId), Integer.valueOf(A34DisponibilidadId)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         A138DCitaId = BC000J14_A138DCitaId[0] ;
         n138DCitaId = BC000J14_n138DCitaId[0] ;
      }
      else
      {
         nIsDirty_26 = (short)(1) ;
         A138DCitaId = 0 ;
         n138DCitaId = false ;
      }
      pr_default.close(9);
      /* Using cursor BC000J15 */
      pr_default.execute(10, new Object[] {Integer.valueOf(A31ProfesionalId)});
      if ( (pr_default.getStatus(10) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Profesional'.", "ForeignKeyNotFound", 1, "PROFESIONALID");
         AnyError = (short)(1) ;
      }
      A85ProfesionalApellidoPaterno = BC000J15_A85ProfesionalApellidoPaterno[0] ;
      A86ProfesionalApellidoMaterno = BC000J15_A86ProfesionalApellidoMaterno[0] ;
      A84ProfesionalNombres = BC000J15_A84ProfesionalNombres[0] ;
      A88ProfesionalCOP = BC000J15_A88ProfesionalCOP[0] ;
      pr_default.close(10);
      nIsDirty_26 = (short)(1) ;
      A83ProfesionalNombreCompleto = A84ProfesionalNombres + " " + A85ProfesionalApellidoPaterno + " " + A86ProfesionalApellidoMaterno ;
      /* Using cursor BC000J16 */
      pr_default.execute(11, new Object[] {Integer.valueOf(A31ProfesionalId), Short.valueOf(A32EspecialidadId)});
      if ( (pr_default.getStatus(11) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Especialidad'.", "ForeignKeyNotFound", 1, "ESPECIALIDADID");
         AnyError = (short)(1) ;
      }
      pr_default.close(11);
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A67DisponibilidadFecha)) || (( GXutil.resetTime(A67DisponibilidadFecha).after( GXutil.resetTime( localUtil.ymdtod( 1753, 1, 1) )) ) || ( GXutil.dateCompare(GXutil.resetTime(A67DisponibilidadFecha), GXutil.resetTime(localUtil.ymdtod( 1753, 1, 1))) )) ) )
      {
         httpContext.GX_msglist.addItem("Campo Disponibilidad Fecha fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      /* Using cursor BC000J17 */
      pr_default.execute(12, new Object[] {Short.valueOf(A32EspecialidadId)});
      if ( (pr_default.getStatus(12) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Especialidad'.", "ForeignKeyNotFound", 1, "ESPECIALIDADID");
         AnyError = (short)(1) ;
      }
      A140EspecialidadCodigo = BC000J17_A140EspecialidadCodigo[0] ;
      A71EspecialidadNombre = BC000J17_A71EspecialidadNombre[0] ;
      pr_default.close(12);
      /* Using cursor BC000J18 */
      pr_default.execute(13, new Object[] {Short.valueOf(A35SGSedeDisponibilidadSedeId)});
      if ( (pr_default.getStatus(13) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'SGSede Disponibilidad'.", "ForeignKeyNotFound", 1, "SGSEDEDISPONIBILIDADSEDEID");
         AnyError = (short)(1) ;
      }
      A74SGSedeDisponibilidadSedeNombre = BC000J18_A74SGSedeDisponibilidadSedeNombre[0] ;
      A77SGSedeDisponibilidadClinicaId = BC000J18_A77SGSedeDisponibilidadClinicaId[0] ;
      pr_default.close(13);
      /* Using cursor BC000J19 */
      pr_default.execute(14, new Object[] {Short.valueOf(A77SGSedeDisponibilidadClinicaId)});
      if ( (pr_default.getStatus(14) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'SGSede Disponibilidad'.", "ForeignKeyNotFound", 1, "SGSEDEDISPONIBILIDADCLINICAID");
         AnyError = (short)(1) ;
      }
      A79SGSedeDisponibilidadClinicaAbreviado = BC000J19_A79SGSedeDisponibilidadClinicaAbreviado[0] ;
      pr_default.close(14);
      if ( ! ( ( GXutil.strcmp(A136DisponibilidadEstado, "A") == 0 ) || ( GXutil.strcmp(A136DisponibilidadEstado, "I") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Disponibilidad Estado fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A139DisponibilidadEstadoCita, "L") == 0 ) || ( GXutil.strcmp(A139DisponibilidadEstadoCita, "O") == 0 ) || ( GXutil.strcmp(A139DisponibilidadEstadoCita, "E") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Disponibilidad Estado Cita fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A298DisponibilidadTipoCita, "V") == 0 ) || ( GXutil.strcmp(A298DisponibilidadTipoCita, "P") == 0 ) || ( GXutil.strcmp(A298DisponibilidadTipoCita, "D") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Disponibilidad Tipo Cita fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors0J26( )
   {
      pr_default.close(9);
      pr_default.close(10);
      pr_default.close(11);
      pr_default.close(12);
      pr_default.close(13);
      pr_default.close(14);
   }

   public void enableDisable( )
   {
   }

   public void getKey0J26( )
   {
      /* Using cursor BC000J20 */
      pr_default.execute(15, new Object[] {Boolean.valueOf(n34DisponibilidadId), Integer.valueOf(A34DisponibilidadId)});
      if ( (pr_default.getStatus(15) != 101) )
      {
         RcdFound26 = (short)(1) ;
      }
      else
      {
         RcdFound26 = (short)(0) ;
      }
      pr_default.close(15);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC000J21 */
      pr_default.execute(16, new Object[] {Boolean.valueOf(n34DisponibilidadId), Integer.valueOf(A34DisponibilidadId)});
      if ( (pr_default.getStatus(16) != 101) )
      {
         zm0J26( 8) ;
         RcdFound26 = (short)(1) ;
         A34DisponibilidadId = BC000J21_A34DisponibilidadId[0] ;
         n34DisponibilidadId = BC000J21_n34DisponibilidadId[0] ;
         A133EventId = BC000J21_A133EventId[0] ;
         A134DisponibilidadDescription = BC000J21_A134DisponibilidadDescription[0] ;
         A67DisponibilidadFecha = BC000J21_A67DisponibilidadFecha[0] ;
         n67DisponibilidadFecha = BC000J21_n67DisponibilidadFecha[0] ;
         A69DisponibilidadHoraInicio = BC000J21_A69DisponibilidadHoraInicio[0] ;
         n69DisponibilidadHoraInicio = BC000J21_n69DisponibilidadHoraInicio[0] ;
         A135DisponibilidadHoraFin = BC000J21_A135DisponibilidadHoraFin[0] ;
         n135DisponibilidadHoraFin = BC000J21_n135DisponibilidadHoraFin[0] ;
         A137DisponibilidadUser = BC000J21_A137DisponibilidadUser[0] ;
         A136DisponibilidadEstado = BC000J21_A136DisponibilidadEstado[0] ;
         A139DisponibilidadEstadoCita = BC000J21_A139DisponibilidadEstadoCita[0] ;
         A298DisponibilidadTipoCita = BC000J21_A298DisponibilidadTipoCita[0] ;
         A31ProfesionalId = BC000J21_A31ProfesionalId[0] ;
         A32EspecialidadId = BC000J21_A32EspecialidadId[0] ;
         A35SGSedeDisponibilidadSedeId = BC000J21_A35SGSedeDisponibilidadSedeId[0] ;
         Z34DisponibilidadId = A34DisponibilidadId ;
         sMode26 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load0J26( ) ;
         if ( AnyError == 1 )
         {
            RcdFound26 = (short)(0) ;
            initializeNonKey0J26( ) ;
         }
         Gx_mode = sMode26 ;
      }
      else
      {
         RcdFound26 = (short)(0) ;
         initializeNonKey0J26( ) ;
         sMode26 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode26 ;
      }
      pr_default.close(16);
   }

   public void getEqualNoModal( )
   {
      getKey0J26( ) ;
      if ( RcdFound26 == 0 )
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
      confirm_0J0( ) ;
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

   public void checkOptimisticConcurrency0J26( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000J22 */
         pr_default.execute(17, new Object[] {Boolean.valueOf(n34DisponibilidadId), Integer.valueOf(A34DisponibilidadId)});
         if ( (pr_default.getStatus(17) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Disponibilidad"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(17) == 101) || ( GXutil.strcmp(Z133EventId, BC000J22_A133EventId[0]) != 0 ) || ( GXutil.strcmp(Z134DisponibilidadDescription, BC000J22_A134DisponibilidadDescription[0]) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(Z67DisponibilidadFecha), GXutil.resetTime(BC000J22_A67DisponibilidadFecha[0])) ) || !( GXutil.dateCompare(Z69DisponibilidadHoraInicio, BC000J22_A69DisponibilidadHoraInicio[0]) ) || !( GXutil.dateCompare(Z135DisponibilidadHoraFin, BC000J22_A135DisponibilidadHoraFin[0]) ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z137DisponibilidadUser != BC000J22_A137DisponibilidadUser[0] ) || ( GXutil.strcmp(Z136DisponibilidadEstado, BC000J22_A136DisponibilidadEstado[0]) != 0 ) || ( GXutil.strcmp(Z139DisponibilidadEstadoCita, BC000J22_A139DisponibilidadEstadoCita[0]) != 0 ) || ( GXutil.strcmp(Z298DisponibilidadTipoCita, BC000J22_A298DisponibilidadTipoCita[0]) != 0 ) || ( Z31ProfesionalId != BC000J22_A31ProfesionalId[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z32EspecialidadId != BC000J22_A32EspecialidadId[0] ) || ( Z35SGSedeDisponibilidadSedeId != BC000J22_A35SGSedeDisponibilidadSedeId[0] ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Disponibilidad"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0J26( )
   {
      beforeValidate0J26( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0J26( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0J26( 0) ;
         checkOptimisticConcurrency0J26( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0J26( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0J26( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000J23 */
                  pr_default.execute(18, new Object[] {A133EventId, A134DisponibilidadDescription, Boolean.valueOf(n67DisponibilidadFecha), A67DisponibilidadFecha, Boolean.valueOf(n69DisponibilidadHoraInicio), A69DisponibilidadHoraInicio, Boolean.valueOf(n135DisponibilidadHoraFin), A135DisponibilidadHoraFin, Integer.valueOf(A137DisponibilidadUser), A136DisponibilidadEstado, A139DisponibilidadEstadoCita, A298DisponibilidadTipoCita, Integer.valueOf(A31ProfesionalId), Short.valueOf(A32EspecialidadId), Short.valueOf(A35SGSedeDisponibilidadSedeId)});
                  A34DisponibilidadId = BC000J23_A34DisponibilidadId[0] ;
                  n34DisponibilidadId = BC000J23_n34DisponibilidadId[0] ;
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Disponibilidad");
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
            load0J26( ) ;
         }
         endLevel0J26( ) ;
      }
      closeExtendedTableCursors0J26( ) ;
   }

   public void update0J26( )
   {
      beforeValidate0J26( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0J26( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0J26( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0J26( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0J26( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000J24 */
                  pr_default.execute(19, new Object[] {A133EventId, A134DisponibilidadDescription, Boolean.valueOf(n67DisponibilidadFecha), A67DisponibilidadFecha, Boolean.valueOf(n69DisponibilidadHoraInicio), A69DisponibilidadHoraInicio, Boolean.valueOf(n135DisponibilidadHoraFin), A135DisponibilidadHoraFin, Integer.valueOf(A137DisponibilidadUser), A136DisponibilidadEstado, A139DisponibilidadEstadoCita, A298DisponibilidadTipoCita, Integer.valueOf(A31ProfesionalId), Short.valueOf(A32EspecialidadId), Short.valueOf(A35SGSedeDisponibilidadSedeId), Boolean.valueOf(n34DisponibilidadId), Integer.valueOf(A34DisponibilidadId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Disponibilidad");
                  if ( (pr_default.getStatus(19) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Disponibilidad"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0J26( ) ;
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
         endLevel0J26( ) ;
      }
      closeExtendedTableCursors0J26( ) ;
   }

   public void deferredUpdate0J26( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0J26( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0J26( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0J26( ) ;
         afterConfirm0J26( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0J26( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000J25 */
               pr_default.execute(20, new Object[] {Boolean.valueOf(n34DisponibilidadId), Integer.valueOf(A34DisponibilidadId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Disponibilidad");
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
      sMode26 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel0J26( ) ;
      Gx_mode = sMode26 ;
   }

   public void onDeleteControls0J26( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV29Pgmname = "Disponibilidad_BC" ;
         /* Using cursor BC000J27 */
         pr_default.execute(21, new Object[] {Boolean.valueOf(n34DisponibilidadId), Integer.valueOf(A34DisponibilidadId), Boolean.valueOf(n34DisponibilidadId), Integer.valueOf(A34DisponibilidadId)});
         if ( (pr_default.getStatus(21) != 101) )
         {
            A138DCitaId = BC000J27_A138DCitaId[0] ;
            n138DCitaId = BC000J27_n138DCitaId[0] ;
         }
         else
         {
            A138DCitaId = 0 ;
            n138DCitaId = false ;
         }
         pr_default.close(21);
         /* Using cursor BC000J28 */
         pr_default.execute(22, new Object[] {Integer.valueOf(A31ProfesionalId)});
         A85ProfesionalApellidoPaterno = BC000J28_A85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = BC000J28_A86ProfesionalApellidoMaterno[0] ;
         A84ProfesionalNombres = BC000J28_A84ProfesionalNombres[0] ;
         A88ProfesionalCOP = BC000J28_A88ProfesionalCOP[0] ;
         pr_default.close(22);
         A83ProfesionalNombreCompleto = A84ProfesionalNombres + " " + A85ProfesionalApellidoPaterno + " " + A86ProfesionalApellidoMaterno ;
         /* Using cursor BC000J29 */
         pr_default.execute(23, new Object[] {Short.valueOf(A32EspecialidadId)});
         A140EspecialidadCodigo = BC000J29_A140EspecialidadCodigo[0] ;
         A71EspecialidadNombre = BC000J29_A71EspecialidadNombre[0] ;
         pr_default.close(23);
         /* Using cursor BC000J30 */
         pr_default.execute(24, new Object[] {Short.valueOf(A35SGSedeDisponibilidadSedeId)});
         A74SGSedeDisponibilidadSedeNombre = BC000J30_A74SGSedeDisponibilidadSedeNombre[0] ;
         A77SGSedeDisponibilidadClinicaId = BC000J30_A77SGSedeDisponibilidadClinicaId[0] ;
         pr_default.close(24);
         /* Using cursor BC000J31 */
         pr_default.execute(25, new Object[] {Short.valueOf(A77SGSedeDisponibilidadClinicaId)});
         A79SGSedeDisponibilidadClinicaAbreviado = BC000J31_A79SGSedeDisponibilidadClinicaAbreviado[0] ;
         pr_default.close(25);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor BC000J32 */
         pr_default.execute(26, new Object[] {Boolean.valueOf(n34DisponibilidadId), Integer.valueOf(A34DisponibilidadId)});
         if ( (pr_default.getStatus(26) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Pago"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(26);
         /* Using cursor BC000J33 */
         pr_default.execute(27, new Object[] {Boolean.valueOf(n34DisponibilidadId), Integer.valueOf(A34DisponibilidadId)});
         if ( (pr_default.getStatus(27) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Cita"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(27);
      }
   }

   public void endLevel0J26( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(17);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0J26( ) ;
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

   public void scanKeyStart0J26( )
   {
      /* Scan By routine */
      /* Using cursor BC000J35 */
      pr_default.execute(28, new Object[] {Boolean.valueOf(n34DisponibilidadId), Integer.valueOf(A34DisponibilidadId), Boolean.valueOf(n34DisponibilidadId), Integer.valueOf(A34DisponibilidadId)});
      RcdFound26 = (short)(0) ;
      if ( (pr_default.getStatus(28) != 101) )
      {
         RcdFound26 = (short)(1) ;
         A34DisponibilidadId = BC000J35_A34DisponibilidadId[0] ;
         n34DisponibilidadId = BC000J35_n34DisponibilidadId[0] ;
         A133EventId = BC000J35_A133EventId[0] ;
         A134DisponibilidadDescription = BC000J35_A134DisponibilidadDescription[0] ;
         A85ProfesionalApellidoPaterno = BC000J35_A85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = BC000J35_A86ProfesionalApellidoMaterno[0] ;
         A84ProfesionalNombres = BC000J35_A84ProfesionalNombres[0] ;
         A88ProfesionalCOP = BC000J35_A88ProfesionalCOP[0] ;
         A67DisponibilidadFecha = BC000J35_A67DisponibilidadFecha[0] ;
         n67DisponibilidadFecha = BC000J35_n67DisponibilidadFecha[0] ;
         A69DisponibilidadHoraInicio = BC000J35_A69DisponibilidadHoraInicio[0] ;
         n69DisponibilidadHoraInicio = BC000J35_n69DisponibilidadHoraInicio[0] ;
         A135DisponibilidadHoraFin = BC000J35_A135DisponibilidadHoraFin[0] ;
         n135DisponibilidadHoraFin = BC000J35_n135DisponibilidadHoraFin[0] ;
         A140EspecialidadCodigo = BC000J35_A140EspecialidadCodigo[0] ;
         A71EspecialidadNombre = BC000J35_A71EspecialidadNombre[0] ;
         A74SGSedeDisponibilidadSedeNombre = BC000J35_A74SGSedeDisponibilidadSedeNombre[0] ;
         A79SGSedeDisponibilidadClinicaAbreviado = BC000J35_A79SGSedeDisponibilidadClinicaAbreviado[0] ;
         A137DisponibilidadUser = BC000J35_A137DisponibilidadUser[0] ;
         A136DisponibilidadEstado = BC000J35_A136DisponibilidadEstado[0] ;
         A139DisponibilidadEstadoCita = BC000J35_A139DisponibilidadEstadoCita[0] ;
         A298DisponibilidadTipoCita = BC000J35_A298DisponibilidadTipoCita[0] ;
         A31ProfesionalId = BC000J35_A31ProfesionalId[0] ;
         A32EspecialidadId = BC000J35_A32EspecialidadId[0] ;
         A35SGSedeDisponibilidadSedeId = BC000J35_A35SGSedeDisponibilidadSedeId[0] ;
         A77SGSedeDisponibilidadClinicaId = BC000J35_A77SGSedeDisponibilidadClinicaId[0] ;
         A138DCitaId = BC000J35_A138DCitaId[0] ;
         n138DCitaId = BC000J35_n138DCitaId[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0J26( )
   {
      /* Scan next routine */
      pr_default.readNext(28);
      RcdFound26 = (short)(0) ;
      scanKeyLoad0J26( ) ;
   }

   public void scanKeyLoad0J26( )
   {
      sMode26 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(28) != 101) )
      {
         RcdFound26 = (short)(1) ;
         A34DisponibilidadId = BC000J35_A34DisponibilidadId[0] ;
         n34DisponibilidadId = BC000J35_n34DisponibilidadId[0] ;
         A133EventId = BC000J35_A133EventId[0] ;
         A134DisponibilidadDescription = BC000J35_A134DisponibilidadDescription[0] ;
         A85ProfesionalApellidoPaterno = BC000J35_A85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = BC000J35_A86ProfesionalApellidoMaterno[0] ;
         A84ProfesionalNombres = BC000J35_A84ProfesionalNombres[0] ;
         A88ProfesionalCOP = BC000J35_A88ProfesionalCOP[0] ;
         A67DisponibilidadFecha = BC000J35_A67DisponibilidadFecha[0] ;
         n67DisponibilidadFecha = BC000J35_n67DisponibilidadFecha[0] ;
         A69DisponibilidadHoraInicio = BC000J35_A69DisponibilidadHoraInicio[0] ;
         n69DisponibilidadHoraInicio = BC000J35_n69DisponibilidadHoraInicio[0] ;
         A135DisponibilidadHoraFin = BC000J35_A135DisponibilidadHoraFin[0] ;
         n135DisponibilidadHoraFin = BC000J35_n135DisponibilidadHoraFin[0] ;
         A140EspecialidadCodigo = BC000J35_A140EspecialidadCodigo[0] ;
         A71EspecialidadNombre = BC000J35_A71EspecialidadNombre[0] ;
         A74SGSedeDisponibilidadSedeNombre = BC000J35_A74SGSedeDisponibilidadSedeNombre[0] ;
         A79SGSedeDisponibilidadClinicaAbreviado = BC000J35_A79SGSedeDisponibilidadClinicaAbreviado[0] ;
         A137DisponibilidadUser = BC000J35_A137DisponibilidadUser[0] ;
         A136DisponibilidadEstado = BC000J35_A136DisponibilidadEstado[0] ;
         A139DisponibilidadEstadoCita = BC000J35_A139DisponibilidadEstadoCita[0] ;
         A298DisponibilidadTipoCita = BC000J35_A298DisponibilidadTipoCita[0] ;
         A31ProfesionalId = BC000J35_A31ProfesionalId[0] ;
         A32EspecialidadId = BC000J35_A32EspecialidadId[0] ;
         A35SGSedeDisponibilidadSedeId = BC000J35_A35SGSedeDisponibilidadSedeId[0] ;
         A77SGSedeDisponibilidadClinicaId = BC000J35_A77SGSedeDisponibilidadClinicaId[0] ;
         A138DCitaId = BC000J35_A138DCitaId[0] ;
         n138DCitaId = BC000J35_n138DCitaId[0] ;
      }
      Gx_mode = sMode26 ;
   }

   public void scanKeyEnd0J26( )
   {
      pr_default.close(28);
   }

   public void afterConfirm0J26( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0J26( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0J26( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0J26( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0J26( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0J26( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0J26( )
   {
   }

   public void send_integrity_lvl_hashes0J26( )
   {
   }

   public void addRow0J26( )
   {
      VarsToRow26( bcDisponibilidad) ;
   }

   public void readRow0J26( )
   {
      RowToVars26( bcDisponibilidad, 1) ;
   }

   public void initializeNonKey0J26( )
   {
      A83ProfesionalNombreCompleto = "" ;
      A138DCitaId = 0 ;
      n138DCitaId = false ;
      A133EventId = "" ;
      A134DisponibilidadDescription = "" ;
      A31ProfesionalId = 0 ;
      A85ProfesionalApellidoPaterno = "" ;
      A86ProfesionalApellidoMaterno = "" ;
      A84ProfesionalNombres = "" ;
      A88ProfesionalCOP = "" ;
      A67DisponibilidadFecha = GXutil.nullDate() ;
      n67DisponibilidadFecha = false ;
      A69DisponibilidadHoraInicio = GXutil.resetTime( GXutil.nullDate() );
      n69DisponibilidadHoraInicio = false ;
      A135DisponibilidadHoraFin = GXutil.resetTime( GXutil.nullDate() );
      n135DisponibilidadHoraFin = false ;
      A32EspecialidadId = (short)(0) ;
      A140EspecialidadCodigo = "" ;
      A71EspecialidadNombre = "" ;
      A35SGSedeDisponibilidadSedeId = (short)(0) ;
      A74SGSedeDisponibilidadSedeNombre = "" ;
      A77SGSedeDisponibilidadClinicaId = (short)(0) ;
      A79SGSedeDisponibilidadClinicaAbreviado = "" ;
      A137DisponibilidadUser = 0 ;
      A136DisponibilidadEstado = "" ;
      A139DisponibilidadEstadoCita = "" ;
      A298DisponibilidadTipoCita = "" ;
      Z133EventId = "" ;
      Z134DisponibilidadDescription = "" ;
      Z67DisponibilidadFecha = GXutil.nullDate() ;
      Z69DisponibilidadHoraInicio = GXutil.resetTime( GXutil.nullDate() );
      Z135DisponibilidadHoraFin = GXutil.resetTime( GXutil.nullDate() );
      Z137DisponibilidadUser = 0 ;
      Z136DisponibilidadEstado = "" ;
      Z139DisponibilidadEstadoCita = "" ;
      Z298DisponibilidadTipoCita = "" ;
      Z31ProfesionalId = 0 ;
      Z32EspecialidadId = (short)(0) ;
      Z35SGSedeDisponibilidadSedeId = (short)(0) ;
   }

   public void initAll0J26( )
   {
      A34DisponibilidadId = 0 ;
      n34DisponibilidadId = false ;
      initializeNonKey0J26( ) ;
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

   public void VarsToRow26( com.projectthani.SdtDisponibilidad obj26 )
   {
      obj26.setgxTv_SdtDisponibilidad_Mode( Gx_mode );
      obj26.setgxTv_SdtDisponibilidad_Profesionalnombrecompleto( A83ProfesionalNombreCompleto );
      obj26.setgxTv_SdtDisponibilidad_Dcitaid( A138DCitaId );
      obj26.setgxTv_SdtDisponibilidad_Eventid( A133EventId );
      obj26.setgxTv_SdtDisponibilidad_Disponibilidaddescription( A134DisponibilidadDescription );
      obj26.setgxTv_SdtDisponibilidad_Profesionalid( A31ProfesionalId );
      obj26.setgxTv_SdtDisponibilidad_Profesionalapellidopaterno( A85ProfesionalApellidoPaterno );
      obj26.setgxTv_SdtDisponibilidad_Profesionalapellidomaterno( A86ProfesionalApellidoMaterno );
      obj26.setgxTv_SdtDisponibilidad_Profesionalnombres( A84ProfesionalNombres );
      obj26.setgxTv_SdtDisponibilidad_Profesionalcop( A88ProfesionalCOP );
      obj26.setgxTv_SdtDisponibilidad_Disponibilidadfecha( A67DisponibilidadFecha );
      obj26.setgxTv_SdtDisponibilidad_Disponibilidadhorainicio( A69DisponibilidadHoraInicio );
      obj26.setgxTv_SdtDisponibilidad_Disponibilidadhorafin( A135DisponibilidadHoraFin );
      obj26.setgxTv_SdtDisponibilidad_Especialidadid( A32EspecialidadId );
      obj26.setgxTv_SdtDisponibilidad_Especialidadcodigo( A140EspecialidadCodigo );
      obj26.setgxTv_SdtDisponibilidad_Especialidadnombre( A71EspecialidadNombre );
      obj26.setgxTv_SdtDisponibilidad_Sgsededisponibilidadsedeid( A35SGSedeDisponibilidadSedeId );
      obj26.setgxTv_SdtDisponibilidad_Sgsededisponibilidadsedenombre( A74SGSedeDisponibilidadSedeNombre );
      obj26.setgxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaid( A77SGSedeDisponibilidadClinicaId );
      obj26.setgxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaabreviado( A79SGSedeDisponibilidadClinicaAbreviado );
      obj26.setgxTv_SdtDisponibilidad_Disponibilidaduser( A137DisponibilidadUser );
      obj26.setgxTv_SdtDisponibilidad_Disponibilidadestado( A136DisponibilidadEstado );
      obj26.setgxTv_SdtDisponibilidad_Disponibilidadestadocita( A139DisponibilidadEstadoCita );
      obj26.setgxTv_SdtDisponibilidad_Disponibilidadtipocita( A298DisponibilidadTipoCita );
      obj26.setgxTv_SdtDisponibilidad_Disponibilidadid( A34DisponibilidadId );
      obj26.setgxTv_SdtDisponibilidad_Disponibilidadid_Z( Z34DisponibilidadId );
      obj26.setgxTv_SdtDisponibilidad_Eventid_Z( Z133EventId );
      obj26.setgxTv_SdtDisponibilidad_Disponibilidaddescription_Z( Z134DisponibilidadDescription );
      obj26.setgxTv_SdtDisponibilidad_Profesionalid_Z( Z31ProfesionalId );
      obj26.setgxTv_SdtDisponibilidad_Profesionalapellidopaterno_Z( Z85ProfesionalApellidoPaterno );
      obj26.setgxTv_SdtDisponibilidad_Profesionalapellidomaterno_Z( Z86ProfesionalApellidoMaterno );
      obj26.setgxTv_SdtDisponibilidad_Profesionalnombres_Z( Z84ProfesionalNombres );
      obj26.setgxTv_SdtDisponibilidad_Profesionalnombrecompleto_Z( Z83ProfesionalNombreCompleto );
      obj26.setgxTv_SdtDisponibilidad_Profesionalcop_Z( Z88ProfesionalCOP );
      obj26.setgxTv_SdtDisponibilidad_Disponibilidadfecha_Z( Z67DisponibilidadFecha );
      obj26.setgxTv_SdtDisponibilidad_Disponibilidadhorainicio_Z( Z69DisponibilidadHoraInicio );
      obj26.setgxTv_SdtDisponibilidad_Disponibilidadhorafin_Z( Z135DisponibilidadHoraFin );
      obj26.setgxTv_SdtDisponibilidad_Especialidadid_Z( Z32EspecialidadId );
      obj26.setgxTv_SdtDisponibilidad_Especialidadcodigo_Z( Z140EspecialidadCodigo );
      obj26.setgxTv_SdtDisponibilidad_Especialidadnombre_Z( Z71EspecialidadNombre );
      obj26.setgxTv_SdtDisponibilidad_Sgsededisponibilidadsedeid_Z( Z35SGSedeDisponibilidadSedeId );
      obj26.setgxTv_SdtDisponibilidad_Sgsededisponibilidadsedenombre_Z( Z74SGSedeDisponibilidadSedeNombre );
      obj26.setgxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaid_Z( Z77SGSedeDisponibilidadClinicaId );
      obj26.setgxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaabreviado_Z( Z79SGSedeDisponibilidadClinicaAbreviado );
      obj26.setgxTv_SdtDisponibilidad_Disponibilidaduser_Z( Z137DisponibilidadUser );
      obj26.setgxTv_SdtDisponibilidad_Disponibilidadestado_Z( Z136DisponibilidadEstado );
      obj26.setgxTv_SdtDisponibilidad_Disponibilidadestadocita_Z( Z139DisponibilidadEstadoCita );
      obj26.setgxTv_SdtDisponibilidad_Dcitaid_Z( Z138DCitaId );
      obj26.setgxTv_SdtDisponibilidad_Disponibilidadtipocita_Z( Z298DisponibilidadTipoCita );
      obj26.setgxTv_SdtDisponibilidad_Disponibilidadid_N( (byte)((byte)((n34DisponibilidadId)?1:0)) );
      obj26.setgxTv_SdtDisponibilidad_Disponibilidadfecha_N( (byte)((byte)((n67DisponibilidadFecha)?1:0)) );
      obj26.setgxTv_SdtDisponibilidad_Disponibilidadhorainicio_N( (byte)((byte)((n69DisponibilidadHoraInicio)?1:0)) );
      obj26.setgxTv_SdtDisponibilidad_Disponibilidadhorafin_N( (byte)((byte)((n135DisponibilidadHoraFin)?1:0)) );
      obj26.setgxTv_SdtDisponibilidad_Dcitaid_N( (byte)((byte)((n138DCitaId)?1:0)) );
      obj26.setgxTv_SdtDisponibilidad_Mode( Gx_mode );
   }

   public void KeyVarsToRow26( com.projectthani.SdtDisponibilidad obj26 )
   {
      obj26.setgxTv_SdtDisponibilidad_Disponibilidadid( A34DisponibilidadId );
   }

   public void RowToVars26( com.projectthani.SdtDisponibilidad obj26 ,
                            int forceLoad )
   {
      Gx_mode = obj26.getgxTv_SdtDisponibilidad_Mode() ;
      A83ProfesionalNombreCompleto = obj26.getgxTv_SdtDisponibilidad_Profesionalnombrecompleto() ;
      A138DCitaId = obj26.getgxTv_SdtDisponibilidad_Dcitaid() ;
      n138DCitaId = false ;
      A133EventId = obj26.getgxTv_SdtDisponibilidad_Eventid() ;
      A134DisponibilidadDescription = obj26.getgxTv_SdtDisponibilidad_Disponibilidaddescription() ;
      A31ProfesionalId = obj26.getgxTv_SdtDisponibilidad_Profesionalid() ;
      A85ProfesionalApellidoPaterno = obj26.getgxTv_SdtDisponibilidad_Profesionalapellidopaterno() ;
      A86ProfesionalApellidoMaterno = obj26.getgxTv_SdtDisponibilidad_Profesionalapellidomaterno() ;
      A84ProfesionalNombres = obj26.getgxTv_SdtDisponibilidad_Profesionalnombres() ;
      A88ProfesionalCOP = obj26.getgxTv_SdtDisponibilidad_Profesionalcop() ;
      A67DisponibilidadFecha = obj26.getgxTv_SdtDisponibilidad_Disponibilidadfecha() ;
      n67DisponibilidadFecha = false ;
      A69DisponibilidadHoraInicio = obj26.getgxTv_SdtDisponibilidad_Disponibilidadhorainicio() ;
      n69DisponibilidadHoraInicio = false ;
      A135DisponibilidadHoraFin = obj26.getgxTv_SdtDisponibilidad_Disponibilidadhorafin() ;
      n135DisponibilidadHoraFin = false ;
      A32EspecialidadId = obj26.getgxTv_SdtDisponibilidad_Especialidadid() ;
      A140EspecialidadCodigo = obj26.getgxTv_SdtDisponibilidad_Especialidadcodigo() ;
      A71EspecialidadNombre = obj26.getgxTv_SdtDisponibilidad_Especialidadnombre() ;
      A35SGSedeDisponibilidadSedeId = obj26.getgxTv_SdtDisponibilidad_Sgsededisponibilidadsedeid() ;
      A74SGSedeDisponibilidadSedeNombre = obj26.getgxTv_SdtDisponibilidad_Sgsededisponibilidadsedenombre() ;
      A77SGSedeDisponibilidadClinicaId = obj26.getgxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaid() ;
      A79SGSedeDisponibilidadClinicaAbreviado = obj26.getgxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaabreviado() ;
      A137DisponibilidadUser = obj26.getgxTv_SdtDisponibilidad_Disponibilidaduser() ;
      A136DisponibilidadEstado = obj26.getgxTv_SdtDisponibilidad_Disponibilidadestado() ;
      A139DisponibilidadEstadoCita = obj26.getgxTv_SdtDisponibilidad_Disponibilidadestadocita() ;
      A298DisponibilidadTipoCita = obj26.getgxTv_SdtDisponibilidad_Disponibilidadtipocita() ;
      A34DisponibilidadId = obj26.getgxTv_SdtDisponibilidad_Disponibilidadid() ;
      n34DisponibilidadId = false ;
      Z34DisponibilidadId = obj26.getgxTv_SdtDisponibilidad_Disponibilidadid_Z() ;
      Z133EventId = obj26.getgxTv_SdtDisponibilidad_Eventid_Z() ;
      Z134DisponibilidadDescription = obj26.getgxTv_SdtDisponibilidad_Disponibilidaddescription_Z() ;
      Z31ProfesionalId = obj26.getgxTv_SdtDisponibilidad_Profesionalid_Z() ;
      Z85ProfesionalApellidoPaterno = obj26.getgxTv_SdtDisponibilidad_Profesionalapellidopaterno_Z() ;
      Z86ProfesionalApellidoMaterno = obj26.getgxTv_SdtDisponibilidad_Profesionalapellidomaterno_Z() ;
      Z84ProfesionalNombres = obj26.getgxTv_SdtDisponibilidad_Profesionalnombres_Z() ;
      Z83ProfesionalNombreCompleto = obj26.getgxTv_SdtDisponibilidad_Profesionalnombrecompleto_Z() ;
      Z88ProfesionalCOP = obj26.getgxTv_SdtDisponibilidad_Profesionalcop_Z() ;
      Z67DisponibilidadFecha = obj26.getgxTv_SdtDisponibilidad_Disponibilidadfecha_Z() ;
      Z69DisponibilidadHoraInicio = obj26.getgxTv_SdtDisponibilidad_Disponibilidadhorainicio_Z() ;
      Z135DisponibilidadHoraFin = obj26.getgxTv_SdtDisponibilidad_Disponibilidadhorafin_Z() ;
      Z32EspecialidadId = obj26.getgxTv_SdtDisponibilidad_Especialidadid_Z() ;
      Z140EspecialidadCodigo = obj26.getgxTv_SdtDisponibilidad_Especialidadcodigo_Z() ;
      Z71EspecialidadNombre = obj26.getgxTv_SdtDisponibilidad_Especialidadnombre_Z() ;
      Z35SGSedeDisponibilidadSedeId = obj26.getgxTv_SdtDisponibilidad_Sgsededisponibilidadsedeid_Z() ;
      Z74SGSedeDisponibilidadSedeNombre = obj26.getgxTv_SdtDisponibilidad_Sgsededisponibilidadsedenombre_Z() ;
      Z77SGSedeDisponibilidadClinicaId = obj26.getgxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaid_Z() ;
      Z79SGSedeDisponibilidadClinicaAbreviado = obj26.getgxTv_SdtDisponibilidad_Sgsededisponibilidadclinicaabreviado_Z() ;
      Z137DisponibilidadUser = obj26.getgxTv_SdtDisponibilidad_Disponibilidaduser_Z() ;
      Z136DisponibilidadEstado = obj26.getgxTv_SdtDisponibilidad_Disponibilidadestado_Z() ;
      Z139DisponibilidadEstadoCita = obj26.getgxTv_SdtDisponibilidad_Disponibilidadestadocita_Z() ;
      Z138DCitaId = obj26.getgxTv_SdtDisponibilidad_Dcitaid_Z() ;
      Z298DisponibilidadTipoCita = obj26.getgxTv_SdtDisponibilidad_Disponibilidadtipocita_Z() ;
      n34DisponibilidadId = (boolean)((obj26.getgxTv_SdtDisponibilidad_Disponibilidadid_N()==0)?false:true) ;
      n67DisponibilidadFecha = (boolean)((obj26.getgxTv_SdtDisponibilidad_Disponibilidadfecha_N()==0)?false:true) ;
      n69DisponibilidadHoraInicio = (boolean)((obj26.getgxTv_SdtDisponibilidad_Disponibilidadhorainicio_N()==0)?false:true) ;
      n135DisponibilidadHoraFin = (boolean)((obj26.getgxTv_SdtDisponibilidad_Disponibilidadhorafin_N()==0)?false:true) ;
      n138DCitaId = (boolean)((obj26.getgxTv_SdtDisponibilidad_Dcitaid_N()==0)?false:true) ;
      Gx_mode = obj26.getgxTv_SdtDisponibilidad_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A34DisponibilidadId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      n34DisponibilidadId = false ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey0J26( ) ;
      scanKeyStart0J26( ) ;
      if ( RcdFound26 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z34DisponibilidadId = A34DisponibilidadId ;
      }
      zm0J26( -8) ;
      onLoadActions0J26( ) ;
      addRow0J26( ) ;
      scanKeyEnd0J26( ) ;
      if ( RcdFound26 == 0 )
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
      RowToVars26( bcDisponibilidad, 0) ;
      scanKeyStart0J26( ) ;
      if ( RcdFound26 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z34DisponibilidadId = A34DisponibilidadId ;
      }
      zm0J26( -8) ;
      onLoadActions0J26( ) ;
      addRow0J26( ) ;
      scanKeyEnd0J26( ) ;
      if ( RcdFound26 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0J26( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert0J26( ) ;
      }
      else
      {
         if ( RcdFound26 == 1 )
         {
            if ( A34DisponibilidadId != Z34DisponibilidadId )
            {
               A34DisponibilidadId = Z34DisponibilidadId ;
               n34DisponibilidadId = false ;
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
               update0J26( ) ;
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
               if ( A34DisponibilidadId != Z34DisponibilidadId )
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
                     insert0J26( ) ;
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
                     insert0J26( ) ;
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
      RowToVars26( bcDisponibilidad, 1) ;
      saveImpl( ) ;
      VarsToRow26( bcDisponibilidad) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars26( bcDisponibilidad, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0J26( ) ;
      afterTrn( ) ;
      VarsToRow26( bcDisponibilidad) ;
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
         com.projectthani.SdtDisponibilidad auxBC = new com.projectthani.SdtDisponibilidad( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A34DisponibilidadId);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcDisponibilidad);
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
      RowToVars26( bcDisponibilidad, 1) ;
      updateImpl( ) ;
      VarsToRow26( bcDisponibilidad) ;
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
      RowToVars26( bcDisponibilidad, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0J26( ) ;
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
      VarsToRow26( bcDisponibilidad) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars26( bcDisponibilidad, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey0J26( ) ;
      if ( RcdFound26 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( A34DisponibilidadId != Z34DisponibilidadId )
         {
            A34DisponibilidadId = Z34DisponibilidadId ;
            n34DisponibilidadId = false ;
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
         if ( A34DisponibilidadId != Z34DisponibilidadId )
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
      pr_default.close(22);
      pr_default.close(2);
      pr_default.close(23);
      pr_default.close(3);
      pr_default.close(4);
      pr_default.close(24);
      pr_default.close(5);
      pr_default.close(25);
      pr_default.close(6);
      pr_default.close(21);
      pr_default.close(7);
      Application.rollbackDataStores(context, remoteHandle, pr_default, "disponibilidad_bc");
      VarsToRow26( bcDisponibilidad) ;
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
      Gx_mode = bcDisponibilidad.getgxTv_SdtDisponibilidad_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcDisponibilidad.setgxTv_SdtDisponibilidad_Mode( Gx_mode );
   }

   public void SetSDT( com.projectthani.SdtDisponibilidad sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcDisponibilidad )
      {
         bcDisponibilidad = sdt ;
         if ( GXutil.strcmp(bcDisponibilidad.getgxTv_SdtDisponibilidad_Mode(), "") == 0 )
         {
            bcDisponibilidad.setgxTv_SdtDisponibilidad_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow26( bcDisponibilidad) ;
         }
         else
         {
            RowToVars26( bcDisponibilidad, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcDisponibilidad.getgxTv_SdtDisponibilidad_Mode(), "") == 0 )
         {
            bcDisponibilidad.setgxTv_SdtDisponibilidad_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars26( bcDisponibilidad, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtDisponibilidad getDisponibilidad_BC( )
   {
      return bcDisponibilidad ;
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
      AV29Pgmname = "" ;
      AV10TrnContext = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11WebSession = httpContext.getWebSession();
      AV14TrnContextAtt = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      Z133EventId = "" ;
      A133EventId = "" ;
      Z134DisponibilidadDescription = "" ;
      A134DisponibilidadDescription = "" ;
      Z67DisponibilidadFecha = GXutil.nullDate() ;
      A67DisponibilidadFecha = GXutil.nullDate() ;
      Z69DisponibilidadHoraInicio = GXutil.resetTime( GXutil.nullDate() );
      A69DisponibilidadHoraInicio = GXutil.resetTime( GXutil.nullDate() );
      Z135DisponibilidadHoraFin = GXutil.resetTime( GXutil.nullDate() );
      A135DisponibilidadHoraFin = GXutil.resetTime( GXutil.nullDate() );
      Z136DisponibilidadEstado = "" ;
      A136DisponibilidadEstado = "" ;
      Z139DisponibilidadEstadoCita = "" ;
      A139DisponibilidadEstadoCita = "" ;
      Z298DisponibilidadTipoCita = "" ;
      A298DisponibilidadTipoCita = "" ;
      Z83ProfesionalNombreCompleto = "" ;
      A83ProfesionalNombreCompleto = "" ;
      Z85ProfesionalApellidoPaterno = "" ;
      A85ProfesionalApellidoPaterno = "" ;
      Z86ProfesionalApellidoMaterno = "" ;
      A86ProfesionalApellidoMaterno = "" ;
      Z84ProfesionalNombres = "" ;
      A84ProfesionalNombres = "" ;
      Z88ProfesionalCOP = "" ;
      A88ProfesionalCOP = "" ;
      Z140EspecialidadCodigo = "" ;
      A140EspecialidadCodigo = "" ;
      Z71EspecialidadNombre = "" ;
      A71EspecialidadNombre = "" ;
      Z74SGSedeDisponibilidadSedeNombre = "" ;
      A74SGSedeDisponibilidadSedeNombre = "" ;
      Z79SGSedeDisponibilidadClinicaAbreviado = "" ;
      A79SGSedeDisponibilidadClinicaAbreviado = "" ;
      BC000J12_A34DisponibilidadId = new int[1] ;
      BC000J12_n34DisponibilidadId = new boolean[] {false} ;
      BC000J12_A133EventId = new String[] {""} ;
      BC000J12_A134DisponibilidadDescription = new String[] {""} ;
      BC000J12_A85ProfesionalApellidoPaterno = new String[] {""} ;
      BC000J12_A86ProfesionalApellidoMaterno = new String[] {""} ;
      BC000J12_A84ProfesionalNombres = new String[] {""} ;
      BC000J12_A88ProfesionalCOP = new String[] {""} ;
      BC000J12_A67DisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      BC000J12_n67DisponibilidadFecha = new boolean[] {false} ;
      BC000J12_A69DisponibilidadHoraInicio = new java.util.Date[] {GXutil.nullDate()} ;
      BC000J12_n69DisponibilidadHoraInicio = new boolean[] {false} ;
      BC000J12_A135DisponibilidadHoraFin = new java.util.Date[] {GXutil.nullDate()} ;
      BC000J12_n135DisponibilidadHoraFin = new boolean[] {false} ;
      BC000J12_A140EspecialidadCodigo = new String[] {""} ;
      BC000J12_A71EspecialidadNombre = new String[] {""} ;
      BC000J12_A74SGSedeDisponibilidadSedeNombre = new String[] {""} ;
      BC000J12_A79SGSedeDisponibilidadClinicaAbreviado = new String[] {""} ;
      BC000J12_A137DisponibilidadUser = new int[1] ;
      BC000J12_A136DisponibilidadEstado = new String[] {""} ;
      BC000J12_A139DisponibilidadEstadoCita = new String[] {""} ;
      BC000J12_A298DisponibilidadTipoCita = new String[] {""} ;
      BC000J12_A31ProfesionalId = new int[1] ;
      BC000J12_A32EspecialidadId = new short[1] ;
      BC000J12_A35SGSedeDisponibilidadSedeId = new short[1] ;
      BC000J12_A77SGSedeDisponibilidadClinicaId = new short[1] ;
      BC000J12_A138DCitaId = new int[1] ;
      BC000J12_n138DCitaId = new boolean[] {false} ;
      BC000J14_A138DCitaId = new int[1] ;
      BC000J14_n138DCitaId = new boolean[] {false} ;
      BC000J15_A85ProfesionalApellidoPaterno = new String[] {""} ;
      BC000J15_A86ProfesionalApellidoMaterno = new String[] {""} ;
      BC000J15_A84ProfesionalNombres = new String[] {""} ;
      BC000J15_A88ProfesionalCOP = new String[] {""} ;
      BC000J16_A31ProfesionalId = new int[1] ;
      BC000J17_A140EspecialidadCodigo = new String[] {""} ;
      BC000J17_A71EspecialidadNombre = new String[] {""} ;
      BC000J18_A74SGSedeDisponibilidadSedeNombre = new String[] {""} ;
      BC000J18_A77SGSedeDisponibilidadClinicaId = new short[1] ;
      BC000J19_A79SGSedeDisponibilidadClinicaAbreviado = new String[] {""} ;
      BC000J20_A34DisponibilidadId = new int[1] ;
      BC000J20_n34DisponibilidadId = new boolean[] {false} ;
      BC000J21_A34DisponibilidadId = new int[1] ;
      BC000J21_n34DisponibilidadId = new boolean[] {false} ;
      BC000J21_A133EventId = new String[] {""} ;
      BC000J21_A134DisponibilidadDescription = new String[] {""} ;
      BC000J21_A67DisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      BC000J21_n67DisponibilidadFecha = new boolean[] {false} ;
      BC000J21_A69DisponibilidadHoraInicio = new java.util.Date[] {GXutil.nullDate()} ;
      BC000J21_n69DisponibilidadHoraInicio = new boolean[] {false} ;
      BC000J21_A135DisponibilidadHoraFin = new java.util.Date[] {GXutil.nullDate()} ;
      BC000J21_n135DisponibilidadHoraFin = new boolean[] {false} ;
      BC000J21_A137DisponibilidadUser = new int[1] ;
      BC000J21_A136DisponibilidadEstado = new String[] {""} ;
      BC000J21_A139DisponibilidadEstadoCita = new String[] {""} ;
      BC000J21_A298DisponibilidadTipoCita = new String[] {""} ;
      BC000J21_A31ProfesionalId = new int[1] ;
      BC000J21_A32EspecialidadId = new short[1] ;
      BC000J21_A35SGSedeDisponibilidadSedeId = new short[1] ;
      sMode26 = "" ;
      BC000J22_A34DisponibilidadId = new int[1] ;
      BC000J22_n34DisponibilidadId = new boolean[] {false} ;
      BC000J22_A133EventId = new String[] {""} ;
      BC000J22_A134DisponibilidadDescription = new String[] {""} ;
      BC000J22_A67DisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      BC000J22_n67DisponibilidadFecha = new boolean[] {false} ;
      BC000J22_A69DisponibilidadHoraInicio = new java.util.Date[] {GXutil.nullDate()} ;
      BC000J22_n69DisponibilidadHoraInicio = new boolean[] {false} ;
      BC000J22_A135DisponibilidadHoraFin = new java.util.Date[] {GXutil.nullDate()} ;
      BC000J22_n135DisponibilidadHoraFin = new boolean[] {false} ;
      BC000J22_A137DisponibilidadUser = new int[1] ;
      BC000J22_A136DisponibilidadEstado = new String[] {""} ;
      BC000J22_A139DisponibilidadEstadoCita = new String[] {""} ;
      BC000J22_A298DisponibilidadTipoCita = new String[] {""} ;
      BC000J22_A31ProfesionalId = new int[1] ;
      BC000J22_A32EspecialidadId = new short[1] ;
      BC000J22_A35SGSedeDisponibilidadSedeId = new short[1] ;
      BC000J23_A34DisponibilidadId = new int[1] ;
      BC000J23_n34DisponibilidadId = new boolean[] {false} ;
      BC000J27_A138DCitaId = new int[1] ;
      BC000J27_n138DCitaId = new boolean[] {false} ;
      BC000J28_A85ProfesionalApellidoPaterno = new String[] {""} ;
      BC000J28_A86ProfesionalApellidoMaterno = new String[] {""} ;
      BC000J28_A84ProfesionalNombres = new String[] {""} ;
      BC000J28_A88ProfesionalCOP = new String[] {""} ;
      BC000J29_A140EspecialidadCodigo = new String[] {""} ;
      BC000J29_A71EspecialidadNombre = new String[] {""} ;
      BC000J30_A74SGSedeDisponibilidadSedeNombre = new String[] {""} ;
      BC000J30_A77SGSedeDisponibilidadClinicaId = new short[1] ;
      BC000J31_A79SGSedeDisponibilidadClinicaAbreviado = new String[] {""} ;
      BC000J32_A47PagoId = new int[1] ;
      BC000J33_A19CitaId = new int[1] ;
      BC000J35_A34DisponibilidadId = new int[1] ;
      BC000J35_n34DisponibilidadId = new boolean[] {false} ;
      BC000J35_A133EventId = new String[] {""} ;
      BC000J35_A134DisponibilidadDescription = new String[] {""} ;
      BC000J35_A85ProfesionalApellidoPaterno = new String[] {""} ;
      BC000J35_A86ProfesionalApellidoMaterno = new String[] {""} ;
      BC000J35_A84ProfesionalNombres = new String[] {""} ;
      BC000J35_A88ProfesionalCOP = new String[] {""} ;
      BC000J35_A67DisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      BC000J35_n67DisponibilidadFecha = new boolean[] {false} ;
      BC000J35_A69DisponibilidadHoraInicio = new java.util.Date[] {GXutil.nullDate()} ;
      BC000J35_n69DisponibilidadHoraInicio = new boolean[] {false} ;
      BC000J35_A135DisponibilidadHoraFin = new java.util.Date[] {GXutil.nullDate()} ;
      BC000J35_n135DisponibilidadHoraFin = new boolean[] {false} ;
      BC000J35_A140EspecialidadCodigo = new String[] {""} ;
      BC000J35_A71EspecialidadNombre = new String[] {""} ;
      BC000J35_A74SGSedeDisponibilidadSedeNombre = new String[] {""} ;
      BC000J35_A79SGSedeDisponibilidadClinicaAbreviado = new String[] {""} ;
      BC000J35_A137DisponibilidadUser = new int[1] ;
      BC000J35_A136DisponibilidadEstado = new String[] {""} ;
      BC000J35_A139DisponibilidadEstadoCita = new String[] {""} ;
      BC000J35_A298DisponibilidadTipoCita = new String[] {""} ;
      BC000J35_A31ProfesionalId = new int[1] ;
      BC000J35_A32EspecialidadId = new short[1] ;
      BC000J35_A35SGSedeDisponibilidadSedeId = new short[1] ;
      BC000J35_A77SGSedeDisponibilidadClinicaId = new short[1] ;
      BC000J35_A138DCitaId = new int[1] ;
      BC000J35_n138DCitaId = new boolean[] {false} ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.disponibilidad_bc__default(),
         new Object[] {
             new Object[] {
            BC000J2_A34DisponibilidadId, BC000J2_A133EventId, BC000J2_A134DisponibilidadDescription, BC000J2_A67DisponibilidadFecha, BC000J2_n67DisponibilidadFecha, BC000J2_A69DisponibilidadHoraInicio, BC000J2_n69DisponibilidadHoraInicio, BC000J2_A135DisponibilidadHoraFin, BC000J2_n135DisponibilidadHoraFin, BC000J2_A137DisponibilidadUser,
            BC000J2_A136DisponibilidadEstado, BC000J2_A139DisponibilidadEstadoCita, BC000J2_A298DisponibilidadTipoCita, BC000J2_A31ProfesionalId, BC000J2_A32EspecialidadId, BC000J2_A35SGSedeDisponibilidadSedeId
            }
            , new Object[] {
            BC000J3_A34DisponibilidadId, BC000J3_A133EventId, BC000J3_A134DisponibilidadDescription, BC000J3_A67DisponibilidadFecha, BC000J3_n67DisponibilidadFecha, BC000J3_A69DisponibilidadHoraInicio, BC000J3_n69DisponibilidadHoraInicio, BC000J3_A135DisponibilidadHoraFin, BC000J3_n135DisponibilidadHoraFin, BC000J3_A137DisponibilidadUser,
            BC000J3_A136DisponibilidadEstado, BC000J3_A139DisponibilidadEstadoCita, BC000J3_A298DisponibilidadTipoCita, BC000J3_A31ProfesionalId, BC000J3_A32EspecialidadId, BC000J3_A35SGSedeDisponibilidadSedeId
            }
            , new Object[] {
            BC000J4_A85ProfesionalApellidoPaterno, BC000J4_A86ProfesionalApellidoMaterno, BC000J4_A84ProfesionalNombres, BC000J4_A88ProfesionalCOP
            }
            , new Object[] {
            BC000J5_A140EspecialidadCodigo, BC000J5_A71EspecialidadNombre
            }
            , new Object[] {
            BC000J6_A31ProfesionalId
            }
            , new Object[] {
            BC000J7_A74SGSedeDisponibilidadSedeNombre, BC000J7_A77SGSedeDisponibilidadClinicaId
            }
            , new Object[] {
            BC000J8_A79SGSedeDisponibilidadClinicaAbreviado
            }
            , new Object[] {
            BC000J10_A138DCitaId, BC000J10_n138DCitaId
            }
            , new Object[] {
            BC000J12_A34DisponibilidadId, BC000J12_A133EventId, BC000J12_A134DisponibilidadDescription, BC000J12_A85ProfesionalApellidoPaterno, BC000J12_A86ProfesionalApellidoMaterno, BC000J12_A84ProfesionalNombres, BC000J12_A88ProfesionalCOP, BC000J12_A67DisponibilidadFecha, BC000J12_n67DisponibilidadFecha, BC000J12_A69DisponibilidadHoraInicio,
            BC000J12_n69DisponibilidadHoraInicio, BC000J12_A135DisponibilidadHoraFin, BC000J12_n135DisponibilidadHoraFin, BC000J12_A140EspecialidadCodigo, BC000J12_A71EspecialidadNombre, BC000J12_A74SGSedeDisponibilidadSedeNombre, BC000J12_A79SGSedeDisponibilidadClinicaAbreviado, BC000J12_A137DisponibilidadUser, BC000J12_A136DisponibilidadEstado, BC000J12_A139DisponibilidadEstadoCita,
            BC000J12_A298DisponibilidadTipoCita, BC000J12_A31ProfesionalId, BC000J12_A32EspecialidadId, BC000J12_A35SGSedeDisponibilidadSedeId, BC000J12_A77SGSedeDisponibilidadClinicaId, BC000J12_A138DCitaId, BC000J12_n138DCitaId
            }
            , new Object[] {
            BC000J14_A138DCitaId, BC000J14_n138DCitaId
            }
            , new Object[] {
            BC000J15_A85ProfesionalApellidoPaterno, BC000J15_A86ProfesionalApellidoMaterno, BC000J15_A84ProfesionalNombres, BC000J15_A88ProfesionalCOP
            }
            , new Object[] {
            BC000J16_A31ProfesionalId
            }
            , new Object[] {
            BC000J17_A140EspecialidadCodigo, BC000J17_A71EspecialidadNombre
            }
            , new Object[] {
            BC000J18_A74SGSedeDisponibilidadSedeNombre, BC000J18_A77SGSedeDisponibilidadClinicaId
            }
            , new Object[] {
            BC000J19_A79SGSedeDisponibilidadClinicaAbreviado
            }
            , new Object[] {
            BC000J20_A34DisponibilidadId
            }
            , new Object[] {
            BC000J21_A34DisponibilidadId, BC000J21_A133EventId, BC000J21_A134DisponibilidadDescription, BC000J21_A67DisponibilidadFecha, BC000J21_n67DisponibilidadFecha, BC000J21_A69DisponibilidadHoraInicio, BC000J21_n69DisponibilidadHoraInicio, BC000J21_A135DisponibilidadHoraFin, BC000J21_n135DisponibilidadHoraFin, BC000J21_A137DisponibilidadUser,
            BC000J21_A136DisponibilidadEstado, BC000J21_A139DisponibilidadEstadoCita, BC000J21_A298DisponibilidadTipoCita, BC000J21_A31ProfesionalId, BC000J21_A32EspecialidadId, BC000J21_A35SGSedeDisponibilidadSedeId
            }
            , new Object[] {
            BC000J22_A34DisponibilidadId, BC000J22_A133EventId, BC000J22_A134DisponibilidadDescription, BC000J22_A67DisponibilidadFecha, BC000J22_n67DisponibilidadFecha, BC000J22_A69DisponibilidadHoraInicio, BC000J22_n69DisponibilidadHoraInicio, BC000J22_A135DisponibilidadHoraFin, BC000J22_n135DisponibilidadHoraFin, BC000J22_A137DisponibilidadUser,
            BC000J22_A136DisponibilidadEstado, BC000J22_A139DisponibilidadEstadoCita, BC000J22_A298DisponibilidadTipoCita, BC000J22_A31ProfesionalId, BC000J22_A32EspecialidadId, BC000J22_A35SGSedeDisponibilidadSedeId
            }
            , new Object[] {
            BC000J23_A34DisponibilidadId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000J27_A138DCitaId, BC000J27_n138DCitaId
            }
            , new Object[] {
            BC000J28_A85ProfesionalApellidoPaterno, BC000J28_A86ProfesionalApellidoMaterno, BC000J28_A84ProfesionalNombres, BC000J28_A88ProfesionalCOP
            }
            , new Object[] {
            BC000J29_A140EspecialidadCodigo, BC000J29_A71EspecialidadNombre
            }
            , new Object[] {
            BC000J30_A74SGSedeDisponibilidadSedeNombre, BC000J30_A77SGSedeDisponibilidadClinicaId
            }
            , new Object[] {
            BC000J31_A79SGSedeDisponibilidadClinicaAbreviado
            }
            , new Object[] {
            BC000J32_A47PagoId
            }
            , new Object[] {
            BC000J33_A19CitaId
            }
            , new Object[] {
            BC000J35_A34DisponibilidadId, BC000J35_A133EventId, BC000J35_A134DisponibilidadDescription, BC000J35_A85ProfesionalApellidoPaterno, BC000J35_A86ProfesionalApellidoMaterno, BC000J35_A84ProfesionalNombres, BC000J35_A88ProfesionalCOP, BC000J35_A67DisponibilidadFecha, BC000J35_n67DisponibilidadFecha, BC000J35_A69DisponibilidadHoraInicio,
            BC000J35_n69DisponibilidadHoraInicio, BC000J35_A135DisponibilidadHoraFin, BC000J35_n135DisponibilidadHoraFin, BC000J35_A140EspecialidadCodigo, BC000J35_A71EspecialidadNombre, BC000J35_A74SGSedeDisponibilidadSedeNombre, BC000J35_A79SGSedeDisponibilidadClinicaAbreviado, BC000J35_A137DisponibilidadUser, BC000J35_A136DisponibilidadEstado, BC000J35_A139DisponibilidadEstadoCita,
            BC000J35_A298DisponibilidadTipoCita, BC000J35_A31ProfesionalId, BC000J35_A32EspecialidadId, BC000J35_A35SGSedeDisponibilidadSedeId, BC000J35_A77SGSedeDisponibilidadClinicaId, BC000J35_A138DCitaId, BC000J35_n138DCitaId
            }
         }
      );
      AV29Pgmname = "Disponibilidad_BC" ;
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e120J2 ();
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short AV13Insert_EspecialidadId ;
   private short AV16Insert_SGSedeDisponibilidadSedeId ;
   private short Z32EspecialidadId ;
   private short A32EspecialidadId ;
   private short Z35SGSedeDisponibilidadSedeId ;
   private short A35SGSedeDisponibilidadSedeId ;
   private short Z77SGSedeDisponibilidadClinicaId ;
   private short A77SGSedeDisponibilidadClinicaId ;
   private short RcdFound26 ;
   private short nIsDirty_26 ;
   private int trnEnded ;
   private int Z34DisponibilidadId ;
   private int A34DisponibilidadId ;
   private int AV30GXV1 ;
   private int AV12Insert_ProfesionalId ;
   private int GX_JID ;
   private int Z137DisponibilidadUser ;
   private int A137DisponibilidadUser ;
   private int Z31ProfesionalId ;
   private int A31ProfesionalId ;
   private int Z138DCitaId ;
   private int A138DCitaId ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String AV29Pgmname ;
   private String Z133EventId ;
   private String A133EventId ;
   private String Z136DisponibilidadEstado ;
   private String A136DisponibilidadEstado ;
   private String Z298DisponibilidadTipoCita ;
   private String A298DisponibilidadTipoCita ;
   private String sMode26 ;
   private java.util.Date Z69DisponibilidadHoraInicio ;
   private java.util.Date A69DisponibilidadHoraInicio ;
   private java.util.Date Z135DisponibilidadHoraFin ;
   private java.util.Date A135DisponibilidadHoraFin ;
   private java.util.Date Z67DisponibilidadFecha ;
   private java.util.Date A67DisponibilidadFecha ;
   private boolean returnInSub ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean n34DisponibilidadId ;
   private boolean n67DisponibilidadFecha ;
   private boolean n69DisponibilidadHoraInicio ;
   private boolean n135DisponibilidadHoraFin ;
   private boolean n138DCitaId ;
   private boolean Gx_longc ;
   private boolean mustCommit ;
   private String Z134DisponibilidadDescription ;
   private String A134DisponibilidadDescription ;
   private String Z139DisponibilidadEstadoCita ;
   private String A139DisponibilidadEstadoCita ;
   private String Z83ProfesionalNombreCompleto ;
   private String A83ProfesionalNombreCompleto ;
   private String Z85ProfesionalApellidoPaterno ;
   private String A85ProfesionalApellidoPaterno ;
   private String Z86ProfesionalApellidoMaterno ;
   private String A86ProfesionalApellidoMaterno ;
   private String Z84ProfesionalNombres ;
   private String A84ProfesionalNombres ;
   private String Z88ProfesionalCOP ;
   private String A88ProfesionalCOP ;
   private String Z140EspecialidadCodigo ;
   private String A140EspecialidadCodigo ;
   private String Z71EspecialidadNombre ;
   private String A71EspecialidadNombre ;
   private String Z74SGSedeDisponibilidadSedeNombre ;
   private String A74SGSedeDisponibilidadSedeNombre ;
   private String Z79SGSedeDisponibilidadClinicaAbreviado ;
   private String A79SGSedeDisponibilidadClinicaAbreviado ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV11WebSession ;
   private com.projectthani.SdtDisponibilidad bcDisponibilidad ;
   private IDataStoreProvider pr_default ;
   private int[] BC000J12_A34DisponibilidadId ;
   private boolean[] BC000J12_n34DisponibilidadId ;
   private String[] BC000J12_A133EventId ;
   private String[] BC000J12_A134DisponibilidadDescription ;
   private String[] BC000J12_A85ProfesionalApellidoPaterno ;
   private String[] BC000J12_A86ProfesionalApellidoMaterno ;
   private String[] BC000J12_A84ProfesionalNombres ;
   private String[] BC000J12_A88ProfesionalCOP ;
   private java.util.Date[] BC000J12_A67DisponibilidadFecha ;
   private boolean[] BC000J12_n67DisponibilidadFecha ;
   private java.util.Date[] BC000J12_A69DisponibilidadHoraInicio ;
   private boolean[] BC000J12_n69DisponibilidadHoraInicio ;
   private java.util.Date[] BC000J12_A135DisponibilidadHoraFin ;
   private boolean[] BC000J12_n135DisponibilidadHoraFin ;
   private String[] BC000J12_A140EspecialidadCodigo ;
   private String[] BC000J12_A71EspecialidadNombre ;
   private String[] BC000J12_A74SGSedeDisponibilidadSedeNombre ;
   private String[] BC000J12_A79SGSedeDisponibilidadClinicaAbreviado ;
   private int[] BC000J12_A137DisponibilidadUser ;
   private String[] BC000J12_A136DisponibilidadEstado ;
   private String[] BC000J12_A139DisponibilidadEstadoCita ;
   private String[] BC000J12_A298DisponibilidadTipoCita ;
   private int[] BC000J12_A31ProfesionalId ;
   private short[] BC000J12_A32EspecialidadId ;
   private short[] BC000J12_A35SGSedeDisponibilidadSedeId ;
   private short[] BC000J12_A77SGSedeDisponibilidadClinicaId ;
   private int[] BC000J12_A138DCitaId ;
   private boolean[] BC000J12_n138DCitaId ;
   private int[] BC000J14_A138DCitaId ;
   private boolean[] BC000J14_n138DCitaId ;
   private String[] BC000J15_A85ProfesionalApellidoPaterno ;
   private String[] BC000J15_A86ProfesionalApellidoMaterno ;
   private String[] BC000J15_A84ProfesionalNombres ;
   private String[] BC000J15_A88ProfesionalCOP ;
   private int[] BC000J16_A31ProfesionalId ;
   private String[] BC000J17_A140EspecialidadCodigo ;
   private String[] BC000J17_A71EspecialidadNombre ;
   private String[] BC000J18_A74SGSedeDisponibilidadSedeNombre ;
   private short[] BC000J18_A77SGSedeDisponibilidadClinicaId ;
   private String[] BC000J19_A79SGSedeDisponibilidadClinicaAbreviado ;
   private int[] BC000J20_A34DisponibilidadId ;
   private boolean[] BC000J20_n34DisponibilidadId ;
   private int[] BC000J21_A34DisponibilidadId ;
   private boolean[] BC000J21_n34DisponibilidadId ;
   private String[] BC000J21_A133EventId ;
   private String[] BC000J21_A134DisponibilidadDescription ;
   private java.util.Date[] BC000J21_A67DisponibilidadFecha ;
   private boolean[] BC000J21_n67DisponibilidadFecha ;
   private java.util.Date[] BC000J21_A69DisponibilidadHoraInicio ;
   private boolean[] BC000J21_n69DisponibilidadHoraInicio ;
   private java.util.Date[] BC000J21_A135DisponibilidadHoraFin ;
   private boolean[] BC000J21_n135DisponibilidadHoraFin ;
   private int[] BC000J21_A137DisponibilidadUser ;
   private String[] BC000J21_A136DisponibilidadEstado ;
   private String[] BC000J21_A139DisponibilidadEstadoCita ;
   private String[] BC000J21_A298DisponibilidadTipoCita ;
   private int[] BC000J21_A31ProfesionalId ;
   private short[] BC000J21_A32EspecialidadId ;
   private short[] BC000J21_A35SGSedeDisponibilidadSedeId ;
   private int[] BC000J22_A34DisponibilidadId ;
   private boolean[] BC000J22_n34DisponibilidadId ;
   private String[] BC000J22_A133EventId ;
   private String[] BC000J22_A134DisponibilidadDescription ;
   private java.util.Date[] BC000J22_A67DisponibilidadFecha ;
   private boolean[] BC000J22_n67DisponibilidadFecha ;
   private java.util.Date[] BC000J22_A69DisponibilidadHoraInicio ;
   private boolean[] BC000J22_n69DisponibilidadHoraInicio ;
   private java.util.Date[] BC000J22_A135DisponibilidadHoraFin ;
   private boolean[] BC000J22_n135DisponibilidadHoraFin ;
   private int[] BC000J22_A137DisponibilidadUser ;
   private String[] BC000J22_A136DisponibilidadEstado ;
   private String[] BC000J22_A139DisponibilidadEstadoCita ;
   private String[] BC000J22_A298DisponibilidadTipoCita ;
   private int[] BC000J22_A31ProfesionalId ;
   private short[] BC000J22_A32EspecialidadId ;
   private short[] BC000J22_A35SGSedeDisponibilidadSedeId ;
   private int[] BC000J23_A34DisponibilidadId ;
   private boolean[] BC000J23_n34DisponibilidadId ;
   private int[] BC000J27_A138DCitaId ;
   private boolean[] BC000J27_n138DCitaId ;
   private String[] BC000J28_A85ProfesionalApellidoPaterno ;
   private String[] BC000J28_A86ProfesionalApellidoMaterno ;
   private String[] BC000J28_A84ProfesionalNombres ;
   private String[] BC000J28_A88ProfesionalCOP ;
   private String[] BC000J29_A140EspecialidadCodigo ;
   private String[] BC000J29_A71EspecialidadNombre ;
   private String[] BC000J30_A74SGSedeDisponibilidadSedeNombre ;
   private short[] BC000J30_A77SGSedeDisponibilidadClinicaId ;
   private String[] BC000J31_A79SGSedeDisponibilidadClinicaAbreviado ;
   private int[] BC000J32_A47PagoId ;
   private int[] BC000J33_A19CitaId ;
   private int[] BC000J35_A34DisponibilidadId ;
   private boolean[] BC000J35_n34DisponibilidadId ;
   private String[] BC000J35_A133EventId ;
   private String[] BC000J35_A134DisponibilidadDescription ;
   private String[] BC000J35_A85ProfesionalApellidoPaterno ;
   private String[] BC000J35_A86ProfesionalApellidoMaterno ;
   private String[] BC000J35_A84ProfesionalNombres ;
   private String[] BC000J35_A88ProfesionalCOP ;
   private java.util.Date[] BC000J35_A67DisponibilidadFecha ;
   private boolean[] BC000J35_n67DisponibilidadFecha ;
   private java.util.Date[] BC000J35_A69DisponibilidadHoraInicio ;
   private boolean[] BC000J35_n69DisponibilidadHoraInicio ;
   private java.util.Date[] BC000J35_A135DisponibilidadHoraFin ;
   private boolean[] BC000J35_n135DisponibilidadHoraFin ;
   private String[] BC000J35_A140EspecialidadCodigo ;
   private String[] BC000J35_A71EspecialidadNombre ;
   private String[] BC000J35_A74SGSedeDisponibilidadSedeNombre ;
   private String[] BC000J35_A79SGSedeDisponibilidadClinicaAbreviado ;
   private int[] BC000J35_A137DisponibilidadUser ;
   private String[] BC000J35_A136DisponibilidadEstado ;
   private String[] BC000J35_A139DisponibilidadEstadoCita ;
   private String[] BC000J35_A298DisponibilidadTipoCita ;
   private int[] BC000J35_A31ProfesionalId ;
   private short[] BC000J35_A32EspecialidadId ;
   private short[] BC000J35_A35SGSedeDisponibilidadSedeId ;
   private short[] BC000J35_A77SGSedeDisponibilidadClinicaId ;
   private int[] BC000J35_A138DCitaId ;
   private boolean[] BC000J35_n138DCitaId ;
   private int[] BC000J2_A34DisponibilidadId ;
   private String[] BC000J2_A133EventId ;
   private String[] BC000J2_A134DisponibilidadDescription ;
   private java.util.Date[] BC000J2_A67DisponibilidadFecha ;
   private java.util.Date[] BC000J2_A69DisponibilidadHoraInicio ;
   private java.util.Date[] BC000J2_A135DisponibilidadHoraFin ;
   private int[] BC000J2_A137DisponibilidadUser ;
   private String[] BC000J2_A136DisponibilidadEstado ;
   private String[] BC000J2_A139DisponibilidadEstadoCita ;
   private String[] BC000J2_A298DisponibilidadTipoCita ;
   private int[] BC000J2_A31ProfesionalId ;
   private short[] BC000J2_A32EspecialidadId ;
   private short[] BC000J2_A35SGSedeDisponibilidadSedeId ;
   private int[] BC000J3_A34DisponibilidadId ;
   private String[] BC000J3_A133EventId ;
   private String[] BC000J3_A134DisponibilidadDescription ;
   private java.util.Date[] BC000J3_A67DisponibilidadFecha ;
   private java.util.Date[] BC000J3_A69DisponibilidadHoraInicio ;
   private java.util.Date[] BC000J3_A135DisponibilidadHoraFin ;
   private int[] BC000J3_A137DisponibilidadUser ;
   private String[] BC000J3_A136DisponibilidadEstado ;
   private String[] BC000J3_A139DisponibilidadEstadoCita ;
   private String[] BC000J3_A298DisponibilidadTipoCita ;
   private int[] BC000J3_A31ProfesionalId ;
   private short[] BC000J3_A32EspecialidadId ;
   private short[] BC000J3_A35SGSedeDisponibilidadSedeId ;
   private String[] BC000J4_A85ProfesionalApellidoPaterno ;
   private String[] BC000J4_A86ProfesionalApellidoMaterno ;
   private String[] BC000J4_A84ProfesionalNombres ;
   private String[] BC000J4_A88ProfesionalCOP ;
   private String[] BC000J5_A140EspecialidadCodigo ;
   private String[] BC000J5_A71EspecialidadNombre ;
   private int[] BC000J6_A31ProfesionalId ;
   private String[] BC000J7_A74SGSedeDisponibilidadSedeNombre ;
   private short[] BC000J7_A77SGSedeDisponibilidadClinicaId ;
   private String[] BC000J8_A79SGSedeDisponibilidadClinicaAbreviado ;
   private int[] BC000J10_A138DCitaId ;
   private boolean[] BC000J2_n67DisponibilidadFecha ;
   private boolean[] BC000J2_n69DisponibilidadHoraInicio ;
   private boolean[] BC000J2_n135DisponibilidadHoraFin ;
   private boolean[] BC000J3_n67DisponibilidadFecha ;
   private boolean[] BC000J3_n69DisponibilidadHoraInicio ;
   private boolean[] BC000J3_n135DisponibilidadHoraFin ;
   private boolean[] BC000J10_n138DCitaId ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV7WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV10TrnContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV14TrnContextAtt ;
}

final  class disponibilidad_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC000J2", "SELECT [DisponibilidadId], [EventId], [DisponibilidadDescription], [DisponibilidadFecha], [DisponibilidadHoraInicio], [DisponibilidadHoraFin], [DisponibilidadUser], [DisponibilidadEstado], [DisponibilidadEstadoCita], [DisponibilidadTipoCita], [ProfesionalId], [EspecialidadId], [SGSedeDisponibilidadSedeId] AS SGSedeDisponibilidadSedeId FROM [Disponibilidad] WITH (UPDLOCK) WHERE [DisponibilidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000J3", "SELECT [DisponibilidadId], [EventId], [DisponibilidadDescription], [DisponibilidadFecha], [DisponibilidadHoraInicio], [DisponibilidadHoraFin], [DisponibilidadUser], [DisponibilidadEstado], [DisponibilidadEstadoCita], [DisponibilidadTipoCita], [ProfesionalId], [EspecialidadId], [SGSedeDisponibilidadSedeId] AS SGSedeDisponibilidadSedeId FROM [Disponibilidad] WHERE [DisponibilidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000J4", "SELECT [ProfesionalApellidoPaterno], [ProfesionalApellidoMaterno], [ProfesionalNombres], [ProfesionalCOP] FROM [Profesional] WHERE [ProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000J5", "SELECT [EspecialidadCodigo], [EspecialidadNombre] FROM [Especialidad] WHERE [EspecialidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000J6", "SELECT [ProfesionalId] FROM [ProfesionalEspecialidad] WHERE [ProfesionalId] = ? AND [EspecialidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000J7", "SELECT [SedeNombre] AS SGSedeDisponibilidadSedeNombre, [ClinicaId] AS SGSedeDisponibilidadClinicaId FROM [Sede] WHERE [SedeId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000J8", "SELECT [ClinicaNombreAbreviado] AS SGSedeDisponibilidadClinicaAbreviado FROM [Clinica] WHERE [ClinicaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000J10", "SELECT COALESCE( T1.[DCitaId], 0) AS DCitaId FROM (SELECT MIN([CitaId]) AS DCitaId, [SGCitaDisponibilidadId] FROM [Cita] WHERE ([SGCitaDisponibilidadId] = ?) AND ([CitaEstado] = 'A') GROUP BY [SGCitaDisponibilidadId] ) T1 WHERE T1.[SGCitaDisponibilidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000J12", "SELECT TM1.[DisponibilidadId], TM1.[EventId], TM1.[DisponibilidadDescription], T3.[ProfesionalApellidoPaterno], T3.[ProfesionalApellidoMaterno], T3.[ProfesionalNombres], T3.[ProfesionalCOP], TM1.[DisponibilidadFecha], TM1.[DisponibilidadHoraInicio], TM1.[DisponibilidadHoraFin], T4.[EspecialidadCodigo], T4.[EspecialidadNombre], T5.[SedeNombre] AS SGSedeDisponibilidadSedeNombre, T6.[ClinicaNombreAbreviado] AS SGSedeDisponibilidadClinicaAbreviado, TM1.[DisponibilidadUser], TM1.[DisponibilidadEstado], TM1.[DisponibilidadEstadoCita], TM1.[DisponibilidadTipoCita], TM1.[ProfesionalId], TM1.[EspecialidadId], TM1.[SGSedeDisponibilidadSedeId] AS SGSedeDisponibilidadSedeId, T5.[ClinicaId] AS SGSedeDisponibilidadClinicaId, COALESCE( T2.[DCitaId], 0) AS DCitaId FROM ((((([Disponibilidad] TM1 LEFT JOIN (SELECT MIN([CitaId]) AS DCitaId, [SGCitaDisponibilidadId] FROM [Cita] WHERE ([SGCitaDisponibilidadId] = ?) AND ([CitaEstado] = 'A') GROUP BY [SGCitaDisponibilidadId] ) T2 ON T2.[SGCitaDisponibilidadId] = TM1.[DisponibilidadId]) INNER JOIN [Profesional] T3 ON T3.[ProfesionalId] = TM1.[ProfesionalId]) INNER JOIN [Especialidad] T4 ON T4.[EspecialidadId] = TM1.[EspecialidadId]) INNER JOIN [Sede] T5 ON T5.[SedeId] = TM1.[SGSedeDisponibilidadSedeId]) INNER JOIN [Clinica] T6 ON T6.[ClinicaId] = T5.[ClinicaId]) WHERE TM1.[DisponibilidadId] = ? ORDER BY TM1.[DisponibilidadId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000J14", "SELECT COALESCE( T1.[DCitaId], 0) AS DCitaId FROM (SELECT MIN([CitaId]) AS DCitaId, [SGCitaDisponibilidadId] FROM [Cita] WHERE ([SGCitaDisponibilidadId] = ?) AND ([CitaEstado] = 'A') GROUP BY [SGCitaDisponibilidadId] ) T1 WHERE T1.[SGCitaDisponibilidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000J15", "SELECT [ProfesionalApellidoPaterno], [ProfesionalApellidoMaterno], [ProfesionalNombres], [ProfesionalCOP] FROM [Profesional] WHERE [ProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000J16", "SELECT [ProfesionalId] FROM [ProfesionalEspecialidad] WHERE [ProfesionalId] = ? AND [EspecialidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000J17", "SELECT [EspecialidadCodigo], [EspecialidadNombre] FROM [Especialidad] WHERE [EspecialidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000J18", "SELECT [SedeNombre] AS SGSedeDisponibilidadSedeNombre, [ClinicaId] AS SGSedeDisponibilidadClinicaId FROM [Sede] WHERE [SedeId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000J19", "SELECT [ClinicaNombreAbreviado] AS SGSedeDisponibilidadClinicaAbreviado FROM [Clinica] WHERE [ClinicaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000J20", "SELECT [DisponibilidadId] FROM [Disponibilidad] WHERE [DisponibilidadId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000J21", "SELECT [DisponibilidadId], [EventId], [DisponibilidadDescription], [DisponibilidadFecha], [DisponibilidadHoraInicio], [DisponibilidadHoraFin], [DisponibilidadUser], [DisponibilidadEstado], [DisponibilidadEstadoCita], [DisponibilidadTipoCita], [ProfesionalId], [EspecialidadId], [SGSedeDisponibilidadSedeId] AS SGSedeDisponibilidadSedeId FROM [Disponibilidad] WHERE [DisponibilidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000J22", "SELECT [DisponibilidadId], [EventId], [DisponibilidadDescription], [DisponibilidadFecha], [DisponibilidadHoraInicio], [DisponibilidadHoraFin], [DisponibilidadUser], [DisponibilidadEstado], [DisponibilidadEstadoCita], [DisponibilidadTipoCita], [ProfesionalId], [EspecialidadId], [SGSedeDisponibilidadSedeId] AS SGSedeDisponibilidadSedeId FROM [Disponibilidad] WITH (UPDLOCK) WHERE [DisponibilidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000J23", "INSERT INTO [Disponibilidad]([EventId], [DisponibilidadDescription], [DisponibilidadFecha], [DisponibilidadHoraInicio], [DisponibilidadHoraFin], [DisponibilidadUser], [DisponibilidadEstado], [DisponibilidadEstadoCita], [DisponibilidadTipoCita], [ProfesionalId], [EspecialidadId], [SGSedeDisponibilidadSedeId]) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); SELECT SCOPE_IDENTITY()", GX_NOMASK)
         ,new UpdateCursor("BC000J24", "UPDATE [Disponibilidad] SET [EventId]=?, [DisponibilidadDescription]=?, [DisponibilidadFecha]=?, [DisponibilidadHoraInicio]=?, [DisponibilidadHoraFin]=?, [DisponibilidadUser]=?, [DisponibilidadEstado]=?, [DisponibilidadEstadoCita]=?, [DisponibilidadTipoCita]=?, [ProfesionalId]=?, [EspecialidadId]=?, [SGSedeDisponibilidadSedeId]=?  WHERE [DisponibilidadId] = ?", GX_NOMASK)
         ,new UpdateCursor("BC000J25", "DELETE FROM [Disponibilidad]  WHERE [DisponibilidadId] = ?", GX_NOMASK)
         ,new ForEachCursor("BC000J27", "SELECT COALESCE( T1.[DCitaId], 0) AS DCitaId FROM (SELECT MIN([CitaId]) AS DCitaId, [SGCitaDisponibilidadId] FROM [Cita] WHERE ([SGCitaDisponibilidadId] = ?) AND ([CitaEstado] = 'A') GROUP BY [SGCitaDisponibilidadId] ) T1 WHERE T1.[SGCitaDisponibilidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000J28", "SELECT [ProfesionalApellidoPaterno], [ProfesionalApellidoMaterno], [ProfesionalNombres], [ProfesionalCOP] FROM [Profesional] WHERE [ProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000J29", "SELECT [EspecialidadCodigo], [EspecialidadNombre] FROM [Especialidad] WHERE [EspecialidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000J30", "SELECT [SedeNombre] AS SGSedeDisponibilidadSedeNombre, [ClinicaId] AS SGSedeDisponibilidadClinicaId FROM [Sede] WHERE [SedeId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000J31", "SELECT [ClinicaNombreAbreviado] AS SGSedeDisponibilidadClinicaAbreviado FROM [Clinica] WHERE [ClinicaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000J32", "SELECT TOP 1 [PagoId] FROM [Pago] WHERE [DisponibilidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000J33", "SELECT TOP 1 [CitaId] FROM [Cita] WHERE [SGCitaDisponibilidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000J35", "SELECT TM1.[DisponibilidadId], TM1.[EventId], TM1.[DisponibilidadDescription], T3.[ProfesionalApellidoPaterno], T3.[ProfesionalApellidoMaterno], T3.[ProfesionalNombres], T3.[ProfesionalCOP], TM1.[DisponibilidadFecha], TM1.[DisponibilidadHoraInicio], TM1.[DisponibilidadHoraFin], T4.[EspecialidadCodigo], T4.[EspecialidadNombre], T5.[SedeNombre] AS SGSedeDisponibilidadSedeNombre, T6.[ClinicaNombreAbreviado] AS SGSedeDisponibilidadClinicaAbreviado, TM1.[DisponibilidadUser], TM1.[DisponibilidadEstado], TM1.[DisponibilidadEstadoCita], TM1.[DisponibilidadTipoCita], TM1.[ProfesionalId], TM1.[EspecialidadId], TM1.[SGSedeDisponibilidadSedeId] AS SGSedeDisponibilidadSedeId, T5.[ClinicaId] AS SGSedeDisponibilidadClinicaId, COALESCE( T2.[DCitaId], 0) AS DCitaId FROM ((((([Disponibilidad] TM1 LEFT JOIN (SELECT MIN([CitaId]) AS DCitaId, [SGCitaDisponibilidadId] FROM [Cita] WHERE ([SGCitaDisponibilidadId] = ?) AND ([CitaEstado] = 'A') GROUP BY [SGCitaDisponibilidadId] ) T2 ON T2.[SGCitaDisponibilidadId] = TM1.[DisponibilidadId]) INNER JOIN [Profesional] T3 ON T3.[ProfesionalId] = TM1.[ProfesionalId]) INNER JOIN [Especialidad] T4 ON T4.[EspecialidadId] = TM1.[EspecialidadId]) INNER JOIN [Sede] T5 ON T5.[SedeId] = TM1.[SGSedeDisponibilidadSedeId]) INNER JOIN [Clinica] T6 ON T6.[ClinicaId] = T5.[ClinicaId]) WHERE TM1.[DisponibilidadId] = ? ORDER BY TM1.[DisponibilidadId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[5])[0] = GXutil.resetDate(rslt.getGXDateTime(5));
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[7])[0] = GXutil.resetDate(rslt.getGXDateTime(6));
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((int[]) buf[9])[0] = rslt.getInt(7);
               ((String[]) buf[10])[0] = rslt.getString(8, 1);
               ((String[]) buf[11])[0] = rslt.getVarchar(9);
               ((String[]) buf[12])[0] = rslt.getString(10, 1);
               ((int[]) buf[13])[0] = rslt.getInt(11);
               ((short[]) buf[14])[0] = rslt.getShort(12);
               ((short[]) buf[15])[0] = rslt.getShort(13);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[5])[0] = GXutil.resetDate(rslt.getGXDateTime(5));
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[7])[0] = GXutil.resetDate(rslt.getGXDateTime(6));
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((int[]) buf[9])[0] = rslt.getInt(7);
               ((String[]) buf[10])[0] = rslt.getString(8, 1);
               ((String[]) buf[11])[0] = rslt.getVarchar(9);
               ((String[]) buf[12])[0] = rslt.getString(10, 1);
               ((int[]) buf[13])[0] = rslt.getInt(11);
               ((short[]) buf[14])[0] = rslt.getShort(12);
               ((short[]) buf[15])[0] = rslt.getShort(13);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDate(8);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[9])[0] = GXutil.resetDate(rslt.getGXDateTime(9));
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[11])[0] = GXutil.resetDate(rslt.getGXDateTime(10));
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getVarchar(11);
               ((String[]) buf[14])[0] = rslt.getVarchar(12);
               ((String[]) buf[15])[0] = rslt.getVarchar(13);
               ((String[]) buf[16])[0] = rslt.getVarchar(14);
               ((int[]) buf[17])[0] = rslt.getInt(15);
               ((String[]) buf[18])[0] = rslt.getString(16, 1);
               ((String[]) buf[19])[0] = rslt.getVarchar(17);
               ((String[]) buf[20])[0] = rslt.getString(18, 1);
               ((int[]) buf[21])[0] = rslt.getInt(19);
               ((short[]) buf[22])[0] = rslt.getShort(20);
               ((short[]) buf[23])[0] = rslt.getShort(21);
               ((short[]) buf[24])[0] = rslt.getShort(22);
               ((int[]) buf[25])[0] = rslt.getInt(23);
               ((boolean[]) buf[26])[0] = rslt.wasNull();
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 10 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 11 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 12 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 13 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 14 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 15 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 16 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[5])[0] = GXutil.resetDate(rslt.getGXDateTime(5));
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[7])[0] = GXutil.resetDate(rslt.getGXDateTime(6));
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((int[]) buf[9])[0] = rslt.getInt(7);
               ((String[]) buf[10])[0] = rslt.getString(8, 1);
               ((String[]) buf[11])[0] = rslt.getVarchar(9);
               ((String[]) buf[12])[0] = rslt.getString(10, 1);
               ((int[]) buf[13])[0] = rslt.getInt(11);
               ((short[]) buf[14])[0] = rslt.getShort(12);
               ((short[]) buf[15])[0] = rslt.getShort(13);
               return;
            case 17 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[5])[0] = GXutil.resetDate(rslt.getGXDateTime(5));
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[7])[0] = GXutil.resetDate(rslt.getGXDateTime(6));
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((int[]) buf[9])[0] = rslt.getInt(7);
               ((String[]) buf[10])[0] = rslt.getString(8, 1);
               ((String[]) buf[11])[0] = rslt.getVarchar(9);
               ((String[]) buf[12])[0] = rslt.getString(10, 1);
               ((int[]) buf[13])[0] = rslt.getInt(11);
               ((short[]) buf[14])[0] = rslt.getShort(12);
               ((short[]) buf[15])[0] = rslt.getShort(13);
               return;
            case 18 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 21 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 22 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 23 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 24 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 25 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 26 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 27 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 28 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDate(8);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[9])[0] = GXutil.resetDate(rslt.getGXDateTime(9));
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[11])[0] = GXutil.resetDate(rslt.getGXDateTime(10));
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getVarchar(11);
               ((String[]) buf[14])[0] = rslt.getVarchar(12);
               ((String[]) buf[15])[0] = rslt.getVarchar(13);
               ((String[]) buf[16])[0] = rslt.getVarchar(14);
               ((int[]) buf[17])[0] = rslt.getInt(15);
               ((String[]) buf[18])[0] = rslt.getString(16, 1);
               ((String[]) buf[19])[0] = rslt.getVarchar(17);
               ((String[]) buf[20])[0] = rslt.getString(18, 1);
               ((int[]) buf[21])[0] = rslt.getInt(19);
               ((short[]) buf[22])[0] = rslt.getShort(20);
               ((short[]) buf[23])[0] = rslt.getShort(21);
               ((short[]) buf[24])[0] = rslt.getShort(22);
               ((int[]) buf[25])[0] = rslt.getInt(23);
               ((boolean[]) buf[26])[0] = rslt.wasNull();
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
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 1 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 3 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 5 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 6 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 7 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(2, ((Number) parms[3]).intValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(3, ((Number) parms[5]).intValue());
               }
               return;
            case 8 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(2, ((Number) parms[3]).intValue());
               }
               return;
            case 9 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(2, ((Number) parms[3]).intValue());
               }
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 11 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 12 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 13 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 14 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 15 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 16 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 17 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 18 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setVarchar(2, (String)parms[1], 100, false);
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.TIMESTAMP );
               }
               else
               {
                  stmt.setDate(3, (java.util.Date)parms[3]);
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.TIMESTAMP );
               }
               else
               {
                  stmt.setDateTime(4, (java.util.Date)parms[5], true);
               }
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.TIMESTAMP );
               }
               else
               {
                  stmt.setDateTime(5, (java.util.Date)parms[7], true);
               }
               stmt.setInt(6, ((Number) parms[8]).intValue());
               stmt.setString(7, (String)parms[9], 1);
               stmt.setVarchar(8, (String)parms[10], 2, false);
               stmt.setString(9, (String)parms[11], 1);
               stmt.setInt(10, ((Number) parms[12]).intValue());
               stmt.setShort(11, ((Number) parms[13]).shortValue());
               stmt.setShort(12, ((Number) parms[14]).shortValue());
               return;
            case 19 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setVarchar(2, (String)parms[1], 100, false);
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.TIMESTAMP );
               }
               else
               {
                  stmt.setDate(3, (java.util.Date)parms[3]);
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.TIMESTAMP );
               }
               else
               {
                  stmt.setDateTime(4, (java.util.Date)parms[5], true);
               }
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.TIMESTAMP );
               }
               else
               {
                  stmt.setDateTime(5, (java.util.Date)parms[7], true);
               }
               stmt.setInt(6, ((Number) parms[8]).intValue());
               stmt.setString(7, (String)parms[9], 1);
               stmt.setVarchar(8, (String)parms[10], 2, false);
               stmt.setString(9, (String)parms[11], 1);
               stmt.setInt(10, ((Number) parms[12]).intValue());
               stmt.setShort(11, ((Number) parms[13]).shortValue());
               stmt.setShort(12, ((Number) parms[14]).shortValue());
               if ( ((Boolean) parms[15]).booleanValue() )
               {
                  stmt.setNull( 13 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(13, ((Number) parms[16]).intValue());
               }
               return;
            case 20 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 21 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(2, ((Number) parms[3]).intValue());
               }
               return;
            case 22 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 23 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 24 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 25 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 26 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 27 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 28 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(2, ((Number) parms[3]).intValue());
               }
               return;
      }
   }

}

