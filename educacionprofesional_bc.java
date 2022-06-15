package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class educacionprofesional_bc extends GXWebPanel implements IGxSilentTrn
{
   public educacionprofesional_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public educacionprofesional_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( educacionprofesional_bc.class ));
   }

   public educacionprofesional_bc( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow1349( ) ;
      standaloneNotModal( ) ;
      initializeNonKey1349( ) ;
      standaloneModal( ) ;
      addRow1349( ) ;
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
            Z59EducacionProfesionalId = A59EducacionProfesionalId ;
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

   public void confirm_130( )
   {
      beforeValidate1349( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls1349( ) ;
         }
         else
         {
            checkExtendedTable1349( ) ;
            if ( AnyError == 0 )
            {
               zm1349( 4) ;
            }
            closeExtendedTableCursors1349( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void zm1349( int GX_JID )
   {
      if ( ( GX_JID == 3 ) || ( GX_JID == 0 ) )
      {
         Z334EducacionProfesionalNombreInstitucion = A334EducacionProfesionalNombreInstitucion ;
         Z335EducacionProfesionalPais = A335EducacionProfesionalPais ;
         Z336EducacionProfesionalDesde = A336EducacionProfesionalDesde ;
         Z337EducacionProfesionalHasta = A337EducacionProfesionalHasta ;
         Z31ProfesionalId = A31ProfesionalId ;
      }
      if ( ( GX_JID == 4 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -3 )
      {
         Z59EducacionProfesionalId = A59EducacionProfesionalId ;
         Z334EducacionProfesionalNombreInstitucion = A334EducacionProfesionalNombreInstitucion ;
         Z335EducacionProfesionalPais = A335EducacionProfesionalPais ;
         Z336EducacionProfesionalDesde = A336EducacionProfesionalDesde ;
         Z337EducacionProfesionalHasta = A337EducacionProfesionalHasta ;
         Z31ProfesionalId = A31ProfesionalId ;
      }
   }

   public void standaloneNotModal( )
   {
   }

   public void standaloneModal( )
   {
   }

   public void load1349( )
   {
      /* Using cursor BC00135 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A59EducacionProfesionalId)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound49 = (short)(1) ;
         A334EducacionProfesionalNombreInstitucion = BC00135_A334EducacionProfesionalNombreInstitucion[0] ;
         A335EducacionProfesionalPais = BC00135_A335EducacionProfesionalPais[0] ;
         A336EducacionProfesionalDesde = BC00135_A336EducacionProfesionalDesde[0] ;
         A337EducacionProfesionalHasta = BC00135_A337EducacionProfesionalHasta[0] ;
         A31ProfesionalId = BC00135_A31ProfesionalId[0] ;
         zm1349( -3) ;
      }
      pr_default.close(3);
      onLoadActions1349( ) ;
   }

   public void onLoadActions1349( )
   {
   }

   public void checkExtendedTable1349( )
   {
      nIsDirty_49 = (short)(0) ;
      standaloneModal( ) ;
      /* Using cursor BC00136 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A31ProfesionalId)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Profesional'.", "ForeignKeyNotFound", 1, "PROFESIONALID");
         AnyError = (short)(1) ;
      }
      pr_default.close(4);
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A336EducacionProfesionalDesde)) || (( GXutil.resetTime(A336EducacionProfesionalDesde).after( GXutil.resetTime( localUtil.ymdtod( 1753, 1, 1) )) ) || ( GXutil.dateCompare(GXutil.resetTime(A336EducacionProfesionalDesde), GXutil.resetTime(localUtil.ymdtod( 1753, 1, 1))) )) ) )
      {
         httpContext.GX_msglist.addItem("Campo Educacion Profesional Desde fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A337EducacionProfesionalHasta)) || (( GXutil.resetTime(A337EducacionProfesionalHasta).after( GXutil.resetTime( localUtil.ymdtod( 1753, 1, 1) )) ) || ( GXutil.dateCompare(GXutil.resetTime(A337EducacionProfesionalHasta), GXutil.resetTime(localUtil.ymdtod( 1753, 1, 1))) )) ) )
      {
         httpContext.GX_msglist.addItem("Campo Educacion Profesional Hasta fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors1349( )
   {
      pr_default.close(4);
   }

   public void enableDisable( )
   {
   }

   public void getKey1349( )
   {
      /* Using cursor BC00137 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A59EducacionProfesionalId)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound49 = (short)(1) ;
      }
      else
      {
         RcdFound49 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC00138 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A59EducacionProfesionalId)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         zm1349( 3) ;
         RcdFound49 = (short)(1) ;
         A59EducacionProfesionalId = BC00138_A59EducacionProfesionalId[0] ;
         A334EducacionProfesionalNombreInstitucion = BC00138_A334EducacionProfesionalNombreInstitucion[0] ;
         A335EducacionProfesionalPais = BC00138_A335EducacionProfesionalPais[0] ;
         A336EducacionProfesionalDesde = BC00138_A336EducacionProfesionalDesde[0] ;
         A337EducacionProfesionalHasta = BC00138_A337EducacionProfesionalHasta[0] ;
         A31ProfesionalId = BC00138_A31ProfesionalId[0] ;
         Z59EducacionProfesionalId = A59EducacionProfesionalId ;
         sMode49 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load1349( ) ;
         if ( AnyError == 1 )
         {
            RcdFound49 = (short)(0) ;
            initializeNonKey1349( ) ;
         }
         Gx_mode = sMode49 ;
      }
      else
      {
         RcdFound49 = (short)(0) ;
         initializeNonKey1349( ) ;
         sMode49 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode49 ;
      }
      pr_default.close(6);
   }

   public void getEqualNoModal( )
   {
      getKey1349( ) ;
      if ( RcdFound49 == 0 )
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
      confirm_130( ) ;
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

   public void checkOptimisticConcurrency1349( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC00139 */
         pr_default.execute(7, new Object[] {Integer.valueOf(A59EducacionProfesionalId)});
         if ( (pr_default.getStatus(7) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"EducacionProfesional"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(7) == 101) || ( GXutil.strcmp(Z334EducacionProfesionalNombreInstitucion, BC00139_A334EducacionProfesionalNombreInstitucion[0]) != 0 ) || ( GXutil.strcmp(Z335EducacionProfesionalPais, BC00139_A335EducacionProfesionalPais[0]) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(Z336EducacionProfesionalDesde), GXutil.resetTime(BC00139_A336EducacionProfesionalDesde[0])) ) || !( GXutil.dateCompare(GXutil.resetTime(Z337EducacionProfesionalHasta), GXutil.resetTime(BC00139_A337EducacionProfesionalHasta[0])) ) || ( Z31ProfesionalId != BC00139_A31ProfesionalId[0] ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"EducacionProfesional"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1349( )
   {
      beforeValidate1349( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1349( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1349( 0) ;
         checkOptimisticConcurrency1349( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1349( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1349( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC001310 */
                  pr_default.execute(8, new Object[] {A334EducacionProfesionalNombreInstitucion, A335EducacionProfesionalPais, A336EducacionProfesionalDesde, A337EducacionProfesionalHasta, Integer.valueOf(A31ProfesionalId)});
                  A59EducacionProfesionalId = BC001310_A59EducacionProfesionalId[0] ;
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("EducacionProfesional");
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
            load1349( ) ;
         }
         endLevel1349( ) ;
      }
      closeExtendedTableCursors1349( ) ;
   }

   public void update1349( )
   {
      beforeValidate1349( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1349( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1349( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1349( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate1349( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC001311 */
                  pr_default.execute(9, new Object[] {A334EducacionProfesionalNombreInstitucion, A335EducacionProfesionalPais, A336EducacionProfesionalDesde, A337EducacionProfesionalHasta, Integer.valueOf(A31ProfesionalId), Integer.valueOf(A59EducacionProfesionalId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("EducacionProfesional");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"EducacionProfesional"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate1349( ) ;
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
         endLevel1349( ) ;
      }
      closeExtendedTableCursors1349( ) ;
   }

   public void deferredUpdate1349( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate1349( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1349( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1349( ) ;
         afterConfirm1349( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1349( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC001312 */
               pr_default.execute(10, new Object[] {Integer.valueOf(A59EducacionProfesionalId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("EducacionProfesional");
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
      sMode49 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel1349( ) ;
      Gx_mode = sMode49 ;
   }

   public void onDeleteControls1349( )
   {
      standaloneModal( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel1349( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(7);
      }
      if ( AnyError == 0 )
      {
         beforeComplete1349( ) ;
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

   public void scanKeyStart1349( )
   {
      /* Using cursor BC001313 */
      pr_default.execute(11, new Object[] {Integer.valueOf(A59EducacionProfesionalId)});
      RcdFound49 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound49 = (short)(1) ;
         A59EducacionProfesionalId = BC001313_A59EducacionProfesionalId[0] ;
         A334EducacionProfesionalNombreInstitucion = BC001313_A334EducacionProfesionalNombreInstitucion[0] ;
         A335EducacionProfesionalPais = BC001313_A335EducacionProfesionalPais[0] ;
         A336EducacionProfesionalDesde = BC001313_A336EducacionProfesionalDesde[0] ;
         A337EducacionProfesionalHasta = BC001313_A337EducacionProfesionalHasta[0] ;
         A31ProfesionalId = BC001313_A31ProfesionalId[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext1349( )
   {
      /* Scan next routine */
      pr_default.readNext(11);
      RcdFound49 = (short)(0) ;
      scanKeyLoad1349( ) ;
   }

   public void scanKeyLoad1349( )
   {
      sMode49 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound49 = (short)(1) ;
         A59EducacionProfesionalId = BC001313_A59EducacionProfesionalId[0] ;
         A334EducacionProfesionalNombreInstitucion = BC001313_A334EducacionProfesionalNombreInstitucion[0] ;
         A335EducacionProfesionalPais = BC001313_A335EducacionProfesionalPais[0] ;
         A336EducacionProfesionalDesde = BC001313_A336EducacionProfesionalDesde[0] ;
         A337EducacionProfesionalHasta = BC001313_A337EducacionProfesionalHasta[0] ;
         A31ProfesionalId = BC001313_A31ProfesionalId[0] ;
      }
      Gx_mode = sMode49 ;
   }

   public void scanKeyEnd1349( )
   {
      pr_default.close(11);
   }

   public void afterConfirm1349( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert1349( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1349( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1349( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1349( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1349( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1349( )
   {
   }

   public void send_integrity_lvl_hashes1349( )
   {
   }

   public void addRow1349( )
   {
      VarsToRow49( bcEducacionProfesional) ;
   }

   public void readRow1349( )
   {
      RowToVars49( bcEducacionProfesional, 1) ;
   }

   public void initializeNonKey1349( )
   {
      A31ProfesionalId = 0 ;
      A334EducacionProfesionalNombreInstitucion = "" ;
      A335EducacionProfesionalPais = "" ;
      A336EducacionProfesionalDesde = GXutil.nullDate() ;
      A337EducacionProfesionalHasta = GXutil.nullDate() ;
      Z334EducacionProfesionalNombreInstitucion = "" ;
      Z335EducacionProfesionalPais = "" ;
      Z336EducacionProfesionalDesde = GXutil.nullDate() ;
      Z337EducacionProfesionalHasta = GXutil.nullDate() ;
      Z31ProfesionalId = 0 ;
   }

   public void initAll1349( )
   {
      A59EducacionProfesionalId = 0 ;
      initializeNonKey1349( ) ;
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

   public void VarsToRow49( com.projectthani.SdtEducacionProfesional obj49 )
   {
      obj49.setgxTv_SdtEducacionProfesional_Mode( Gx_mode );
      obj49.setgxTv_SdtEducacionProfesional_Profesionalid( A31ProfesionalId );
      obj49.setgxTv_SdtEducacionProfesional_Educacionprofesionalnombreinstitucion( A334EducacionProfesionalNombreInstitucion );
      obj49.setgxTv_SdtEducacionProfesional_Educacionprofesionalpais( A335EducacionProfesionalPais );
      obj49.setgxTv_SdtEducacionProfesional_Educacionprofesionaldesde( A336EducacionProfesionalDesde );
      obj49.setgxTv_SdtEducacionProfesional_Educacionprofesionalhasta( A337EducacionProfesionalHasta );
      obj49.setgxTv_SdtEducacionProfesional_Educacionprofesionalid( A59EducacionProfesionalId );
      obj49.setgxTv_SdtEducacionProfesional_Educacionprofesionalid_Z( Z59EducacionProfesionalId );
      obj49.setgxTv_SdtEducacionProfesional_Profesionalid_Z( Z31ProfesionalId );
      obj49.setgxTv_SdtEducacionProfesional_Educacionprofesionalnombreinstitucion_Z( Z334EducacionProfesionalNombreInstitucion );
      obj49.setgxTv_SdtEducacionProfesional_Educacionprofesionalpais_Z( Z335EducacionProfesionalPais );
      obj49.setgxTv_SdtEducacionProfesional_Educacionprofesionaldesde_Z( Z336EducacionProfesionalDesde );
      obj49.setgxTv_SdtEducacionProfesional_Educacionprofesionalhasta_Z( Z337EducacionProfesionalHasta );
      obj49.setgxTv_SdtEducacionProfesional_Mode( Gx_mode );
   }

   public void KeyVarsToRow49( com.projectthani.SdtEducacionProfesional obj49 )
   {
      obj49.setgxTv_SdtEducacionProfesional_Educacionprofesionalid( A59EducacionProfesionalId );
   }

   public void RowToVars49( com.projectthani.SdtEducacionProfesional obj49 ,
                            int forceLoad )
   {
      Gx_mode = obj49.getgxTv_SdtEducacionProfesional_Mode() ;
      A31ProfesionalId = obj49.getgxTv_SdtEducacionProfesional_Profesionalid() ;
      A334EducacionProfesionalNombreInstitucion = obj49.getgxTv_SdtEducacionProfesional_Educacionprofesionalnombreinstitucion() ;
      A335EducacionProfesionalPais = obj49.getgxTv_SdtEducacionProfesional_Educacionprofesionalpais() ;
      A336EducacionProfesionalDesde = obj49.getgxTv_SdtEducacionProfesional_Educacionprofesionaldesde() ;
      A337EducacionProfesionalHasta = obj49.getgxTv_SdtEducacionProfesional_Educacionprofesionalhasta() ;
      A59EducacionProfesionalId = obj49.getgxTv_SdtEducacionProfesional_Educacionprofesionalid() ;
      Z59EducacionProfesionalId = obj49.getgxTv_SdtEducacionProfesional_Educacionprofesionalid_Z() ;
      Z31ProfesionalId = obj49.getgxTv_SdtEducacionProfesional_Profesionalid_Z() ;
      Z334EducacionProfesionalNombreInstitucion = obj49.getgxTv_SdtEducacionProfesional_Educacionprofesionalnombreinstitucion_Z() ;
      Z335EducacionProfesionalPais = obj49.getgxTv_SdtEducacionProfesional_Educacionprofesionalpais_Z() ;
      Z336EducacionProfesionalDesde = obj49.getgxTv_SdtEducacionProfesional_Educacionprofesionaldesde_Z() ;
      Z337EducacionProfesionalHasta = obj49.getgxTv_SdtEducacionProfesional_Educacionprofesionalhasta_Z() ;
      Gx_mode = obj49.getgxTv_SdtEducacionProfesional_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A59EducacionProfesionalId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey1349( ) ;
      scanKeyStart1349( ) ;
      if ( RcdFound49 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z59EducacionProfesionalId = A59EducacionProfesionalId ;
      }
      zm1349( -3) ;
      onLoadActions1349( ) ;
      addRow1349( ) ;
      scanKeyEnd1349( ) ;
      if ( RcdFound49 == 0 )
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
      RowToVars49( bcEducacionProfesional, 0) ;
      scanKeyStart1349( ) ;
      if ( RcdFound49 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z59EducacionProfesionalId = A59EducacionProfesionalId ;
      }
      zm1349( -3) ;
      onLoadActions1349( ) ;
      addRow1349( ) ;
      scanKeyEnd1349( ) ;
      if ( RcdFound49 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey1349( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert1349( ) ;
      }
      else
      {
         if ( RcdFound49 == 1 )
         {
            if ( A59EducacionProfesionalId != Z59EducacionProfesionalId )
            {
               A59EducacionProfesionalId = Z59EducacionProfesionalId ;
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
               update1349( ) ;
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
               if ( A59EducacionProfesionalId != Z59EducacionProfesionalId )
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
                     insert1349( ) ;
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
                     insert1349( ) ;
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
      RowToVars49( bcEducacionProfesional, 1) ;
      saveImpl( ) ;
      VarsToRow49( bcEducacionProfesional) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars49( bcEducacionProfesional, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert1349( ) ;
      afterTrn( ) ;
      VarsToRow49( bcEducacionProfesional) ;
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
         com.projectthani.SdtEducacionProfesional auxBC = new com.projectthani.SdtEducacionProfesional( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A59EducacionProfesionalId);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcEducacionProfesional);
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
      RowToVars49( bcEducacionProfesional, 1) ;
      updateImpl( ) ;
      VarsToRow49( bcEducacionProfesional) ;
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
      RowToVars49( bcEducacionProfesional, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert1349( ) ;
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
      VarsToRow49( bcEducacionProfesional) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars49( bcEducacionProfesional, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey1349( ) ;
      if ( RcdFound49 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( A59EducacionProfesionalId != Z59EducacionProfesionalId )
         {
            A59EducacionProfesionalId = Z59EducacionProfesionalId ;
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
         if ( A59EducacionProfesionalId != Z59EducacionProfesionalId )
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
      Application.rollbackDataStores(context, remoteHandle, pr_default, "educacionprofesional_bc");
      VarsToRow49( bcEducacionProfesional) ;
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
      Gx_mode = bcEducacionProfesional.getgxTv_SdtEducacionProfesional_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcEducacionProfesional.setgxTv_SdtEducacionProfesional_Mode( Gx_mode );
   }

   public void SetSDT( com.projectthani.SdtEducacionProfesional sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcEducacionProfesional )
      {
         bcEducacionProfesional = sdt ;
         if ( GXutil.strcmp(bcEducacionProfesional.getgxTv_SdtEducacionProfesional_Mode(), "") == 0 )
         {
            bcEducacionProfesional.setgxTv_SdtEducacionProfesional_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow49( bcEducacionProfesional) ;
         }
         else
         {
            RowToVars49( bcEducacionProfesional, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcEducacionProfesional.getgxTv_SdtEducacionProfesional_Mode(), "") == 0 )
         {
            bcEducacionProfesional.setgxTv_SdtEducacionProfesional_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars49( bcEducacionProfesional, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtEducacionProfesional getEducacionProfesional_BC( )
   {
      return bcEducacionProfesional ;
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
      Z334EducacionProfesionalNombreInstitucion = "" ;
      A334EducacionProfesionalNombreInstitucion = "" ;
      Z335EducacionProfesionalPais = "" ;
      A335EducacionProfesionalPais = "" ;
      Z336EducacionProfesionalDesde = GXutil.nullDate() ;
      A336EducacionProfesionalDesde = GXutil.nullDate() ;
      Z337EducacionProfesionalHasta = GXutil.nullDate() ;
      A337EducacionProfesionalHasta = GXutil.nullDate() ;
      BC00135_A59EducacionProfesionalId = new int[1] ;
      BC00135_A334EducacionProfesionalNombreInstitucion = new String[] {""} ;
      BC00135_A335EducacionProfesionalPais = new String[] {""} ;
      BC00135_A336EducacionProfesionalDesde = new java.util.Date[] {GXutil.nullDate()} ;
      BC00135_A337EducacionProfesionalHasta = new java.util.Date[] {GXutil.nullDate()} ;
      BC00135_A31ProfesionalId = new int[1] ;
      BC00136_A31ProfesionalId = new int[1] ;
      BC00137_A59EducacionProfesionalId = new int[1] ;
      BC00138_A59EducacionProfesionalId = new int[1] ;
      BC00138_A334EducacionProfesionalNombreInstitucion = new String[] {""} ;
      BC00138_A335EducacionProfesionalPais = new String[] {""} ;
      BC00138_A336EducacionProfesionalDesde = new java.util.Date[] {GXutil.nullDate()} ;
      BC00138_A337EducacionProfesionalHasta = new java.util.Date[] {GXutil.nullDate()} ;
      BC00138_A31ProfesionalId = new int[1] ;
      sMode49 = "" ;
      BC00139_A59EducacionProfesionalId = new int[1] ;
      BC00139_A334EducacionProfesionalNombreInstitucion = new String[] {""} ;
      BC00139_A335EducacionProfesionalPais = new String[] {""} ;
      BC00139_A336EducacionProfesionalDesde = new java.util.Date[] {GXutil.nullDate()} ;
      BC00139_A337EducacionProfesionalHasta = new java.util.Date[] {GXutil.nullDate()} ;
      BC00139_A31ProfesionalId = new int[1] ;
      BC001310_A59EducacionProfesionalId = new int[1] ;
      BC001313_A59EducacionProfesionalId = new int[1] ;
      BC001313_A334EducacionProfesionalNombreInstitucion = new String[] {""} ;
      BC001313_A335EducacionProfesionalPais = new String[] {""} ;
      BC001313_A336EducacionProfesionalDesde = new java.util.Date[] {GXutil.nullDate()} ;
      BC001313_A337EducacionProfesionalHasta = new java.util.Date[] {GXutil.nullDate()} ;
      BC001313_A31ProfesionalId = new int[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.educacionprofesional_bc__default(),
         new Object[] {
             new Object[] {
            BC00132_A59EducacionProfesionalId, BC00132_A334EducacionProfesionalNombreInstitucion, BC00132_A335EducacionProfesionalPais, BC00132_A336EducacionProfesionalDesde, BC00132_A337EducacionProfesionalHasta, BC00132_A31ProfesionalId
            }
            , new Object[] {
            BC00133_A59EducacionProfesionalId, BC00133_A334EducacionProfesionalNombreInstitucion, BC00133_A335EducacionProfesionalPais, BC00133_A336EducacionProfesionalDesde, BC00133_A337EducacionProfesionalHasta, BC00133_A31ProfesionalId
            }
            , new Object[] {
            BC00134_A31ProfesionalId
            }
            , new Object[] {
            BC00135_A59EducacionProfesionalId, BC00135_A334EducacionProfesionalNombreInstitucion, BC00135_A335EducacionProfesionalPais, BC00135_A336EducacionProfesionalDesde, BC00135_A337EducacionProfesionalHasta, BC00135_A31ProfesionalId
            }
            , new Object[] {
            BC00136_A31ProfesionalId
            }
            , new Object[] {
            BC00137_A59EducacionProfesionalId
            }
            , new Object[] {
            BC00138_A59EducacionProfesionalId, BC00138_A334EducacionProfesionalNombreInstitucion, BC00138_A335EducacionProfesionalPais, BC00138_A336EducacionProfesionalDesde, BC00138_A337EducacionProfesionalHasta, BC00138_A31ProfesionalId
            }
            , new Object[] {
            BC00139_A59EducacionProfesionalId, BC00139_A334EducacionProfesionalNombreInstitucion, BC00139_A335EducacionProfesionalPais, BC00139_A336EducacionProfesionalDesde, BC00139_A337EducacionProfesionalHasta, BC00139_A31ProfesionalId
            }
            , new Object[] {
            BC001310_A59EducacionProfesionalId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC001313_A59EducacionProfesionalId, BC001313_A334EducacionProfesionalNombreInstitucion, BC001313_A335EducacionProfesionalPais, BC001313_A336EducacionProfesionalDesde, BC001313_A337EducacionProfesionalHasta, BC001313_A31ProfesionalId
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
   private short RcdFound49 ;
   private short nIsDirty_49 ;
   private int trnEnded ;
   private int Z59EducacionProfesionalId ;
   private int A59EducacionProfesionalId ;
   private int GX_JID ;
   private int Z31ProfesionalId ;
   private int A31ProfesionalId ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sMode49 ;
   private java.util.Date Z336EducacionProfesionalDesde ;
   private java.util.Date A336EducacionProfesionalDesde ;
   private java.util.Date Z337EducacionProfesionalHasta ;
   private java.util.Date A337EducacionProfesionalHasta ;
   private boolean mustCommit ;
   private String Z334EducacionProfesionalNombreInstitucion ;
   private String A334EducacionProfesionalNombreInstitucion ;
   private String Z335EducacionProfesionalPais ;
   private String A335EducacionProfesionalPais ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.projectthani.SdtEducacionProfesional bcEducacionProfesional ;
   private IDataStoreProvider pr_default ;
   private int[] BC00135_A59EducacionProfesionalId ;
   private String[] BC00135_A334EducacionProfesionalNombreInstitucion ;
   private String[] BC00135_A335EducacionProfesionalPais ;
   private java.util.Date[] BC00135_A336EducacionProfesionalDesde ;
   private java.util.Date[] BC00135_A337EducacionProfesionalHasta ;
   private int[] BC00135_A31ProfesionalId ;
   private int[] BC00136_A31ProfesionalId ;
   private int[] BC00137_A59EducacionProfesionalId ;
   private int[] BC00138_A59EducacionProfesionalId ;
   private String[] BC00138_A334EducacionProfesionalNombreInstitucion ;
   private String[] BC00138_A335EducacionProfesionalPais ;
   private java.util.Date[] BC00138_A336EducacionProfesionalDesde ;
   private java.util.Date[] BC00138_A337EducacionProfesionalHasta ;
   private int[] BC00138_A31ProfesionalId ;
   private int[] BC00139_A59EducacionProfesionalId ;
   private String[] BC00139_A334EducacionProfesionalNombreInstitucion ;
   private String[] BC00139_A335EducacionProfesionalPais ;
   private java.util.Date[] BC00139_A336EducacionProfesionalDesde ;
   private java.util.Date[] BC00139_A337EducacionProfesionalHasta ;
   private int[] BC00139_A31ProfesionalId ;
   private int[] BC001310_A59EducacionProfesionalId ;
   private int[] BC001313_A59EducacionProfesionalId ;
   private String[] BC001313_A334EducacionProfesionalNombreInstitucion ;
   private String[] BC001313_A335EducacionProfesionalPais ;
   private java.util.Date[] BC001313_A336EducacionProfesionalDesde ;
   private java.util.Date[] BC001313_A337EducacionProfesionalHasta ;
   private int[] BC001313_A31ProfesionalId ;
   private int[] BC00132_A59EducacionProfesionalId ;
   private String[] BC00132_A334EducacionProfesionalNombreInstitucion ;
   private String[] BC00132_A335EducacionProfesionalPais ;
   private java.util.Date[] BC00132_A336EducacionProfesionalDesde ;
   private java.util.Date[] BC00132_A337EducacionProfesionalHasta ;
   private int[] BC00132_A31ProfesionalId ;
   private int[] BC00133_A59EducacionProfesionalId ;
   private String[] BC00133_A334EducacionProfesionalNombreInstitucion ;
   private String[] BC00133_A335EducacionProfesionalPais ;
   private java.util.Date[] BC00133_A336EducacionProfesionalDesde ;
   private java.util.Date[] BC00133_A337EducacionProfesionalHasta ;
   private int[] BC00133_A31ProfesionalId ;
   private int[] BC00134_A31ProfesionalId ;
}

final  class educacionprofesional_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC00132", "SELECT [EducacionProfesionalId], [EducacionProfesionalNombreInstitucion], [EducacionProfesionalPais], [EducacionProfesionalDesde], [EducacionProfesionalHasta], [ProfesionalId] FROM [EducacionProfesional] WITH (UPDLOCK) WHERE [EducacionProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00133", "SELECT [EducacionProfesionalId], [EducacionProfesionalNombreInstitucion], [EducacionProfesionalPais], [EducacionProfesionalDesde], [EducacionProfesionalHasta], [ProfesionalId] FROM [EducacionProfesional] WHERE [EducacionProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00134", "SELECT [ProfesionalId] FROM [Profesional] WHERE [ProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00135", "SELECT TM1.[EducacionProfesionalId], TM1.[EducacionProfesionalNombreInstitucion], TM1.[EducacionProfesionalPais], TM1.[EducacionProfesionalDesde], TM1.[EducacionProfesionalHasta], TM1.[ProfesionalId] FROM [EducacionProfesional] TM1 WHERE TM1.[EducacionProfesionalId] = ? ORDER BY TM1.[EducacionProfesionalId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00136", "SELECT [ProfesionalId] FROM [Profesional] WHERE [ProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00137", "SELECT [EducacionProfesionalId] FROM [EducacionProfesional] WHERE [EducacionProfesionalId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00138", "SELECT [EducacionProfesionalId], [EducacionProfesionalNombreInstitucion], [EducacionProfesionalPais], [EducacionProfesionalDesde], [EducacionProfesionalHasta], [ProfesionalId] FROM [EducacionProfesional] WHERE [EducacionProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00139", "SELECT [EducacionProfesionalId], [EducacionProfesionalNombreInstitucion], [EducacionProfesionalPais], [EducacionProfesionalDesde], [EducacionProfesionalHasta], [ProfesionalId] FROM [EducacionProfesional] WITH (UPDLOCK) WHERE [EducacionProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001310", "INSERT INTO [EducacionProfesional]([EducacionProfesionalNombreInstitucion], [EducacionProfesionalPais], [EducacionProfesionalDesde], [EducacionProfesionalHasta], [ProfesionalId]) VALUES(?, ?, ?, ?, ?); SELECT SCOPE_IDENTITY()", GX_NOMASK)
         ,new UpdateCursor("BC001311", "UPDATE [EducacionProfesional] SET [EducacionProfesionalNombreInstitucion]=?, [EducacionProfesionalPais]=?, [EducacionProfesionalDesde]=?, [EducacionProfesionalHasta]=?, [ProfesionalId]=?  WHERE [EducacionProfesionalId] = ?", GX_NOMASK)
         ,new UpdateCursor("BC001312", "DELETE FROM [EducacionProfesional]  WHERE [EducacionProfesionalId] = ?", GX_NOMASK)
         ,new ForEachCursor("BC001313", "SELECT TM1.[EducacionProfesionalId], TM1.[EducacionProfesionalNombreInstitucion], TM1.[EducacionProfesionalPais], TM1.[EducacionProfesionalDesde], TM1.[EducacionProfesionalHasta], TM1.[ProfesionalId] FROM [EducacionProfesional] TM1 WHERE TM1.[EducacionProfesionalId] = ? ORDER BY TM1.[EducacionProfesionalId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 11 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
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
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 8 :
               stmt.setVarchar(1, (String)parms[0], 300, false);
               stmt.setVarchar(2, (String)parms[1], 150, false);
               stmt.setDate(3, (java.util.Date)parms[2]);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               return;
            case 9 :
               stmt.setVarchar(1, (String)parms[0], 300, false);
               stmt.setVarchar(2, (String)parms[1], 150, false);
               stmt.setDate(3, (java.util.Date)parms[2]);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 11 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

