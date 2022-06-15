package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class petitoriosubcategwwexportreport_impl extends GXWebReport
{
   public petitoriosubcategwwexportreport_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public void webExecute( )
   {
      if ( (GXutil.strcmp("", httpContext.getCookie( "GX_SESSION_ID"))==0) )
      {
         gxcookieaux = httpContext.setCookie( "GX_SESSION_ID", httpContext.encrypt64( com.genexus.util.Encryption.getNewKey( ), context.getServerKey( )), "", GXutil.nullDate(), "", (short)(httpContext.getHttpSecure( ))) ;
      }
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      entryPointCalled = false ;
      gxfirstwebparm = httpContext.GetNextPar( ) ;
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( toggleJsOutput )
      {
      }
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      httpContext.setDefaultTheme("WorkWithPlusTheme");
      M_top = 0 ;
      M_bot = 6 ;
      P_lines = (int)(66-M_bot) ;
      getPrinter().GxClearAttris() ;
      add_metrics( ) ;
      lineHeight = 15 ;
      PrtOffset = 0 ;
      gxXPage = 100 ;
      gxYPage = 100 ;
      getPrinter().GxSetDocName("") ;
      try
      {
         Gx_out = "FIL" ;
         if (!initPrinter (Gx_out, gxXPage, gxYPage, "GXPRN.INI", "", "", 2, 1, 1, 15840, 12240, 0, 1, 1, 0, 1, 1) )
         {
            cleanup();
            return;
         }
         getPrinter().setModal(true) ;
         P_lines = (int)(gxYPage-(lineHeight*6)) ;
         Gx_line = (int)(P_lines+1) ;
         getPrinter().setPageLines(P_lines);
         getPrinter().setLineHeight(lineHeight);
         getPrinter().setM_top(M_top);
         getPrinter().setM_bot(M_bot);
         GXt_boolean1 = AV8IsAuthorized ;
         GXv_boolean2[0] = GXt_boolean1 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPetitorioSubCateg", GXv_boolean2) ;
         petitoriosubcategwwexportreport_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
         AV8IsAuthorized = GXt_boolean1 ;
         if ( ! AV8IsAuthorized )
         {
            callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV42Pgmname))}, new String[] {"GxObject"}) );
            httpContext.wjLocDisableFrm = (byte)(1) ;
         }
         if ( AV8IsAuthorized )
         {
            GXv_SdtWWPContext3[0] = AV9WWPContext;
            new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
            AV9WWPContext = GXv_SdtWWPContext3[0] ;
            /* Execute user subroutine: 'LOADGRIDSTATE' */
            S151 ();
            if ( returnInSub )
            {
               getPrinter().GxEndPage() ;
               /* Close printer file */
               getPrinter().GxEndDocument() ;
               endPrinter();
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            AV38Title = "Lista de Petitorio Sub Categ" ;
            /* Execute user subroutine: 'PRINTFILTERS' */
            S111 ();
            if ( returnInSub )
            {
               getPrinter().GxEndPage() ;
               /* Close printer file */
               getPrinter().GxEndDocument() ;
               endPrinter();
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            /* Execute user subroutine: 'PRINTCOLUMNTITLES' */
            S121 ();
            if ( returnInSub )
            {
               getPrinter().GxEndPage() ;
               /* Close printer file */
               getPrinter().GxEndDocument() ;
               endPrinter();
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            /* Execute user subroutine: 'PRINTDATA' */
            S131 ();
            if ( returnInSub )
            {
               getPrinter().GxEndPage() ;
               /* Close printer file */
               getPrinter().GxEndDocument() ;
               endPrinter();
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            /* Execute user subroutine: 'PRINTFOOTER' */
            S171 ();
            if ( returnInSub )
            {
               getPrinter().GxEndPage() ;
               /* Close printer file */
               getPrinter().GxEndDocument() ;
               endPrinter();
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         /* Print footer for last page */
         ToSkip = (int)(P_lines+1) ;
         h4W0( true, 0) ;
         /* Close printer file */
         getPrinter().GxEndDocument() ;
         endPrinter();
      }
      catch ( ProcessInterruptedException e )
      {
      }
      if ( httpContext.willRedirect( ) )
      {
         httpContext.redirect( httpContext.wjLoc );
         httpContext.wjLoc = "" ;
      }
      cleanup();
   }

   public void S111( ) throws ProcessInterruptedException
   {
      /* 'PRINTFILTERS' Routine */
      returnInSub = false ;
      if ( ! (GXutil.strcmp("", AV13FilterFullText)==0) )
      {
         h4W0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Filter", 25, Gx_line+0, 146, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV13FilterFullText, "")), 146, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! ( (0==AV18TFPetitorioSubCategId) && (0==AV19TFPetitorioSubCategId_To) ) )
      {
         h4W0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Categoría", 25, Gx_line+0, 146, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV18TFPetitorioSubCategId), "ZZZ9")), 146, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV26TFPetitorioSubCategId_To_Description = GXutil.format( "%1 (%2)", "Categoría", "Hasta", "", "", "", "", "", "", "") ;
         h4W0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV26TFPetitorioSubCategId_To_Description, "")), 25, Gx_line+0, 146, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV19TFPetitorioSubCategId_To), "ZZZ9")), 146, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! ( (0==AV20TFPetitorioCategId) && (0==AV21TFPetitorioCategId_To) ) )
      {
         h4W0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Petitorio Categ Id", 25, Gx_line+0, 146, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV20TFPetitorioCategId), "ZZZ9")), 146, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
         AV27TFPetitorioCategId_To_Description = GXutil.format( "%1 (%2)", "Petitorio Categ Id", "Hasta", "", "", "", "", "", "", "") ;
         h4W0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV27TFPetitorioCategId_To_Description, "")), 25, Gx_line+0, 146, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV21TFPetitorioCategId_To), "ZZZ9")), 146, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      if ( ! (GXutil.strcmp("", AV23TFPetitorioCategNombre_Sel)==0) )
      {
         h4W0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Petitorio Categ Nombre", 25, Gx_line+0, 146, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV23TFPetitorioCategNombre_Sel, "")), 146, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV22TFPetitorioCategNombre)==0) )
         {
            h4W0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Petitorio Categ Nombre", 25, Gx_line+0, 146, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV22TFPetitorioCategNombre, "")), 146, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      if ( ! (GXutil.strcmp("", AV25TFPetitorioSubCategNombre_Sel)==0) )
      {
         h4W0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Categ Nombre", 25, Gx_line+0, 146, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV25TFPetitorioSubCategNombre_Sel, "")), 146, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV24TFPetitorioSubCategNombre)==0) )
         {
            h4W0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText("Categ Nombre", 25, Gx_line+0, 146, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV24TFPetitorioSubCategNombre, "")), 146, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
   }

   public void S121( ) throws ProcessInterruptedException
   {
      /* 'PRINTCOLUMNTITLES' Routine */
      returnInSub = false ;
      h4W0( false, 22) ;
      getPrinter().GxDrawLine(25, Gx_line+21, 789, Gx_line+21, 2, 0, 128, 128, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+22) ;
      h4W0( false, 37) ;
      getPrinter().GxAttris("Microsoft Sans Serif", 9, false, false, false, false, 0, 0, 128, 128, 0, 255, 255, 255) ;
      getPrinter().GxDrawText("Categoría", 30, Gx_line+10, 154, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Petitorio Categ Id", 158, Gx_line+10, 282, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText("Petitorio Categ Nombre", 286, Gx_line+10, 534, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText("Categ Nombre", 538, Gx_line+10, 787, Gx_line+27, 0, 0, 0, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+37) ;
   }

   public void S131( ) throws ProcessInterruptedException
   {
      /* 'PRINTDATA' Routine */
      returnInSub = false ;
      AV46Petitoriosubcategwwds_1_filterfulltext = AV13FilterFullText ;
      AV47Petitoriosubcategwwds_2_tfpetitoriosubcategid = AV18TFPetitorioSubCategId ;
      AV48Petitoriosubcategwwds_3_tfpetitoriosubcategid_to = AV19TFPetitorioSubCategId_To ;
      AV49Petitoriosubcategwwds_4_tfpetitoriocategid = AV20TFPetitorioCategId ;
      AV50Petitoriosubcategwwds_5_tfpetitoriocategid_to = AV21TFPetitorioCategId_To ;
      AV51Petitoriosubcategwwds_6_tfpetitoriocategnombre = AV22TFPetitorioCategNombre ;
      AV52Petitoriosubcategwwds_7_tfpetitoriocategnombre_sel = AV23TFPetitorioCategNombre_Sel ;
      AV53Petitoriosubcategwwds_8_tfpetitoriosubcategnombre = AV24TFPetitorioSubCategNombre ;
      AV54Petitoriosubcategwwds_9_tfpetitoriosubcategnombre_sel = AV25TFPetitorioSubCategNombre_Sel ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV46Petitoriosubcategwwds_1_filterfulltext ,
                                           Short.valueOf(AV47Petitoriosubcategwwds_2_tfpetitoriosubcategid) ,
                                           Short.valueOf(AV48Petitoriosubcategwwds_3_tfpetitoriosubcategid_to) ,
                                           Short.valueOf(AV49Petitoriosubcategwwds_4_tfpetitoriocategid) ,
                                           Short.valueOf(AV50Petitoriosubcategwwds_5_tfpetitoriocategid_to) ,
                                           AV52Petitoriosubcategwwds_7_tfpetitoriocategnombre_sel ,
                                           AV51Petitoriosubcategwwds_6_tfpetitoriocategnombre ,
                                           AV54Petitoriosubcategwwds_9_tfpetitoriosubcategnombre_sel ,
                                           AV53Petitoriosubcategwwds_8_tfpetitoriosubcategnombre ,
                                           Short.valueOf(A48PetitorioSubCategId) ,
                                           Short.valueOf(A49PetitorioCategId) ,
                                           A266PetitorioCategNombre ,
                                           A265PetitorioSubCategNombre ,
                                           Short.valueOf(AV11OrderedBy) ,
                                           Boolean.valueOf(AV12OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT,
                                           TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV46Petitoriosubcategwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Petitoriosubcategwwds_1_filterfulltext), "%", "") ;
      lV46Petitoriosubcategwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Petitoriosubcategwwds_1_filterfulltext), "%", "") ;
      lV46Petitoriosubcategwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Petitoriosubcategwwds_1_filterfulltext), "%", "") ;
      lV46Petitoriosubcategwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV46Petitoriosubcategwwds_1_filterfulltext), "%", "") ;
      lV51Petitoriosubcategwwds_6_tfpetitoriocategnombre = GXutil.concat( GXutil.rtrim( AV51Petitoriosubcategwwds_6_tfpetitoriocategnombre), "%", "") ;
      lV53Petitoriosubcategwwds_8_tfpetitoriosubcategnombre = GXutil.concat( GXutil.rtrim( AV53Petitoriosubcategwwds_8_tfpetitoriosubcategnombre), "%", "") ;
      /* Using cursor P004W2 */
      pr_default.execute(0, new Object[] {lV46Petitoriosubcategwwds_1_filterfulltext, lV46Petitoriosubcategwwds_1_filterfulltext, lV46Petitoriosubcategwwds_1_filterfulltext, lV46Petitoriosubcategwwds_1_filterfulltext, Short.valueOf(AV47Petitoriosubcategwwds_2_tfpetitoriosubcategid), Short.valueOf(AV48Petitoriosubcategwwds_3_tfpetitoriosubcategid_to), Short.valueOf(AV49Petitoriosubcategwwds_4_tfpetitoriocategid), Short.valueOf(AV50Petitoriosubcategwwds_5_tfpetitoriocategid_to), lV51Petitoriosubcategwwds_6_tfpetitoriocategnombre, AV52Petitoriosubcategwwds_7_tfpetitoriocategnombre_sel, lV53Petitoriosubcategwwds_8_tfpetitoriosubcategnombre, AV54Petitoriosubcategwwds_9_tfpetitoriosubcategnombre_sel});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A49PetitorioCategId = P004W2_A49PetitorioCategId[0] ;
         A48PetitorioSubCategId = P004W2_A48PetitorioSubCategId[0] ;
         A265PetitorioSubCategNombre = P004W2_A265PetitorioSubCategNombre[0] ;
         A266PetitorioCategNombre = P004W2_A266PetitorioCategNombre[0] ;
         A266PetitorioCategNombre = P004W2_A266PetitorioCategNombre[0] ;
         /* Execute user subroutine: 'BEFOREPRINTLINE' */
         S144 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            pr_default.close(0);
            getPrinter().GxEndPage() ;
            /* Close printer file */
            getPrinter().GxEndDocument() ;
            endPrinter();
            returnInSub = true;
            if (true) return;
         }
         h4W0( false, 66) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A48PetitorioSubCategId), "ZZZ9")), 30, Gx_line+10, 154, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A49PetitorioCategId), "ZZZ9")), 158, Gx_line+10, 282, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A266PetitorioCategNombre, "")), 286, Gx_line+10, 534, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A265PetitorioSubCategNombre, "")), 538, Gx_line+10, 787, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawLine(28, Gx_line+65, 789, Gx_line+65, 1, 220, 220, 220, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+66) ;
         /* Execute user subroutine: 'AFTERPRINTLINE' */
         S161 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            pr_default.close(0);
            getPrinter().GxEndPage() ;
            /* Close printer file */
            getPrinter().GxEndDocument() ;
            endPrinter();
            returnInSub = true;
            if (true) return;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void S151( ) throws ProcessInterruptedException
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV14Session.getValue("PetitorioSubCategWWGridState"), "") == 0 )
      {
         AV16GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "PetitorioSubCategWWGridState"), null, null);
      }
      else
      {
         AV16GridState.fromxml(AV14Session.getValue("PetitorioSubCategWWGridState"), null, null);
      }
      AV11OrderedBy = AV16GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV12OrderedDsc = AV16GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV55GXV1 = 1 ;
      while ( AV55GXV1 <= AV16GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV17GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV16GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV55GXV1));
         if ( GXutil.strcmp(AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV13FilterFullText = AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOSUBCATEGID") == 0 )
         {
            AV18TFPetitorioSubCategId = (short)(GXutil.lval( AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV19TFPetitorioSubCategId_To = (short)(GXutil.lval( AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOCATEGID") == 0 )
         {
            AV20TFPetitorioCategId = (short)(GXutil.lval( AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV21TFPetitorioCategId_To = (short)(GXutil.lval( AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOCATEGNOMBRE") == 0 )
         {
            AV22TFPetitorioCategNombre = AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOCATEGNOMBRE_SEL") == 0 )
         {
            AV23TFPetitorioCategNombre_Sel = AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOSUBCATEGNOMBRE") == 0 )
         {
            AV24TFPetitorioSubCategNombre = AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOSUBCATEGNOMBRE_SEL") == 0 )
         {
            AV25TFPetitorioSubCategNombre_Sel = AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV55GXV1 = (int)(AV55GXV1+1) ;
      }
   }

   public void S144( ) throws ProcessInterruptedException
   {
      /* 'BEFOREPRINTLINE' Routine */
      returnInSub = false ;
   }

   public void S161( ) throws ProcessInterruptedException
   {
      /* 'AFTERPRINTLINE' Routine */
      returnInSub = false ;
   }

   public void S171( ) throws ProcessInterruptedException
   {
      /* 'PRINTFOOTER' Routine */
      returnInSub = false ;
   }

   public void h4W0( boolean bFoot ,
                     int Inc )
   {
      /* Skip the required number of lines */
      while ( ( ToSkip > 0 ) || ( Gx_line + Inc > P_lines ) )
      {
         if ( Gx_line + Inc >= P_lines )
         {
            if ( Gx_page > 0 )
            {
               /* Print footers */
               Gx_line = P_lines ;
               AV36PageInfo = "Page: " + GXutil.trim( GXutil.str( Gx_page, 6, 0)) ;
               AV33DateInfo = "Date: " + localUtil.format( Gx_date, "99/99/99") ;
               getPrinter().GxDrawRect(0, Gx_line+5, 819, Gx_line+40, 1, 0, 0, 0, 1, 0, 128, 128, 1, 1, 1, 1, 0, 0, 0, 0) ;
               getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
               getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV36PageInfo, "")), 30, Gx_line+15, 409, Gx_line+30, 0, 0, 0, 0) ;
               getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV33DateInfo, "")), 409, Gx_line+15, 789, Gx_line+30, 2, 0, 0, 0) ;
               Gx_OldLine = Gx_line ;
               Gx_line = (int)(Gx_line+40) ;
               getPrinter().GxEndPage() ;
               if ( bFoot )
               {
                  return  ;
               }
            }
            ToSkip = 0 ;
            Gx_line = 0 ;
            Gx_page = (int)(Gx_page+1) ;
            /* Skip Margin Top Lines */
            Gx_line = (int)(Gx_line+(M_top*lineHeight)) ;
            /* Print headers */
            getPrinter().GxStartPage() ;
            getPrinter().setPage(Gx_page);
            AV31AppName = "DVelop Software Solutions" ;
            AV37Phone = "+1 550 8923" ;
            AV35Mail = "info@mail.com" ;
            AV39Website = "http://www.web.com" ;
            AV28AddressLine1 = "French Boulevard 2859" ;
            AV29AddressLine2 = "Downtown" ;
            AV30AddressLine3 = "Paris, France" ;
            getPrinter().GxDrawRect(0, Gx_line+0, 819, Gx_line+108, 1, 0, 0, 0, 1, 0, 128, 128, 1, 1, 1, 1, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV31AppName, "")), 30, Gx_line+30, 283, Gx_line+45, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 20, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV38Title, "")), 30, Gx_line+45, 283, Gx_line+78, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV37Phone, "")), 283, Gx_line+30, 536, Gx_line+46, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV35Mail, "")), 283, Gx_line+46, 536, Gx_line+62, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV39Website, "")), 283, Gx_line+62, 536, Gx_line+78, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV28AddressLine1, "")), 536, Gx_line+30, 789, Gx_line+46, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV29AddressLine2, "")), 536, Gx_line+46, 789, Gx_line+62, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV30AddressLine3, "")), 536, Gx_line+62, 789, Gx_line+78, 2, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+128) ;
            if (true) break;
         }
         else
         {
            PrtOffset = 0 ;
            Gx_line = (int)(Gx_line+1) ;
         }
         ToSkip = (int)(ToSkip-1) ;
      }
      getPrinter().setPage(Gx_page);
   }

   public void add_metrics( )
   {
      add_metrics0( ) ;
   }

   public void add_metrics0( )
   {
      getPrinter().setMetrics("Microsoft Sans Serif", false, false, 58, 14, 72, 171,  new int[] {48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 18, 20, 23, 36, 36, 57, 43, 12, 21, 21, 25, 37, 18, 21, 18, 18, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 18, 18, 37, 37, 37, 36, 65, 43, 43, 46, 46, 43, 39, 50, 46, 18, 32, 43, 36, 53, 46, 50, 43, 50, 46, 43, 40, 46, 43, 64, 41, 42, 39, 18, 18, 18, 27, 36, 21, 36, 36, 32, 36, 36, 18, 36, 36, 14, 15, 33, 14, 55, 36, 36, 36, 36, 21, 32, 18, 36, 33, 47, 31, 31, 31, 21, 17, 21, 37, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 18, 20, 36, 36, 36, 36, 17, 36, 21, 47, 24, 36, 37, 21, 47, 35, 26, 35, 21, 21, 21, 37, 34, 21, 21, 21, 23, 36, 53, 53, 53, 39, 43, 43, 43, 43, 43, 43, 64, 46, 43, 43, 43, 43, 18, 18, 18, 18, 46, 46, 50, 50, 50, 50, 50, 37, 50, 46, 46, 46, 46, 43, 43, 39, 36, 36, 36, 36, 36, 36, 57, 32, 36, 36, 36, 36, 18, 18, 18, 18, 36, 36, 36, 36, 36, 36, 36, 35, 39, 36, 36, 36, 36, 32, 36, 32}) ;
   }

   protected int getOutputType( )
   {
      return OUTPUT_PDF;
   }

   protected java.io.OutputStream getOutputStream( )
   {
      return httpContext.getOutputStream();
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      super.cleanup();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      GXKey = "" ;
      gxfirstwebparm = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV42Pgmname = "" ;
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV38Title = "" ;
      AV13FilterFullText = "" ;
      AV26TFPetitorioSubCategId_To_Description = "" ;
      AV27TFPetitorioCategId_To_Description = "" ;
      AV23TFPetitorioCategNombre_Sel = "" ;
      AV22TFPetitorioCategNombre = "" ;
      AV25TFPetitorioSubCategNombre_Sel = "" ;
      AV24TFPetitorioSubCategNombre = "" ;
      A266PetitorioCategNombre = "" ;
      A265PetitorioSubCategNombre = "" ;
      AV46Petitoriosubcategwwds_1_filterfulltext = "" ;
      AV51Petitoriosubcategwwds_6_tfpetitoriocategnombre = "" ;
      AV52Petitoriosubcategwwds_7_tfpetitoriocategnombre_sel = "" ;
      AV53Petitoriosubcategwwds_8_tfpetitoriosubcategnombre = "" ;
      AV54Petitoriosubcategwwds_9_tfpetitoriosubcategnombre_sel = "" ;
      scmdbuf = "" ;
      lV46Petitoriosubcategwwds_1_filterfulltext = "" ;
      lV51Petitoriosubcategwwds_6_tfpetitoriocategnombre = "" ;
      lV53Petitoriosubcategwwds_8_tfpetitoriosubcategnombre = "" ;
      P004W2_A49PetitorioCategId = new short[1] ;
      P004W2_A48PetitorioSubCategId = new short[1] ;
      P004W2_A265PetitorioSubCategNombre = new String[] {""} ;
      P004W2_A266PetitorioCategNombre = new String[] {""} ;
      AV14Session = httpContext.getWebSession();
      AV16GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV17GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV36PageInfo = "" ;
      AV33DateInfo = "" ;
      Gx_date = GXutil.nullDate() ;
      AV31AppName = "" ;
      AV37Phone = "" ;
      AV35Mail = "" ;
      AV39Website = "" ;
      AV28AddressLine1 = "" ;
      AV29AddressLine2 = "" ;
      AV30AddressLine3 = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.petitoriosubcategwwexportreport__default(),
         new Object[] {
             new Object[] {
            P004W2_A49PetitorioCategId, P004W2_A48PetitorioSubCategId, P004W2_A265PetitorioSubCategNombre, P004W2_A266PetitorioCategNombre
            }
         }
      );
      Gx_date = GXutil.today( ) ;
      AV42Pgmname = "PetitorioSubCategWWExportReport" ;
      /* GeneXus formulas. */
      Gx_line = 0 ;
      Gx_date = GXutil.today( ) ;
      AV42Pgmname = "PetitorioSubCategWWExportReport" ;
      Gx_err = (short)(0) ;
   }

   private short gxcookieaux ;
   private short AV18TFPetitorioSubCategId ;
   private short AV19TFPetitorioSubCategId_To ;
   private short AV20TFPetitorioCategId ;
   private short AV21TFPetitorioCategId_To ;
   private short A48PetitorioSubCategId ;
   private short A49PetitorioCategId ;
   private short AV47Petitoriosubcategwwds_2_tfpetitoriosubcategid ;
   private short AV48Petitoriosubcategwwds_3_tfpetitoriosubcategid_to ;
   private short AV49Petitoriosubcategwwds_4_tfpetitoriocategid ;
   private short AV50Petitoriosubcategwwds_5_tfpetitoriocategid_to ;
   private short AV11OrderedBy ;
   private short Gx_err ;
   private int M_top ;
   private int M_bot ;
   private int Line ;
   private int ToSkip ;
   private int PrtOffset ;
   private int Gx_OldLine ;
   private int AV55GXV1 ;
   private String GXKey ;
   private String gxfirstwebparm ;
   private String AV42Pgmname ;
   private String scmdbuf ;
   private java.util.Date Gx_date ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV12OrderedDsc ;
   private String AV38Title ;
   private String AV13FilterFullText ;
   private String AV26TFPetitorioSubCategId_To_Description ;
   private String AV27TFPetitorioCategId_To_Description ;
   private String AV23TFPetitorioCategNombre_Sel ;
   private String AV22TFPetitorioCategNombre ;
   private String AV25TFPetitorioSubCategNombre_Sel ;
   private String AV24TFPetitorioSubCategNombre ;
   private String A266PetitorioCategNombre ;
   private String A265PetitorioSubCategNombre ;
   private String AV46Petitoriosubcategwwds_1_filterfulltext ;
   private String AV51Petitoriosubcategwwds_6_tfpetitoriocategnombre ;
   private String AV52Petitoriosubcategwwds_7_tfpetitoriocategnombre_sel ;
   private String AV53Petitoriosubcategwwds_8_tfpetitoriosubcategnombre ;
   private String AV54Petitoriosubcategwwds_9_tfpetitoriosubcategnombre_sel ;
   private String lV46Petitoriosubcategwwds_1_filterfulltext ;
   private String lV51Petitoriosubcategwwds_6_tfpetitoriocategnombre ;
   private String lV53Petitoriosubcategwwds_8_tfpetitoriosubcategnombre ;
   private String AV36PageInfo ;
   private String AV33DateInfo ;
   private String AV31AppName ;
   private String AV37Phone ;
   private String AV35Mail ;
   private String AV39Website ;
   private String AV28AddressLine1 ;
   private String AV29AddressLine2 ;
   private String AV30AddressLine3 ;
   private com.genexus.webpanels.WebSession AV14Session ;
   private IDataStoreProvider pr_default ;
   private short[] P004W2_A49PetitorioCategId ;
   private short[] P004W2_A48PetitorioSubCategId ;
   private String[] P004W2_A265PetitorioSubCategNombre ;
   private String[] P004W2_A266PetitorioCategNombre ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV16GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV17GridStateFilterValue ;
}

final  class petitoriosubcategwwexportreport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P004W2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV46Petitoriosubcategwwds_1_filterfulltext ,
                                          short AV47Petitoriosubcategwwds_2_tfpetitoriosubcategid ,
                                          short AV48Petitoriosubcategwwds_3_tfpetitoriosubcategid_to ,
                                          short AV49Petitoriosubcategwwds_4_tfpetitoriocategid ,
                                          short AV50Petitoriosubcategwwds_5_tfpetitoriocategid_to ,
                                          String AV52Petitoriosubcategwwds_7_tfpetitoriocategnombre_sel ,
                                          String AV51Petitoriosubcategwwds_6_tfpetitoriocategnombre ,
                                          String AV54Petitoriosubcategwwds_9_tfpetitoriosubcategnombre_sel ,
                                          String AV53Petitoriosubcategwwds_8_tfpetitoriosubcategnombre ,
                                          short A48PetitorioSubCategId ,
                                          short A49PetitorioCategId ,
                                          String A266PetitorioCategNombre ,
                                          String A265PetitorioSubCategNombre ,
                                          short AV11OrderedBy ,
                                          boolean AV12OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[12];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT T1.[PetitorioCategId], T1.[PetitorioSubCategId], T1.[PetitorioSubCategNombre], T2.[PetitorioCategNombre] FROM ([PetitorioSubCateg] T1 INNER JOIN [PetitorioCateg]" ;
      scmdbuf += " T2 ON T2.[PetitorioCategId] = T1.[PetitorioCategId])" ;
      if ( ! (GXutil.strcmp("", AV46Petitoriosubcategwwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST(T1.[PetitorioSubCategId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(4), CAST(T1.[PetitorioCategId] AS decimal(4,0))) like '%' + ?) or ( T2.[PetitorioCategNombre] like '%' + ?) or ( T1.[PetitorioSubCategNombre] like '%' + ?))");
      }
      else
      {
         GXv_int4[0] = (byte)(1) ;
         GXv_int4[1] = (byte)(1) ;
         GXv_int4[2] = (byte)(1) ;
         GXv_int4[3] = (byte)(1) ;
      }
      if ( ! (0==AV47Petitoriosubcategwwds_2_tfpetitoriosubcategid) )
      {
         addWhere(sWhereString, "(T1.[PetitorioSubCategId] >= ?)");
      }
      else
      {
         GXv_int4[4] = (byte)(1) ;
      }
      if ( ! (0==AV48Petitoriosubcategwwds_3_tfpetitoriosubcategid_to) )
      {
         addWhere(sWhereString, "(T1.[PetitorioSubCategId] <= ?)");
      }
      else
      {
         GXv_int4[5] = (byte)(1) ;
      }
      if ( ! (0==AV49Petitoriosubcategwwds_4_tfpetitoriocategid) )
      {
         addWhere(sWhereString, "(T1.[PetitorioCategId] >= ?)");
      }
      else
      {
         GXv_int4[6] = (byte)(1) ;
      }
      if ( ! (0==AV50Petitoriosubcategwwds_5_tfpetitoriocategid_to) )
      {
         addWhere(sWhereString, "(T1.[PetitorioCategId] <= ?)");
      }
      else
      {
         GXv_int4[7] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV52Petitoriosubcategwwds_7_tfpetitoriocategnombre_sel)==0) && ( ! (GXutil.strcmp("", AV51Petitoriosubcategwwds_6_tfpetitoriocategnombre)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PetitorioCategNombre] like ?)");
      }
      else
      {
         GXv_int4[8] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV52Petitoriosubcategwwds_7_tfpetitoriocategnombre_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PetitorioCategNombre] = ?)");
      }
      else
      {
         GXv_int4[9] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV54Petitoriosubcategwwds_9_tfpetitoriosubcategnombre_sel)==0) && ( ! (GXutil.strcmp("", AV53Petitoriosubcategwwds_8_tfpetitoriosubcategnombre)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PetitorioSubCategNombre] like ?)");
      }
      else
      {
         GXv_int4[10] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV54Petitoriosubcategwwds_9_tfpetitoriosubcategnombre_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PetitorioSubCategNombre] = ?)");
      }
      else
      {
         GXv_int4[11] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV11OrderedBy == 1 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PetitorioSubCategNombre]" ;
      }
      else if ( ( AV11OrderedBy == 1 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PetitorioSubCategNombre] DESC" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PetitorioSubCategId]" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PetitorioSubCategId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PetitorioCategId]" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PetitorioCategId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[PetitorioCategNombre]" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[PetitorioCategNombre] DESC" ;
      }
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_P004W2(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).shortValue() , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).shortValue() , ((Number) dynConstraints[10]).shortValue() , (String)dynConstraints[11] , (String)dynConstraints[12] , ((Number) dynConstraints[13]).shortValue() , ((Boolean) dynConstraints[14]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P004W2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[12], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[13], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[16]).shortValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[17]).shortValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[18]).shortValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[19]).shortValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[20], 200);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[21], 200);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 200);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 200);
               }
               return;
      }
   }

}

