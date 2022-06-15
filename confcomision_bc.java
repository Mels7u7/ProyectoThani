package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class confcomision_bc extends GXWebPanel implements IGxSilentTrn
{
   public confcomision_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public confcomision_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( confcomision_bc.class ));
   }

   public confcomision_bc( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow0F22( ) ;
      standaloneNotModal( ) ;
      initializeNonKey0F22( ) ;
      standaloneModal( ) ;
      addRow0F22( ) ;
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
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z29ConfComisionId = A29ConfComisionId ;
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

   public void confirm_0F0( )
   {
      beforeValidate0F22( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0F22( ) ;
         }
         else
         {
            checkExtendedTable0F22( ) ;
            if ( AnyError == 0 )
            {
               zm0F22( 5) ;
               zm0F22( 6) ;
            }
            closeExtendedTableCursors0F22( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void zm0F22( int GX_JID )
   {
      if ( ( GX_JID == 4 ) || ( GX_JID == 0 ) )
      {
         Z123FechaDesde = A123FechaDesde ;
         Z124FechaHasta = A124FechaHasta ;
         Z125Porcentaje = A125Porcentaje ;
         Z126Estado = A126Estado ;
         Z31ProfesionalId = A31ProfesionalId ;
         Z32EspecialidadId = A32EspecialidadId ;
         Z30SedeId = A30SedeId ;
      }
      if ( ( GX_JID == 5 ) || ( GX_JID == 0 ) )
      {
      }
      if ( ( GX_JID == 6 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -4 )
      {
         Z29ConfComisionId = A29ConfComisionId ;
         Z123FechaDesde = A123FechaDesde ;
         Z124FechaHasta = A124FechaHasta ;
         Z125Porcentaje = A125Porcentaje ;
         Z126Estado = A126Estado ;
         Z31ProfesionalId = A31ProfesionalId ;
         Z32EspecialidadId = A32EspecialidadId ;
         Z30SedeId = A30SedeId ;
      }
   }

   public void standaloneNotModal( )
   {
   }

   public void standaloneModal( )
   {
   }

   public void load0F22( )
   {
      /* Using cursor BC000F6 */
      pr_default.execute(4, new Object[] {Short.valueOf(A29ConfComisionId)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound22 = (short)(1) ;
         A123FechaDesde = BC000F6_A123FechaDesde[0] ;
         A124FechaHasta = BC000F6_A124FechaHasta[0] ;
         A125Porcentaje = BC000F6_A125Porcentaje[0] ;
         A126Estado = BC000F6_A126Estado[0] ;
         A31ProfesionalId = BC000F6_A31ProfesionalId[0] ;
         A32EspecialidadId = BC000F6_A32EspecialidadId[0] ;
         A30SedeId = BC000F6_A30SedeId[0] ;
         zm0F22( -4) ;
      }
      pr_default.close(4);
      onLoadActions0F22( ) ;
   }

   public void onLoadActions0F22( )
   {
   }

   public void checkExtendedTable0F22( )
   {
      nIsDirty_22 = (short)(0) ;
      standaloneModal( ) ;
      /* Using cursor BC000F7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A31ProfesionalId), Short.valueOf(A32EspecialidadId)});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Especialidad'.", "ForeignKeyNotFound", 1, "ESPECIALIDADID");
         AnyError = (short)(1) ;
      }
      pr_default.close(5);
      /* Using cursor BC000F8 */
      pr_default.execute(6, new Object[] {Short.valueOf(A30SedeId)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Sede'.", "ForeignKeyNotFound", 1, "SEDEID");
         AnyError = (short)(1) ;
      }
      pr_default.close(6);
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A123FechaDesde)) || (( GXutil.resetTime(A123FechaDesde).after( GXutil.resetTime( localUtil.ymdtod( 1753, 1, 1) )) ) || ( GXutil.dateCompare(GXutil.resetTime(A123FechaDesde), GXutil.resetTime(localUtil.ymdtod( 1753, 1, 1))) )) ) )
      {
         httpContext.GX_msglist.addItem("Campo Fecha Desde fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A124FechaHasta)) || (( GXutil.resetTime(A124FechaHasta).after( GXutil.resetTime( localUtil.ymdtod( 1753, 1, 1) )) ) || ( GXutil.dateCompare(GXutil.resetTime(A124FechaHasta), GXutil.resetTime(localUtil.ymdtod( 1753, 1, 1))) )) ) )
      {
         httpContext.GX_msglist.addItem("Campo Fecha Hasta fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A126Estado, "A") == 0 ) || ( GXutil.strcmp(A126Estado, "I") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Estado fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors0F22( )
   {
      pr_default.close(5);
      pr_default.close(6);
   }

   public void enableDisable( )
   {
   }

   public void getKey0F22( )
   {
      /* Using cursor BC000F9 */
      pr_default.execute(7, new Object[] {Short.valueOf(A29ConfComisionId)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound22 = (short)(1) ;
      }
      else
      {
         RcdFound22 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC000F10 */
      pr_default.execute(8, new Object[] {Short.valueOf(A29ConfComisionId)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         zm0F22( 4) ;
         RcdFound22 = (short)(1) ;
         A29ConfComisionId = BC000F10_A29ConfComisionId[0] ;
         A123FechaDesde = BC000F10_A123FechaDesde[0] ;
         A124FechaHasta = BC000F10_A124FechaHasta[0] ;
         A125Porcentaje = BC000F10_A125Porcentaje[0] ;
         A126Estado = BC000F10_A126Estado[0] ;
         A31ProfesionalId = BC000F10_A31ProfesionalId[0] ;
         A32EspecialidadId = BC000F10_A32EspecialidadId[0] ;
         A30SedeId = BC000F10_A30SedeId[0] ;
         Z29ConfComisionId = A29ConfComisionId ;
         sMode22 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load0F22( ) ;
         if ( AnyError == 1 )
         {
            RcdFound22 = (short)(0) ;
            initializeNonKey0F22( ) ;
         }
         Gx_mode = sMode22 ;
      }
      else
      {
         RcdFound22 = (short)(0) ;
         initializeNonKey0F22( ) ;
         sMode22 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode22 ;
      }
      pr_default.close(8);
   }

   public void getEqualNoModal( )
   {
      getKey0F22( ) ;
      if ( RcdFound22 == 0 )
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
      confirm_0F0( ) ;
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

   public void checkOptimisticConcurrency0F22( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000F11 */
         pr_default.execute(9, new Object[] {Short.valueOf(A29ConfComisionId)});
         if ( (pr_default.getStatus(9) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ConfComision"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(9) == 101) || !( GXutil.dateCompare(GXutil.resetTime(Z123FechaDesde), GXutil.resetTime(BC000F11_A123FechaDesde[0])) ) || !( GXutil.dateCompare(GXutil.resetTime(Z124FechaHasta), GXutil.resetTime(BC000F11_A124FechaHasta[0])) ) || ( Z125Porcentaje != BC000F11_A125Porcentaje[0] ) || ( GXutil.strcmp(Z126Estado, BC000F11_A126Estado[0]) != 0 ) || ( Z31ProfesionalId != BC000F11_A31ProfesionalId[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z32EspecialidadId != BC000F11_A32EspecialidadId[0] ) || ( Z30SedeId != BC000F11_A30SedeId[0] ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"ConfComision"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0F22( )
   {
      beforeValidate0F22( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0F22( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0F22( 0) ;
         checkOptimisticConcurrency0F22( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0F22( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0F22( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000F12 */
                  pr_default.execute(10, new Object[] {A123FechaDesde, A124FechaHasta, Short.valueOf(A125Porcentaje), A126Estado, Integer.valueOf(A31ProfesionalId), Short.valueOf(A32EspecialidadId), Short.valueOf(A30SedeId)});
                  A29ConfComisionId = BC000F12_A29ConfComisionId[0] ;
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ConfComision");
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
            load0F22( ) ;
         }
         endLevel0F22( ) ;
      }
      closeExtendedTableCursors0F22( ) ;
   }

   public void update0F22( )
   {
      beforeValidate0F22( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0F22( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0F22( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0F22( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0F22( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000F13 */
                  pr_default.execute(11, new Object[] {A123FechaDesde, A124FechaHasta, Short.valueOf(A125Porcentaje), A126Estado, Integer.valueOf(A31ProfesionalId), Short.valueOf(A32EspecialidadId), Short.valueOf(A30SedeId), Short.valueOf(A29ConfComisionId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ConfComision");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ConfComision"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0F22( ) ;
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
         endLevel0F22( ) ;
      }
      closeExtendedTableCursors0F22( ) ;
   }

   public void deferredUpdate0F22( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0F22( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0F22( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0F22( ) ;
         afterConfirm0F22( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0F22( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000F14 */
               pr_default.execute(12, new Object[] {Short.valueOf(A29ConfComisionId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("ConfComision");
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
      sMode22 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel0F22( ) ;
      Gx_mode = sMode22 ;
   }

   public void onDeleteControls0F22( )
   {
      standaloneModal( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel0F22( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(9);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0F22( ) ;
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

   public void scanKeyStart0F22( )
   {
      /* Using cursor BC000F15 */
      pr_default.execute(13, new Object[] {Short.valueOf(A29ConfComisionId)});
      RcdFound22 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound22 = (short)(1) ;
         A29ConfComisionId = BC000F15_A29ConfComisionId[0] ;
         A123FechaDesde = BC000F15_A123FechaDesde[0] ;
         A124FechaHasta = BC000F15_A124FechaHasta[0] ;
         A125Porcentaje = BC000F15_A125Porcentaje[0] ;
         A126Estado = BC000F15_A126Estado[0] ;
         A31ProfesionalId = BC000F15_A31ProfesionalId[0] ;
         A32EspecialidadId = BC000F15_A32EspecialidadId[0] ;
         A30SedeId = BC000F15_A30SedeId[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0F22( )
   {
      /* Scan next routine */
      pr_default.readNext(13);
      RcdFound22 = (short)(0) ;
      scanKeyLoad0F22( ) ;
   }

   public void scanKeyLoad0F22( )
   {
      sMode22 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound22 = (short)(1) ;
         A29ConfComisionId = BC000F15_A29ConfComisionId[0] ;
         A123FechaDesde = BC000F15_A123FechaDesde[0] ;
         A124FechaHasta = BC000F15_A124FechaHasta[0] ;
         A125Porcentaje = BC000F15_A125Porcentaje[0] ;
         A126Estado = BC000F15_A126Estado[0] ;
         A31ProfesionalId = BC000F15_A31ProfesionalId[0] ;
         A32EspecialidadId = BC000F15_A32EspecialidadId[0] ;
         A30SedeId = BC000F15_A30SedeId[0] ;
      }
      Gx_mode = sMode22 ;
   }

   public void scanKeyEnd0F22( )
   {
      pr_default.close(13);
   }

   public void afterConfirm0F22( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0F22( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0F22( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0F22( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0F22( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0F22( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0F22( )
   {
   }

   public void send_integrity_lvl_hashes0F22( )
   {
   }

   public void addRow0F22( )
   {
      VarsToRow22( bcConfComision) ;
   }

   public void readRow0F22( )
   {
      RowToVars22( bcConfComision, 1) ;
   }

   public void initializeNonKey0F22( )
   {
      A31ProfesionalId = 0 ;
      A32EspecialidadId = (short)(0) ;
      A30SedeId = (short)(0) ;
      A123FechaDesde = GXutil.nullDate() ;
      A124FechaHasta = GXutil.nullDate() ;
      A125Porcentaje = (short)(0) ;
      A126Estado = "" ;
      Z123FechaDesde = GXutil.nullDate() ;
      Z124FechaHasta = GXutil.nullDate() ;
      Z125Porcentaje = (short)(0) ;
      Z126Estado = "" ;
      Z31ProfesionalId = 0 ;
      Z32EspecialidadId = (short)(0) ;
      Z30SedeId = (short)(0) ;
   }

   public void initAll0F22( )
   {
      A29ConfComisionId = (short)(0) ;
      initializeNonKey0F22( ) ;
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

   public void VarsToRow22( com.projectthani.SdtConfComision obj22 )
   {
      obj22.setgxTv_SdtConfComision_Mode( Gx_mode );
      obj22.setgxTv_SdtConfComision_Profesionalid( A31ProfesionalId );
      obj22.setgxTv_SdtConfComision_Especialidadid( A32EspecialidadId );
      obj22.setgxTv_SdtConfComision_Sedeid( A30SedeId );
      obj22.setgxTv_SdtConfComision_Fechadesde( A123FechaDesde );
      obj22.setgxTv_SdtConfComision_Fechahasta( A124FechaHasta );
      obj22.setgxTv_SdtConfComision_Porcentaje( A125Porcentaje );
      obj22.setgxTv_SdtConfComision_Estado( A126Estado );
      obj22.setgxTv_SdtConfComision_Confcomisionid( A29ConfComisionId );
      obj22.setgxTv_SdtConfComision_Confcomisionid_Z( Z29ConfComisionId );
      obj22.setgxTv_SdtConfComision_Profesionalid_Z( Z31ProfesionalId );
      obj22.setgxTv_SdtConfComision_Especialidadid_Z( Z32EspecialidadId );
      obj22.setgxTv_SdtConfComision_Sedeid_Z( Z30SedeId );
      obj22.setgxTv_SdtConfComision_Fechadesde_Z( Z123FechaDesde );
      obj22.setgxTv_SdtConfComision_Fechahasta_Z( Z124FechaHasta );
      obj22.setgxTv_SdtConfComision_Porcentaje_Z( Z125Porcentaje );
      obj22.setgxTv_SdtConfComision_Estado_Z( Z126Estado );
      obj22.setgxTv_SdtConfComision_Mode( Gx_mode );
   }

   public void KeyVarsToRow22( com.projectthani.SdtConfComision obj22 )
   {
      obj22.setgxTv_SdtConfComision_Confcomisionid( A29ConfComisionId );
   }

   public void RowToVars22( com.projectthani.SdtConfComision obj22 ,
                            int forceLoad )
   {
      Gx_mode = obj22.getgxTv_SdtConfComision_Mode() ;
      A31ProfesionalId = obj22.getgxTv_SdtConfComision_Profesionalid() ;
      A32EspecialidadId = obj22.getgxTv_SdtConfComision_Especialidadid() ;
      A30SedeId = obj22.getgxTv_SdtConfComision_Sedeid() ;
      A123FechaDesde = obj22.getgxTv_SdtConfComision_Fechadesde() ;
      A124FechaHasta = obj22.getgxTv_SdtConfComision_Fechahasta() ;
      A125Porcentaje = obj22.getgxTv_SdtConfComision_Porcentaje() ;
      A126Estado = obj22.getgxTv_SdtConfComision_Estado() ;
      A29ConfComisionId = obj22.getgxTv_SdtConfComision_Confcomisionid() ;
      Z29ConfComisionId = obj22.getgxTv_SdtConfComision_Confcomisionid_Z() ;
      Z31ProfesionalId = obj22.getgxTv_SdtConfComision_Profesionalid_Z() ;
      Z32EspecialidadId = obj22.getgxTv_SdtConfComision_Especialidadid_Z() ;
      Z30SedeId = obj22.getgxTv_SdtConfComision_Sedeid_Z() ;
      Z123FechaDesde = obj22.getgxTv_SdtConfComision_Fechadesde_Z() ;
      Z124FechaHasta = obj22.getgxTv_SdtConfComision_Fechahasta_Z() ;
      Z125Porcentaje = obj22.getgxTv_SdtConfComision_Porcentaje_Z() ;
      Z126Estado = obj22.getgxTv_SdtConfComision_Estado_Z() ;
      Gx_mode = obj22.getgxTv_SdtConfComision_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A29ConfComisionId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.SHORT)).shortValue() ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey0F22( ) ;
      scanKeyStart0F22( ) ;
      if ( RcdFound22 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z29ConfComisionId = A29ConfComisionId ;
      }
      zm0F22( -4) ;
      onLoadActions0F22( ) ;
      addRow0F22( ) ;
      scanKeyEnd0F22( ) ;
      if ( RcdFound22 == 0 )
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
      RowToVars22( bcConfComision, 0) ;
      scanKeyStart0F22( ) ;
      if ( RcdFound22 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z29ConfComisionId = A29ConfComisionId ;
      }
      zm0F22( -4) ;
      onLoadActions0F22( ) ;
      addRow0F22( ) ;
      scanKeyEnd0F22( ) ;
      if ( RcdFound22 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0F22( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert0F22( ) ;
      }
      else
      {
         if ( RcdFound22 == 1 )
         {
            if ( A29ConfComisionId != Z29ConfComisionId )
            {
               A29ConfComisionId = Z29ConfComisionId ;
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
               update0F22( ) ;
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
               if ( A29ConfComisionId != Z29ConfComisionId )
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
                     insert0F22( ) ;
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
                     insert0F22( ) ;
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
      RowToVars22( bcConfComision, 1) ;
      saveImpl( ) ;
      VarsToRow22( bcConfComision) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars22( bcConfComision, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0F22( ) ;
      afterTrn( ) ;
      VarsToRow22( bcConfComision) ;
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
         com.projectthani.SdtConfComision auxBC = new com.projectthani.SdtConfComision( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A29ConfComisionId);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcConfComision);
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
      RowToVars22( bcConfComision, 1) ;
      updateImpl( ) ;
      VarsToRow22( bcConfComision) ;
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
      RowToVars22( bcConfComision, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0F22( ) ;
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
      VarsToRow22( bcConfComision) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars22( bcConfComision, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey0F22( ) ;
      if ( RcdFound22 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( A29ConfComisionId != Z29ConfComisionId )
         {
            A29ConfComisionId = Z29ConfComisionId ;
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
         if ( A29ConfComisionId != Z29ConfComisionId )
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
      pr_default.close(2);
      pr_default.close(3);
      Application.rollbackDataStores(context, remoteHandle, pr_default, "confcomision_bc");
      VarsToRow22( bcConfComision) ;
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
      Gx_mode = bcConfComision.getgxTv_SdtConfComision_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcConfComision.setgxTv_SdtConfComision_Mode( Gx_mode );
   }

   public void SetSDT( com.projectthani.SdtConfComision sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcConfComision )
      {
         bcConfComision = sdt ;
         if ( GXutil.strcmp(bcConfComision.getgxTv_SdtConfComision_Mode(), "") == 0 )
         {
            bcConfComision.setgxTv_SdtConfComision_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow22( bcConfComision) ;
         }
         else
         {
            RowToVars22( bcConfComision, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcConfComision.getgxTv_SdtConfComision_Mode(), "") == 0 )
         {
            bcConfComision.setgxTv_SdtConfComision_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars22( bcConfComision, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtConfComision getConfComision_BC( )
   {
      return bcConfComision ;
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
      Z123FechaDesde = GXutil.nullDate() ;
      A123FechaDesde = GXutil.nullDate() ;
      Z124FechaHasta = GXutil.nullDate() ;
      A124FechaHasta = GXutil.nullDate() ;
      Z126Estado = "" ;
      A126Estado = "" ;
      BC000F6_A29ConfComisionId = new short[1] ;
      BC000F6_A123FechaDesde = new java.util.Date[] {GXutil.nullDate()} ;
      BC000F6_A124FechaHasta = new java.util.Date[] {GXutil.nullDate()} ;
      BC000F6_A125Porcentaje = new short[1] ;
      BC000F6_A126Estado = new String[] {""} ;
      BC000F6_A31ProfesionalId = new int[1] ;
      BC000F6_A32EspecialidadId = new short[1] ;
      BC000F6_A30SedeId = new short[1] ;
      BC000F7_A31ProfesionalId = new int[1] ;
      BC000F8_A30SedeId = new short[1] ;
      BC000F9_A29ConfComisionId = new short[1] ;
      BC000F10_A29ConfComisionId = new short[1] ;
      BC000F10_A123FechaDesde = new java.util.Date[] {GXutil.nullDate()} ;
      BC000F10_A124FechaHasta = new java.util.Date[] {GXutil.nullDate()} ;
      BC000F10_A125Porcentaje = new short[1] ;
      BC000F10_A126Estado = new String[] {""} ;
      BC000F10_A31ProfesionalId = new int[1] ;
      BC000F10_A32EspecialidadId = new short[1] ;
      BC000F10_A30SedeId = new short[1] ;
      sMode22 = "" ;
      BC000F11_A29ConfComisionId = new short[1] ;
      BC000F11_A123FechaDesde = new java.util.Date[] {GXutil.nullDate()} ;
      BC000F11_A124FechaHasta = new java.util.Date[] {GXutil.nullDate()} ;
      BC000F11_A125Porcentaje = new short[1] ;
      BC000F11_A126Estado = new String[] {""} ;
      BC000F11_A31ProfesionalId = new int[1] ;
      BC000F11_A32EspecialidadId = new short[1] ;
      BC000F11_A30SedeId = new short[1] ;
      BC000F12_A29ConfComisionId = new short[1] ;
      BC000F15_A29ConfComisionId = new short[1] ;
      BC000F15_A123FechaDesde = new java.util.Date[] {GXutil.nullDate()} ;
      BC000F15_A124FechaHasta = new java.util.Date[] {GXutil.nullDate()} ;
      BC000F15_A125Porcentaje = new short[1] ;
      BC000F15_A126Estado = new String[] {""} ;
      BC000F15_A31ProfesionalId = new int[1] ;
      BC000F15_A32EspecialidadId = new short[1] ;
      BC000F15_A30SedeId = new short[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.confcomision_bc__default(),
         new Object[] {
             new Object[] {
            BC000F2_A29ConfComisionId, BC000F2_A123FechaDesde, BC000F2_A124FechaHasta, BC000F2_A125Porcentaje, BC000F2_A126Estado, BC000F2_A31ProfesionalId, BC000F2_A32EspecialidadId, BC000F2_A30SedeId
            }
            , new Object[] {
            BC000F3_A29ConfComisionId, BC000F3_A123FechaDesde, BC000F3_A124FechaHasta, BC000F3_A125Porcentaje, BC000F3_A126Estado, BC000F3_A31ProfesionalId, BC000F3_A32EspecialidadId, BC000F3_A30SedeId
            }
            , new Object[] {
            BC000F4_A31ProfesionalId
            }
            , new Object[] {
            BC000F5_A30SedeId
            }
            , new Object[] {
            BC000F6_A29ConfComisionId, BC000F6_A123FechaDesde, BC000F6_A124FechaHasta, BC000F6_A125Porcentaje, BC000F6_A126Estado, BC000F6_A31ProfesionalId, BC000F6_A32EspecialidadId, BC000F6_A30SedeId
            }
            , new Object[] {
            BC000F7_A31ProfesionalId
            }
            , new Object[] {
            BC000F8_A30SedeId
            }
            , new Object[] {
            BC000F9_A29ConfComisionId
            }
            , new Object[] {
            BC000F10_A29ConfComisionId, BC000F10_A123FechaDesde, BC000F10_A124FechaHasta, BC000F10_A125Porcentaje, BC000F10_A126Estado, BC000F10_A31ProfesionalId, BC000F10_A32EspecialidadId, BC000F10_A30SedeId
            }
            , new Object[] {
            BC000F11_A29ConfComisionId, BC000F11_A123FechaDesde, BC000F11_A124FechaHasta, BC000F11_A125Porcentaje, BC000F11_A126Estado, BC000F11_A31ProfesionalId, BC000F11_A32EspecialidadId, BC000F11_A30SedeId
            }
            , new Object[] {
            BC000F12_A29ConfComisionId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000F15_A29ConfComisionId, BC000F15_A123FechaDesde, BC000F15_A124FechaHasta, BC000F15_A125Porcentaje, BC000F15_A126Estado, BC000F15_A31ProfesionalId, BC000F15_A32EspecialidadId, BC000F15_A30SedeId
            }
         }
      );
      /* Execute Start event if defined. */
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short Z29ConfComisionId ;
   private short A29ConfComisionId ;
   private short Z125Porcentaje ;
   private short A125Porcentaje ;
   private short Z32EspecialidadId ;
   private short A32EspecialidadId ;
   private short Z30SedeId ;
   private short A30SedeId ;
   private short RcdFound22 ;
   private short nIsDirty_22 ;
   private int trnEnded ;
   private int GX_JID ;
   private int Z31ProfesionalId ;
   private int A31ProfesionalId ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String Z126Estado ;
   private String A126Estado ;
   private String sMode22 ;
   private java.util.Date Z123FechaDesde ;
   private java.util.Date A123FechaDesde ;
   private java.util.Date Z124FechaHasta ;
   private java.util.Date A124FechaHasta ;
   private boolean Gx_longc ;
   private boolean mustCommit ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.projectthani.SdtConfComision bcConfComision ;
   private IDataStoreProvider pr_default ;
   private short[] BC000F6_A29ConfComisionId ;
   private java.util.Date[] BC000F6_A123FechaDesde ;
   private java.util.Date[] BC000F6_A124FechaHasta ;
   private short[] BC000F6_A125Porcentaje ;
   private String[] BC000F6_A126Estado ;
   private int[] BC000F6_A31ProfesionalId ;
   private short[] BC000F6_A32EspecialidadId ;
   private short[] BC000F6_A30SedeId ;
   private int[] BC000F7_A31ProfesionalId ;
   private short[] BC000F8_A30SedeId ;
   private short[] BC000F9_A29ConfComisionId ;
   private short[] BC000F10_A29ConfComisionId ;
   private java.util.Date[] BC000F10_A123FechaDesde ;
   private java.util.Date[] BC000F10_A124FechaHasta ;
   private short[] BC000F10_A125Porcentaje ;
   private String[] BC000F10_A126Estado ;
   private int[] BC000F10_A31ProfesionalId ;
   private short[] BC000F10_A32EspecialidadId ;
   private short[] BC000F10_A30SedeId ;
   private short[] BC000F11_A29ConfComisionId ;
   private java.util.Date[] BC000F11_A123FechaDesde ;
   private java.util.Date[] BC000F11_A124FechaHasta ;
   private short[] BC000F11_A125Porcentaje ;
   private String[] BC000F11_A126Estado ;
   private int[] BC000F11_A31ProfesionalId ;
   private short[] BC000F11_A32EspecialidadId ;
   private short[] BC000F11_A30SedeId ;
   private short[] BC000F12_A29ConfComisionId ;
   private short[] BC000F15_A29ConfComisionId ;
   private java.util.Date[] BC000F15_A123FechaDesde ;
   private java.util.Date[] BC000F15_A124FechaHasta ;
   private short[] BC000F15_A125Porcentaje ;
   private String[] BC000F15_A126Estado ;
   private int[] BC000F15_A31ProfesionalId ;
   private short[] BC000F15_A32EspecialidadId ;
   private short[] BC000F15_A30SedeId ;
   private short[] BC000F2_A29ConfComisionId ;
   private java.util.Date[] BC000F2_A123FechaDesde ;
   private java.util.Date[] BC000F2_A124FechaHasta ;
   private short[] BC000F2_A125Porcentaje ;
   private String[] BC000F2_A126Estado ;
   private int[] BC000F2_A31ProfesionalId ;
   private short[] BC000F2_A32EspecialidadId ;
   private short[] BC000F2_A30SedeId ;
   private short[] BC000F3_A29ConfComisionId ;
   private java.util.Date[] BC000F3_A123FechaDesde ;
   private java.util.Date[] BC000F3_A124FechaHasta ;
   private short[] BC000F3_A125Porcentaje ;
   private String[] BC000F3_A126Estado ;
   private int[] BC000F3_A31ProfesionalId ;
   private short[] BC000F3_A32EspecialidadId ;
   private short[] BC000F3_A30SedeId ;
   private int[] BC000F4_A31ProfesionalId ;
   private short[] BC000F5_A30SedeId ;
}

final  class confcomision_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC000F2", "SELECT [ConfComisionId], [FechaDesde], [FechaHasta], [Porcentaje], [Estado], [ProfesionalId], [EspecialidadId], [SedeId] FROM [ConfComision] WITH (UPDLOCK) WHERE [ConfComisionId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F3", "SELECT [ConfComisionId], [FechaDesde], [FechaHasta], [Porcentaje], [Estado], [ProfesionalId], [EspecialidadId], [SedeId] FROM [ConfComision] WHERE [ConfComisionId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F4", "SELECT [ProfesionalId] FROM [ProfesionalEspecialidad] WHERE [ProfesionalId] = ? AND [EspecialidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F5", "SELECT [SedeId] FROM [Sede] WHERE [SedeId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F6", "SELECT TM1.[ConfComisionId], TM1.[FechaDesde], TM1.[FechaHasta], TM1.[Porcentaje], TM1.[Estado], TM1.[ProfesionalId], TM1.[EspecialidadId], TM1.[SedeId] FROM [ConfComision] TM1 WHERE TM1.[ConfComisionId] = ? ORDER BY TM1.[ConfComisionId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F7", "SELECT [ProfesionalId] FROM [ProfesionalEspecialidad] WHERE [ProfesionalId] = ? AND [EspecialidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F8", "SELECT [SedeId] FROM [Sede] WHERE [SedeId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F9", "SELECT [ConfComisionId] FROM [ConfComision] WHERE [ConfComisionId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F10", "SELECT [ConfComisionId], [FechaDesde], [FechaHasta], [Porcentaje], [Estado], [ProfesionalId], [EspecialidadId], [SedeId] FROM [ConfComision] WHERE [ConfComisionId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F11", "SELECT [ConfComisionId], [FechaDesde], [FechaHasta], [Porcentaje], [Estado], [ProfesionalId], [EspecialidadId], [SedeId] FROM [ConfComision] WITH (UPDLOCK) WHERE [ConfComisionId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000F12", "INSERT INTO [ConfComision]([FechaDesde], [FechaHasta], [Porcentaje], [Estado], [ProfesionalId], [EspecialidadId], [SedeId]) VALUES(?, ?, ?, ?, ?, ?, ?); SELECT SCOPE_IDENTITY()", GX_NOMASK)
         ,new UpdateCursor("BC000F13", "UPDATE [ConfComision] SET [FechaDesde]=?, [FechaHasta]=?, [Porcentaje]=?, [Estado]=?, [ProfesionalId]=?, [EspecialidadId]=?, [SedeId]=?  WHERE [ConfComisionId] = ?", GX_NOMASK)
         ,new UpdateCursor("BC000F14", "DELETE FROM [ConfComision]  WHERE [ConfComisionId] = ?", GX_NOMASK)
         ,new ForEachCursor("BC000F15", "SELECT TM1.[ConfComisionId], TM1.[FechaDesde], TM1.[FechaHasta], TM1.[Porcentaje], TM1.[Estado], TM1.[ProfesionalId], TM1.[EspecialidadId], TM1.[SedeId] FROM [ConfComision] TM1 WHERE TM1.[ConfComisionId] = ? ORDER BY TM1.[ConfComisionId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 6 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 7 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 8 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
            case 9 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
            case 10 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 13 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
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
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 3 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 4 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
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
               stmt.setDate(1, (java.util.Date)parms[0]);
               stmt.setDate(2, (java.util.Date)parms[1]);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setString(4, (String)parms[3], 1);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               return;
            case 11 :
               stmt.setDate(1, (java.util.Date)parms[0]);
               stmt.setDate(2, (java.util.Date)parms[1]);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setString(4, (String)parms[3], 1);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               return;
            case 12 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 13 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

