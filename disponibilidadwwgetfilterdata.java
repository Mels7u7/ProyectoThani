package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class disponibilidadwwgetfilterdata extends GXProcedure
{
   public disponibilidadwwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( disponibilidadwwgetfilterdata.class ), "" );
   }

   public disponibilidadwwgetfilterdata( int remoteHandle ,
                                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String[] aP3 ,
                             String[] aP4 )
   {
      disponibilidadwwgetfilterdata.this.aP5 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String[] aP3 ,
                        String[] aP4 ,
                        String[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String[] aP3 ,
                             String[] aP4 ,
                             String[] aP5 )
   {
      disponibilidadwwgetfilterdata.this.AV59DDOName = aP0;
      disponibilidadwwgetfilterdata.this.AV57SearchTxt = aP1;
      disponibilidadwwgetfilterdata.this.AV58SearchTxtTo = aP2;
      disponibilidadwwgetfilterdata.this.aP3 = aP3;
      disponibilidadwwgetfilterdata.this.aP4 = aP4;
      disponibilidadwwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV62Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV65OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV67OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWDisponibilidad", GXv_boolean2) ;
      disponibilidadwwgetfilterdata.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         /* Execute user subroutine: 'LOADGRIDSTATE' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( GXutil.strcmp(GXutil.upper( AV59DDOName), "DDO_EVENTID") == 0 )
         {
            /* Execute user subroutine: 'LOADEVENTIDOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV59DDOName), "DDO_DISPONIBILIDADDESCRIPTION") == 0 )
         {
            /* Execute user subroutine: 'LOADDISPONIBILIDADDESCRIPTIONOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV59DDOName), "DDO_PROFESIONALAPELLIDOPATERNO") == 0 )
         {
            /* Execute user subroutine: 'LOADPROFESIONALAPELLIDOPATERNOOPTIONS' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV59DDOName), "DDO_PROFESIONALAPELLIDOMATERNO") == 0 )
         {
            /* Execute user subroutine: 'LOADPROFESIONALAPELLIDOMATERNOOPTIONS' */
            S151 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV59DDOName), "DDO_PROFESIONALNOMBRES") == 0 )
         {
            /* Execute user subroutine: 'LOADPROFESIONALNOMBRESOPTIONS' */
            S161 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV59DDOName), "DDO_PROFESIONALNOMBRECOMPLETO") == 0 )
         {
            /* Execute user subroutine: 'LOADPROFESIONALNOMBRECOMPLETOOPTIONS' */
            S171 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV59DDOName), "DDO_PROFESIONALCOP") == 0 )
         {
            /* Execute user subroutine: 'LOADPROFESIONALCOPOPTIONS' */
            S181 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV59DDOName), "DDO_ESPECIALIDADCODIGO") == 0 )
         {
            /* Execute user subroutine: 'LOADESPECIALIDADCODIGOOPTIONS' */
            S191 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV59DDOName), "DDO_ESPECIALIDADNOMBRE") == 0 )
         {
            /* Execute user subroutine: 'LOADESPECIALIDADNOMBREOPTIONS' */
            S201 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV63OptionsJson = AV62Options.toJSonString(false) ;
      AV66OptionsDescJson = AV65OptionsDesc.toJSonString(false) ;
      AV68OptionIndexesJson = AV67OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV70Session.getValue("DisponibilidadWWGridState"), "") == 0 )
      {
         AV72GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "DisponibilidadWWGridState"), null, null);
      }
      else
      {
         AV72GridState.fromxml(AV70Session.getValue("DisponibilidadWWGridState"), null, null);
      }
      AV80GXV1 = 1 ;
      while ( AV80GXV1 <= AV72GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV73GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV72GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV80GXV1));
         if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV75FilterFullText = AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDISPONIBILIDADID") == 0 )
         {
            AV11TFDisponibilidadId = (int)(GXutil.lval( AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV12TFDisponibilidadId_To = (int)(GXutil.lval( AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEVENTID") == 0 )
         {
            AV13TFEventId = AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEVENTID_SEL") == 0 )
         {
            AV14TFEventId_Sel = AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDISPONIBILIDADDESCRIPTION") == 0 )
         {
            AV15TFDisponibilidadDescription = AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDISPONIBILIDADDESCRIPTION_SEL") == 0 )
         {
            AV16TFDisponibilidadDescription_Sel = AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALID") == 0 )
         {
            AV17TFProfesionalId = (int)(GXutil.lval( AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV18TFProfesionalId_To = (int)(GXutil.lval( AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALAPELLIDOPATERNO") == 0 )
         {
            AV19TFProfesionalApellidoPaterno = AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALAPELLIDOPATERNO_SEL") == 0 )
         {
            AV20TFProfesionalApellidoPaterno_Sel = AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALAPELLIDOMATERNO") == 0 )
         {
            AV21TFProfesionalApellidoMaterno = AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALAPELLIDOMATERNO_SEL") == 0 )
         {
            AV22TFProfesionalApellidoMaterno_Sel = AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALNOMBRES") == 0 )
         {
            AV23TFProfesionalNombres = AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALNOMBRES_SEL") == 0 )
         {
            AV24TFProfesionalNombres_Sel = AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALNOMBRECOMPLETO") == 0 )
         {
            AV25TFProfesionalNombreCompleto = AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALNOMBRECOMPLETO_SEL") == 0 )
         {
            AV26TFProfesionalNombreCompleto_Sel = AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALCOP") == 0 )
         {
            AV27TFProfesionalCOP = AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROFESIONALCOP_SEL") == 0 )
         {
            AV28TFProfesionalCOP_Sel = AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDISPONIBILIDADFECHA") == 0 )
         {
            AV29TFDisponibilidadFecha = localUtil.ctod( AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3) ;
            AV30TFDisponibilidadFecha_To = localUtil.ctod( AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3) ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDISPONIBILIDADHORAINICIO") == 0 )
         {
            AV31TFDisponibilidadHoraInicio = GXutil.resetDate(localUtil.ctot( AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3)) ;
            AV32TFDisponibilidadHoraInicio_To = GXutil.resetDate(localUtil.ctot( AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3)) ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDISPONIBILIDADHORAFIN") == 0 )
         {
            AV33TFDisponibilidadHoraFin = GXutil.resetDate(localUtil.ctot( AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3)) ;
            AV34TFDisponibilidadHoraFin_To = GXutil.resetDate(localUtil.ctot( AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3)) ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESPECIALIDADID") == 0 )
         {
            AV35TFEspecialidadId = (short)(GXutil.lval( AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV36TFEspecialidadId_To = (short)(GXutil.lval( AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESPECIALIDADCODIGO") == 0 )
         {
            AV37TFEspecialidadCodigo = AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESPECIALIDADCODIGO_SEL") == 0 )
         {
            AV38TFEspecialidadCodigo_Sel = AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESPECIALIDADNOMBRE") == 0 )
         {
            AV39TFEspecialidadNombre = AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESPECIALIDADNOMBRE_SEL") == 0 )
         {
            AV40TFEspecialidadNombre_Sel = AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDISPONIBILIDADUSER") == 0 )
         {
            AV49TFDisponibilidadUser = (int)(GXutil.lval( AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV50TFDisponibilidadUser_To = (int)(GXutil.lval( AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDISPONIBILIDADESTADO_SEL") == 0 )
         {
            AV51TFDisponibilidadEstado_SelsJson = AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV52TFDisponibilidadEstado_Sels.fromJSonString(AV51TFDisponibilidadEstado_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDISPONIBILIDADESTADOCITA_SEL") == 0 )
         {
            AV53TFDisponibilidadEstadoCita_SelsJson = AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV54TFDisponibilidadEstadoCita_Sels.fromJSonString(AV53TFDisponibilidadEstadoCita_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDCITAID") == 0 )
         {
            AV55TFDCitaId = (int)(GXutil.lval( AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV56TFDCitaId_To = (int)(GXutil.lval( AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDISPONIBILIDADTIPOCITA_SEL") == 0 )
         {
            AV76TFDisponibilidadTipoCita_SelsJson = AV73GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV77TFDisponibilidadTipoCita_Sels.fromJSonString(AV76TFDisponibilidadTipoCita_SelsJson, null);
         }
         AV80GXV1 = (int)(AV80GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADEVENTIDOPTIONS' Routine */
      returnInSub = false ;
      AV13TFEventId = AV57SearchTxt ;
      AV14TFEventId_Sel = "" ;
      AV82Disponibilidadwwds_1_filterfulltext = AV75FilterFullText ;
      AV83Disponibilidadwwds_2_tfdisponibilidadid = AV11TFDisponibilidadId ;
      AV84Disponibilidadwwds_3_tfdisponibilidadid_to = AV12TFDisponibilidadId_To ;
      AV85Disponibilidadwwds_4_tfeventid = AV13TFEventId ;
      AV86Disponibilidadwwds_5_tfeventid_sel = AV14TFEventId_Sel ;
      AV87Disponibilidadwwds_6_tfdisponibilidaddescription = AV15TFDisponibilidadDescription ;
      AV88Disponibilidadwwds_7_tfdisponibilidaddescription_sel = AV16TFDisponibilidadDescription_Sel ;
      AV89Disponibilidadwwds_8_tfprofesionalid = AV17TFProfesionalId ;
      AV90Disponibilidadwwds_9_tfprofesionalid_to = AV18TFProfesionalId_To ;
      AV91Disponibilidadwwds_10_tfprofesionalapellidopaterno = AV19TFProfesionalApellidoPaterno ;
      AV92Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel = AV20TFProfesionalApellidoPaterno_Sel ;
      AV93Disponibilidadwwds_12_tfprofesionalapellidomaterno = AV21TFProfesionalApellidoMaterno ;
      AV94Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel = AV22TFProfesionalApellidoMaterno_Sel ;
      AV95Disponibilidadwwds_14_tfprofesionalnombres = AV23TFProfesionalNombres ;
      AV96Disponibilidadwwds_15_tfprofesionalnombres_sel = AV24TFProfesionalNombres_Sel ;
      AV97Disponibilidadwwds_16_tfprofesionalnombrecompleto = AV25TFProfesionalNombreCompleto ;
      AV98Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel = AV26TFProfesionalNombreCompleto_Sel ;
      AV99Disponibilidadwwds_18_tfprofesionalcop = AV27TFProfesionalCOP ;
      AV100Disponibilidadwwds_19_tfprofesionalcop_sel = AV28TFProfesionalCOP_Sel ;
      AV101Disponibilidadwwds_20_tfdisponibilidadfecha = AV29TFDisponibilidadFecha ;
      AV102Disponibilidadwwds_21_tfdisponibilidadfecha_to = AV30TFDisponibilidadFecha_To ;
      AV103Disponibilidadwwds_22_tfdisponibilidadhorainicio = AV31TFDisponibilidadHoraInicio ;
      AV104Disponibilidadwwds_23_tfdisponibilidadhorainicio_to = AV32TFDisponibilidadHoraInicio_To ;
      AV105Disponibilidadwwds_24_tfdisponibilidadhorafin = AV33TFDisponibilidadHoraFin ;
      AV106Disponibilidadwwds_25_tfdisponibilidadhorafin_to = AV34TFDisponibilidadHoraFin_To ;
      AV107Disponibilidadwwds_26_tfespecialidadid = AV35TFEspecialidadId ;
      AV108Disponibilidadwwds_27_tfespecialidadid_to = AV36TFEspecialidadId_To ;
      AV109Disponibilidadwwds_28_tfespecialidadcodigo = AV37TFEspecialidadCodigo ;
      AV110Disponibilidadwwds_29_tfespecialidadcodigo_sel = AV38TFEspecialidadCodigo_Sel ;
      AV111Disponibilidadwwds_30_tfespecialidadnombre = AV39TFEspecialidadNombre ;
      AV112Disponibilidadwwds_31_tfespecialidadnombre_sel = AV40TFEspecialidadNombre_Sel ;
      AV113Disponibilidadwwds_32_tfdisponibilidaduser = AV49TFDisponibilidadUser ;
      AV114Disponibilidadwwds_33_tfdisponibilidaduser_to = AV50TFDisponibilidadUser_To ;
      AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels = AV52TFDisponibilidadEstado_Sels ;
      AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels = AV54TFDisponibilidadEstadoCita_Sels ;
      AV117Disponibilidadwwds_36_tfdcitaid = AV55TFDCitaId ;
      AV118Disponibilidadwwds_37_tfdcitaid_to = AV56TFDCitaId_To ;
      AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels = AV77TFDisponibilidadTipoCita_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A136DisponibilidadEstado ,
                                           AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels ,
                                           A139DisponibilidadEstadoCita ,
                                           AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels ,
                                           A298DisponibilidadTipoCita ,
                                           AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels ,
                                           Integer.valueOf(AV83Disponibilidadwwds_2_tfdisponibilidadid) ,
                                           Integer.valueOf(AV84Disponibilidadwwds_3_tfdisponibilidadid_to) ,
                                           AV86Disponibilidadwwds_5_tfeventid_sel ,
                                           AV85Disponibilidadwwds_4_tfeventid ,
                                           AV88Disponibilidadwwds_7_tfdisponibilidaddescription_sel ,
                                           AV87Disponibilidadwwds_6_tfdisponibilidaddescription ,
                                           Integer.valueOf(AV89Disponibilidadwwds_8_tfprofesionalid) ,
                                           Integer.valueOf(AV90Disponibilidadwwds_9_tfprofesionalid_to) ,
                                           AV92Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel ,
                                           AV91Disponibilidadwwds_10_tfprofesionalapellidopaterno ,
                                           AV94Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel ,
                                           AV93Disponibilidadwwds_12_tfprofesionalapellidomaterno ,
                                           AV96Disponibilidadwwds_15_tfprofesionalnombres_sel ,
                                           AV95Disponibilidadwwds_14_tfprofesionalnombres ,
                                           AV98Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel ,
                                           AV97Disponibilidadwwds_16_tfprofesionalnombrecompleto ,
                                           AV100Disponibilidadwwds_19_tfprofesionalcop_sel ,
                                           AV99Disponibilidadwwds_18_tfprofesionalcop ,
                                           AV101Disponibilidadwwds_20_tfdisponibilidadfecha ,
                                           AV102Disponibilidadwwds_21_tfdisponibilidadfecha_to ,
                                           AV103Disponibilidadwwds_22_tfdisponibilidadhorainicio ,
                                           AV104Disponibilidadwwds_23_tfdisponibilidadhorainicio_to ,
                                           AV105Disponibilidadwwds_24_tfdisponibilidadhorafin ,
                                           AV106Disponibilidadwwds_25_tfdisponibilidadhorafin_to ,
                                           Short.valueOf(AV107Disponibilidadwwds_26_tfespecialidadid) ,
                                           Short.valueOf(AV108Disponibilidadwwds_27_tfespecialidadid_to) ,
                                           AV110Disponibilidadwwds_29_tfespecialidadcodigo_sel ,
                                           AV109Disponibilidadwwds_28_tfespecialidadcodigo ,
                                           AV112Disponibilidadwwds_31_tfespecialidadnombre_sel ,
                                           AV111Disponibilidadwwds_30_tfespecialidadnombre ,
                                           Integer.valueOf(AV113Disponibilidadwwds_32_tfdisponibilidaduser) ,
                                           Integer.valueOf(AV114Disponibilidadwwds_33_tfdisponibilidaduser_to) ,
                                           Integer.valueOf(AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels.size()) ,
                                           Integer.valueOf(AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels.size()) ,
                                           Integer.valueOf(AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels.size()) ,
                                           Integer.valueOf(A34DisponibilidadId) ,
                                           A133EventId ,
                                           A134DisponibilidadDescription ,
                                           Integer.valueOf(A31ProfesionalId) ,
                                           A85ProfesionalApellidoPaterno ,
                                           A86ProfesionalApellidoMaterno ,
                                           A84ProfesionalNombres ,
                                           A88ProfesionalCOP ,
                                           A67DisponibilidadFecha ,
                                           A69DisponibilidadHoraInicio ,
                                           A135DisponibilidadHoraFin ,
                                           Short.valueOf(A32EspecialidadId) ,
                                           A140EspecialidadCodigo ,
                                           A71EspecialidadNombre ,
                                           Integer.valueOf(A137DisponibilidadUser) ,
                                           AV82Disponibilidadwwds_1_filterfulltext ,
                                           A83ProfesionalNombreCompleto ,
                                           Integer.valueOf(A138DCitaId) ,
                                           Integer.valueOf(AV117Disponibilidadwwds_36_tfdcitaid) ,
                                           Integer.valueOf(AV118Disponibilidadwwds_37_tfdcitaid_to) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN,
                                           TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.BOOLEAN,
                                           TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV85Disponibilidadwwds_4_tfeventid = GXutil.padr( GXutil.rtrim( AV85Disponibilidadwwds_4_tfeventid), 20, "%") ;
      lV87Disponibilidadwwds_6_tfdisponibilidaddescription = GXutil.concat( GXutil.rtrim( AV87Disponibilidadwwds_6_tfdisponibilidaddescription), "%", "") ;
      lV91Disponibilidadwwds_10_tfprofesionalapellidopaterno = GXutil.concat( GXutil.rtrim( AV91Disponibilidadwwds_10_tfprofesionalapellidopaterno), "%", "") ;
      lV93Disponibilidadwwds_12_tfprofesionalapellidomaterno = GXutil.concat( GXutil.rtrim( AV93Disponibilidadwwds_12_tfprofesionalapellidomaterno), "%", "") ;
      lV95Disponibilidadwwds_14_tfprofesionalnombres = GXutil.concat( GXutil.rtrim( AV95Disponibilidadwwds_14_tfprofesionalnombres), "%", "") ;
      lV97Disponibilidadwwds_16_tfprofesionalnombrecompleto = GXutil.concat( GXutil.rtrim( AV97Disponibilidadwwds_16_tfprofesionalnombrecompleto), "%", "") ;
      lV99Disponibilidadwwds_18_tfprofesionalcop = GXutil.concat( GXutil.rtrim( AV99Disponibilidadwwds_18_tfprofesionalcop), "%", "") ;
      lV109Disponibilidadwwds_28_tfespecialidadcodigo = GXutil.concat( GXutil.rtrim( AV109Disponibilidadwwds_28_tfespecialidadcodigo), "%", "") ;
      lV111Disponibilidadwwds_30_tfespecialidadnombre = GXutil.concat( GXutil.rtrim( AV111Disponibilidadwwds_30_tfespecialidadnombre), "%", "") ;
      /* Using cursor P002X3 */
      pr_default.execute(0, new Object[] {AV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, Integer.valueOf(AV117Disponibilidadwwds_36_tfdcitaid), Integer.valueOf(AV117Disponibilidadwwds_36_tfdcitaid), Integer.valueOf(AV118Disponibilidadwwds_37_tfdcitaid_to), Integer.valueOf(AV118Disponibilidadwwds_37_tfdcitaid_to), Integer.valueOf(AV83Disponibilidadwwds_2_tfdisponibilidadid), Integer.valueOf(AV84Disponibilidadwwds_3_tfdisponibilidadid_to), lV85Disponibilidadwwds_4_tfeventid, AV86Disponibilidadwwds_5_tfeventid_sel, lV87Disponibilidadwwds_6_tfdisponibilidaddescription, AV88Disponibilidadwwds_7_tfdisponibilidaddescription_sel, Integer.valueOf(AV89Disponibilidadwwds_8_tfprofesionalid), Integer.valueOf(AV90Disponibilidadwwds_9_tfprofesionalid_to), lV91Disponibilidadwwds_10_tfprofesionalapellidopaterno, AV92Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel, lV93Disponibilidadwwds_12_tfprofesionalapellidomaterno, AV94Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel, lV95Disponibilidadwwds_14_tfprofesionalnombres, AV96Disponibilidadwwds_15_tfprofesionalnombres_sel, lV97Disponibilidadwwds_16_tfprofesionalnombrecompleto, AV98Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel, lV99Disponibilidadwwds_18_tfprofesionalcop, AV100Disponibilidadwwds_19_tfprofesionalcop_sel, AV101Disponibilidadwwds_20_tfdisponibilidadfecha, AV102Disponibilidadwwds_21_tfdisponibilidadfecha_to, AV103Disponibilidadwwds_22_tfdisponibilidadhorainicio, AV104Disponibilidadwwds_23_tfdisponibilidadhorainicio_to, AV105Disponibilidadwwds_24_tfdisponibilidadhorafin, AV106Disponibilidadwwds_25_tfdisponibilidadhorafin_to, Short.valueOf(AV107Disponibilidadwwds_26_tfespecialidadid), Short.valueOf(AV108Disponibilidadwwds_27_tfespecialidadid_to), lV109Disponibilidadwwds_28_tfespecialidadcodigo, AV110Disponibilidadwwds_29_tfespecialidadcodigo_sel, lV111Disponibilidadwwds_30_tfespecialidadnombre, AV112Disponibilidadwwds_31_tfespecialidadnombre_sel, Integer.valueOf(AV113Disponibilidadwwds_32_tfdisponibilidaduser), Integer.valueOf(AV114Disponibilidadwwds_33_tfdisponibilidaduser_to)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk2X2 = false ;
         A133EventId = P002X3_A133EventId[0] ;
         A137DisponibilidadUser = P002X3_A137DisponibilidadUser[0] ;
         A32EspecialidadId = P002X3_A32EspecialidadId[0] ;
         A135DisponibilidadHoraFin = P002X3_A135DisponibilidadHoraFin[0] ;
         n135DisponibilidadHoraFin = P002X3_n135DisponibilidadHoraFin[0] ;
         A69DisponibilidadHoraInicio = P002X3_A69DisponibilidadHoraInicio[0] ;
         n69DisponibilidadHoraInicio = P002X3_n69DisponibilidadHoraInicio[0] ;
         A67DisponibilidadFecha = P002X3_A67DisponibilidadFecha[0] ;
         n67DisponibilidadFecha = P002X3_n67DisponibilidadFecha[0] ;
         A31ProfesionalId = P002X3_A31ProfesionalId[0] ;
         A34DisponibilidadId = P002X3_A34DisponibilidadId[0] ;
         A298DisponibilidadTipoCita = P002X3_A298DisponibilidadTipoCita[0] ;
         A139DisponibilidadEstadoCita = P002X3_A139DisponibilidadEstadoCita[0] ;
         A136DisponibilidadEstado = P002X3_A136DisponibilidadEstado[0] ;
         A71EspecialidadNombre = P002X3_A71EspecialidadNombre[0] ;
         A140EspecialidadCodigo = P002X3_A140EspecialidadCodigo[0] ;
         A88ProfesionalCOP = P002X3_A88ProfesionalCOP[0] ;
         A83ProfesionalNombreCompleto = P002X3_A83ProfesionalNombreCompleto[0] ;
         A134DisponibilidadDescription = P002X3_A134DisponibilidadDescription[0] ;
         A138DCitaId = P002X3_A138DCitaId[0] ;
         n138DCitaId = P002X3_n138DCitaId[0] ;
         A84ProfesionalNombres = P002X3_A84ProfesionalNombres[0] ;
         A85ProfesionalApellidoPaterno = P002X3_A85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = P002X3_A86ProfesionalApellidoMaterno[0] ;
         A71EspecialidadNombre = P002X3_A71EspecialidadNombre[0] ;
         A140EspecialidadCodigo = P002X3_A140EspecialidadCodigo[0] ;
         A88ProfesionalCOP = P002X3_A88ProfesionalCOP[0] ;
         A84ProfesionalNombres = P002X3_A84ProfesionalNombres[0] ;
         A85ProfesionalApellidoPaterno = P002X3_A85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = P002X3_A86ProfesionalApellidoMaterno[0] ;
         A138DCitaId = P002X3_A138DCitaId[0] ;
         n138DCitaId = P002X3_n138DCitaId[0] ;
         AV69count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P002X3_A133EventId[0], A133EventId) == 0 ) )
         {
            brk2X2 = false ;
            A34DisponibilidadId = P002X3_A34DisponibilidadId[0] ;
            AV69count = (long)(AV69count+1) ;
            brk2X2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A133EventId)==0) )
         {
            AV61Option = A133EventId ;
            AV62Options.add(AV61Option, 0);
            AV67OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV69count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV62Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk2X2 )
         {
            brk2X2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADDISPONIBILIDADDESCRIPTIONOPTIONS' Routine */
      returnInSub = false ;
      AV15TFDisponibilidadDescription = AV57SearchTxt ;
      AV16TFDisponibilidadDescription_Sel = "" ;
      AV82Disponibilidadwwds_1_filterfulltext = AV75FilterFullText ;
      AV83Disponibilidadwwds_2_tfdisponibilidadid = AV11TFDisponibilidadId ;
      AV84Disponibilidadwwds_3_tfdisponibilidadid_to = AV12TFDisponibilidadId_To ;
      AV85Disponibilidadwwds_4_tfeventid = AV13TFEventId ;
      AV86Disponibilidadwwds_5_tfeventid_sel = AV14TFEventId_Sel ;
      AV87Disponibilidadwwds_6_tfdisponibilidaddescription = AV15TFDisponibilidadDescription ;
      AV88Disponibilidadwwds_7_tfdisponibilidaddescription_sel = AV16TFDisponibilidadDescription_Sel ;
      AV89Disponibilidadwwds_8_tfprofesionalid = AV17TFProfesionalId ;
      AV90Disponibilidadwwds_9_tfprofesionalid_to = AV18TFProfesionalId_To ;
      AV91Disponibilidadwwds_10_tfprofesionalapellidopaterno = AV19TFProfesionalApellidoPaterno ;
      AV92Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel = AV20TFProfesionalApellidoPaterno_Sel ;
      AV93Disponibilidadwwds_12_tfprofesionalapellidomaterno = AV21TFProfesionalApellidoMaterno ;
      AV94Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel = AV22TFProfesionalApellidoMaterno_Sel ;
      AV95Disponibilidadwwds_14_tfprofesionalnombres = AV23TFProfesionalNombres ;
      AV96Disponibilidadwwds_15_tfprofesionalnombres_sel = AV24TFProfesionalNombres_Sel ;
      AV97Disponibilidadwwds_16_tfprofesionalnombrecompleto = AV25TFProfesionalNombreCompleto ;
      AV98Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel = AV26TFProfesionalNombreCompleto_Sel ;
      AV99Disponibilidadwwds_18_tfprofesionalcop = AV27TFProfesionalCOP ;
      AV100Disponibilidadwwds_19_tfprofesionalcop_sel = AV28TFProfesionalCOP_Sel ;
      AV101Disponibilidadwwds_20_tfdisponibilidadfecha = AV29TFDisponibilidadFecha ;
      AV102Disponibilidadwwds_21_tfdisponibilidadfecha_to = AV30TFDisponibilidadFecha_To ;
      AV103Disponibilidadwwds_22_tfdisponibilidadhorainicio = AV31TFDisponibilidadHoraInicio ;
      AV104Disponibilidadwwds_23_tfdisponibilidadhorainicio_to = AV32TFDisponibilidadHoraInicio_To ;
      AV105Disponibilidadwwds_24_tfdisponibilidadhorafin = AV33TFDisponibilidadHoraFin ;
      AV106Disponibilidadwwds_25_tfdisponibilidadhorafin_to = AV34TFDisponibilidadHoraFin_To ;
      AV107Disponibilidadwwds_26_tfespecialidadid = AV35TFEspecialidadId ;
      AV108Disponibilidadwwds_27_tfespecialidadid_to = AV36TFEspecialidadId_To ;
      AV109Disponibilidadwwds_28_tfespecialidadcodigo = AV37TFEspecialidadCodigo ;
      AV110Disponibilidadwwds_29_tfespecialidadcodigo_sel = AV38TFEspecialidadCodigo_Sel ;
      AV111Disponibilidadwwds_30_tfespecialidadnombre = AV39TFEspecialidadNombre ;
      AV112Disponibilidadwwds_31_tfespecialidadnombre_sel = AV40TFEspecialidadNombre_Sel ;
      AV113Disponibilidadwwds_32_tfdisponibilidaduser = AV49TFDisponibilidadUser ;
      AV114Disponibilidadwwds_33_tfdisponibilidaduser_to = AV50TFDisponibilidadUser_To ;
      AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels = AV52TFDisponibilidadEstado_Sels ;
      AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels = AV54TFDisponibilidadEstadoCita_Sels ;
      AV117Disponibilidadwwds_36_tfdcitaid = AV55TFDCitaId ;
      AV118Disponibilidadwwds_37_tfdcitaid_to = AV56TFDCitaId_To ;
      AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels = AV77TFDisponibilidadTipoCita_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A136DisponibilidadEstado ,
                                           AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels ,
                                           A139DisponibilidadEstadoCita ,
                                           AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels ,
                                           A298DisponibilidadTipoCita ,
                                           AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels ,
                                           Integer.valueOf(AV83Disponibilidadwwds_2_tfdisponibilidadid) ,
                                           Integer.valueOf(AV84Disponibilidadwwds_3_tfdisponibilidadid_to) ,
                                           AV86Disponibilidadwwds_5_tfeventid_sel ,
                                           AV85Disponibilidadwwds_4_tfeventid ,
                                           AV88Disponibilidadwwds_7_tfdisponibilidaddescription_sel ,
                                           AV87Disponibilidadwwds_6_tfdisponibilidaddescription ,
                                           Integer.valueOf(AV89Disponibilidadwwds_8_tfprofesionalid) ,
                                           Integer.valueOf(AV90Disponibilidadwwds_9_tfprofesionalid_to) ,
                                           AV92Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel ,
                                           AV91Disponibilidadwwds_10_tfprofesionalapellidopaterno ,
                                           AV94Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel ,
                                           AV93Disponibilidadwwds_12_tfprofesionalapellidomaterno ,
                                           AV96Disponibilidadwwds_15_tfprofesionalnombres_sel ,
                                           AV95Disponibilidadwwds_14_tfprofesionalnombres ,
                                           AV98Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel ,
                                           AV97Disponibilidadwwds_16_tfprofesionalnombrecompleto ,
                                           AV100Disponibilidadwwds_19_tfprofesionalcop_sel ,
                                           AV99Disponibilidadwwds_18_tfprofesionalcop ,
                                           AV101Disponibilidadwwds_20_tfdisponibilidadfecha ,
                                           AV102Disponibilidadwwds_21_tfdisponibilidadfecha_to ,
                                           AV103Disponibilidadwwds_22_tfdisponibilidadhorainicio ,
                                           AV104Disponibilidadwwds_23_tfdisponibilidadhorainicio_to ,
                                           AV105Disponibilidadwwds_24_tfdisponibilidadhorafin ,
                                           AV106Disponibilidadwwds_25_tfdisponibilidadhorafin_to ,
                                           Short.valueOf(AV107Disponibilidadwwds_26_tfespecialidadid) ,
                                           Short.valueOf(AV108Disponibilidadwwds_27_tfespecialidadid_to) ,
                                           AV110Disponibilidadwwds_29_tfespecialidadcodigo_sel ,
                                           AV109Disponibilidadwwds_28_tfespecialidadcodigo ,
                                           AV112Disponibilidadwwds_31_tfespecialidadnombre_sel ,
                                           AV111Disponibilidadwwds_30_tfespecialidadnombre ,
                                           Integer.valueOf(AV113Disponibilidadwwds_32_tfdisponibilidaduser) ,
                                           Integer.valueOf(AV114Disponibilidadwwds_33_tfdisponibilidaduser_to) ,
                                           Integer.valueOf(AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels.size()) ,
                                           Integer.valueOf(AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels.size()) ,
                                           Integer.valueOf(AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels.size()) ,
                                           Integer.valueOf(A34DisponibilidadId) ,
                                           A133EventId ,
                                           A134DisponibilidadDescription ,
                                           Integer.valueOf(A31ProfesionalId) ,
                                           A85ProfesionalApellidoPaterno ,
                                           A86ProfesionalApellidoMaterno ,
                                           A84ProfesionalNombres ,
                                           A88ProfesionalCOP ,
                                           A67DisponibilidadFecha ,
                                           A69DisponibilidadHoraInicio ,
                                           A135DisponibilidadHoraFin ,
                                           Short.valueOf(A32EspecialidadId) ,
                                           A140EspecialidadCodigo ,
                                           A71EspecialidadNombre ,
                                           Integer.valueOf(A137DisponibilidadUser) ,
                                           AV82Disponibilidadwwds_1_filterfulltext ,
                                           A83ProfesionalNombreCompleto ,
                                           Integer.valueOf(A138DCitaId) ,
                                           Integer.valueOf(AV117Disponibilidadwwds_36_tfdcitaid) ,
                                           Integer.valueOf(AV118Disponibilidadwwds_37_tfdcitaid_to) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN,
                                           TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.BOOLEAN,
                                           TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV85Disponibilidadwwds_4_tfeventid = GXutil.padr( GXutil.rtrim( AV85Disponibilidadwwds_4_tfeventid), 20, "%") ;
      lV87Disponibilidadwwds_6_tfdisponibilidaddescription = GXutil.concat( GXutil.rtrim( AV87Disponibilidadwwds_6_tfdisponibilidaddescription), "%", "") ;
      lV91Disponibilidadwwds_10_tfprofesionalapellidopaterno = GXutil.concat( GXutil.rtrim( AV91Disponibilidadwwds_10_tfprofesionalapellidopaterno), "%", "") ;
      lV93Disponibilidadwwds_12_tfprofesionalapellidomaterno = GXutil.concat( GXutil.rtrim( AV93Disponibilidadwwds_12_tfprofesionalapellidomaterno), "%", "") ;
      lV95Disponibilidadwwds_14_tfprofesionalnombres = GXutil.concat( GXutil.rtrim( AV95Disponibilidadwwds_14_tfprofesionalnombres), "%", "") ;
      lV97Disponibilidadwwds_16_tfprofesionalnombrecompleto = GXutil.concat( GXutil.rtrim( AV97Disponibilidadwwds_16_tfprofesionalnombrecompleto), "%", "") ;
      lV99Disponibilidadwwds_18_tfprofesionalcop = GXutil.concat( GXutil.rtrim( AV99Disponibilidadwwds_18_tfprofesionalcop), "%", "") ;
      lV109Disponibilidadwwds_28_tfespecialidadcodigo = GXutil.concat( GXutil.rtrim( AV109Disponibilidadwwds_28_tfespecialidadcodigo), "%", "") ;
      lV111Disponibilidadwwds_30_tfespecialidadnombre = GXutil.concat( GXutil.rtrim( AV111Disponibilidadwwds_30_tfespecialidadnombre), "%", "") ;
      /* Using cursor P002X5 */
      pr_default.execute(1, new Object[] {AV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, Integer.valueOf(AV117Disponibilidadwwds_36_tfdcitaid), Integer.valueOf(AV117Disponibilidadwwds_36_tfdcitaid), Integer.valueOf(AV118Disponibilidadwwds_37_tfdcitaid_to), Integer.valueOf(AV118Disponibilidadwwds_37_tfdcitaid_to), Integer.valueOf(AV83Disponibilidadwwds_2_tfdisponibilidadid), Integer.valueOf(AV84Disponibilidadwwds_3_tfdisponibilidadid_to), lV85Disponibilidadwwds_4_tfeventid, AV86Disponibilidadwwds_5_tfeventid_sel, lV87Disponibilidadwwds_6_tfdisponibilidaddescription, AV88Disponibilidadwwds_7_tfdisponibilidaddescription_sel, Integer.valueOf(AV89Disponibilidadwwds_8_tfprofesionalid), Integer.valueOf(AV90Disponibilidadwwds_9_tfprofesionalid_to), lV91Disponibilidadwwds_10_tfprofesionalapellidopaterno, AV92Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel, lV93Disponibilidadwwds_12_tfprofesionalapellidomaterno, AV94Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel, lV95Disponibilidadwwds_14_tfprofesionalnombres, AV96Disponibilidadwwds_15_tfprofesionalnombres_sel, lV97Disponibilidadwwds_16_tfprofesionalnombrecompleto, AV98Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel, lV99Disponibilidadwwds_18_tfprofesionalcop, AV100Disponibilidadwwds_19_tfprofesionalcop_sel, AV101Disponibilidadwwds_20_tfdisponibilidadfecha, AV102Disponibilidadwwds_21_tfdisponibilidadfecha_to, AV103Disponibilidadwwds_22_tfdisponibilidadhorainicio, AV104Disponibilidadwwds_23_tfdisponibilidadhorainicio_to, AV105Disponibilidadwwds_24_tfdisponibilidadhorafin, AV106Disponibilidadwwds_25_tfdisponibilidadhorafin_to, Short.valueOf(AV107Disponibilidadwwds_26_tfespecialidadid), Short.valueOf(AV108Disponibilidadwwds_27_tfespecialidadid_to), lV109Disponibilidadwwds_28_tfespecialidadcodigo, AV110Disponibilidadwwds_29_tfespecialidadcodigo_sel, lV111Disponibilidadwwds_30_tfespecialidadnombre, AV112Disponibilidadwwds_31_tfespecialidadnombre_sel, Integer.valueOf(AV113Disponibilidadwwds_32_tfdisponibilidaduser), Integer.valueOf(AV114Disponibilidadwwds_33_tfdisponibilidaduser_to)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk2X4 = false ;
         A134DisponibilidadDescription = P002X5_A134DisponibilidadDescription[0] ;
         A137DisponibilidadUser = P002X5_A137DisponibilidadUser[0] ;
         A32EspecialidadId = P002X5_A32EspecialidadId[0] ;
         A135DisponibilidadHoraFin = P002X5_A135DisponibilidadHoraFin[0] ;
         n135DisponibilidadHoraFin = P002X5_n135DisponibilidadHoraFin[0] ;
         A69DisponibilidadHoraInicio = P002X5_A69DisponibilidadHoraInicio[0] ;
         n69DisponibilidadHoraInicio = P002X5_n69DisponibilidadHoraInicio[0] ;
         A67DisponibilidadFecha = P002X5_A67DisponibilidadFecha[0] ;
         n67DisponibilidadFecha = P002X5_n67DisponibilidadFecha[0] ;
         A31ProfesionalId = P002X5_A31ProfesionalId[0] ;
         A34DisponibilidadId = P002X5_A34DisponibilidadId[0] ;
         A298DisponibilidadTipoCita = P002X5_A298DisponibilidadTipoCita[0] ;
         A139DisponibilidadEstadoCita = P002X5_A139DisponibilidadEstadoCita[0] ;
         A136DisponibilidadEstado = P002X5_A136DisponibilidadEstado[0] ;
         A71EspecialidadNombre = P002X5_A71EspecialidadNombre[0] ;
         A140EspecialidadCodigo = P002X5_A140EspecialidadCodigo[0] ;
         A88ProfesionalCOP = P002X5_A88ProfesionalCOP[0] ;
         A83ProfesionalNombreCompleto = P002X5_A83ProfesionalNombreCompleto[0] ;
         A133EventId = P002X5_A133EventId[0] ;
         A138DCitaId = P002X5_A138DCitaId[0] ;
         n138DCitaId = P002X5_n138DCitaId[0] ;
         A84ProfesionalNombres = P002X5_A84ProfesionalNombres[0] ;
         A85ProfesionalApellidoPaterno = P002X5_A85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = P002X5_A86ProfesionalApellidoMaterno[0] ;
         A71EspecialidadNombre = P002X5_A71EspecialidadNombre[0] ;
         A140EspecialidadCodigo = P002X5_A140EspecialidadCodigo[0] ;
         A88ProfesionalCOP = P002X5_A88ProfesionalCOP[0] ;
         A84ProfesionalNombres = P002X5_A84ProfesionalNombres[0] ;
         A85ProfesionalApellidoPaterno = P002X5_A85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = P002X5_A86ProfesionalApellidoMaterno[0] ;
         A138DCitaId = P002X5_A138DCitaId[0] ;
         n138DCitaId = P002X5_n138DCitaId[0] ;
         AV69count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P002X5_A134DisponibilidadDescription[0], A134DisponibilidadDescription) == 0 ) )
         {
            brk2X4 = false ;
            A34DisponibilidadId = P002X5_A34DisponibilidadId[0] ;
            AV69count = (long)(AV69count+1) ;
            brk2X4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A134DisponibilidadDescription)==0) )
         {
            AV61Option = A134DisponibilidadDescription ;
            AV62Options.add(AV61Option, 0);
            AV67OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV69count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV62Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk2X4 )
         {
            brk2X4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADPROFESIONALAPELLIDOPATERNOOPTIONS' Routine */
      returnInSub = false ;
      AV19TFProfesionalApellidoPaterno = AV57SearchTxt ;
      AV20TFProfesionalApellidoPaterno_Sel = "" ;
      AV82Disponibilidadwwds_1_filterfulltext = AV75FilterFullText ;
      AV83Disponibilidadwwds_2_tfdisponibilidadid = AV11TFDisponibilidadId ;
      AV84Disponibilidadwwds_3_tfdisponibilidadid_to = AV12TFDisponibilidadId_To ;
      AV85Disponibilidadwwds_4_tfeventid = AV13TFEventId ;
      AV86Disponibilidadwwds_5_tfeventid_sel = AV14TFEventId_Sel ;
      AV87Disponibilidadwwds_6_tfdisponibilidaddescription = AV15TFDisponibilidadDescription ;
      AV88Disponibilidadwwds_7_tfdisponibilidaddescription_sel = AV16TFDisponibilidadDescription_Sel ;
      AV89Disponibilidadwwds_8_tfprofesionalid = AV17TFProfesionalId ;
      AV90Disponibilidadwwds_9_tfprofesionalid_to = AV18TFProfesionalId_To ;
      AV91Disponibilidadwwds_10_tfprofesionalapellidopaterno = AV19TFProfesionalApellidoPaterno ;
      AV92Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel = AV20TFProfesionalApellidoPaterno_Sel ;
      AV93Disponibilidadwwds_12_tfprofesionalapellidomaterno = AV21TFProfesionalApellidoMaterno ;
      AV94Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel = AV22TFProfesionalApellidoMaterno_Sel ;
      AV95Disponibilidadwwds_14_tfprofesionalnombres = AV23TFProfesionalNombres ;
      AV96Disponibilidadwwds_15_tfprofesionalnombres_sel = AV24TFProfesionalNombres_Sel ;
      AV97Disponibilidadwwds_16_tfprofesionalnombrecompleto = AV25TFProfesionalNombreCompleto ;
      AV98Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel = AV26TFProfesionalNombreCompleto_Sel ;
      AV99Disponibilidadwwds_18_tfprofesionalcop = AV27TFProfesionalCOP ;
      AV100Disponibilidadwwds_19_tfprofesionalcop_sel = AV28TFProfesionalCOP_Sel ;
      AV101Disponibilidadwwds_20_tfdisponibilidadfecha = AV29TFDisponibilidadFecha ;
      AV102Disponibilidadwwds_21_tfdisponibilidadfecha_to = AV30TFDisponibilidadFecha_To ;
      AV103Disponibilidadwwds_22_tfdisponibilidadhorainicio = AV31TFDisponibilidadHoraInicio ;
      AV104Disponibilidadwwds_23_tfdisponibilidadhorainicio_to = AV32TFDisponibilidadHoraInicio_To ;
      AV105Disponibilidadwwds_24_tfdisponibilidadhorafin = AV33TFDisponibilidadHoraFin ;
      AV106Disponibilidadwwds_25_tfdisponibilidadhorafin_to = AV34TFDisponibilidadHoraFin_To ;
      AV107Disponibilidadwwds_26_tfespecialidadid = AV35TFEspecialidadId ;
      AV108Disponibilidadwwds_27_tfespecialidadid_to = AV36TFEspecialidadId_To ;
      AV109Disponibilidadwwds_28_tfespecialidadcodigo = AV37TFEspecialidadCodigo ;
      AV110Disponibilidadwwds_29_tfespecialidadcodigo_sel = AV38TFEspecialidadCodigo_Sel ;
      AV111Disponibilidadwwds_30_tfespecialidadnombre = AV39TFEspecialidadNombre ;
      AV112Disponibilidadwwds_31_tfespecialidadnombre_sel = AV40TFEspecialidadNombre_Sel ;
      AV113Disponibilidadwwds_32_tfdisponibilidaduser = AV49TFDisponibilidadUser ;
      AV114Disponibilidadwwds_33_tfdisponibilidaduser_to = AV50TFDisponibilidadUser_To ;
      AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels = AV52TFDisponibilidadEstado_Sels ;
      AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels = AV54TFDisponibilidadEstadoCita_Sels ;
      AV117Disponibilidadwwds_36_tfdcitaid = AV55TFDCitaId ;
      AV118Disponibilidadwwds_37_tfdcitaid_to = AV56TFDCitaId_To ;
      AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels = AV77TFDisponibilidadTipoCita_Sels ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A136DisponibilidadEstado ,
                                           AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels ,
                                           A139DisponibilidadEstadoCita ,
                                           AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels ,
                                           A298DisponibilidadTipoCita ,
                                           AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels ,
                                           Integer.valueOf(AV83Disponibilidadwwds_2_tfdisponibilidadid) ,
                                           Integer.valueOf(AV84Disponibilidadwwds_3_tfdisponibilidadid_to) ,
                                           AV86Disponibilidadwwds_5_tfeventid_sel ,
                                           AV85Disponibilidadwwds_4_tfeventid ,
                                           AV88Disponibilidadwwds_7_tfdisponibilidaddescription_sel ,
                                           AV87Disponibilidadwwds_6_tfdisponibilidaddescription ,
                                           Integer.valueOf(AV89Disponibilidadwwds_8_tfprofesionalid) ,
                                           Integer.valueOf(AV90Disponibilidadwwds_9_tfprofesionalid_to) ,
                                           AV92Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel ,
                                           AV91Disponibilidadwwds_10_tfprofesionalapellidopaterno ,
                                           AV94Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel ,
                                           AV93Disponibilidadwwds_12_tfprofesionalapellidomaterno ,
                                           AV96Disponibilidadwwds_15_tfprofesionalnombres_sel ,
                                           AV95Disponibilidadwwds_14_tfprofesionalnombres ,
                                           AV98Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel ,
                                           AV97Disponibilidadwwds_16_tfprofesionalnombrecompleto ,
                                           AV100Disponibilidadwwds_19_tfprofesionalcop_sel ,
                                           AV99Disponibilidadwwds_18_tfprofesionalcop ,
                                           AV101Disponibilidadwwds_20_tfdisponibilidadfecha ,
                                           AV102Disponibilidadwwds_21_tfdisponibilidadfecha_to ,
                                           AV103Disponibilidadwwds_22_tfdisponibilidadhorainicio ,
                                           AV104Disponibilidadwwds_23_tfdisponibilidadhorainicio_to ,
                                           AV105Disponibilidadwwds_24_tfdisponibilidadhorafin ,
                                           AV106Disponibilidadwwds_25_tfdisponibilidadhorafin_to ,
                                           Short.valueOf(AV107Disponibilidadwwds_26_tfespecialidadid) ,
                                           Short.valueOf(AV108Disponibilidadwwds_27_tfespecialidadid_to) ,
                                           AV110Disponibilidadwwds_29_tfespecialidadcodigo_sel ,
                                           AV109Disponibilidadwwds_28_tfespecialidadcodigo ,
                                           AV112Disponibilidadwwds_31_tfespecialidadnombre_sel ,
                                           AV111Disponibilidadwwds_30_tfespecialidadnombre ,
                                           Integer.valueOf(AV113Disponibilidadwwds_32_tfdisponibilidaduser) ,
                                           Integer.valueOf(AV114Disponibilidadwwds_33_tfdisponibilidaduser_to) ,
                                           Integer.valueOf(AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels.size()) ,
                                           Integer.valueOf(AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels.size()) ,
                                           Integer.valueOf(AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels.size()) ,
                                           Integer.valueOf(A34DisponibilidadId) ,
                                           A133EventId ,
                                           A134DisponibilidadDescription ,
                                           Integer.valueOf(A31ProfesionalId) ,
                                           A85ProfesionalApellidoPaterno ,
                                           A86ProfesionalApellidoMaterno ,
                                           A84ProfesionalNombres ,
                                           A88ProfesionalCOP ,
                                           A67DisponibilidadFecha ,
                                           A69DisponibilidadHoraInicio ,
                                           A135DisponibilidadHoraFin ,
                                           Short.valueOf(A32EspecialidadId) ,
                                           A140EspecialidadCodigo ,
                                           A71EspecialidadNombre ,
                                           Integer.valueOf(A137DisponibilidadUser) ,
                                           AV82Disponibilidadwwds_1_filterfulltext ,
                                           A83ProfesionalNombreCompleto ,
                                           Integer.valueOf(A138DCitaId) ,
                                           Integer.valueOf(AV117Disponibilidadwwds_36_tfdcitaid) ,
                                           Integer.valueOf(AV118Disponibilidadwwds_37_tfdcitaid_to) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN,
                                           TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.BOOLEAN,
                                           TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV85Disponibilidadwwds_4_tfeventid = GXutil.padr( GXutil.rtrim( AV85Disponibilidadwwds_4_tfeventid), 20, "%") ;
      lV87Disponibilidadwwds_6_tfdisponibilidaddescription = GXutil.concat( GXutil.rtrim( AV87Disponibilidadwwds_6_tfdisponibilidaddescription), "%", "") ;
      lV91Disponibilidadwwds_10_tfprofesionalapellidopaterno = GXutil.concat( GXutil.rtrim( AV91Disponibilidadwwds_10_tfprofesionalapellidopaterno), "%", "") ;
      lV93Disponibilidadwwds_12_tfprofesionalapellidomaterno = GXutil.concat( GXutil.rtrim( AV93Disponibilidadwwds_12_tfprofesionalapellidomaterno), "%", "") ;
      lV95Disponibilidadwwds_14_tfprofesionalnombres = GXutil.concat( GXutil.rtrim( AV95Disponibilidadwwds_14_tfprofesionalnombres), "%", "") ;
      lV97Disponibilidadwwds_16_tfprofesionalnombrecompleto = GXutil.concat( GXutil.rtrim( AV97Disponibilidadwwds_16_tfprofesionalnombrecompleto), "%", "") ;
      lV99Disponibilidadwwds_18_tfprofesionalcop = GXutil.concat( GXutil.rtrim( AV99Disponibilidadwwds_18_tfprofesionalcop), "%", "") ;
      lV109Disponibilidadwwds_28_tfespecialidadcodigo = GXutil.concat( GXutil.rtrim( AV109Disponibilidadwwds_28_tfespecialidadcodigo), "%", "") ;
      lV111Disponibilidadwwds_30_tfespecialidadnombre = GXutil.concat( GXutil.rtrim( AV111Disponibilidadwwds_30_tfespecialidadnombre), "%", "") ;
      /* Using cursor P002X7 */
      pr_default.execute(2, new Object[] {AV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, Integer.valueOf(AV117Disponibilidadwwds_36_tfdcitaid), Integer.valueOf(AV117Disponibilidadwwds_36_tfdcitaid), Integer.valueOf(AV118Disponibilidadwwds_37_tfdcitaid_to), Integer.valueOf(AV118Disponibilidadwwds_37_tfdcitaid_to), Integer.valueOf(AV83Disponibilidadwwds_2_tfdisponibilidadid), Integer.valueOf(AV84Disponibilidadwwds_3_tfdisponibilidadid_to), lV85Disponibilidadwwds_4_tfeventid, AV86Disponibilidadwwds_5_tfeventid_sel, lV87Disponibilidadwwds_6_tfdisponibilidaddescription, AV88Disponibilidadwwds_7_tfdisponibilidaddescription_sel, Integer.valueOf(AV89Disponibilidadwwds_8_tfprofesionalid), Integer.valueOf(AV90Disponibilidadwwds_9_tfprofesionalid_to), lV91Disponibilidadwwds_10_tfprofesionalapellidopaterno, AV92Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel, lV93Disponibilidadwwds_12_tfprofesionalapellidomaterno, AV94Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel, lV95Disponibilidadwwds_14_tfprofesionalnombres, AV96Disponibilidadwwds_15_tfprofesionalnombres_sel, lV97Disponibilidadwwds_16_tfprofesionalnombrecompleto, AV98Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel, lV99Disponibilidadwwds_18_tfprofesionalcop, AV100Disponibilidadwwds_19_tfprofesionalcop_sel, AV101Disponibilidadwwds_20_tfdisponibilidadfecha, AV102Disponibilidadwwds_21_tfdisponibilidadfecha_to, AV103Disponibilidadwwds_22_tfdisponibilidadhorainicio, AV104Disponibilidadwwds_23_tfdisponibilidadhorainicio_to, AV105Disponibilidadwwds_24_tfdisponibilidadhorafin, AV106Disponibilidadwwds_25_tfdisponibilidadhorafin_to, Short.valueOf(AV107Disponibilidadwwds_26_tfespecialidadid), Short.valueOf(AV108Disponibilidadwwds_27_tfespecialidadid_to), lV109Disponibilidadwwds_28_tfespecialidadcodigo, AV110Disponibilidadwwds_29_tfespecialidadcodigo_sel, lV111Disponibilidadwwds_30_tfespecialidadnombre, AV112Disponibilidadwwds_31_tfespecialidadnombre_sel, Integer.valueOf(AV113Disponibilidadwwds_32_tfdisponibilidaduser), Integer.valueOf(AV114Disponibilidadwwds_33_tfdisponibilidaduser_to)});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brk2X6 = false ;
         A137DisponibilidadUser = P002X7_A137DisponibilidadUser[0] ;
         A32EspecialidadId = P002X7_A32EspecialidadId[0] ;
         A135DisponibilidadHoraFin = P002X7_A135DisponibilidadHoraFin[0] ;
         n135DisponibilidadHoraFin = P002X7_n135DisponibilidadHoraFin[0] ;
         A69DisponibilidadHoraInicio = P002X7_A69DisponibilidadHoraInicio[0] ;
         n69DisponibilidadHoraInicio = P002X7_n69DisponibilidadHoraInicio[0] ;
         A67DisponibilidadFecha = P002X7_A67DisponibilidadFecha[0] ;
         n67DisponibilidadFecha = P002X7_n67DisponibilidadFecha[0] ;
         A31ProfesionalId = P002X7_A31ProfesionalId[0] ;
         A34DisponibilidadId = P002X7_A34DisponibilidadId[0] ;
         A298DisponibilidadTipoCita = P002X7_A298DisponibilidadTipoCita[0] ;
         A139DisponibilidadEstadoCita = P002X7_A139DisponibilidadEstadoCita[0] ;
         A136DisponibilidadEstado = P002X7_A136DisponibilidadEstado[0] ;
         A71EspecialidadNombre = P002X7_A71EspecialidadNombre[0] ;
         A140EspecialidadCodigo = P002X7_A140EspecialidadCodigo[0] ;
         A88ProfesionalCOP = P002X7_A88ProfesionalCOP[0] ;
         A83ProfesionalNombreCompleto = P002X7_A83ProfesionalNombreCompleto[0] ;
         A134DisponibilidadDescription = P002X7_A134DisponibilidadDescription[0] ;
         A133EventId = P002X7_A133EventId[0] ;
         A138DCitaId = P002X7_A138DCitaId[0] ;
         n138DCitaId = P002X7_n138DCitaId[0] ;
         A84ProfesionalNombres = P002X7_A84ProfesionalNombres[0] ;
         A85ProfesionalApellidoPaterno = P002X7_A85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = P002X7_A86ProfesionalApellidoMaterno[0] ;
         A71EspecialidadNombre = P002X7_A71EspecialidadNombre[0] ;
         A140EspecialidadCodigo = P002X7_A140EspecialidadCodigo[0] ;
         A88ProfesionalCOP = P002X7_A88ProfesionalCOP[0] ;
         A84ProfesionalNombres = P002X7_A84ProfesionalNombres[0] ;
         A85ProfesionalApellidoPaterno = P002X7_A85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = P002X7_A86ProfesionalApellidoMaterno[0] ;
         A138DCitaId = P002X7_A138DCitaId[0] ;
         n138DCitaId = P002X7_n138DCitaId[0] ;
         AV69count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( GXutil.strcmp(P002X7_A85ProfesionalApellidoPaterno[0], A85ProfesionalApellidoPaterno) == 0 ) )
         {
            brk2X6 = false ;
            A31ProfesionalId = P002X7_A31ProfesionalId[0] ;
            A34DisponibilidadId = P002X7_A34DisponibilidadId[0] ;
            AV69count = (long)(AV69count+1) ;
            brk2X6 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A85ProfesionalApellidoPaterno)==0) )
         {
            AV61Option = A85ProfesionalApellidoPaterno ;
            AV62Options.add(AV61Option, 0);
            AV67OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV69count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV62Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk2X6 )
         {
            brk2X6 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   public void S151( )
   {
      /* 'LOADPROFESIONALAPELLIDOMATERNOOPTIONS' Routine */
      returnInSub = false ;
      AV21TFProfesionalApellidoMaterno = AV57SearchTxt ;
      AV22TFProfesionalApellidoMaterno_Sel = "" ;
      AV82Disponibilidadwwds_1_filterfulltext = AV75FilterFullText ;
      AV83Disponibilidadwwds_2_tfdisponibilidadid = AV11TFDisponibilidadId ;
      AV84Disponibilidadwwds_3_tfdisponibilidadid_to = AV12TFDisponibilidadId_To ;
      AV85Disponibilidadwwds_4_tfeventid = AV13TFEventId ;
      AV86Disponibilidadwwds_5_tfeventid_sel = AV14TFEventId_Sel ;
      AV87Disponibilidadwwds_6_tfdisponibilidaddescription = AV15TFDisponibilidadDescription ;
      AV88Disponibilidadwwds_7_tfdisponibilidaddescription_sel = AV16TFDisponibilidadDescription_Sel ;
      AV89Disponibilidadwwds_8_tfprofesionalid = AV17TFProfesionalId ;
      AV90Disponibilidadwwds_9_tfprofesionalid_to = AV18TFProfesionalId_To ;
      AV91Disponibilidadwwds_10_tfprofesionalapellidopaterno = AV19TFProfesionalApellidoPaterno ;
      AV92Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel = AV20TFProfesionalApellidoPaterno_Sel ;
      AV93Disponibilidadwwds_12_tfprofesionalapellidomaterno = AV21TFProfesionalApellidoMaterno ;
      AV94Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel = AV22TFProfesionalApellidoMaterno_Sel ;
      AV95Disponibilidadwwds_14_tfprofesionalnombres = AV23TFProfesionalNombres ;
      AV96Disponibilidadwwds_15_tfprofesionalnombres_sel = AV24TFProfesionalNombres_Sel ;
      AV97Disponibilidadwwds_16_tfprofesionalnombrecompleto = AV25TFProfesionalNombreCompleto ;
      AV98Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel = AV26TFProfesionalNombreCompleto_Sel ;
      AV99Disponibilidadwwds_18_tfprofesionalcop = AV27TFProfesionalCOP ;
      AV100Disponibilidadwwds_19_tfprofesionalcop_sel = AV28TFProfesionalCOP_Sel ;
      AV101Disponibilidadwwds_20_tfdisponibilidadfecha = AV29TFDisponibilidadFecha ;
      AV102Disponibilidadwwds_21_tfdisponibilidadfecha_to = AV30TFDisponibilidadFecha_To ;
      AV103Disponibilidadwwds_22_tfdisponibilidadhorainicio = AV31TFDisponibilidadHoraInicio ;
      AV104Disponibilidadwwds_23_tfdisponibilidadhorainicio_to = AV32TFDisponibilidadHoraInicio_To ;
      AV105Disponibilidadwwds_24_tfdisponibilidadhorafin = AV33TFDisponibilidadHoraFin ;
      AV106Disponibilidadwwds_25_tfdisponibilidadhorafin_to = AV34TFDisponibilidadHoraFin_To ;
      AV107Disponibilidadwwds_26_tfespecialidadid = AV35TFEspecialidadId ;
      AV108Disponibilidadwwds_27_tfespecialidadid_to = AV36TFEspecialidadId_To ;
      AV109Disponibilidadwwds_28_tfespecialidadcodigo = AV37TFEspecialidadCodigo ;
      AV110Disponibilidadwwds_29_tfespecialidadcodigo_sel = AV38TFEspecialidadCodigo_Sel ;
      AV111Disponibilidadwwds_30_tfespecialidadnombre = AV39TFEspecialidadNombre ;
      AV112Disponibilidadwwds_31_tfespecialidadnombre_sel = AV40TFEspecialidadNombre_Sel ;
      AV113Disponibilidadwwds_32_tfdisponibilidaduser = AV49TFDisponibilidadUser ;
      AV114Disponibilidadwwds_33_tfdisponibilidaduser_to = AV50TFDisponibilidadUser_To ;
      AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels = AV52TFDisponibilidadEstado_Sels ;
      AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels = AV54TFDisponibilidadEstadoCita_Sels ;
      AV117Disponibilidadwwds_36_tfdcitaid = AV55TFDCitaId ;
      AV118Disponibilidadwwds_37_tfdcitaid_to = AV56TFDCitaId_To ;
      AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels = AV77TFDisponibilidadTipoCita_Sels ;
      pr_default.dynParam(3, new Object[]{ new Object[]{
                                           A136DisponibilidadEstado ,
                                           AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels ,
                                           A139DisponibilidadEstadoCita ,
                                           AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels ,
                                           A298DisponibilidadTipoCita ,
                                           AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels ,
                                           Integer.valueOf(AV83Disponibilidadwwds_2_tfdisponibilidadid) ,
                                           Integer.valueOf(AV84Disponibilidadwwds_3_tfdisponibilidadid_to) ,
                                           AV86Disponibilidadwwds_5_tfeventid_sel ,
                                           AV85Disponibilidadwwds_4_tfeventid ,
                                           AV88Disponibilidadwwds_7_tfdisponibilidaddescription_sel ,
                                           AV87Disponibilidadwwds_6_tfdisponibilidaddescription ,
                                           Integer.valueOf(AV89Disponibilidadwwds_8_tfprofesionalid) ,
                                           Integer.valueOf(AV90Disponibilidadwwds_9_tfprofesionalid_to) ,
                                           AV92Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel ,
                                           AV91Disponibilidadwwds_10_tfprofesionalapellidopaterno ,
                                           AV94Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel ,
                                           AV93Disponibilidadwwds_12_tfprofesionalapellidomaterno ,
                                           AV96Disponibilidadwwds_15_tfprofesionalnombres_sel ,
                                           AV95Disponibilidadwwds_14_tfprofesionalnombres ,
                                           AV98Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel ,
                                           AV97Disponibilidadwwds_16_tfprofesionalnombrecompleto ,
                                           AV100Disponibilidadwwds_19_tfprofesionalcop_sel ,
                                           AV99Disponibilidadwwds_18_tfprofesionalcop ,
                                           AV101Disponibilidadwwds_20_tfdisponibilidadfecha ,
                                           AV102Disponibilidadwwds_21_tfdisponibilidadfecha_to ,
                                           AV103Disponibilidadwwds_22_tfdisponibilidadhorainicio ,
                                           AV104Disponibilidadwwds_23_tfdisponibilidadhorainicio_to ,
                                           AV105Disponibilidadwwds_24_tfdisponibilidadhorafin ,
                                           AV106Disponibilidadwwds_25_tfdisponibilidadhorafin_to ,
                                           Short.valueOf(AV107Disponibilidadwwds_26_tfespecialidadid) ,
                                           Short.valueOf(AV108Disponibilidadwwds_27_tfespecialidadid_to) ,
                                           AV110Disponibilidadwwds_29_tfespecialidadcodigo_sel ,
                                           AV109Disponibilidadwwds_28_tfespecialidadcodigo ,
                                           AV112Disponibilidadwwds_31_tfespecialidadnombre_sel ,
                                           AV111Disponibilidadwwds_30_tfespecialidadnombre ,
                                           Integer.valueOf(AV113Disponibilidadwwds_32_tfdisponibilidaduser) ,
                                           Integer.valueOf(AV114Disponibilidadwwds_33_tfdisponibilidaduser_to) ,
                                           Integer.valueOf(AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels.size()) ,
                                           Integer.valueOf(AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels.size()) ,
                                           Integer.valueOf(AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels.size()) ,
                                           Integer.valueOf(A34DisponibilidadId) ,
                                           A133EventId ,
                                           A134DisponibilidadDescription ,
                                           Integer.valueOf(A31ProfesionalId) ,
                                           A85ProfesionalApellidoPaterno ,
                                           A86ProfesionalApellidoMaterno ,
                                           A84ProfesionalNombres ,
                                           A88ProfesionalCOP ,
                                           A67DisponibilidadFecha ,
                                           A69DisponibilidadHoraInicio ,
                                           A135DisponibilidadHoraFin ,
                                           Short.valueOf(A32EspecialidadId) ,
                                           A140EspecialidadCodigo ,
                                           A71EspecialidadNombre ,
                                           Integer.valueOf(A137DisponibilidadUser) ,
                                           AV82Disponibilidadwwds_1_filterfulltext ,
                                           A83ProfesionalNombreCompleto ,
                                           Integer.valueOf(A138DCitaId) ,
                                           Integer.valueOf(AV117Disponibilidadwwds_36_tfdcitaid) ,
                                           Integer.valueOf(AV118Disponibilidadwwds_37_tfdcitaid_to) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN,
                                           TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.BOOLEAN,
                                           TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV85Disponibilidadwwds_4_tfeventid = GXutil.padr( GXutil.rtrim( AV85Disponibilidadwwds_4_tfeventid), 20, "%") ;
      lV87Disponibilidadwwds_6_tfdisponibilidaddescription = GXutil.concat( GXutil.rtrim( AV87Disponibilidadwwds_6_tfdisponibilidaddescription), "%", "") ;
      lV91Disponibilidadwwds_10_tfprofesionalapellidopaterno = GXutil.concat( GXutil.rtrim( AV91Disponibilidadwwds_10_tfprofesionalapellidopaterno), "%", "") ;
      lV93Disponibilidadwwds_12_tfprofesionalapellidomaterno = GXutil.concat( GXutil.rtrim( AV93Disponibilidadwwds_12_tfprofesionalapellidomaterno), "%", "") ;
      lV95Disponibilidadwwds_14_tfprofesionalnombres = GXutil.concat( GXutil.rtrim( AV95Disponibilidadwwds_14_tfprofesionalnombres), "%", "") ;
      lV97Disponibilidadwwds_16_tfprofesionalnombrecompleto = GXutil.concat( GXutil.rtrim( AV97Disponibilidadwwds_16_tfprofesionalnombrecompleto), "%", "") ;
      lV99Disponibilidadwwds_18_tfprofesionalcop = GXutil.concat( GXutil.rtrim( AV99Disponibilidadwwds_18_tfprofesionalcop), "%", "") ;
      lV109Disponibilidadwwds_28_tfespecialidadcodigo = GXutil.concat( GXutil.rtrim( AV109Disponibilidadwwds_28_tfespecialidadcodigo), "%", "") ;
      lV111Disponibilidadwwds_30_tfespecialidadnombre = GXutil.concat( GXutil.rtrim( AV111Disponibilidadwwds_30_tfespecialidadnombre), "%", "") ;
      /* Using cursor P002X9 */
      pr_default.execute(3, new Object[] {AV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, Integer.valueOf(AV117Disponibilidadwwds_36_tfdcitaid), Integer.valueOf(AV117Disponibilidadwwds_36_tfdcitaid), Integer.valueOf(AV118Disponibilidadwwds_37_tfdcitaid_to), Integer.valueOf(AV118Disponibilidadwwds_37_tfdcitaid_to), Integer.valueOf(AV83Disponibilidadwwds_2_tfdisponibilidadid), Integer.valueOf(AV84Disponibilidadwwds_3_tfdisponibilidadid_to), lV85Disponibilidadwwds_4_tfeventid, AV86Disponibilidadwwds_5_tfeventid_sel, lV87Disponibilidadwwds_6_tfdisponibilidaddescription, AV88Disponibilidadwwds_7_tfdisponibilidaddescription_sel, Integer.valueOf(AV89Disponibilidadwwds_8_tfprofesionalid), Integer.valueOf(AV90Disponibilidadwwds_9_tfprofesionalid_to), lV91Disponibilidadwwds_10_tfprofesionalapellidopaterno, AV92Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel, lV93Disponibilidadwwds_12_tfprofesionalapellidomaterno, AV94Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel, lV95Disponibilidadwwds_14_tfprofesionalnombres, AV96Disponibilidadwwds_15_tfprofesionalnombres_sel, lV97Disponibilidadwwds_16_tfprofesionalnombrecompleto, AV98Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel, lV99Disponibilidadwwds_18_tfprofesionalcop, AV100Disponibilidadwwds_19_tfprofesionalcop_sel, AV101Disponibilidadwwds_20_tfdisponibilidadfecha, AV102Disponibilidadwwds_21_tfdisponibilidadfecha_to, AV103Disponibilidadwwds_22_tfdisponibilidadhorainicio, AV104Disponibilidadwwds_23_tfdisponibilidadhorainicio_to, AV105Disponibilidadwwds_24_tfdisponibilidadhorafin, AV106Disponibilidadwwds_25_tfdisponibilidadhorafin_to, Short.valueOf(AV107Disponibilidadwwds_26_tfespecialidadid), Short.valueOf(AV108Disponibilidadwwds_27_tfespecialidadid_to), lV109Disponibilidadwwds_28_tfespecialidadcodigo, AV110Disponibilidadwwds_29_tfespecialidadcodigo_sel, lV111Disponibilidadwwds_30_tfespecialidadnombre, AV112Disponibilidadwwds_31_tfespecialidadnombre_sel, Integer.valueOf(AV113Disponibilidadwwds_32_tfdisponibilidaduser), Integer.valueOf(AV114Disponibilidadwwds_33_tfdisponibilidaduser_to)});
      while ( (pr_default.getStatus(3) != 101) )
      {
         brk2X8 = false ;
         A137DisponibilidadUser = P002X9_A137DisponibilidadUser[0] ;
         A32EspecialidadId = P002X9_A32EspecialidadId[0] ;
         A135DisponibilidadHoraFin = P002X9_A135DisponibilidadHoraFin[0] ;
         n135DisponibilidadHoraFin = P002X9_n135DisponibilidadHoraFin[0] ;
         A69DisponibilidadHoraInicio = P002X9_A69DisponibilidadHoraInicio[0] ;
         n69DisponibilidadHoraInicio = P002X9_n69DisponibilidadHoraInicio[0] ;
         A67DisponibilidadFecha = P002X9_A67DisponibilidadFecha[0] ;
         n67DisponibilidadFecha = P002X9_n67DisponibilidadFecha[0] ;
         A31ProfesionalId = P002X9_A31ProfesionalId[0] ;
         A34DisponibilidadId = P002X9_A34DisponibilidadId[0] ;
         A298DisponibilidadTipoCita = P002X9_A298DisponibilidadTipoCita[0] ;
         A139DisponibilidadEstadoCita = P002X9_A139DisponibilidadEstadoCita[0] ;
         A136DisponibilidadEstado = P002X9_A136DisponibilidadEstado[0] ;
         A71EspecialidadNombre = P002X9_A71EspecialidadNombre[0] ;
         A140EspecialidadCodigo = P002X9_A140EspecialidadCodigo[0] ;
         A88ProfesionalCOP = P002X9_A88ProfesionalCOP[0] ;
         A83ProfesionalNombreCompleto = P002X9_A83ProfesionalNombreCompleto[0] ;
         A134DisponibilidadDescription = P002X9_A134DisponibilidadDescription[0] ;
         A133EventId = P002X9_A133EventId[0] ;
         A138DCitaId = P002X9_A138DCitaId[0] ;
         n138DCitaId = P002X9_n138DCitaId[0] ;
         A84ProfesionalNombres = P002X9_A84ProfesionalNombres[0] ;
         A85ProfesionalApellidoPaterno = P002X9_A85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = P002X9_A86ProfesionalApellidoMaterno[0] ;
         A71EspecialidadNombre = P002X9_A71EspecialidadNombre[0] ;
         A140EspecialidadCodigo = P002X9_A140EspecialidadCodigo[0] ;
         A88ProfesionalCOP = P002X9_A88ProfesionalCOP[0] ;
         A84ProfesionalNombres = P002X9_A84ProfesionalNombres[0] ;
         A85ProfesionalApellidoPaterno = P002X9_A85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = P002X9_A86ProfesionalApellidoMaterno[0] ;
         A138DCitaId = P002X9_A138DCitaId[0] ;
         n138DCitaId = P002X9_n138DCitaId[0] ;
         AV69count = 0 ;
         while ( (pr_default.getStatus(3) != 101) && ( GXutil.strcmp(P002X9_A86ProfesionalApellidoMaterno[0], A86ProfesionalApellidoMaterno) == 0 ) )
         {
            brk2X8 = false ;
            A31ProfesionalId = P002X9_A31ProfesionalId[0] ;
            A34DisponibilidadId = P002X9_A34DisponibilidadId[0] ;
            AV69count = (long)(AV69count+1) ;
            brk2X8 = true ;
            pr_default.readNext(3);
         }
         if ( ! (GXutil.strcmp("", A86ProfesionalApellidoMaterno)==0) )
         {
            AV61Option = A86ProfesionalApellidoMaterno ;
            AV62Options.add(AV61Option, 0);
            AV67OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV69count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV62Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk2X8 )
         {
            brk2X8 = true ;
            pr_default.readNext(3);
         }
      }
      pr_default.close(3);
   }

   public void S161( )
   {
      /* 'LOADPROFESIONALNOMBRESOPTIONS' Routine */
      returnInSub = false ;
      AV23TFProfesionalNombres = AV57SearchTxt ;
      AV24TFProfesionalNombres_Sel = "" ;
      AV82Disponibilidadwwds_1_filterfulltext = AV75FilterFullText ;
      AV83Disponibilidadwwds_2_tfdisponibilidadid = AV11TFDisponibilidadId ;
      AV84Disponibilidadwwds_3_tfdisponibilidadid_to = AV12TFDisponibilidadId_To ;
      AV85Disponibilidadwwds_4_tfeventid = AV13TFEventId ;
      AV86Disponibilidadwwds_5_tfeventid_sel = AV14TFEventId_Sel ;
      AV87Disponibilidadwwds_6_tfdisponibilidaddescription = AV15TFDisponibilidadDescription ;
      AV88Disponibilidadwwds_7_tfdisponibilidaddescription_sel = AV16TFDisponibilidadDescription_Sel ;
      AV89Disponibilidadwwds_8_tfprofesionalid = AV17TFProfesionalId ;
      AV90Disponibilidadwwds_9_tfprofesionalid_to = AV18TFProfesionalId_To ;
      AV91Disponibilidadwwds_10_tfprofesionalapellidopaterno = AV19TFProfesionalApellidoPaterno ;
      AV92Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel = AV20TFProfesionalApellidoPaterno_Sel ;
      AV93Disponibilidadwwds_12_tfprofesionalapellidomaterno = AV21TFProfesionalApellidoMaterno ;
      AV94Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel = AV22TFProfesionalApellidoMaterno_Sel ;
      AV95Disponibilidadwwds_14_tfprofesionalnombres = AV23TFProfesionalNombres ;
      AV96Disponibilidadwwds_15_tfprofesionalnombres_sel = AV24TFProfesionalNombres_Sel ;
      AV97Disponibilidadwwds_16_tfprofesionalnombrecompleto = AV25TFProfesionalNombreCompleto ;
      AV98Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel = AV26TFProfesionalNombreCompleto_Sel ;
      AV99Disponibilidadwwds_18_tfprofesionalcop = AV27TFProfesionalCOP ;
      AV100Disponibilidadwwds_19_tfprofesionalcop_sel = AV28TFProfesionalCOP_Sel ;
      AV101Disponibilidadwwds_20_tfdisponibilidadfecha = AV29TFDisponibilidadFecha ;
      AV102Disponibilidadwwds_21_tfdisponibilidadfecha_to = AV30TFDisponibilidadFecha_To ;
      AV103Disponibilidadwwds_22_tfdisponibilidadhorainicio = AV31TFDisponibilidadHoraInicio ;
      AV104Disponibilidadwwds_23_tfdisponibilidadhorainicio_to = AV32TFDisponibilidadHoraInicio_To ;
      AV105Disponibilidadwwds_24_tfdisponibilidadhorafin = AV33TFDisponibilidadHoraFin ;
      AV106Disponibilidadwwds_25_tfdisponibilidadhorafin_to = AV34TFDisponibilidadHoraFin_To ;
      AV107Disponibilidadwwds_26_tfespecialidadid = AV35TFEspecialidadId ;
      AV108Disponibilidadwwds_27_tfespecialidadid_to = AV36TFEspecialidadId_To ;
      AV109Disponibilidadwwds_28_tfespecialidadcodigo = AV37TFEspecialidadCodigo ;
      AV110Disponibilidadwwds_29_tfespecialidadcodigo_sel = AV38TFEspecialidadCodigo_Sel ;
      AV111Disponibilidadwwds_30_tfespecialidadnombre = AV39TFEspecialidadNombre ;
      AV112Disponibilidadwwds_31_tfespecialidadnombre_sel = AV40TFEspecialidadNombre_Sel ;
      AV113Disponibilidadwwds_32_tfdisponibilidaduser = AV49TFDisponibilidadUser ;
      AV114Disponibilidadwwds_33_tfdisponibilidaduser_to = AV50TFDisponibilidadUser_To ;
      AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels = AV52TFDisponibilidadEstado_Sels ;
      AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels = AV54TFDisponibilidadEstadoCita_Sels ;
      AV117Disponibilidadwwds_36_tfdcitaid = AV55TFDCitaId ;
      AV118Disponibilidadwwds_37_tfdcitaid_to = AV56TFDCitaId_To ;
      AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels = AV77TFDisponibilidadTipoCita_Sels ;
      pr_default.dynParam(4, new Object[]{ new Object[]{
                                           A136DisponibilidadEstado ,
                                           AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels ,
                                           A139DisponibilidadEstadoCita ,
                                           AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels ,
                                           A298DisponibilidadTipoCita ,
                                           AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels ,
                                           Integer.valueOf(AV83Disponibilidadwwds_2_tfdisponibilidadid) ,
                                           Integer.valueOf(AV84Disponibilidadwwds_3_tfdisponibilidadid_to) ,
                                           AV86Disponibilidadwwds_5_tfeventid_sel ,
                                           AV85Disponibilidadwwds_4_tfeventid ,
                                           AV88Disponibilidadwwds_7_tfdisponibilidaddescription_sel ,
                                           AV87Disponibilidadwwds_6_tfdisponibilidaddescription ,
                                           Integer.valueOf(AV89Disponibilidadwwds_8_tfprofesionalid) ,
                                           Integer.valueOf(AV90Disponibilidadwwds_9_tfprofesionalid_to) ,
                                           AV92Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel ,
                                           AV91Disponibilidadwwds_10_tfprofesionalapellidopaterno ,
                                           AV94Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel ,
                                           AV93Disponibilidadwwds_12_tfprofesionalapellidomaterno ,
                                           AV96Disponibilidadwwds_15_tfprofesionalnombres_sel ,
                                           AV95Disponibilidadwwds_14_tfprofesionalnombres ,
                                           AV98Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel ,
                                           AV97Disponibilidadwwds_16_tfprofesionalnombrecompleto ,
                                           AV100Disponibilidadwwds_19_tfprofesionalcop_sel ,
                                           AV99Disponibilidadwwds_18_tfprofesionalcop ,
                                           AV101Disponibilidadwwds_20_tfdisponibilidadfecha ,
                                           AV102Disponibilidadwwds_21_tfdisponibilidadfecha_to ,
                                           AV103Disponibilidadwwds_22_tfdisponibilidadhorainicio ,
                                           AV104Disponibilidadwwds_23_tfdisponibilidadhorainicio_to ,
                                           AV105Disponibilidadwwds_24_tfdisponibilidadhorafin ,
                                           AV106Disponibilidadwwds_25_tfdisponibilidadhorafin_to ,
                                           Short.valueOf(AV107Disponibilidadwwds_26_tfespecialidadid) ,
                                           Short.valueOf(AV108Disponibilidadwwds_27_tfespecialidadid_to) ,
                                           AV110Disponibilidadwwds_29_tfespecialidadcodigo_sel ,
                                           AV109Disponibilidadwwds_28_tfespecialidadcodigo ,
                                           AV112Disponibilidadwwds_31_tfespecialidadnombre_sel ,
                                           AV111Disponibilidadwwds_30_tfespecialidadnombre ,
                                           Integer.valueOf(AV113Disponibilidadwwds_32_tfdisponibilidaduser) ,
                                           Integer.valueOf(AV114Disponibilidadwwds_33_tfdisponibilidaduser_to) ,
                                           Integer.valueOf(AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels.size()) ,
                                           Integer.valueOf(AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels.size()) ,
                                           Integer.valueOf(AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels.size()) ,
                                           Integer.valueOf(A34DisponibilidadId) ,
                                           A133EventId ,
                                           A134DisponibilidadDescription ,
                                           Integer.valueOf(A31ProfesionalId) ,
                                           A85ProfesionalApellidoPaterno ,
                                           A86ProfesionalApellidoMaterno ,
                                           A84ProfesionalNombres ,
                                           A88ProfesionalCOP ,
                                           A67DisponibilidadFecha ,
                                           A69DisponibilidadHoraInicio ,
                                           A135DisponibilidadHoraFin ,
                                           Short.valueOf(A32EspecialidadId) ,
                                           A140EspecialidadCodigo ,
                                           A71EspecialidadNombre ,
                                           Integer.valueOf(A137DisponibilidadUser) ,
                                           AV82Disponibilidadwwds_1_filterfulltext ,
                                           A83ProfesionalNombreCompleto ,
                                           Integer.valueOf(A138DCitaId) ,
                                           Integer.valueOf(AV117Disponibilidadwwds_36_tfdcitaid) ,
                                           Integer.valueOf(AV118Disponibilidadwwds_37_tfdcitaid_to) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN,
                                           TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.BOOLEAN,
                                           TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV85Disponibilidadwwds_4_tfeventid = GXutil.padr( GXutil.rtrim( AV85Disponibilidadwwds_4_tfeventid), 20, "%") ;
      lV87Disponibilidadwwds_6_tfdisponibilidaddescription = GXutil.concat( GXutil.rtrim( AV87Disponibilidadwwds_6_tfdisponibilidaddescription), "%", "") ;
      lV91Disponibilidadwwds_10_tfprofesionalapellidopaterno = GXutil.concat( GXutil.rtrim( AV91Disponibilidadwwds_10_tfprofesionalapellidopaterno), "%", "") ;
      lV93Disponibilidadwwds_12_tfprofesionalapellidomaterno = GXutil.concat( GXutil.rtrim( AV93Disponibilidadwwds_12_tfprofesionalapellidomaterno), "%", "") ;
      lV95Disponibilidadwwds_14_tfprofesionalnombres = GXutil.concat( GXutil.rtrim( AV95Disponibilidadwwds_14_tfprofesionalnombres), "%", "") ;
      lV97Disponibilidadwwds_16_tfprofesionalnombrecompleto = GXutil.concat( GXutil.rtrim( AV97Disponibilidadwwds_16_tfprofesionalnombrecompleto), "%", "") ;
      lV99Disponibilidadwwds_18_tfprofesionalcop = GXutil.concat( GXutil.rtrim( AV99Disponibilidadwwds_18_tfprofesionalcop), "%", "") ;
      lV109Disponibilidadwwds_28_tfespecialidadcodigo = GXutil.concat( GXutil.rtrim( AV109Disponibilidadwwds_28_tfespecialidadcodigo), "%", "") ;
      lV111Disponibilidadwwds_30_tfespecialidadnombre = GXutil.concat( GXutil.rtrim( AV111Disponibilidadwwds_30_tfespecialidadnombre), "%", "") ;
      /* Using cursor P002X11 */
      pr_default.execute(4, new Object[] {AV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, Integer.valueOf(AV117Disponibilidadwwds_36_tfdcitaid), Integer.valueOf(AV117Disponibilidadwwds_36_tfdcitaid), Integer.valueOf(AV118Disponibilidadwwds_37_tfdcitaid_to), Integer.valueOf(AV118Disponibilidadwwds_37_tfdcitaid_to), Integer.valueOf(AV83Disponibilidadwwds_2_tfdisponibilidadid), Integer.valueOf(AV84Disponibilidadwwds_3_tfdisponibilidadid_to), lV85Disponibilidadwwds_4_tfeventid, AV86Disponibilidadwwds_5_tfeventid_sel, lV87Disponibilidadwwds_6_tfdisponibilidaddescription, AV88Disponibilidadwwds_7_tfdisponibilidaddescription_sel, Integer.valueOf(AV89Disponibilidadwwds_8_tfprofesionalid), Integer.valueOf(AV90Disponibilidadwwds_9_tfprofesionalid_to), lV91Disponibilidadwwds_10_tfprofesionalapellidopaterno, AV92Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel, lV93Disponibilidadwwds_12_tfprofesionalapellidomaterno, AV94Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel, lV95Disponibilidadwwds_14_tfprofesionalnombres, AV96Disponibilidadwwds_15_tfprofesionalnombres_sel, lV97Disponibilidadwwds_16_tfprofesionalnombrecompleto, AV98Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel, lV99Disponibilidadwwds_18_tfprofesionalcop, AV100Disponibilidadwwds_19_tfprofesionalcop_sel, AV101Disponibilidadwwds_20_tfdisponibilidadfecha, AV102Disponibilidadwwds_21_tfdisponibilidadfecha_to, AV103Disponibilidadwwds_22_tfdisponibilidadhorainicio, AV104Disponibilidadwwds_23_tfdisponibilidadhorainicio_to, AV105Disponibilidadwwds_24_tfdisponibilidadhorafin, AV106Disponibilidadwwds_25_tfdisponibilidadhorafin_to, Short.valueOf(AV107Disponibilidadwwds_26_tfespecialidadid), Short.valueOf(AV108Disponibilidadwwds_27_tfespecialidadid_to), lV109Disponibilidadwwds_28_tfespecialidadcodigo, AV110Disponibilidadwwds_29_tfespecialidadcodigo_sel, lV111Disponibilidadwwds_30_tfespecialidadnombre, AV112Disponibilidadwwds_31_tfespecialidadnombre_sel, Integer.valueOf(AV113Disponibilidadwwds_32_tfdisponibilidaduser), Integer.valueOf(AV114Disponibilidadwwds_33_tfdisponibilidaduser_to)});
      while ( (pr_default.getStatus(4) != 101) )
      {
         brk2X10 = false ;
         A137DisponibilidadUser = P002X11_A137DisponibilidadUser[0] ;
         A32EspecialidadId = P002X11_A32EspecialidadId[0] ;
         A135DisponibilidadHoraFin = P002X11_A135DisponibilidadHoraFin[0] ;
         n135DisponibilidadHoraFin = P002X11_n135DisponibilidadHoraFin[0] ;
         A69DisponibilidadHoraInicio = P002X11_A69DisponibilidadHoraInicio[0] ;
         n69DisponibilidadHoraInicio = P002X11_n69DisponibilidadHoraInicio[0] ;
         A67DisponibilidadFecha = P002X11_A67DisponibilidadFecha[0] ;
         n67DisponibilidadFecha = P002X11_n67DisponibilidadFecha[0] ;
         A31ProfesionalId = P002X11_A31ProfesionalId[0] ;
         A34DisponibilidadId = P002X11_A34DisponibilidadId[0] ;
         A298DisponibilidadTipoCita = P002X11_A298DisponibilidadTipoCita[0] ;
         A139DisponibilidadEstadoCita = P002X11_A139DisponibilidadEstadoCita[0] ;
         A136DisponibilidadEstado = P002X11_A136DisponibilidadEstado[0] ;
         A71EspecialidadNombre = P002X11_A71EspecialidadNombre[0] ;
         A140EspecialidadCodigo = P002X11_A140EspecialidadCodigo[0] ;
         A88ProfesionalCOP = P002X11_A88ProfesionalCOP[0] ;
         A83ProfesionalNombreCompleto = P002X11_A83ProfesionalNombreCompleto[0] ;
         A134DisponibilidadDescription = P002X11_A134DisponibilidadDescription[0] ;
         A133EventId = P002X11_A133EventId[0] ;
         A138DCitaId = P002X11_A138DCitaId[0] ;
         n138DCitaId = P002X11_n138DCitaId[0] ;
         A84ProfesionalNombres = P002X11_A84ProfesionalNombres[0] ;
         A85ProfesionalApellidoPaterno = P002X11_A85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = P002X11_A86ProfesionalApellidoMaterno[0] ;
         A71EspecialidadNombre = P002X11_A71EspecialidadNombre[0] ;
         A140EspecialidadCodigo = P002X11_A140EspecialidadCodigo[0] ;
         A88ProfesionalCOP = P002X11_A88ProfesionalCOP[0] ;
         A84ProfesionalNombres = P002X11_A84ProfesionalNombres[0] ;
         A85ProfesionalApellidoPaterno = P002X11_A85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = P002X11_A86ProfesionalApellidoMaterno[0] ;
         A138DCitaId = P002X11_A138DCitaId[0] ;
         n138DCitaId = P002X11_n138DCitaId[0] ;
         AV69count = 0 ;
         while ( (pr_default.getStatus(4) != 101) && ( GXutil.strcmp(P002X11_A84ProfesionalNombres[0], A84ProfesionalNombres) == 0 ) )
         {
            brk2X10 = false ;
            A31ProfesionalId = P002X11_A31ProfesionalId[0] ;
            A34DisponibilidadId = P002X11_A34DisponibilidadId[0] ;
            AV69count = (long)(AV69count+1) ;
            brk2X10 = true ;
            pr_default.readNext(4);
         }
         if ( ! (GXutil.strcmp("", A84ProfesionalNombres)==0) )
         {
            AV61Option = A84ProfesionalNombres ;
            AV62Options.add(AV61Option, 0);
            AV67OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV69count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV62Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk2X10 )
         {
            brk2X10 = true ;
            pr_default.readNext(4);
         }
      }
      pr_default.close(4);
   }

   public void S171( )
   {
      /* 'LOADPROFESIONALNOMBRECOMPLETOOPTIONS' Routine */
      returnInSub = false ;
      AV25TFProfesionalNombreCompleto = AV57SearchTxt ;
      AV26TFProfesionalNombreCompleto_Sel = "" ;
      AV82Disponibilidadwwds_1_filterfulltext = AV75FilterFullText ;
      AV83Disponibilidadwwds_2_tfdisponibilidadid = AV11TFDisponibilidadId ;
      AV84Disponibilidadwwds_3_tfdisponibilidadid_to = AV12TFDisponibilidadId_To ;
      AV85Disponibilidadwwds_4_tfeventid = AV13TFEventId ;
      AV86Disponibilidadwwds_5_tfeventid_sel = AV14TFEventId_Sel ;
      AV87Disponibilidadwwds_6_tfdisponibilidaddescription = AV15TFDisponibilidadDescription ;
      AV88Disponibilidadwwds_7_tfdisponibilidaddescription_sel = AV16TFDisponibilidadDescription_Sel ;
      AV89Disponibilidadwwds_8_tfprofesionalid = AV17TFProfesionalId ;
      AV90Disponibilidadwwds_9_tfprofesionalid_to = AV18TFProfesionalId_To ;
      AV91Disponibilidadwwds_10_tfprofesionalapellidopaterno = AV19TFProfesionalApellidoPaterno ;
      AV92Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel = AV20TFProfesionalApellidoPaterno_Sel ;
      AV93Disponibilidadwwds_12_tfprofesionalapellidomaterno = AV21TFProfesionalApellidoMaterno ;
      AV94Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel = AV22TFProfesionalApellidoMaterno_Sel ;
      AV95Disponibilidadwwds_14_tfprofesionalnombres = AV23TFProfesionalNombres ;
      AV96Disponibilidadwwds_15_tfprofesionalnombres_sel = AV24TFProfesionalNombres_Sel ;
      AV97Disponibilidadwwds_16_tfprofesionalnombrecompleto = AV25TFProfesionalNombreCompleto ;
      AV98Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel = AV26TFProfesionalNombreCompleto_Sel ;
      AV99Disponibilidadwwds_18_tfprofesionalcop = AV27TFProfesionalCOP ;
      AV100Disponibilidadwwds_19_tfprofesionalcop_sel = AV28TFProfesionalCOP_Sel ;
      AV101Disponibilidadwwds_20_tfdisponibilidadfecha = AV29TFDisponibilidadFecha ;
      AV102Disponibilidadwwds_21_tfdisponibilidadfecha_to = AV30TFDisponibilidadFecha_To ;
      AV103Disponibilidadwwds_22_tfdisponibilidadhorainicio = AV31TFDisponibilidadHoraInicio ;
      AV104Disponibilidadwwds_23_tfdisponibilidadhorainicio_to = AV32TFDisponibilidadHoraInicio_To ;
      AV105Disponibilidadwwds_24_tfdisponibilidadhorafin = AV33TFDisponibilidadHoraFin ;
      AV106Disponibilidadwwds_25_tfdisponibilidadhorafin_to = AV34TFDisponibilidadHoraFin_To ;
      AV107Disponibilidadwwds_26_tfespecialidadid = AV35TFEspecialidadId ;
      AV108Disponibilidadwwds_27_tfespecialidadid_to = AV36TFEspecialidadId_To ;
      AV109Disponibilidadwwds_28_tfespecialidadcodigo = AV37TFEspecialidadCodigo ;
      AV110Disponibilidadwwds_29_tfespecialidadcodigo_sel = AV38TFEspecialidadCodigo_Sel ;
      AV111Disponibilidadwwds_30_tfespecialidadnombre = AV39TFEspecialidadNombre ;
      AV112Disponibilidadwwds_31_tfespecialidadnombre_sel = AV40TFEspecialidadNombre_Sel ;
      AV113Disponibilidadwwds_32_tfdisponibilidaduser = AV49TFDisponibilidadUser ;
      AV114Disponibilidadwwds_33_tfdisponibilidaduser_to = AV50TFDisponibilidadUser_To ;
      AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels = AV52TFDisponibilidadEstado_Sels ;
      AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels = AV54TFDisponibilidadEstadoCita_Sels ;
      AV117Disponibilidadwwds_36_tfdcitaid = AV55TFDCitaId ;
      AV118Disponibilidadwwds_37_tfdcitaid_to = AV56TFDCitaId_To ;
      AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels = AV77TFDisponibilidadTipoCita_Sels ;
      pr_default.dynParam(5, new Object[]{ new Object[]{
                                           A136DisponibilidadEstado ,
                                           AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels ,
                                           A139DisponibilidadEstadoCita ,
                                           AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels ,
                                           A298DisponibilidadTipoCita ,
                                           AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels ,
                                           Integer.valueOf(AV83Disponibilidadwwds_2_tfdisponibilidadid) ,
                                           Integer.valueOf(AV84Disponibilidadwwds_3_tfdisponibilidadid_to) ,
                                           AV86Disponibilidadwwds_5_tfeventid_sel ,
                                           AV85Disponibilidadwwds_4_tfeventid ,
                                           AV88Disponibilidadwwds_7_tfdisponibilidaddescription_sel ,
                                           AV87Disponibilidadwwds_6_tfdisponibilidaddescription ,
                                           Integer.valueOf(AV89Disponibilidadwwds_8_tfprofesionalid) ,
                                           Integer.valueOf(AV90Disponibilidadwwds_9_tfprofesionalid_to) ,
                                           AV92Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel ,
                                           AV91Disponibilidadwwds_10_tfprofesionalapellidopaterno ,
                                           AV94Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel ,
                                           AV93Disponibilidadwwds_12_tfprofesionalapellidomaterno ,
                                           AV96Disponibilidadwwds_15_tfprofesionalnombres_sel ,
                                           AV95Disponibilidadwwds_14_tfprofesionalnombres ,
                                           AV98Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel ,
                                           AV97Disponibilidadwwds_16_tfprofesionalnombrecompleto ,
                                           AV100Disponibilidadwwds_19_tfprofesionalcop_sel ,
                                           AV99Disponibilidadwwds_18_tfprofesionalcop ,
                                           AV101Disponibilidadwwds_20_tfdisponibilidadfecha ,
                                           AV102Disponibilidadwwds_21_tfdisponibilidadfecha_to ,
                                           AV103Disponibilidadwwds_22_tfdisponibilidadhorainicio ,
                                           AV104Disponibilidadwwds_23_tfdisponibilidadhorainicio_to ,
                                           AV105Disponibilidadwwds_24_tfdisponibilidadhorafin ,
                                           AV106Disponibilidadwwds_25_tfdisponibilidadhorafin_to ,
                                           Short.valueOf(AV107Disponibilidadwwds_26_tfespecialidadid) ,
                                           Short.valueOf(AV108Disponibilidadwwds_27_tfespecialidadid_to) ,
                                           AV110Disponibilidadwwds_29_tfespecialidadcodigo_sel ,
                                           AV109Disponibilidadwwds_28_tfespecialidadcodigo ,
                                           AV112Disponibilidadwwds_31_tfespecialidadnombre_sel ,
                                           AV111Disponibilidadwwds_30_tfespecialidadnombre ,
                                           Integer.valueOf(AV113Disponibilidadwwds_32_tfdisponibilidaduser) ,
                                           Integer.valueOf(AV114Disponibilidadwwds_33_tfdisponibilidaduser_to) ,
                                           Integer.valueOf(AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels.size()) ,
                                           Integer.valueOf(AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels.size()) ,
                                           Integer.valueOf(AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels.size()) ,
                                           Integer.valueOf(A34DisponibilidadId) ,
                                           A133EventId ,
                                           A134DisponibilidadDescription ,
                                           Integer.valueOf(A31ProfesionalId) ,
                                           A85ProfesionalApellidoPaterno ,
                                           A86ProfesionalApellidoMaterno ,
                                           A84ProfesionalNombres ,
                                           A88ProfesionalCOP ,
                                           A67DisponibilidadFecha ,
                                           A69DisponibilidadHoraInicio ,
                                           A135DisponibilidadHoraFin ,
                                           Short.valueOf(A32EspecialidadId) ,
                                           A140EspecialidadCodigo ,
                                           A71EspecialidadNombre ,
                                           Integer.valueOf(A137DisponibilidadUser) ,
                                           AV82Disponibilidadwwds_1_filterfulltext ,
                                           A83ProfesionalNombreCompleto ,
                                           Integer.valueOf(A138DCitaId) ,
                                           Integer.valueOf(AV117Disponibilidadwwds_36_tfdcitaid) ,
                                           Integer.valueOf(AV118Disponibilidadwwds_37_tfdcitaid_to) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN,
                                           TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.BOOLEAN,
                                           TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV85Disponibilidadwwds_4_tfeventid = GXutil.padr( GXutil.rtrim( AV85Disponibilidadwwds_4_tfeventid), 20, "%") ;
      lV87Disponibilidadwwds_6_tfdisponibilidaddescription = GXutil.concat( GXutil.rtrim( AV87Disponibilidadwwds_6_tfdisponibilidaddescription), "%", "") ;
      lV91Disponibilidadwwds_10_tfprofesionalapellidopaterno = GXutil.concat( GXutil.rtrim( AV91Disponibilidadwwds_10_tfprofesionalapellidopaterno), "%", "") ;
      lV93Disponibilidadwwds_12_tfprofesionalapellidomaterno = GXutil.concat( GXutil.rtrim( AV93Disponibilidadwwds_12_tfprofesionalapellidomaterno), "%", "") ;
      lV95Disponibilidadwwds_14_tfprofesionalnombres = GXutil.concat( GXutil.rtrim( AV95Disponibilidadwwds_14_tfprofesionalnombres), "%", "") ;
      lV97Disponibilidadwwds_16_tfprofesionalnombrecompleto = GXutil.concat( GXutil.rtrim( AV97Disponibilidadwwds_16_tfprofesionalnombrecompleto), "%", "") ;
      lV99Disponibilidadwwds_18_tfprofesionalcop = GXutil.concat( GXutil.rtrim( AV99Disponibilidadwwds_18_tfprofesionalcop), "%", "") ;
      lV109Disponibilidadwwds_28_tfespecialidadcodigo = GXutil.concat( GXutil.rtrim( AV109Disponibilidadwwds_28_tfespecialidadcodigo), "%", "") ;
      lV111Disponibilidadwwds_30_tfespecialidadnombre = GXutil.concat( GXutil.rtrim( AV111Disponibilidadwwds_30_tfespecialidadnombre), "%", "") ;
      /* Using cursor P002X13 */
      pr_default.execute(5, new Object[] {AV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, Integer.valueOf(AV117Disponibilidadwwds_36_tfdcitaid), Integer.valueOf(AV117Disponibilidadwwds_36_tfdcitaid), Integer.valueOf(AV118Disponibilidadwwds_37_tfdcitaid_to), Integer.valueOf(AV118Disponibilidadwwds_37_tfdcitaid_to), Integer.valueOf(AV83Disponibilidadwwds_2_tfdisponibilidadid), Integer.valueOf(AV84Disponibilidadwwds_3_tfdisponibilidadid_to), lV85Disponibilidadwwds_4_tfeventid, AV86Disponibilidadwwds_5_tfeventid_sel, lV87Disponibilidadwwds_6_tfdisponibilidaddescription, AV88Disponibilidadwwds_7_tfdisponibilidaddescription_sel, Integer.valueOf(AV89Disponibilidadwwds_8_tfprofesionalid), Integer.valueOf(AV90Disponibilidadwwds_9_tfprofesionalid_to), lV91Disponibilidadwwds_10_tfprofesionalapellidopaterno, AV92Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel, lV93Disponibilidadwwds_12_tfprofesionalapellidomaterno, AV94Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel, lV95Disponibilidadwwds_14_tfprofesionalnombres, AV96Disponibilidadwwds_15_tfprofesionalnombres_sel, lV97Disponibilidadwwds_16_tfprofesionalnombrecompleto, AV98Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel, lV99Disponibilidadwwds_18_tfprofesionalcop, AV100Disponibilidadwwds_19_tfprofesionalcop_sel, AV101Disponibilidadwwds_20_tfdisponibilidadfecha, AV102Disponibilidadwwds_21_tfdisponibilidadfecha_to, AV103Disponibilidadwwds_22_tfdisponibilidadhorainicio, AV104Disponibilidadwwds_23_tfdisponibilidadhorainicio_to, AV105Disponibilidadwwds_24_tfdisponibilidadhorafin, AV106Disponibilidadwwds_25_tfdisponibilidadhorafin_to, Short.valueOf(AV107Disponibilidadwwds_26_tfespecialidadid), Short.valueOf(AV108Disponibilidadwwds_27_tfespecialidadid_to), lV109Disponibilidadwwds_28_tfespecialidadcodigo, AV110Disponibilidadwwds_29_tfespecialidadcodigo_sel, lV111Disponibilidadwwds_30_tfespecialidadnombre, AV112Disponibilidadwwds_31_tfespecialidadnombre_sel, Integer.valueOf(AV113Disponibilidadwwds_32_tfdisponibilidaduser), Integer.valueOf(AV114Disponibilidadwwds_33_tfdisponibilidaduser_to)});
      while ( (pr_default.getStatus(5) != 101) )
      {
         A137DisponibilidadUser = P002X13_A137DisponibilidadUser[0] ;
         A32EspecialidadId = P002X13_A32EspecialidadId[0] ;
         A135DisponibilidadHoraFin = P002X13_A135DisponibilidadHoraFin[0] ;
         n135DisponibilidadHoraFin = P002X13_n135DisponibilidadHoraFin[0] ;
         A69DisponibilidadHoraInicio = P002X13_A69DisponibilidadHoraInicio[0] ;
         n69DisponibilidadHoraInicio = P002X13_n69DisponibilidadHoraInicio[0] ;
         A67DisponibilidadFecha = P002X13_A67DisponibilidadFecha[0] ;
         n67DisponibilidadFecha = P002X13_n67DisponibilidadFecha[0] ;
         A31ProfesionalId = P002X13_A31ProfesionalId[0] ;
         A34DisponibilidadId = P002X13_A34DisponibilidadId[0] ;
         A298DisponibilidadTipoCita = P002X13_A298DisponibilidadTipoCita[0] ;
         A139DisponibilidadEstadoCita = P002X13_A139DisponibilidadEstadoCita[0] ;
         A136DisponibilidadEstado = P002X13_A136DisponibilidadEstado[0] ;
         A71EspecialidadNombre = P002X13_A71EspecialidadNombre[0] ;
         A140EspecialidadCodigo = P002X13_A140EspecialidadCodigo[0] ;
         A88ProfesionalCOP = P002X13_A88ProfesionalCOP[0] ;
         A83ProfesionalNombreCompleto = P002X13_A83ProfesionalNombreCompleto[0] ;
         A134DisponibilidadDescription = P002X13_A134DisponibilidadDescription[0] ;
         A133EventId = P002X13_A133EventId[0] ;
         A138DCitaId = P002X13_A138DCitaId[0] ;
         n138DCitaId = P002X13_n138DCitaId[0] ;
         A84ProfesionalNombres = P002X13_A84ProfesionalNombres[0] ;
         A85ProfesionalApellidoPaterno = P002X13_A85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = P002X13_A86ProfesionalApellidoMaterno[0] ;
         A71EspecialidadNombre = P002X13_A71EspecialidadNombre[0] ;
         A140EspecialidadCodigo = P002X13_A140EspecialidadCodigo[0] ;
         A88ProfesionalCOP = P002X13_A88ProfesionalCOP[0] ;
         A84ProfesionalNombres = P002X13_A84ProfesionalNombres[0] ;
         A85ProfesionalApellidoPaterno = P002X13_A85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = P002X13_A86ProfesionalApellidoMaterno[0] ;
         A138DCitaId = P002X13_A138DCitaId[0] ;
         n138DCitaId = P002X13_n138DCitaId[0] ;
         if ( ! (GXutil.strcmp("", A83ProfesionalNombreCompleto)==0) )
         {
            AV61Option = A83ProfesionalNombreCompleto ;
            AV60InsertIndex = 1 ;
            while ( ( AV60InsertIndex <= AV62Options.size() ) && ( GXutil.strcmp((String)AV62Options.elementAt(-1+AV60InsertIndex), AV61Option) < 0 ) )
            {
               AV60InsertIndex = (int)(AV60InsertIndex+1) ;
            }
            if ( ( AV60InsertIndex <= AV62Options.size() ) && ( GXutil.strcmp((String)AV62Options.elementAt(-1+AV60InsertIndex), AV61Option) == 0 ) )
            {
               AV69count = GXutil.lval( (String)AV67OptionIndexes.elementAt(-1+AV60InsertIndex)) ;
               AV69count = (long)(AV69count+1) ;
               AV67OptionIndexes.removeItem(AV60InsertIndex);
               AV67OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV69count), "Z,ZZZ,ZZZ,ZZ9")), AV60InsertIndex);
            }
            else
            {
               AV62Options.add(AV61Option, AV60InsertIndex);
               AV67OptionIndexes.add("1", AV60InsertIndex);
            }
         }
         if ( AV62Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         pr_default.readNext(5);
      }
      pr_default.close(5);
   }

   public void S181( )
   {
      /* 'LOADPROFESIONALCOPOPTIONS' Routine */
      returnInSub = false ;
      AV27TFProfesionalCOP = AV57SearchTxt ;
      AV28TFProfesionalCOP_Sel = "" ;
      AV82Disponibilidadwwds_1_filterfulltext = AV75FilterFullText ;
      AV83Disponibilidadwwds_2_tfdisponibilidadid = AV11TFDisponibilidadId ;
      AV84Disponibilidadwwds_3_tfdisponibilidadid_to = AV12TFDisponibilidadId_To ;
      AV85Disponibilidadwwds_4_tfeventid = AV13TFEventId ;
      AV86Disponibilidadwwds_5_tfeventid_sel = AV14TFEventId_Sel ;
      AV87Disponibilidadwwds_6_tfdisponibilidaddescription = AV15TFDisponibilidadDescription ;
      AV88Disponibilidadwwds_7_tfdisponibilidaddescription_sel = AV16TFDisponibilidadDescription_Sel ;
      AV89Disponibilidadwwds_8_tfprofesionalid = AV17TFProfesionalId ;
      AV90Disponibilidadwwds_9_tfprofesionalid_to = AV18TFProfesionalId_To ;
      AV91Disponibilidadwwds_10_tfprofesionalapellidopaterno = AV19TFProfesionalApellidoPaterno ;
      AV92Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel = AV20TFProfesionalApellidoPaterno_Sel ;
      AV93Disponibilidadwwds_12_tfprofesionalapellidomaterno = AV21TFProfesionalApellidoMaterno ;
      AV94Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel = AV22TFProfesionalApellidoMaterno_Sel ;
      AV95Disponibilidadwwds_14_tfprofesionalnombres = AV23TFProfesionalNombres ;
      AV96Disponibilidadwwds_15_tfprofesionalnombres_sel = AV24TFProfesionalNombres_Sel ;
      AV97Disponibilidadwwds_16_tfprofesionalnombrecompleto = AV25TFProfesionalNombreCompleto ;
      AV98Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel = AV26TFProfesionalNombreCompleto_Sel ;
      AV99Disponibilidadwwds_18_tfprofesionalcop = AV27TFProfesionalCOP ;
      AV100Disponibilidadwwds_19_tfprofesionalcop_sel = AV28TFProfesionalCOP_Sel ;
      AV101Disponibilidadwwds_20_tfdisponibilidadfecha = AV29TFDisponibilidadFecha ;
      AV102Disponibilidadwwds_21_tfdisponibilidadfecha_to = AV30TFDisponibilidadFecha_To ;
      AV103Disponibilidadwwds_22_tfdisponibilidadhorainicio = AV31TFDisponibilidadHoraInicio ;
      AV104Disponibilidadwwds_23_tfdisponibilidadhorainicio_to = AV32TFDisponibilidadHoraInicio_To ;
      AV105Disponibilidadwwds_24_tfdisponibilidadhorafin = AV33TFDisponibilidadHoraFin ;
      AV106Disponibilidadwwds_25_tfdisponibilidadhorafin_to = AV34TFDisponibilidadHoraFin_To ;
      AV107Disponibilidadwwds_26_tfespecialidadid = AV35TFEspecialidadId ;
      AV108Disponibilidadwwds_27_tfespecialidadid_to = AV36TFEspecialidadId_To ;
      AV109Disponibilidadwwds_28_tfespecialidadcodigo = AV37TFEspecialidadCodigo ;
      AV110Disponibilidadwwds_29_tfespecialidadcodigo_sel = AV38TFEspecialidadCodigo_Sel ;
      AV111Disponibilidadwwds_30_tfespecialidadnombre = AV39TFEspecialidadNombre ;
      AV112Disponibilidadwwds_31_tfespecialidadnombre_sel = AV40TFEspecialidadNombre_Sel ;
      AV113Disponibilidadwwds_32_tfdisponibilidaduser = AV49TFDisponibilidadUser ;
      AV114Disponibilidadwwds_33_tfdisponibilidaduser_to = AV50TFDisponibilidadUser_To ;
      AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels = AV52TFDisponibilidadEstado_Sels ;
      AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels = AV54TFDisponibilidadEstadoCita_Sels ;
      AV117Disponibilidadwwds_36_tfdcitaid = AV55TFDCitaId ;
      AV118Disponibilidadwwds_37_tfdcitaid_to = AV56TFDCitaId_To ;
      AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels = AV77TFDisponibilidadTipoCita_Sels ;
      pr_default.dynParam(6, new Object[]{ new Object[]{
                                           A136DisponibilidadEstado ,
                                           AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels ,
                                           A139DisponibilidadEstadoCita ,
                                           AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels ,
                                           A298DisponibilidadTipoCita ,
                                           AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels ,
                                           Integer.valueOf(AV83Disponibilidadwwds_2_tfdisponibilidadid) ,
                                           Integer.valueOf(AV84Disponibilidadwwds_3_tfdisponibilidadid_to) ,
                                           AV86Disponibilidadwwds_5_tfeventid_sel ,
                                           AV85Disponibilidadwwds_4_tfeventid ,
                                           AV88Disponibilidadwwds_7_tfdisponibilidaddescription_sel ,
                                           AV87Disponibilidadwwds_6_tfdisponibilidaddescription ,
                                           Integer.valueOf(AV89Disponibilidadwwds_8_tfprofesionalid) ,
                                           Integer.valueOf(AV90Disponibilidadwwds_9_tfprofesionalid_to) ,
                                           AV92Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel ,
                                           AV91Disponibilidadwwds_10_tfprofesionalapellidopaterno ,
                                           AV94Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel ,
                                           AV93Disponibilidadwwds_12_tfprofesionalapellidomaterno ,
                                           AV96Disponibilidadwwds_15_tfprofesionalnombres_sel ,
                                           AV95Disponibilidadwwds_14_tfprofesionalnombres ,
                                           AV98Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel ,
                                           AV97Disponibilidadwwds_16_tfprofesionalnombrecompleto ,
                                           AV100Disponibilidadwwds_19_tfprofesionalcop_sel ,
                                           AV99Disponibilidadwwds_18_tfprofesionalcop ,
                                           AV101Disponibilidadwwds_20_tfdisponibilidadfecha ,
                                           AV102Disponibilidadwwds_21_tfdisponibilidadfecha_to ,
                                           AV103Disponibilidadwwds_22_tfdisponibilidadhorainicio ,
                                           AV104Disponibilidadwwds_23_tfdisponibilidadhorainicio_to ,
                                           AV105Disponibilidadwwds_24_tfdisponibilidadhorafin ,
                                           AV106Disponibilidadwwds_25_tfdisponibilidadhorafin_to ,
                                           Short.valueOf(AV107Disponibilidadwwds_26_tfespecialidadid) ,
                                           Short.valueOf(AV108Disponibilidadwwds_27_tfespecialidadid_to) ,
                                           AV110Disponibilidadwwds_29_tfespecialidadcodigo_sel ,
                                           AV109Disponibilidadwwds_28_tfespecialidadcodigo ,
                                           AV112Disponibilidadwwds_31_tfespecialidadnombre_sel ,
                                           AV111Disponibilidadwwds_30_tfespecialidadnombre ,
                                           Integer.valueOf(AV113Disponibilidadwwds_32_tfdisponibilidaduser) ,
                                           Integer.valueOf(AV114Disponibilidadwwds_33_tfdisponibilidaduser_to) ,
                                           Integer.valueOf(AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels.size()) ,
                                           Integer.valueOf(AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels.size()) ,
                                           Integer.valueOf(AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels.size()) ,
                                           Integer.valueOf(A34DisponibilidadId) ,
                                           A133EventId ,
                                           A134DisponibilidadDescription ,
                                           Integer.valueOf(A31ProfesionalId) ,
                                           A85ProfesionalApellidoPaterno ,
                                           A86ProfesionalApellidoMaterno ,
                                           A84ProfesionalNombres ,
                                           A88ProfesionalCOP ,
                                           A67DisponibilidadFecha ,
                                           A69DisponibilidadHoraInicio ,
                                           A135DisponibilidadHoraFin ,
                                           Short.valueOf(A32EspecialidadId) ,
                                           A140EspecialidadCodigo ,
                                           A71EspecialidadNombre ,
                                           Integer.valueOf(A137DisponibilidadUser) ,
                                           AV82Disponibilidadwwds_1_filterfulltext ,
                                           A83ProfesionalNombreCompleto ,
                                           Integer.valueOf(A138DCitaId) ,
                                           Integer.valueOf(AV117Disponibilidadwwds_36_tfdcitaid) ,
                                           Integer.valueOf(AV118Disponibilidadwwds_37_tfdcitaid_to) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN,
                                           TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.BOOLEAN,
                                           TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV85Disponibilidadwwds_4_tfeventid = GXutil.padr( GXutil.rtrim( AV85Disponibilidadwwds_4_tfeventid), 20, "%") ;
      lV87Disponibilidadwwds_6_tfdisponibilidaddescription = GXutil.concat( GXutil.rtrim( AV87Disponibilidadwwds_6_tfdisponibilidaddescription), "%", "") ;
      lV91Disponibilidadwwds_10_tfprofesionalapellidopaterno = GXutil.concat( GXutil.rtrim( AV91Disponibilidadwwds_10_tfprofesionalapellidopaterno), "%", "") ;
      lV93Disponibilidadwwds_12_tfprofesionalapellidomaterno = GXutil.concat( GXutil.rtrim( AV93Disponibilidadwwds_12_tfprofesionalapellidomaterno), "%", "") ;
      lV95Disponibilidadwwds_14_tfprofesionalnombres = GXutil.concat( GXutil.rtrim( AV95Disponibilidadwwds_14_tfprofesionalnombres), "%", "") ;
      lV97Disponibilidadwwds_16_tfprofesionalnombrecompleto = GXutil.concat( GXutil.rtrim( AV97Disponibilidadwwds_16_tfprofesionalnombrecompleto), "%", "") ;
      lV99Disponibilidadwwds_18_tfprofesionalcop = GXutil.concat( GXutil.rtrim( AV99Disponibilidadwwds_18_tfprofesionalcop), "%", "") ;
      lV109Disponibilidadwwds_28_tfespecialidadcodigo = GXutil.concat( GXutil.rtrim( AV109Disponibilidadwwds_28_tfespecialidadcodigo), "%", "") ;
      lV111Disponibilidadwwds_30_tfespecialidadnombre = GXutil.concat( GXutil.rtrim( AV111Disponibilidadwwds_30_tfespecialidadnombre), "%", "") ;
      /* Using cursor P002X15 */
      pr_default.execute(6, new Object[] {AV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, Integer.valueOf(AV117Disponibilidadwwds_36_tfdcitaid), Integer.valueOf(AV117Disponibilidadwwds_36_tfdcitaid), Integer.valueOf(AV118Disponibilidadwwds_37_tfdcitaid_to), Integer.valueOf(AV118Disponibilidadwwds_37_tfdcitaid_to), Integer.valueOf(AV83Disponibilidadwwds_2_tfdisponibilidadid), Integer.valueOf(AV84Disponibilidadwwds_3_tfdisponibilidadid_to), lV85Disponibilidadwwds_4_tfeventid, AV86Disponibilidadwwds_5_tfeventid_sel, lV87Disponibilidadwwds_6_tfdisponibilidaddescription, AV88Disponibilidadwwds_7_tfdisponibilidaddescription_sel, Integer.valueOf(AV89Disponibilidadwwds_8_tfprofesionalid), Integer.valueOf(AV90Disponibilidadwwds_9_tfprofesionalid_to), lV91Disponibilidadwwds_10_tfprofesionalapellidopaterno, AV92Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel, lV93Disponibilidadwwds_12_tfprofesionalapellidomaterno, AV94Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel, lV95Disponibilidadwwds_14_tfprofesionalnombres, AV96Disponibilidadwwds_15_tfprofesionalnombres_sel, lV97Disponibilidadwwds_16_tfprofesionalnombrecompleto, AV98Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel, lV99Disponibilidadwwds_18_tfprofesionalcop, AV100Disponibilidadwwds_19_tfprofesionalcop_sel, AV101Disponibilidadwwds_20_tfdisponibilidadfecha, AV102Disponibilidadwwds_21_tfdisponibilidadfecha_to, AV103Disponibilidadwwds_22_tfdisponibilidadhorainicio, AV104Disponibilidadwwds_23_tfdisponibilidadhorainicio_to, AV105Disponibilidadwwds_24_tfdisponibilidadhorafin, AV106Disponibilidadwwds_25_tfdisponibilidadhorafin_to, Short.valueOf(AV107Disponibilidadwwds_26_tfespecialidadid), Short.valueOf(AV108Disponibilidadwwds_27_tfespecialidadid_to), lV109Disponibilidadwwds_28_tfespecialidadcodigo, AV110Disponibilidadwwds_29_tfespecialidadcodigo_sel, lV111Disponibilidadwwds_30_tfespecialidadnombre, AV112Disponibilidadwwds_31_tfespecialidadnombre_sel, Integer.valueOf(AV113Disponibilidadwwds_32_tfdisponibilidaduser), Integer.valueOf(AV114Disponibilidadwwds_33_tfdisponibilidaduser_to)});
      while ( (pr_default.getStatus(6) != 101) )
      {
         brk2X13 = false ;
         A88ProfesionalCOP = P002X15_A88ProfesionalCOP[0] ;
         A137DisponibilidadUser = P002X15_A137DisponibilidadUser[0] ;
         A32EspecialidadId = P002X15_A32EspecialidadId[0] ;
         A135DisponibilidadHoraFin = P002X15_A135DisponibilidadHoraFin[0] ;
         n135DisponibilidadHoraFin = P002X15_n135DisponibilidadHoraFin[0] ;
         A69DisponibilidadHoraInicio = P002X15_A69DisponibilidadHoraInicio[0] ;
         n69DisponibilidadHoraInicio = P002X15_n69DisponibilidadHoraInicio[0] ;
         A67DisponibilidadFecha = P002X15_A67DisponibilidadFecha[0] ;
         n67DisponibilidadFecha = P002X15_n67DisponibilidadFecha[0] ;
         A31ProfesionalId = P002X15_A31ProfesionalId[0] ;
         A34DisponibilidadId = P002X15_A34DisponibilidadId[0] ;
         A298DisponibilidadTipoCita = P002X15_A298DisponibilidadTipoCita[0] ;
         A139DisponibilidadEstadoCita = P002X15_A139DisponibilidadEstadoCita[0] ;
         A136DisponibilidadEstado = P002X15_A136DisponibilidadEstado[0] ;
         A71EspecialidadNombre = P002X15_A71EspecialidadNombre[0] ;
         A140EspecialidadCodigo = P002X15_A140EspecialidadCodigo[0] ;
         A83ProfesionalNombreCompleto = P002X15_A83ProfesionalNombreCompleto[0] ;
         A134DisponibilidadDescription = P002X15_A134DisponibilidadDescription[0] ;
         A133EventId = P002X15_A133EventId[0] ;
         A138DCitaId = P002X15_A138DCitaId[0] ;
         n138DCitaId = P002X15_n138DCitaId[0] ;
         A84ProfesionalNombres = P002X15_A84ProfesionalNombres[0] ;
         A85ProfesionalApellidoPaterno = P002X15_A85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = P002X15_A86ProfesionalApellidoMaterno[0] ;
         A71EspecialidadNombre = P002X15_A71EspecialidadNombre[0] ;
         A140EspecialidadCodigo = P002X15_A140EspecialidadCodigo[0] ;
         A88ProfesionalCOP = P002X15_A88ProfesionalCOP[0] ;
         A84ProfesionalNombres = P002X15_A84ProfesionalNombres[0] ;
         A85ProfesionalApellidoPaterno = P002X15_A85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = P002X15_A86ProfesionalApellidoMaterno[0] ;
         A138DCitaId = P002X15_A138DCitaId[0] ;
         n138DCitaId = P002X15_n138DCitaId[0] ;
         AV69count = 0 ;
         while ( (pr_default.getStatus(6) != 101) && ( GXutil.strcmp(P002X15_A88ProfesionalCOP[0], A88ProfesionalCOP) == 0 ) )
         {
            brk2X13 = false ;
            A31ProfesionalId = P002X15_A31ProfesionalId[0] ;
            A34DisponibilidadId = P002X15_A34DisponibilidadId[0] ;
            AV69count = (long)(AV69count+1) ;
            brk2X13 = true ;
            pr_default.readNext(6);
         }
         if ( ! (GXutil.strcmp("", A88ProfesionalCOP)==0) )
         {
            AV61Option = A88ProfesionalCOP ;
            AV62Options.add(AV61Option, 0);
            AV67OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV69count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV62Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk2X13 )
         {
            brk2X13 = true ;
            pr_default.readNext(6);
         }
      }
      pr_default.close(6);
   }

   public void S191( )
   {
      /* 'LOADESPECIALIDADCODIGOOPTIONS' Routine */
      returnInSub = false ;
      AV37TFEspecialidadCodigo = AV57SearchTxt ;
      AV38TFEspecialidadCodigo_Sel = "" ;
      AV82Disponibilidadwwds_1_filterfulltext = AV75FilterFullText ;
      AV83Disponibilidadwwds_2_tfdisponibilidadid = AV11TFDisponibilidadId ;
      AV84Disponibilidadwwds_3_tfdisponibilidadid_to = AV12TFDisponibilidadId_To ;
      AV85Disponibilidadwwds_4_tfeventid = AV13TFEventId ;
      AV86Disponibilidadwwds_5_tfeventid_sel = AV14TFEventId_Sel ;
      AV87Disponibilidadwwds_6_tfdisponibilidaddescription = AV15TFDisponibilidadDescription ;
      AV88Disponibilidadwwds_7_tfdisponibilidaddescription_sel = AV16TFDisponibilidadDescription_Sel ;
      AV89Disponibilidadwwds_8_tfprofesionalid = AV17TFProfesionalId ;
      AV90Disponibilidadwwds_9_tfprofesionalid_to = AV18TFProfesionalId_To ;
      AV91Disponibilidadwwds_10_tfprofesionalapellidopaterno = AV19TFProfesionalApellidoPaterno ;
      AV92Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel = AV20TFProfesionalApellidoPaterno_Sel ;
      AV93Disponibilidadwwds_12_tfprofesionalapellidomaterno = AV21TFProfesionalApellidoMaterno ;
      AV94Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel = AV22TFProfesionalApellidoMaterno_Sel ;
      AV95Disponibilidadwwds_14_tfprofesionalnombres = AV23TFProfesionalNombres ;
      AV96Disponibilidadwwds_15_tfprofesionalnombres_sel = AV24TFProfesionalNombres_Sel ;
      AV97Disponibilidadwwds_16_tfprofesionalnombrecompleto = AV25TFProfesionalNombreCompleto ;
      AV98Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel = AV26TFProfesionalNombreCompleto_Sel ;
      AV99Disponibilidadwwds_18_tfprofesionalcop = AV27TFProfesionalCOP ;
      AV100Disponibilidadwwds_19_tfprofesionalcop_sel = AV28TFProfesionalCOP_Sel ;
      AV101Disponibilidadwwds_20_tfdisponibilidadfecha = AV29TFDisponibilidadFecha ;
      AV102Disponibilidadwwds_21_tfdisponibilidadfecha_to = AV30TFDisponibilidadFecha_To ;
      AV103Disponibilidadwwds_22_tfdisponibilidadhorainicio = AV31TFDisponibilidadHoraInicio ;
      AV104Disponibilidadwwds_23_tfdisponibilidadhorainicio_to = AV32TFDisponibilidadHoraInicio_To ;
      AV105Disponibilidadwwds_24_tfdisponibilidadhorafin = AV33TFDisponibilidadHoraFin ;
      AV106Disponibilidadwwds_25_tfdisponibilidadhorafin_to = AV34TFDisponibilidadHoraFin_To ;
      AV107Disponibilidadwwds_26_tfespecialidadid = AV35TFEspecialidadId ;
      AV108Disponibilidadwwds_27_tfespecialidadid_to = AV36TFEspecialidadId_To ;
      AV109Disponibilidadwwds_28_tfespecialidadcodigo = AV37TFEspecialidadCodigo ;
      AV110Disponibilidadwwds_29_tfespecialidadcodigo_sel = AV38TFEspecialidadCodigo_Sel ;
      AV111Disponibilidadwwds_30_tfespecialidadnombre = AV39TFEspecialidadNombre ;
      AV112Disponibilidadwwds_31_tfespecialidadnombre_sel = AV40TFEspecialidadNombre_Sel ;
      AV113Disponibilidadwwds_32_tfdisponibilidaduser = AV49TFDisponibilidadUser ;
      AV114Disponibilidadwwds_33_tfdisponibilidaduser_to = AV50TFDisponibilidadUser_To ;
      AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels = AV52TFDisponibilidadEstado_Sels ;
      AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels = AV54TFDisponibilidadEstadoCita_Sels ;
      AV117Disponibilidadwwds_36_tfdcitaid = AV55TFDCitaId ;
      AV118Disponibilidadwwds_37_tfdcitaid_to = AV56TFDCitaId_To ;
      AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels = AV77TFDisponibilidadTipoCita_Sels ;
      pr_default.dynParam(7, new Object[]{ new Object[]{
                                           A136DisponibilidadEstado ,
                                           AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels ,
                                           A139DisponibilidadEstadoCita ,
                                           AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels ,
                                           A298DisponibilidadTipoCita ,
                                           AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels ,
                                           Integer.valueOf(AV83Disponibilidadwwds_2_tfdisponibilidadid) ,
                                           Integer.valueOf(AV84Disponibilidadwwds_3_tfdisponibilidadid_to) ,
                                           AV86Disponibilidadwwds_5_tfeventid_sel ,
                                           AV85Disponibilidadwwds_4_tfeventid ,
                                           AV88Disponibilidadwwds_7_tfdisponibilidaddescription_sel ,
                                           AV87Disponibilidadwwds_6_tfdisponibilidaddescription ,
                                           Integer.valueOf(AV89Disponibilidadwwds_8_tfprofesionalid) ,
                                           Integer.valueOf(AV90Disponibilidadwwds_9_tfprofesionalid_to) ,
                                           AV92Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel ,
                                           AV91Disponibilidadwwds_10_tfprofesionalapellidopaterno ,
                                           AV94Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel ,
                                           AV93Disponibilidadwwds_12_tfprofesionalapellidomaterno ,
                                           AV96Disponibilidadwwds_15_tfprofesionalnombres_sel ,
                                           AV95Disponibilidadwwds_14_tfprofesionalnombres ,
                                           AV98Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel ,
                                           AV97Disponibilidadwwds_16_tfprofesionalnombrecompleto ,
                                           AV100Disponibilidadwwds_19_tfprofesionalcop_sel ,
                                           AV99Disponibilidadwwds_18_tfprofesionalcop ,
                                           AV101Disponibilidadwwds_20_tfdisponibilidadfecha ,
                                           AV102Disponibilidadwwds_21_tfdisponibilidadfecha_to ,
                                           AV103Disponibilidadwwds_22_tfdisponibilidadhorainicio ,
                                           AV104Disponibilidadwwds_23_tfdisponibilidadhorainicio_to ,
                                           AV105Disponibilidadwwds_24_tfdisponibilidadhorafin ,
                                           AV106Disponibilidadwwds_25_tfdisponibilidadhorafin_to ,
                                           Short.valueOf(AV107Disponibilidadwwds_26_tfespecialidadid) ,
                                           Short.valueOf(AV108Disponibilidadwwds_27_tfespecialidadid_to) ,
                                           AV110Disponibilidadwwds_29_tfespecialidadcodigo_sel ,
                                           AV109Disponibilidadwwds_28_tfespecialidadcodigo ,
                                           AV112Disponibilidadwwds_31_tfespecialidadnombre_sel ,
                                           AV111Disponibilidadwwds_30_tfespecialidadnombre ,
                                           Integer.valueOf(AV113Disponibilidadwwds_32_tfdisponibilidaduser) ,
                                           Integer.valueOf(AV114Disponibilidadwwds_33_tfdisponibilidaduser_to) ,
                                           Integer.valueOf(AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels.size()) ,
                                           Integer.valueOf(AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels.size()) ,
                                           Integer.valueOf(AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels.size()) ,
                                           Integer.valueOf(A34DisponibilidadId) ,
                                           A133EventId ,
                                           A134DisponibilidadDescription ,
                                           Integer.valueOf(A31ProfesionalId) ,
                                           A85ProfesionalApellidoPaterno ,
                                           A86ProfesionalApellidoMaterno ,
                                           A84ProfesionalNombres ,
                                           A88ProfesionalCOP ,
                                           A67DisponibilidadFecha ,
                                           A69DisponibilidadHoraInicio ,
                                           A135DisponibilidadHoraFin ,
                                           Short.valueOf(A32EspecialidadId) ,
                                           A140EspecialidadCodigo ,
                                           A71EspecialidadNombre ,
                                           Integer.valueOf(A137DisponibilidadUser) ,
                                           AV82Disponibilidadwwds_1_filterfulltext ,
                                           A83ProfesionalNombreCompleto ,
                                           Integer.valueOf(A138DCitaId) ,
                                           Integer.valueOf(AV117Disponibilidadwwds_36_tfdcitaid) ,
                                           Integer.valueOf(AV118Disponibilidadwwds_37_tfdcitaid_to) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN,
                                           TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.BOOLEAN,
                                           TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV85Disponibilidadwwds_4_tfeventid = GXutil.padr( GXutil.rtrim( AV85Disponibilidadwwds_4_tfeventid), 20, "%") ;
      lV87Disponibilidadwwds_6_tfdisponibilidaddescription = GXutil.concat( GXutil.rtrim( AV87Disponibilidadwwds_6_tfdisponibilidaddescription), "%", "") ;
      lV91Disponibilidadwwds_10_tfprofesionalapellidopaterno = GXutil.concat( GXutil.rtrim( AV91Disponibilidadwwds_10_tfprofesionalapellidopaterno), "%", "") ;
      lV93Disponibilidadwwds_12_tfprofesionalapellidomaterno = GXutil.concat( GXutil.rtrim( AV93Disponibilidadwwds_12_tfprofesionalapellidomaterno), "%", "") ;
      lV95Disponibilidadwwds_14_tfprofesionalnombres = GXutil.concat( GXutil.rtrim( AV95Disponibilidadwwds_14_tfprofesionalnombres), "%", "") ;
      lV97Disponibilidadwwds_16_tfprofesionalnombrecompleto = GXutil.concat( GXutil.rtrim( AV97Disponibilidadwwds_16_tfprofesionalnombrecompleto), "%", "") ;
      lV99Disponibilidadwwds_18_tfprofesionalcop = GXutil.concat( GXutil.rtrim( AV99Disponibilidadwwds_18_tfprofesionalcop), "%", "") ;
      lV109Disponibilidadwwds_28_tfespecialidadcodigo = GXutil.concat( GXutil.rtrim( AV109Disponibilidadwwds_28_tfespecialidadcodigo), "%", "") ;
      lV111Disponibilidadwwds_30_tfespecialidadnombre = GXutil.concat( GXutil.rtrim( AV111Disponibilidadwwds_30_tfespecialidadnombre), "%", "") ;
      /* Using cursor P002X17 */
      pr_default.execute(7, new Object[] {AV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, Integer.valueOf(AV117Disponibilidadwwds_36_tfdcitaid), Integer.valueOf(AV117Disponibilidadwwds_36_tfdcitaid), Integer.valueOf(AV118Disponibilidadwwds_37_tfdcitaid_to), Integer.valueOf(AV118Disponibilidadwwds_37_tfdcitaid_to), Integer.valueOf(AV83Disponibilidadwwds_2_tfdisponibilidadid), Integer.valueOf(AV84Disponibilidadwwds_3_tfdisponibilidadid_to), lV85Disponibilidadwwds_4_tfeventid, AV86Disponibilidadwwds_5_tfeventid_sel, lV87Disponibilidadwwds_6_tfdisponibilidaddescription, AV88Disponibilidadwwds_7_tfdisponibilidaddescription_sel, Integer.valueOf(AV89Disponibilidadwwds_8_tfprofesionalid), Integer.valueOf(AV90Disponibilidadwwds_9_tfprofesionalid_to), lV91Disponibilidadwwds_10_tfprofesionalapellidopaterno, AV92Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel, lV93Disponibilidadwwds_12_tfprofesionalapellidomaterno, AV94Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel, lV95Disponibilidadwwds_14_tfprofesionalnombres, AV96Disponibilidadwwds_15_tfprofesionalnombres_sel, lV97Disponibilidadwwds_16_tfprofesionalnombrecompleto, AV98Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel, lV99Disponibilidadwwds_18_tfprofesionalcop, AV100Disponibilidadwwds_19_tfprofesionalcop_sel, AV101Disponibilidadwwds_20_tfdisponibilidadfecha, AV102Disponibilidadwwds_21_tfdisponibilidadfecha_to, AV103Disponibilidadwwds_22_tfdisponibilidadhorainicio, AV104Disponibilidadwwds_23_tfdisponibilidadhorainicio_to, AV105Disponibilidadwwds_24_tfdisponibilidadhorafin, AV106Disponibilidadwwds_25_tfdisponibilidadhorafin_to, Short.valueOf(AV107Disponibilidadwwds_26_tfespecialidadid), Short.valueOf(AV108Disponibilidadwwds_27_tfespecialidadid_to), lV109Disponibilidadwwds_28_tfespecialidadcodigo, AV110Disponibilidadwwds_29_tfespecialidadcodigo_sel, lV111Disponibilidadwwds_30_tfespecialidadnombre, AV112Disponibilidadwwds_31_tfespecialidadnombre_sel, Integer.valueOf(AV113Disponibilidadwwds_32_tfdisponibilidaduser), Integer.valueOf(AV114Disponibilidadwwds_33_tfdisponibilidaduser_to)});
      while ( (pr_default.getStatus(7) != 101) )
      {
         brk2X15 = false ;
         A140EspecialidadCodigo = P002X17_A140EspecialidadCodigo[0] ;
         A137DisponibilidadUser = P002X17_A137DisponibilidadUser[0] ;
         A32EspecialidadId = P002X17_A32EspecialidadId[0] ;
         A135DisponibilidadHoraFin = P002X17_A135DisponibilidadHoraFin[0] ;
         n135DisponibilidadHoraFin = P002X17_n135DisponibilidadHoraFin[0] ;
         A69DisponibilidadHoraInicio = P002X17_A69DisponibilidadHoraInicio[0] ;
         n69DisponibilidadHoraInicio = P002X17_n69DisponibilidadHoraInicio[0] ;
         A67DisponibilidadFecha = P002X17_A67DisponibilidadFecha[0] ;
         n67DisponibilidadFecha = P002X17_n67DisponibilidadFecha[0] ;
         A31ProfesionalId = P002X17_A31ProfesionalId[0] ;
         A34DisponibilidadId = P002X17_A34DisponibilidadId[0] ;
         A298DisponibilidadTipoCita = P002X17_A298DisponibilidadTipoCita[0] ;
         A139DisponibilidadEstadoCita = P002X17_A139DisponibilidadEstadoCita[0] ;
         A136DisponibilidadEstado = P002X17_A136DisponibilidadEstado[0] ;
         A71EspecialidadNombre = P002X17_A71EspecialidadNombre[0] ;
         A88ProfesionalCOP = P002X17_A88ProfesionalCOP[0] ;
         A83ProfesionalNombreCompleto = P002X17_A83ProfesionalNombreCompleto[0] ;
         A134DisponibilidadDescription = P002X17_A134DisponibilidadDescription[0] ;
         A133EventId = P002X17_A133EventId[0] ;
         A138DCitaId = P002X17_A138DCitaId[0] ;
         n138DCitaId = P002X17_n138DCitaId[0] ;
         A84ProfesionalNombres = P002X17_A84ProfesionalNombres[0] ;
         A85ProfesionalApellidoPaterno = P002X17_A85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = P002X17_A86ProfesionalApellidoMaterno[0] ;
         A140EspecialidadCodigo = P002X17_A140EspecialidadCodigo[0] ;
         A71EspecialidadNombre = P002X17_A71EspecialidadNombre[0] ;
         A88ProfesionalCOP = P002X17_A88ProfesionalCOP[0] ;
         A84ProfesionalNombres = P002X17_A84ProfesionalNombres[0] ;
         A85ProfesionalApellidoPaterno = P002X17_A85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = P002X17_A86ProfesionalApellidoMaterno[0] ;
         A138DCitaId = P002X17_A138DCitaId[0] ;
         n138DCitaId = P002X17_n138DCitaId[0] ;
         AV69count = 0 ;
         while ( (pr_default.getStatus(7) != 101) && ( GXutil.strcmp(P002X17_A140EspecialidadCodigo[0], A140EspecialidadCodigo) == 0 ) )
         {
            brk2X15 = false ;
            A32EspecialidadId = P002X17_A32EspecialidadId[0] ;
            A34DisponibilidadId = P002X17_A34DisponibilidadId[0] ;
            AV69count = (long)(AV69count+1) ;
            brk2X15 = true ;
            pr_default.readNext(7);
         }
         if ( ! (GXutil.strcmp("", A140EspecialidadCodigo)==0) )
         {
            AV61Option = A140EspecialidadCodigo ;
            AV62Options.add(AV61Option, 0);
            AV67OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV69count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV62Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk2X15 )
         {
            brk2X15 = true ;
            pr_default.readNext(7);
         }
      }
      pr_default.close(7);
   }

   public void S201( )
   {
      /* 'LOADESPECIALIDADNOMBREOPTIONS' Routine */
      returnInSub = false ;
      AV39TFEspecialidadNombre = AV57SearchTxt ;
      AV40TFEspecialidadNombre_Sel = "" ;
      AV82Disponibilidadwwds_1_filterfulltext = AV75FilterFullText ;
      AV83Disponibilidadwwds_2_tfdisponibilidadid = AV11TFDisponibilidadId ;
      AV84Disponibilidadwwds_3_tfdisponibilidadid_to = AV12TFDisponibilidadId_To ;
      AV85Disponibilidadwwds_4_tfeventid = AV13TFEventId ;
      AV86Disponibilidadwwds_5_tfeventid_sel = AV14TFEventId_Sel ;
      AV87Disponibilidadwwds_6_tfdisponibilidaddescription = AV15TFDisponibilidadDescription ;
      AV88Disponibilidadwwds_7_tfdisponibilidaddescription_sel = AV16TFDisponibilidadDescription_Sel ;
      AV89Disponibilidadwwds_8_tfprofesionalid = AV17TFProfesionalId ;
      AV90Disponibilidadwwds_9_tfprofesionalid_to = AV18TFProfesionalId_To ;
      AV91Disponibilidadwwds_10_tfprofesionalapellidopaterno = AV19TFProfesionalApellidoPaterno ;
      AV92Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel = AV20TFProfesionalApellidoPaterno_Sel ;
      AV93Disponibilidadwwds_12_tfprofesionalapellidomaterno = AV21TFProfesionalApellidoMaterno ;
      AV94Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel = AV22TFProfesionalApellidoMaterno_Sel ;
      AV95Disponibilidadwwds_14_tfprofesionalnombres = AV23TFProfesionalNombres ;
      AV96Disponibilidadwwds_15_tfprofesionalnombres_sel = AV24TFProfesionalNombres_Sel ;
      AV97Disponibilidadwwds_16_tfprofesionalnombrecompleto = AV25TFProfesionalNombreCompleto ;
      AV98Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel = AV26TFProfesionalNombreCompleto_Sel ;
      AV99Disponibilidadwwds_18_tfprofesionalcop = AV27TFProfesionalCOP ;
      AV100Disponibilidadwwds_19_tfprofesionalcop_sel = AV28TFProfesionalCOP_Sel ;
      AV101Disponibilidadwwds_20_tfdisponibilidadfecha = AV29TFDisponibilidadFecha ;
      AV102Disponibilidadwwds_21_tfdisponibilidadfecha_to = AV30TFDisponibilidadFecha_To ;
      AV103Disponibilidadwwds_22_tfdisponibilidadhorainicio = AV31TFDisponibilidadHoraInicio ;
      AV104Disponibilidadwwds_23_tfdisponibilidadhorainicio_to = AV32TFDisponibilidadHoraInicio_To ;
      AV105Disponibilidadwwds_24_tfdisponibilidadhorafin = AV33TFDisponibilidadHoraFin ;
      AV106Disponibilidadwwds_25_tfdisponibilidadhorafin_to = AV34TFDisponibilidadHoraFin_To ;
      AV107Disponibilidadwwds_26_tfespecialidadid = AV35TFEspecialidadId ;
      AV108Disponibilidadwwds_27_tfespecialidadid_to = AV36TFEspecialidadId_To ;
      AV109Disponibilidadwwds_28_tfespecialidadcodigo = AV37TFEspecialidadCodigo ;
      AV110Disponibilidadwwds_29_tfespecialidadcodigo_sel = AV38TFEspecialidadCodigo_Sel ;
      AV111Disponibilidadwwds_30_tfespecialidadnombre = AV39TFEspecialidadNombre ;
      AV112Disponibilidadwwds_31_tfespecialidadnombre_sel = AV40TFEspecialidadNombre_Sel ;
      AV113Disponibilidadwwds_32_tfdisponibilidaduser = AV49TFDisponibilidadUser ;
      AV114Disponibilidadwwds_33_tfdisponibilidaduser_to = AV50TFDisponibilidadUser_To ;
      AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels = AV52TFDisponibilidadEstado_Sels ;
      AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels = AV54TFDisponibilidadEstadoCita_Sels ;
      AV117Disponibilidadwwds_36_tfdcitaid = AV55TFDCitaId ;
      AV118Disponibilidadwwds_37_tfdcitaid_to = AV56TFDCitaId_To ;
      AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels = AV77TFDisponibilidadTipoCita_Sels ;
      pr_default.dynParam(8, new Object[]{ new Object[]{
                                           A136DisponibilidadEstado ,
                                           AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels ,
                                           A139DisponibilidadEstadoCita ,
                                           AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels ,
                                           A298DisponibilidadTipoCita ,
                                           AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels ,
                                           Integer.valueOf(AV83Disponibilidadwwds_2_tfdisponibilidadid) ,
                                           Integer.valueOf(AV84Disponibilidadwwds_3_tfdisponibilidadid_to) ,
                                           AV86Disponibilidadwwds_5_tfeventid_sel ,
                                           AV85Disponibilidadwwds_4_tfeventid ,
                                           AV88Disponibilidadwwds_7_tfdisponibilidaddescription_sel ,
                                           AV87Disponibilidadwwds_6_tfdisponibilidaddescription ,
                                           Integer.valueOf(AV89Disponibilidadwwds_8_tfprofesionalid) ,
                                           Integer.valueOf(AV90Disponibilidadwwds_9_tfprofesionalid_to) ,
                                           AV92Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel ,
                                           AV91Disponibilidadwwds_10_tfprofesionalapellidopaterno ,
                                           AV94Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel ,
                                           AV93Disponibilidadwwds_12_tfprofesionalapellidomaterno ,
                                           AV96Disponibilidadwwds_15_tfprofesionalnombres_sel ,
                                           AV95Disponibilidadwwds_14_tfprofesionalnombres ,
                                           AV98Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel ,
                                           AV97Disponibilidadwwds_16_tfprofesionalnombrecompleto ,
                                           AV100Disponibilidadwwds_19_tfprofesionalcop_sel ,
                                           AV99Disponibilidadwwds_18_tfprofesionalcop ,
                                           AV101Disponibilidadwwds_20_tfdisponibilidadfecha ,
                                           AV102Disponibilidadwwds_21_tfdisponibilidadfecha_to ,
                                           AV103Disponibilidadwwds_22_tfdisponibilidadhorainicio ,
                                           AV104Disponibilidadwwds_23_tfdisponibilidadhorainicio_to ,
                                           AV105Disponibilidadwwds_24_tfdisponibilidadhorafin ,
                                           AV106Disponibilidadwwds_25_tfdisponibilidadhorafin_to ,
                                           Short.valueOf(AV107Disponibilidadwwds_26_tfespecialidadid) ,
                                           Short.valueOf(AV108Disponibilidadwwds_27_tfespecialidadid_to) ,
                                           AV110Disponibilidadwwds_29_tfespecialidadcodigo_sel ,
                                           AV109Disponibilidadwwds_28_tfespecialidadcodigo ,
                                           AV112Disponibilidadwwds_31_tfespecialidadnombre_sel ,
                                           AV111Disponibilidadwwds_30_tfespecialidadnombre ,
                                           Integer.valueOf(AV113Disponibilidadwwds_32_tfdisponibilidaduser) ,
                                           Integer.valueOf(AV114Disponibilidadwwds_33_tfdisponibilidaduser_to) ,
                                           Integer.valueOf(AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels.size()) ,
                                           Integer.valueOf(AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels.size()) ,
                                           Integer.valueOf(AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels.size()) ,
                                           Integer.valueOf(A34DisponibilidadId) ,
                                           A133EventId ,
                                           A134DisponibilidadDescription ,
                                           Integer.valueOf(A31ProfesionalId) ,
                                           A85ProfesionalApellidoPaterno ,
                                           A86ProfesionalApellidoMaterno ,
                                           A84ProfesionalNombres ,
                                           A88ProfesionalCOP ,
                                           A67DisponibilidadFecha ,
                                           A69DisponibilidadHoraInicio ,
                                           A135DisponibilidadHoraFin ,
                                           Short.valueOf(A32EspecialidadId) ,
                                           A140EspecialidadCodigo ,
                                           A71EspecialidadNombre ,
                                           Integer.valueOf(A137DisponibilidadUser) ,
                                           AV82Disponibilidadwwds_1_filterfulltext ,
                                           A83ProfesionalNombreCompleto ,
                                           Integer.valueOf(A138DCitaId) ,
                                           Integer.valueOf(AV117Disponibilidadwwds_36_tfdcitaid) ,
                                           Integer.valueOf(AV118Disponibilidadwwds_37_tfdcitaid_to) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN,
                                           TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.BOOLEAN,
                                           TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV82Disponibilidadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV82Disponibilidadwwds_1_filterfulltext), "%", "") ;
      lV85Disponibilidadwwds_4_tfeventid = GXutil.padr( GXutil.rtrim( AV85Disponibilidadwwds_4_tfeventid), 20, "%") ;
      lV87Disponibilidadwwds_6_tfdisponibilidaddescription = GXutil.concat( GXutil.rtrim( AV87Disponibilidadwwds_6_tfdisponibilidaddescription), "%", "") ;
      lV91Disponibilidadwwds_10_tfprofesionalapellidopaterno = GXutil.concat( GXutil.rtrim( AV91Disponibilidadwwds_10_tfprofesionalapellidopaterno), "%", "") ;
      lV93Disponibilidadwwds_12_tfprofesionalapellidomaterno = GXutil.concat( GXutil.rtrim( AV93Disponibilidadwwds_12_tfprofesionalapellidomaterno), "%", "") ;
      lV95Disponibilidadwwds_14_tfprofesionalnombres = GXutil.concat( GXutil.rtrim( AV95Disponibilidadwwds_14_tfprofesionalnombres), "%", "") ;
      lV97Disponibilidadwwds_16_tfprofesionalnombrecompleto = GXutil.concat( GXutil.rtrim( AV97Disponibilidadwwds_16_tfprofesionalnombrecompleto), "%", "") ;
      lV99Disponibilidadwwds_18_tfprofesionalcop = GXutil.concat( GXutil.rtrim( AV99Disponibilidadwwds_18_tfprofesionalcop), "%", "") ;
      lV109Disponibilidadwwds_28_tfespecialidadcodigo = GXutil.concat( GXutil.rtrim( AV109Disponibilidadwwds_28_tfespecialidadcodigo), "%", "") ;
      lV111Disponibilidadwwds_30_tfespecialidadnombre = GXutil.concat( GXutil.rtrim( AV111Disponibilidadwwds_30_tfespecialidadnombre), "%", "") ;
      /* Using cursor P002X19 */
      pr_default.execute(8, new Object[] {AV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, lV82Disponibilidadwwds_1_filterfulltext, Integer.valueOf(AV117Disponibilidadwwds_36_tfdcitaid), Integer.valueOf(AV117Disponibilidadwwds_36_tfdcitaid), Integer.valueOf(AV118Disponibilidadwwds_37_tfdcitaid_to), Integer.valueOf(AV118Disponibilidadwwds_37_tfdcitaid_to), Integer.valueOf(AV83Disponibilidadwwds_2_tfdisponibilidadid), Integer.valueOf(AV84Disponibilidadwwds_3_tfdisponibilidadid_to), lV85Disponibilidadwwds_4_tfeventid, AV86Disponibilidadwwds_5_tfeventid_sel, lV87Disponibilidadwwds_6_tfdisponibilidaddescription, AV88Disponibilidadwwds_7_tfdisponibilidaddescription_sel, Integer.valueOf(AV89Disponibilidadwwds_8_tfprofesionalid), Integer.valueOf(AV90Disponibilidadwwds_9_tfprofesionalid_to), lV91Disponibilidadwwds_10_tfprofesionalapellidopaterno, AV92Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel, lV93Disponibilidadwwds_12_tfprofesionalapellidomaterno, AV94Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel, lV95Disponibilidadwwds_14_tfprofesionalnombres, AV96Disponibilidadwwds_15_tfprofesionalnombres_sel, lV97Disponibilidadwwds_16_tfprofesionalnombrecompleto, AV98Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel, lV99Disponibilidadwwds_18_tfprofesionalcop, AV100Disponibilidadwwds_19_tfprofesionalcop_sel, AV101Disponibilidadwwds_20_tfdisponibilidadfecha, AV102Disponibilidadwwds_21_tfdisponibilidadfecha_to, AV103Disponibilidadwwds_22_tfdisponibilidadhorainicio, AV104Disponibilidadwwds_23_tfdisponibilidadhorainicio_to, AV105Disponibilidadwwds_24_tfdisponibilidadhorafin, AV106Disponibilidadwwds_25_tfdisponibilidadhorafin_to, Short.valueOf(AV107Disponibilidadwwds_26_tfespecialidadid), Short.valueOf(AV108Disponibilidadwwds_27_tfespecialidadid_to), lV109Disponibilidadwwds_28_tfespecialidadcodigo, AV110Disponibilidadwwds_29_tfespecialidadcodigo_sel, lV111Disponibilidadwwds_30_tfespecialidadnombre, AV112Disponibilidadwwds_31_tfespecialidadnombre_sel, Integer.valueOf(AV113Disponibilidadwwds_32_tfdisponibilidaduser), Integer.valueOf(AV114Disponibilidadwwds_33_tfdisponibilidaduser_to)});
      while ( (pr_default.getStatus(8) != 101) )
      {
         brk2X17 = false ;
         A71EspecialidadNombre = P002X19_A71EspecialidadNombre[0] ;
         A137DisponibilidadUser = P002X19_A137DisponibilidadUser[0] ;
         A32EspecialidadId = P002X19_A32EspecialidadId[0] ;
         A135DisponibilidadHoraFin = P002X19_A135DisponibilidadHoraFin[0] ;
         n135DisponibilidadHoraFin = P002X19_n135DisponibilidadHoraFin[0] ;
         A69DisponibilidadHoraInicio = P002X19_A69DisponibilidadHoraInicio[0] ;
         n69DisponibilidadHoraInicio = P002X19_n69DisponibilidadHoraInicio[0] ;
         A67DisponibilidadFecha = P002X19_A67DisponibilidadFecha[0] ;
         n67DisponibilidadFecha = P002X19_n67DisponibilidadFecha[0] ;
         A31ProfesionalId = P002X19_A31ProfesionalId[0] ;
         A34DisponibilidadId = P002X19_A34DisponibilidadId[0] ;
         A298DisponibilidadTipoCita = P002X19_A298DisponibilidadTipoCita[0] ;
         A139DisponibilidadEstadoCita = P002X19_A139DisponibilidadEstadoCita[0] ;
         A136DisponibilidadEstado = P002X19_A136DisponibilidadEstado[0] ;
         A140EspecialidadCodigo = P002X19_A140EspecialidadCodigo[0] ;
         A88ProfesionalCOP = P002X19_A88ProfesionalCOP[0] ;
         A83ProfesionalNombreCompleto = P002X19_A83ProfesionalNombreCompleto[0] ;
         A134DisponibilidadDescription = P002X19_A134DisponibilidadDescription[0] ;
         A133EventId = P002X19_A133EventId[0] ;
         A138DCitaId = P002X19_A138DCitaId[0] ;
         n138DCitaId = P002X19_n138DCitaId[0] ;
         A84ProfesionalNombres = P002X19_A84ProfesionalNombres[0] ;
         A85ProfesionalApellidoPaterno = P002X19_A85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = P002X19_A86ProfesionalApellidoMaterno[0] ;
         A71EspecialidadNombre = P002X19_A71EspecialidadNombre[0] ;
         A140EspecialidadCodigo = P002X19_A140EspecialidadCodigo[0] ;
         A88ProfesionalCOP = P002X19_A88ProfesionalCOP[0] ;
         A84ProfesionalNombres = P002X19_A84ProfesionalNombres[0] ;
         A85ProfesionalApellidoPaterno = P002X19_A85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = P002X19_A86ProfesionalApellidoMaterno[0] ;
         A138DCitaId = P002X19_A138DCitaId[0] ;
         n138DCitaId = P002X19_n138DCitaId[0] ;
         AV69count = 0 ;
         while ( (pr_default.getStatus(8) != 101) && ( GXutil.strcmp(P002X19_A71EspecialidadNombre[0], A71EspecialidadNombre) == 0 ) )
         {
            brk2X17 = false ;
            A32EspecialidadId = P002X19_A32EspecialidadId[0] ;
            A34DisponibilidadId = P002X19_A34DisponibilidadId[0] ;
            AV69count = (long)(AV69count+1) ;
            brk2X17 = true ;
            pr_default.readNext(8);
         }
         if ( ! (GXutil.strcmp("", A71EspecialidadNombre)==0) )
         {
            AV61Option = A71EspecialidadNombre ;
            AV62Options.add(AV61Option, 0);
            AV67OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV69count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV62Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk2X17 )
         {
            brk2X17 = true ;
            pr_default.readNext(8);
         }
      }
      pr_default.close(8);
   }

   protected void cleanup( )
   {
      this.aP3[0] = disponibilidadwwgetfilterdata.this.AV63OptionsJson;
      this.aP4[0] = disponibilidadwwgetfilterdata.this.AV66OptionsDescJson;
      this.aP5[0] = disponibilidadwwgetfilterdata.this.AV68OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV63OptionsJson = "" ;
      AV66OptionsDescJson = "" ;
      AV68OptionIndexesJson = "" ;
      AV62Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV65OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV67OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean2 = new boolean[1] ;
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV70Session = httpContext.getWebSession();
      AV72GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV73GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV75FilterFullText = "" ;
      AV13TFEventId = "" ;
      AV14TFEventId_Sel = "" ;
      AV15TFDisponibilidadDescription = "" ;
      AV16TFDisponibilidadDescription_Sel = "" ;
      AV19TFProfesionalApellidoPaterno = "" ;
      AV20TFProfesionalApellidoPaterno_Sel = "" ;
      AV21TFProfesionalApellidoMaterno = "" ;
      AV22TFProfesionalApellidoMaterno_Sel = "" ;
      AV23TFProfesionalNombres = "" ;
      AV24TFProfesionalNombres_Sel = "" ;
      AV25TFProfesionalNombreCompleto = "" ;
      AV26TFProfesionalNombreCompleto_Sel = "" ;
      AV27TFProfesionalCOP = "" ;
      AV28TFProfesionalCOP_Sel = "" ;
      AV29TFDisponibilidadFecha = GXutil.nullDate() ;
      AV30TFDisponibilidadFecha_To = GXutil.nullDate() ;
      AV31TFDisponibilidadHoraInicio = GXutil.resetTime( GXutil.nullDate() );
      AV32TFDisponibilidadHoraInicio_To = GXutil.resetTime( GXutil.nullDate() );
      AV33TFDisponibilidadHoraFin = GXutil.resetTime( GXutil.nullDate() );
      AV34TFDisponibilidadHoraFin_To = GXutil.resetTime( GXutil.nullDate() );
      AV37TFEspecialidadCodigo = "" ;
      AV38TFEspecialidadCodigo_Sel = "" ;
      AV39TFEspecialidadNombre = "" ;
      AV40TFEspecialidadNombre_Sel = "" ;
      AV51TFDisponibilidadEstado_SelsJson = "" ;
      AV52TFDisponibilidadEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV53TFDisponibilidadEstadoCita_SelsJson = "" ;
      AV54TFDisponibilidadEstadoCita_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV76TFDisponibilidadTipoCita_SelsJson = "" ;
      AV77TFDisponibilidadTipoCita_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      A133EventId = "" ;
      AV82Disponibilidadwwds_1_filterfulltext = "" ;
      AV85Disponibilidadwwds_4_tfeventid = "" ;
      AV86Disponibilidadwwds_5_tfeventid_sel = "" ;
      AV87Disponibilidadwwds_6_tfdisponibilidaddescription = "" ;
      AV88Disponibilidadwwds_7_tfdisponibilidaddescription_sel = "" ;
      AV91Disponibilidadwwds_10_tfprofesionalapellidopaterno = "" ;
      AV92Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel = "" ;
      AV93Disponibilidadwwds_12_tfprofesionalapellidomaterno = "" ;
      AV94Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel = "" ;
      AV95Disponibilidadwwds_14_tfprofesionalnombres = "" ;
      AV96Disponibilidadwwds_15_tfprofesionalnombres_sel = "" ;
      AV97Disponibilidadwwds_16_tfprofesionalnombrecompleto = "" ;
      AV98Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel = "" ;
      AV99Disponibilidadwwds_18_tfprofesionalcop = "" ;
      AV100Disponibilidadwwds_19_tfprofesionalcop_sel = "" ;
      AV101Disponibilidadwwds_20_tfdisponibilidadfecha = GXutil.nullDate() ;
      AV102Disponibilidadwwds_21_tfdisponibilidadfecha_to = GXutil.nullDate() ;
      AV103Disponibilidadwwds_22_tfdisponibilidadhorainicio = GXutil.resetTime( GXutil.nullDate() );
      AV104Disponibilidadwwds_23_tfdisponibilidadhorainicio_to = GXutil.resetTime( GXutil.nullDate() );
      AV105Disponibilidadwwds_24_tfdisponibilidadhorafin = GXutil.resetTime( GXutil.nullDate() );
      AV106Disponibilidadwwds_25_tfdisponibilidadhorafin_to = GXutil.resetTime( GXutil.nullDate() );
      AV109Disponibilidadwwds_28_tfespecialidadcodigo = "" ;
      AV110Disponibilidadwwds_29_tfespecialidadcodigo_sel = "" ;
      AV111Disponibilidadwwds_30_tfespecialidadnombre = "" ;
      AV112Disponibilidadwwds_31_tfespecialidadnombre_sel = "" ;
      AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      lV82Disponibilidadwwds_1_filterfulltext = "" ;
      scmdbuf = "" ;
      lV85Disponibilidadwwds_4_tfeventid = "" ;
      lV87Disponibilidadwwds_6_tfdisponibilidaddescription = "" ;
      lV91Disponibilidadwwds_10_tfprofesionalapellidopaterno = "" ;
      lV93Disponibilidadwwds_12_tfprofesionalapellidomaterno = "" ;
      lV95Disponibilidadwwds_14_tfprofesionalnombres = "" ;
      lV97Disponibilidadwwds_16_tfprofesionalnombrecompleto = "" ;
      lV99Disponibilidadwwds_18_tfprofesionalcop = "" ;
      lV109Disponibilidadwwds_28_tfespecialidadcodigo = "" ;
      lV111Disponibilidadwwds_30_tfespecialidadnombre = "" ;
      A136DisponibilidadEstado = "" ;
      A139DisponibilidadEstadoCita = "" ;
      A298DisponibilidadTipoCita = "" ;
      A134DisponibilidadDescription = "" ;
      A85ProfesionalApellidoPaterno = "" ;
      A86ProfesionalApellidoMaterno = "" ;
      A84ProfesionalNombres = "" ;
      A88ProfesionalCOP = "" ;
      A67DisponibilidadFecha = GXutil.nullDate() ;
      A69DisponibilidadHoraInicio = GXutil.resetTime( GXutil.nullDate() );
      A135DisponibilidadHoraFin = GXutil.resetTime( GXutil.nullDate() );
      A140EspecialidadCodigo = "" ;
      A71EspecialidadNombre = "" ;
      A83ProfesionalNombreCompleto = "" ;
      P002X3_A133EventId = new String[] {""} ;
      P002X3_A137DisponibilidadUser = new int[1] ;
      P002X3_A32EspecialidadId = new short[1] ;
      P002X3_A135DisponibilidadHoraFin = new java.util.Date[] {GXutil.nullDate()} ;
      P002X3_n135DisponibilidadHoraFin = new boolean[] {false} ;
      P002X3_A69DisponibilidadHoraInicio = new java.util.Date[] {GXutil.nullDate()} ;
      P002X3_n69DisponibilidadHoraInicio = new boolean[] {false} ;
      P002X3_A67DisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P002X3_n67DisponibilidadFecha = new boolean[] {false} ;
      P002X3_A31ProfesionalId = new int[1] ;
      P002X3_A34DisponibilidadId = new int[1] ;
      P002X3_A298DisponibilidadTipoCita = new String[] {""} ;
      P002X3_A139DisponibilidadEstadoCita = new String[] {""} ;
      P002X3_A136DisponibilidadEstado = new String[] {""} ;
      P002X3_A71EspecialidadNombre = new String[] {""} ;
      P002X3_A140EspecialidadCodigo = new String[] {""} ;
      P002X3_A88ProfesionalCOP = new String[] {""} ;
      P002X3_A83ProfesionalNombreCompleto = new String[] {""} ;
      P002X3_A134DisponibilidadDescription = new String[] {""} ;
      P002X3_A138DCitaId = new int[1] ;
      P002X3_n138DCitaId = new boolean[] {false} ;
      P002X3_A84ProfesionalNombres = new String[] {""} ;
      P002X3_A85ProfesionalApellidoPaterno = new String[] {""} ;
      P002X3_A86ProfesionalApellidoMaterno = new String[] {""} ;
      AV61Option = "" ;
      P002X5_A134DisponibilidadDescription = new String[] {""} ;
      P002X5_A137DisponibilidadUser = new int[1] ;
      P002X5_A32EspecialidadId = new short[1] ;
      P002X5_A135DisponibilidadHoraFin = new java.util.Date[] {GXutil.nullDate()} ;
      P002X5_n135DisponibilidadHoraFin = new boolean[] {false} ;
      P002X5_A69DisponibilidadHoraInicio = new java.util.Date[] {GXutil.nullDate()} ;
      P002X5_n69DisponibilidadHoraInicio = new boolean[] {false} ;
      P002X5_A67DisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P002X5_n67DisponibilidadFecha = new boolean[] {false} ;
      P002X5_A31ProfesionalId = new int[1] ;
      P002X5_A34DisponibilidadId = new int[1] ;
      P002X5_A298DisponibilidadTipoCita = new String[] {""} ;
      P002X5_A139DisponibilidadEstadoCita = new String[] {""} ;
      P002X5_A136DisponibilidadEstado = new String[] {""} ;
      P002X5_A71EspecialidadNombre = new String[] {""} ;
      P002X5_A140EspecialidadCodigo = new String[] {""} ;
      P002X5_A88ProfesionalCOP = new String[] {""} ;
      P002X5_A83ProfesionalNombreCompleto = new String[] {""} ;
      P002X5_A133EventId = new String[] {""} ;
      P002X5_A138DCitaId = new int[1] ;
      P002X5_n138DCitaId = new boolean[] {false} ;
      P002X5_A84ProfesionalNombres = new String[] {""} ;
      P002X5_A85ProfesionalApellidoPaterno = new String[] {""} ;
      P002X5_A86ProfesionalApellidoMaterno = new String[] {""} ;
      P002X7_A137DisponibilidadUser = new int[1] ;
      P002X7_A32EspecialidadId = new short[1] ;
      P002X7_A135DisponibilidadHoraFin = new java.util.Date[] {GXutil.nullDate()} ;
      P002X7_n135DisponibilidadHoraFin = new boolean[] {false} ;
      P002X7_A69DisponibilidadHoraInicio = new java.util.Date[] {GXutil.nullDate()} ;
      P002X7_n69DisponibilidadHoraInicio = new boolean[] {false} ;
      P002X7_A67DisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P002X7_n67DisponibilidadFecha = new boolean[] {false} ;
      P002X7_A31ProfesionalId = new int[1] ;
      P002X7_A34DisponibilidadId = new int[1] ;
      P002X7_A298DisponibilidadTipoCita = new String[] {""} ;
      P002X7_A139DisponibilidadEstadoCita = new String[] {""} ;
      P002X7_A136DisponibilidadEstado = new String[] {""} ;
      P002X7_A71EspecialidadNombre = new String[] {""} ;
      P002X7_A140EspecialidadCodigo = new String[] {""} ;
      P002X7_A88ProfesionalCOP = new String[] {""} ;
      P002X7_A83ProfesionalNombreCompleto = new String[] {""} ;
      P002X7_A134DisponibilidadDescription = new String[] {""} ;
      P002X7_A133EventId = new String[] {""} ;
      P002X7_A138DCitaId = new int[1] ;
      P002X7_n138DCitaId = new boolean[] {false} ;
      P002X7_A84ProfesionalNombres = new String[] {""} ;
      P002X7_A85ProfesionalApellidoPaterno = new String[] {""} ;
      P002X7_A86ProfesionalApellidoMaterno = new String[] {""} ;
      P002X9_A137DisponibilidadUser = new int[1] ;
      P002X9_A32EspecialidadId = new short[1] ;
      P002X9_A135DisponibilidadHoraFin = new java.util.Date[] {GXutil.nullDate()} ;
      P002X9_n135DisponibilidadHoraFin = new boolean[] {false} ;
      P002X9_A69DisponibilidadHoraInicio = new java.util.Date[] {GXutil.nullDate()} ;
      P002X9_n69DisponibilidadHoraInicio = new boolean[] {false} ;
      P002X9_A67DisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P002X9_n67DisponibilidadFecha = new boolean[] {false} ;
      P002X9_A31ProfesionalId = new int[1] ;
      P002X9_A34DisponibilidadId = new int[1] ;
      P002X9_A298DisponibilidadTipoCita = new String[] {""} ;
      P002X9_A139DisponibilidadEstadoCita = new String[] {""} ;
      P002X9_A136DisponibilidadEstado = new String[] {""} ;
      P002X9_A71EspecialidadNombre = new String[] {""} ;
      P002X9_A140EspecialidadCodigo = new String[] {""} ;
      P002X9_A88ProfesionalCOP = new String[] {""} ;
      P002X9_A83ProfesionalNombreCompleto = new String[] {""} ;
      P002X9_A134DisponibilidadDescription = new String[] {""} ;
      P002X9_A133EventId = new String[] {""} ;
      P002X9_A138DCitaId = new int[1] ;
      P002X9_n138DCitaId = new boolean[] {false} ;
      P002X9_A84ProfesionalNombres = new String[] {""} ;
      P002X9_A85ProfesionalApellidoPaterno = new String[] {""} ;
      P002X9_A86ProfesionalApellidoMaterno = new String[] {""} ;
      P002X11_A137DisponibilidadUser = new int[1] ;
      P002X11_A32EspecialidadId = new short[1] ;
      P002X11_A135DisponibilidadHoraFin = new java.util.Date[] {GXutil.nullDate()} ;
      P002X11_n135DisponibilidadHoraFin = new boolean[] {false} ;
      P002X11_A69DisponibilidadHoraInicio = new java.util.Date[] {GXutil.nullDate()} ;
      P002X11_n69DisponibilidadHoraInicio = new boolean[] {false} ;
      P002X11_A67DisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P002X11_n67DisponibilidadFecha = new boolean[] {false} ;
      P002X11_A31ProfesionalId = new int[1] ;
      P002X11_A34DisponibilidadId = new int[1] ;
      P002X11_A298DisponibilidadTipoCita = new String[] {""} ;
      P002X11_A139DisponibilidadEstadoCita = new String[] {""} ;
      P002X11_A136DisponibilidadEstado = new String[] {""} ;
      P002X11_A71EspecialidadNombre = new String[] {""} ;
      P002X11_A140EspecialidadCodigo = new String[] {""} ;
      P002X11_A88ProfesionalCOP = new String[] {""} ;
      P002X11_A83ProfesionalNombreCompleto = new String[] {""} ;
      P002X11_A134DisponibilidadDescription = new String[] {""} ;
      P002X11_A133EventId = new String[] {""} ;
      P002X11_A138DCitaId = new int[1] ;
      P002X11_n138DCitaId = new boolean[] {false} ;
      P002X11_A84ProfesionalNombres = new String[] {""} ;
      P002X11_A85ProfesionalApellidoPaterno = new String[] {""} ;
      P002X11_A86ProfesionalApellidoMaterno = new String[] {""} ;
      P002X13_A137DisponibilidadUser = new int[1] ;
      P002X13_A32EspecialidadId = new short[1] ;
      P002X13_A135DisponibilidadHoraFin = new java.util.Date[] {GXutil.nullDate()} ;
      P002X13_n135DisponibilidadHoraFin = new boolean[] {false} ;
      P002X13_A69DisponibilidadHoraInicio = new java.util.Date[] {GXutil.nullDate()} ;
      P002X13_n69DisponibilidadHoraInicio = new boolean[] {false} ;
      P002X13_A67DisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P002X13_n67DisponibilidadFecha = new boolean[] {false} ;
      P002X13_A31ProfesionalId = new int[1] ;
      P002X13_A34DisponibilidadId = new int[1] ;
      P002X13_A298DisponibilidadTipoCita = new String[] {""} ;
      P002X13_A139DisponibilidadEstadoCita = new String[] {""} ;
      P002X13_A136DisponibilidadEstado = new String[] {""} ;
      P002X13_A71EspecialidadNombre = new String[] {""} ;
      P002X13_A140EspecialidadCodigo = new String[] {""} ;
      P002X13_A88ProfesionalCOP = new String[] {""} ;
      P002X13_A83ProfesionalNombreCompleto = new String[] {""} ;
      P002X13_A134DisponibilidadDescription = new String[] {""} ;
      P002X13_A133EventId = new String[] {""} ;
      P002X13_A138DCitaId = new int[1] ;
      P002X13_n138DCitaId = new boolean[] {false} ;
      P002X13_A84ProfesionalNombres = new String[] {""} ;
      P002X13_A85ProfesionalApellidoPaterno = new String[] {""} ;
      P002X13_A86ProfesionalApellidoMaterno = new String[] {""} ;
      P002X15_A88ProfesionalCOP = new String[] {""} ;
      P002X15_A137DisponibilidadUser = new int[1] ;
      P002X15_A32EspecialidadId = new short[1] ;
      P002X15_A135DisponibilidadHoraFin = new java.util.Date[] {GXutil.nullDate()} ;
      P002X15_n135DisponibilidadHoraFin = new boolean[] {false} ;
      P002X15_A69DisponibilidadHoraInicio = new java.util.Date[] {GXutil.nullDate()} ;
      P002X15_n69DisponibilidadHoraInicio = new boolean[] {false} ;
      P002X15_A67DisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P002X15_n67DisponibilidadFecha = new boolean[] {false} ;
      P002X15_A31ProfesionalId = new int[1] ;
      P002X15_A34DisponibilidadId = new int[1] ;
      P002X15_A298DisponibilidadTipoCita = new String[] {""} ;
      P002X15_A139DisponibilidadEstadoCita = new String[] {""} ;
      P002X15_A136DisponibilidadEstado = new String[] {""} ;
      P002X15_A71EspecialidadNombre = new String[] {""} ;
      P002X15_A140EspecialidadCodigo = new String[] {""} ;
      P002X15_A83ProfesionalNombreCompleto = new String[] {""} ;
      P002X15_A134DisponibilidadDescription = new String[] {""} ;
      P002X15_A133EventId = new String[] {""} ;
      P002X15_A138DCitaId = new int[1] ;
      P002X15_n138DCitaId = new boolean[] {false} ;
      P002X15_A84ProfesionalNombres = new String[] {""} ;
      P002X15_A85ProfesionalApellidoPaterno = new String[] {""} ;
      P002X15_A86ProfesionalApellidoMaterno = new String[] {""} ;
      P002X17_A140EspecialidadCodigo = new String[] {""} ;
      P002X17_A137DisponibilidadUser = new int[1] ;
      P002X17_A32EspecialidadId = new short[1] ;
      P002X17_A135DisponibilidadHoraFin = new java.util.Date[] {GXutil.nullDate()} ;
      P002X17_n135DisponibilidadHoraFin = new boolean[] {false} ;
      P002X17_A69DisponibilidadHoraInicio = new java.util.Date[] {GXutil.nullDate()} ;
      P002X17_n69DisponibilidadHoraInicio = new boolean[] {false} ;
      P002X17_A67DisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P002X17_n67DisponibilidadFecha = new boolean[] {false} ;
      P002X17_A31ProfesionalId = new int[1] ;
      P002X17_A34DisponibilidadId = new int[1] ;
      P002X17_A298DisponibilidadTipoCita = new String[] {""} ;
      P002X17_A139DisponibilidadEstadoCita = new String[] {""} ;
      P002X17_A136DisponibilidadEstado = new String[] {""} ;
      P002X17_A71EspecialidadNombre = new String[] {""} ;
      P002X17_A88ProfesionalCOP = new String[] {""} ;
      P002X17_A83ProfesionalNombreCompleto = new String[] {""} ;
      P002X17_A134DisponibilidadDescription = new String[] {""} ;
      P002X17_A133EventId = new String[] {""} ;
      P002X17_A138DCitaId = new int[1] ;
      P002X17_n138DCitaId = new boolean[] {false} ;
      P002X17_A84ProfesionalNombres = new String[] {""} ;
      P002X17_A85ProfesionalApellidoPaterno = new String[] {""} ;
      P002X17_A86ProfesionalApellidoMaterno = new String[] {""} ;
      P002X19_A71EspecialidadNombre = new String[] {""} ;
      P002X19_A137DisponibilidadUser = new int[1] ;
      P002X19_A32EspecialidadId = new short[1] ;
      P002X19_A135DisponibilidadHoraFin = new java.util.Date[] {GXutil.nullDate()} ;
      P002X19_n135DisponibilidadHoraFin = new boolean[] {false} ;
      P002X19_A69DisponibilidadHoraInicio = new java.util.Date[] {GXutil.nullDate()} ;
      P002X19_n69DisponibilidadHoraInicio = new boolean[] {false} ;
      P002X19_A67DisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P002X19_n67DisponibilidadFecha = new boolean[] {false} ;
      P002X19_A31ProfesionalId = new int[1] ;
      P002X19_A34DisponibilidadId = new int[1] ;
      P002X19_A298DisponibilidadTipoCita = new String[] {""} ;
      P002X19_A139DisponibilidadEstadoCita = new String[] {""} ;
      P002X19_A136DisponibilidadEstado = new String[] {""} ;
      P002X19_A140EspecialidadCodigo = new String[] {""} ;
      P002X19_A88ProfesionalCOP = new String[] {""} ;
      P002X19_A83ProfesionalNombreCompleto = new String[] {""} ;
      P002X19_A134DisponibilidadDescription = new String[] {""} ;
      P002X19_A133EventId = new String[] {""} ;
      P002X19_A138DCitaId = new int[1] ;
      P002X19_n138DCitaId = new boolean[] {false} ;
      P002X19_A84ProfesionalNombres = new String[] {""} ;
      P002X19_A85ProfesionalApellidoPaterno = new String[] {""} ;
      P002X19_A86ProfesionalApellidoMaterno = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.disponibilidadwwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P002X3_A133EventId, P002X3_A137DisponibilidadUser, P002X3_A32EspecialidadId, P002X3_A135DisponibilidadHoraFin, P002X3_n135DisponibilidadHoraFin, P002X3_A69DisponibilidadHoraInicio, P002X3_n69DisponibilidadHoraInicio, P002X3_A67DisponibilidadFecha, P002X3_n67DisponibilidadFecha, P002X3_A31ProfesionalId,
            P002X3_A34DisponibilidadId, P002X3_A298DisponibilidadTipoCita, P002X3_A139DisponibilidadEstadoCita, P002X3_A136DisponibilidadEstado, P002X3_A71EspecialidadNombre, P002X3_A140EspecialidadCodigo, P002X3_A88ProfesionalCOP, P002X3_A83ProfesionalNombreCompleto, P002X3_A134DisponibilidadDescription, P002X3_A138DCitaId,
            P002X3_n138DCitaId, P002X3_A84ProfesionalNombres, P002X3_A85ProfesionalApellidoPaterno, P002X3_A86ProfesionalApellidoMaterno
            }
            , new Object[] {
            P002X5_A134DisponibilidadDescription, P002X5_A137DisponibilidadUser, P002X5_A32EspecialidadId, P002X5_A135DisponibilidadHoraFin, P002X5_n135DisponibilidadHoraFin, P002X5_A69DisponibilidadHoraInicio, P002X5_n69DisponibilidadHoraInicio, P002X5_A67DisponibilidadFecha, P002X5_n67DisponibilidadFecha, P002X5_A31ProfesionalId,
            P002X5_A34DisponibilidadId, P002X5_A298DisponibilidadTipoCita, P002X5_A139DisponibilidadEstadoCita, P002X5_A136DisponibilidadEstado, P002X5_A71EspecialidadNombre, P002X5_A140EspecialidadCodigo, P002X5_A88ProfesionalCOP, P002X5_A83ProfesionalNombreCompleto, P002X5_A133EventId, P002X5_A138DCitaId,
            P002X5_n138DCitaId, P002X5_A84ProfesionalNombres, P002X5_A85ProfesionalApellidoPaterno, P002X5_A86ProfesionalApellidoMaterno
            }
            , new Object[] {
            P002X7_A137DisponibilidadUser, P002X7_A32EspecialidadId, P002X7_A135DisponibilidadHoraFin, P002X7_n135DisponibilidadHoraFin, P002X7_A69DisponibilidadHoraInicio, P002X7_n69DisponibilidadHoraInicio, P002X7_A67DisponibilidadFecha, P002X7_n67DisponibilidadFecha, P002X7_A31ProfesionalId, P002X7_A34DisponibilidadId,
            P002X7_A298DisponibilidadTipoCita, P002X7_A139DisponibilidadEstadoCita, P002X7_A136DisponibilidadEstado, P002X7_A71EspecialidadNombre, P002X7_A140EspecialidadCodigo, P002X7_A88ProfesionalCOP, P002X7_A83ProfesionalNombreCompleto, P002X7_A134DisponibilidadDescription, P002X7_A133EventId, P002X7_A138DCitaId,
            P002X7_n138DCitaId, P002X7_A84ProfesionalNombres, P002X7_A85ProfesionalApellidoPaterno, P002X7_A86ProfesionalApellidoMaterno
            }
            , new Object[] {
            P002X9_A137DisponibilidadUser, P002X9_A32EspecialidadId, P002X9_A135DisponibilidadHoraFin, P002X9_n135DisponibilidadHoraFin, P002X9_A69DisponibilidadHoraInicio, P002X9_n69DisponibilidadHoraInicio, P002X9_A67DisponibilidadFecha, P002X9_n67DisponibilidadFecha, P002X9_A31ProfesionalId, P002X9_A34DisponibilidadId,
            P002X9_A298DisponibilidadTipoCita, P002X9_A139DisponibilidadEstadoCita, P002X9_A136DisponibilidadEstado, P002X9_A71EspecialidadNombre, P002X9_A140EspecialidadCodigo, P002X9_A88ProfesionalCOP, P002X9_A83ProfesionalNombreCompleto, P002X9_A134DisponibilidadDescription, P002X9_A133EventId, P002X9_A138DCitaId,
            P002X9_n138DCitaId, P002X9_A84ProfesionalNombres, P002X9_A85ProfesionalApellidoPaterno, P002X9_A86ProfesionalApellidoMaterno
            }
            , new Object[] {
            P002X11_A137DisponibilidadUser, P002X11_A32EspecialidadId, P002X11_A135DisponibilidadHoraFin, P002X11_n135DisponibilidadHoraFin, P002X11_A69DisponibilidadHoraInicio, P002X11_n69DisponibilidadHoraInicio, P002X11_A67DisponibilidadFecha, P002X11_n67DisponibilidadFecha, P002X11_A31ProfesionalId, P002X11_A34DisponibilidadId,
            P002X11_A298DisponibilidadTipoCita, P002X11_A139DisponibilidadEstadoCita, P002X11_A136DisponibilidadEstado, P002X11_A71EspecialidadNombre, P002X11_A140EspecialidadCodigo, P002X11_A88ProfesionalCOP, P002X11_A83ProfesionalNombreCompleto, P002X11_A134DisponibilidadDescription, P002X11_A133EventId, P002X11_A138DCitaId,
            P002X11_n138DCitaId, P002X11_A84ProfesionalNombres, P002X11_A85ProfesionalApellidoPaterno, P002X11_A86ProfesionalApellidoMaterno
            }
            , new Object[] {
            P002X13_A137DisponibilidadUser, P002X13_A32EspecialidadId, P002X13_A135DisponibilidadHoraFin, P002X13_n135DisponibilidadHoraFin, P002X13_A69DisponibilidadHoraInicio, P002X13_n69DisponibilidadHoraInicio, P002X13_A67DisponibilidadFecha, P002X13_n67DisponibilidadFecha, P002X13_A31ProfesionalId, P002X13_A34DisponibilidadId,
            P002X13_A298DisponibilidadTipoCita, P002X13_A139DisponibilidadEstadoCita, P002X13_A136DisponibilidadEstado, P002X13_A71EspecialidadNombre, P002X13_A140EspecialidadCodigo, P002X13_A88ProfesionalCOP, P002X13_A83ProfesionalNombreCompleto, P002X13_A134DisponibilidadDescription, P002X13_A133EventId, P002X13_A138DCitaId,
            P002X13_n138DCitaId, P002X13_A84ProfesionalNombres, P002X13_A85ProfesionalApellidoPaterno, P002X13_A86ProfesionalApellidoMaterno
            }
            , new Object[] {
            P002X15_A88ProfesionalCOP, P002X15_A137DisponibilidadUser, P002X15_A32EspecialidadId, P002X15_A135DisponibilidadHoraFin, P002X15_n135DisponibilidadHoraFin, P002X15_A69DisponibilidadHoraInicio, P002X15_n69DisponibilidadHoraInicio, P002X15_A67DisponibilidadFecha, P002X15_n67DisponibilidadFecha, P002X15_A31ProfesionalId,
            P002X15_A34DisponibilidadId, P002X15_A298DisponibilidadTipoCita, P002X15_A139DisponibilidadEstadoCita, P002X15_A136DisponibilidadEstado, P002X15_A71EspecialidadNombre, P002X15_A140EspecialidadCodigo, P002X15_A83ProfesionalNombreCompleto, P002X15_A134DisponibilidadDescription, P002X15_A133EventId, P002X15_A138DCitaId,
            P002X15_n138DCitaId, P002X15_A84ProfesionalNombres, P002X15_A85ProfesionalApellidoPaterno, P002X15_A86ProfesionalApellidoMaterno
            }
            , new Object[] {
            P002X17_A140EspecialidadCodigo, P002X17_A137DisponibilidadUser, P002X17_A32EspecialidadId, P002X17_A135DisponibilidadHoraFin, P002X17_n135DisponibilidadHoraFin, P002X17_A69DisponibilidadHoraInicio, P002X17_n69DisponibilidadHoraInicio, P002X17_A67DisponibilidadFecha, P002X17_n67DisponibilidadFecha, P002X17_A31ProfesionalId,
            P002X17_A34DisponibilidadId, P002X17_A298DisponibilidadTipoCita, P002X17_A139DisponibilidadEstadoCita, P002X17_A136DisponibilidadEstado, P002X17_A71EspecialidadNombre, P002X17_A88ProfesionalCOP, P002X17_A83ProfesionalNombreCompleto, P002X17_A134DisponibilidadDescription, P002X17_A133EventId, P002X17_A138DCitaId,
            P002X17_n138DCitaId, P002X17_A84ProfesionalNombres, P002X17_A85ProfesionalApellidoPaterno, P002X17_A86ProfesionalApellidoMaterno
            }
            , new Object[] {
            P002X19_A71EspecialidadNombre, P002X19_A137DisponibilidadUser, P002X19_A32EspecialidadId, P002X19_A135DisponibilidadHoraFin, P002X19_n135DisponibilidadHoraFin, P002X19_A69DisponibilidadHoraInicio, P002X19_n69DisponibilidadHoraInicio, P002X19_A67DisponibilidadFecha, P002X19_n67DisponibilidadFecha, P002X19_A31ProfesionalId,
            P002X19_A34DisponibilidadId, P002X19_A298DisponibilidadTipoCita, P002X19_A139DisponibilidadEstadoCita, P002X19_A136DisponibilidadEstado, P002X19_A140EspecialidadCodigo, P002X19_A88ProfesionalCOP, P002X19_A83ProfesionalNombreCompleto, P002X19_A134DisponibilidadDescription, P002X19_A133EventId, P002X19_A138DCitaId,
            P002X19_n138DCitaId, P002X19_A84ProfesionalNombres, P002X19_A85ProfesionalApellidoPaterno, P002X19_A86ProfesionalApellidoMaterno
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV35TFEspecialidadId ;
   private short AV36TFEspecialidadId_To ;
   private short AV107Disponibilidadwwds_26_tfespecialidadid ;
   private short AV108Disponibilidadwwds_27_tfespecialidadid_to ;
   private short A32EspecialidadId ;
   private short Gx_err ;
   private int AV80GXV1 ;
   private int AV11TFDisponibilidadId ;
   private int AV12TFDisponibilidadId_To ;
   private int AV17TFProfesionalId ;
   private int AV18TFProfesionalId_To ;
   private int AV49TFDisponibilidadUser ;
   private int AV50TFDisponibilidadUser_To ;
   private int AV55TFDCitaId ;
   private int AV56TFDCitaId_To ;
   private int AV83Disponibilidadwwds_2_tfdisponibilidadid ;
   private int AV84Disponibilidadwwds_3_tfdisponibilidadid_to ;
   private int AV89Disponibilidadwwds_8_tfprofesionalid ;
   private int AV90Disponibilidadwwds_9_tfprofesionalid_to ;
   private int AV113Disponibilidadwwds_32_tfdisponibilidaduser ;
   private int AV114Disponibilidadwwds_33_tfdisponibilidaduser_to ;
   private int AV117Disponibilidadwwds_36_tfdcitaid ;
   private int AV118Disponibilidadwwds_37_tfdcitaid_to ;
   private int AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels_size ;
   private int AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels_size ;
   private int AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels_size ;
   private int A34DisponibilidadId ;
   private int A31ProfesionalId ;
   private int A137DisponibilidadUser ;
   private int A138DCitaId ;
   private int AV60InsertIndex ;
   private long AV69count ;
   private String AV13TFEventId ;
   private String AV14TFEventId_Sel ;
   private String A133EventId ;
   private String AV85Disponibilidadwwds_4_tfeventid ;
   private String AV86Disponibilidadwwds_5_tfeventid_sel ;
   private String scmdbuf ;
   private String lV85Disponibilidadwwds_4_tfeventid ;
   private String A136DisponibilidadEstado ;
   private String A298DisponibilidadTipoCita ;
   private java.util.Date AV31TFDisponibilidadHoraInicio ;
   private java.util.Date AV32TFDisponibilidadHoraInicio_To ;
   private java.util.Date AV33TFDisponibilidadHoraFin ;
   private java.util.Date AV34TFDisponibilidadHoraFin_To ;
   private java.util.Date AV103Disponibilidadwwds_22_tfdisponibilidadhorainicio ;
   private java.util.Date AV104Disponibilidadwwds_23_tfdisponibilidadhorainicio_to ;
   private java.util.Date AV105Disponibilidadwwds_24_tfdisponibilidadhorafin ;
   private java.util.Date AV106Disponibilidadwwds_25_tfdisponibilidadhorafin_to ;
   private java.util.Date A69DisponibilidadHoraInicio ;
   private java.util.Date A135DisponibilidadHoraFin ;
   private java.util.Date AV29TFDisponibilidadFecha ;
   private java.util.Date AV30TFDisponibilidadFecha_To ;
   private java.util.Date AV101Disponibilidadwwds_20_tfdisponibilidadfecha ;
   private java.util.Date AV102Disponibilidadwwds_21_tfdisponibilidadfecha_to ;
   private java.util.Date A67DisponibilidadFecha ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean brk2X2 ;
   private boolean n135DisponibilidadHoraFin ;
   private boolean n69DisponibilidadHoraInicio ;
   private boolean n67DisponibilidadFecha ;
   private boolean n138DCitaId ;
   private boolean brk2X4 ;
   private boolean brk2X6 ;
   private boolean brk2X8 ;
   private boolean brk2X10 ;
   private boolean brk2X13 ;
   private boolean brk2X15 ;
   private boolean brk2X17 ;
   private String AV63OptionsJson ;
   private String AV66OptionsDescJson ;
   private String AV68OptionIndexesJson ;
   private String AV51TFDisponibilidadEstado_SelsJson ;
   private String AV53TFDisponibilidadEstadoCita_SelsJson ;
   private String AV76TFDisponibilidadTipoCita_SelsJson ;
   private String AV59DDOName ;
   private String AV57SearchTxt ;
   private String AV58SearchTxtTo ;
   private String AV75FilterFullText ;
   private String AV15TFDisponibilidadDescription ;
   private String AV16TFDisponibilidadDescription_Sel ;
   private String AV19TFProfesionalApellidoPaterno ;
   private String AV20TFProfesionalApellidoPaterno_Sel ;
   private String AV21TFProfesionalApellidoMaterno ;
   private String AV22TFProfesionalApellidoMaterno_Sel ;
   private String AV23TFProfesionalNombres ;
   private String AV24TFProfesionalNombres_Sel ;
   private String AV25TFProfesionalNombreCompleto ;
   private String AV26TFProfesionalNombreCompleto_Sel ;
   private String AV27TFProfesionalCOP ;
   private String AV28TFProfesionalCOP_Sel ;
   private String AV37TFEspecialidadCodigo ;
   private String AV38TFEspecialidadCodigo_Sel ;
   private String AV39TFEspecialidadNombre ;
   private String AV40TFEspecialidadNombre_Sel ;
   private String AV82Disponibilidadwwds_1_filterfulltext ;
   private String AV87Disponibilidadwwds_6_tfdisponibilidaddescription ;
   private String AV88Disponibilidadwwds_7_tfdisponibilidaddescription_sel ;
   private String AV91Disponibilidadwwds_10_tfprofesionalapellidopaterno ;
   private String AV92Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel ;
   private String AV93Disponibilidadwwds_12_tfprofesionalapellidomaterno ;
   private String AV94Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel ;
   private String AV95Disponibilidadwwds_14_tfprofesionalnombres ;
   private String AV96Disponibilidadwwds_15_tfprofesionalnombres_sel ;
   private String AV97Disponibilidadwwds_16_tfprofesionalnombrecompleto ;
   private String AV98Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel ;
   private String AV99Disponibilidadwwds_18_tfprofesionalcop ;
   private String AV100Disponibilidadwwds_19_tfprofesionalcop_sel ;
   private String AV109Disponibilidadwwds_28_tfespecialidadcodigo ;
   private String AV110Disponibilidadwwds_29_tfespecialidadcodigo_sel ;
   private String AV111Disponibilidadwwds_30_tfespecialidadnombre ;
   private String AV112Disponibilidadwwds_31_tfespecialidadnombre_sel ;
   private String lV82Disponibilidadwwds_1_filterfulltext ;
   private String lV87Disponibilidadwwds_6_tfdisponibilidaddescription ;
   private String lV91Disponibilidadwwds_10_tfprofesionalapellidopaterno ;
   private String lV93Disponibilidadwwds_12_tfprofesionalapellidomaterno ;
   private String lV95Disponibilidadwwds_14_tfprofesionalnombres ;
   private String lV97Disponibilidadwwds_16_tfprofesionalnombrecompleto ;
   private String lV99Disponibilidadwwds_18_tfprofesionalcop ;
   private String lV109Disponibilidadwwds_28_tfespecialidadcodigo ;
   private String lV111Disponibilidadwwds_30_tfespecialidadnombre ;
   private String A139DisponibilidadEstadoCita ;
   private String A134DisponibilidadDescription ;
   private String A85ProfesionalApellidoPaterno ;
   private String A86ProfesionalApellidoMaterno ;
   private String A84ProfesionalNombres ;
   private String A88ProfesionalCOP ;
   private String A140EspecialidadCodigo ;
   private String A71EspecialidadNombre ;
   private String A83ProfesionalNombreCompleto ;
   private String AV61Option ;
   private com.genexus.webpanels.WebSession AV70Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P002X3_A133EventId ;
   private int[] P002X3_A137DisponibilidadUser ;
   private short[] P002X3_A32EspecialidadId ;
   private java.util.Date[] P002X3_A135DisponibilidadHoraFin ;
   private boolean[] P002X3_n135DisponibilidadHoraFin ;
   private java.util.Date[] P002X3_A69DisponibilidadHoraInicio ;
   private boolean[] P002X3_n69DisponibilidadHoraInicio ;
   private java.util.Date[] P002X3_A67DisponibilidadFecha ;
   private boolean[] P002X3_n67DisponibilidadFecha ;
   private int[] P002X3_A31ProfesionalId ;
   private int[] P002X3_A34DisponibilidadId ;
   private String[] P002X3_A298DisponibilidadTipoCita ;
   private String[] P002X3_A139DisponibilidadEstadoCita ;
   private String[] P002X3_A136DisponibilidadEstado ;
   private String[] P002X3_A71EspecialidadNombre ;
   private String[] P002X3_A140EspecialidadCodigo ;
   private String[] P002X3_A88ProfesionalCOP ;
   private String[] P002X3_A83ProfesionalNombreCompleto ;
   private String[] P002X3_A134DisponibilidadDescription ;
   private int[] P002X3_A138DCitaId ;
   private boolean[] P002X3_n138DCitaId ;
   private String[] P002X3_A84ProfesionalNombres ;
   private String[] P002X3_A85ProfesionalApellidoPaterno ;
   private String[] P002X3_A86ProfesionalApellidoMaterno ;
   private String[] P002X5_A134DisponibilidadDescription ;
   private int[] P002X5_A137DisponibilidadUser ;
   private short[] P002X5_A32EspecialidadId ;
   private java.util.Date[] P002X5_A135DisponibilidadHoraFin ;
   private boolean[] P002X5_n135DisponibilidadHoraFin ;
   private java.util.Date[] P002X5_A69DisponibilidadHoraInicio ;
   private boolean[] P002X5_n69DisponibilidadHoraInicio ;
   private java.util.Date[] P002X5_A67DisponibilidadFecha ;
   private boolean[] P002X5_n67DisponibilidadFecha ;
   private int[] P002X5_A31ProfesionalId ;
   private int[] P002X5_A34DisponibilidadId ;
   private String[] P002X5_A298DisponibilidadTipoCita ;
   private String[] P002X5_A139DisponibilidadEstadoCita ;
   private String[] P002X5_A136DisponibilidadEstado ;
   private String[] P002X5_A71EspecialidadNombre ;
   private String[] P002X5_A140EspecialidadCodigo ;
   private String[] P002X5_A88ProfesionalCOP ;
   private String[] P002X5_A83ProfesionalNombreCompleto ;
   private String[] P002X5_A133EventId ;
   private int[] P002X5_A138DCitaId ;
   private boolean[] P002X5_n138DCitaId ;
   private String[] P002X5_A84ProfesionalNombres ;
   private String[] P002X5_A85ProfesionalApellidoPaterno ;
   private String[] P002X5_A86ProfesionalApellidoMaterno ;
   private int[] P002X7_A137DisponibilidadUser ;
   private short[] P002X7_A32EspecialidadId ;
   private java.util.Date[] P002X7_A135DisponibilidadHoraFin ;
   private boolean[] P002X7_n135DisponibilidadHoraFin ;
   private java.util.Date[] P002X7_A69DisponibilidadHoraInicio ;
   private boolean[] P002X7_n69DisponibilidadHoraInicio ;
   private java.util.Date[] P002X7_A67DisponibilidadFecha ;
   private boolean[] P002X7_n67DisponibilidadFecha ;
   private int[] P002X7_A31ProfesionalId ;
   private int[] P002X7_A34DisponibilidadId ;
   private String[] P002X7_A298DisponibilidadTipoCita ;
   private String[] P002X7_A139DisponibilidadEstadoCita ;
   private String[] P002X7_A136DisponibilidadEstado ;
   private String[] P002X7_A71EspecialidadNombre ;
   private String[] P002X7_A140EspecialidadCodigo ;
   private String[] P002X7_A88ProfesionalCOP ;
   private String[] P002X7_A83ProfesionalNombreCompleto ;
   private String[] P002X7_A134DisponibilidadDescription ;
   private String[] P002X7_A133EventId ;
   private int[] P002X7_A138DCitaId ;
   private boolean[] P002X7_n138DCitaId ;
   private String[] P002X7_A84ProfesionalNombres ;
   private String[] P002X7_A85ProfesionalApellidoPaterno ;
   private String[] P002X7_A86ProfesionalApellidoMaterno ;
   private int[] P002X9_A137DisponibilidadUser ;
   private short[] P002X9_A32EspecialidadId ;
   private java.util.Date[] P002X9_A135DisponibilidadHoraFin ;
   private boolean[] P002X9_n135DisponibilidadHoraFin ;
   private java.util.Date[] P002X9_A69DisponibilidadHoraInicio ;
   private boolean[] P002X9_n69DisponibilidadHoraInicio ;
   private java.util.Date[] P002X9_A67DisponibilidadFecha ;
   private boolean[] P002X9_n67DisponibilidadFecha ;
   private int[] P002X9_A31ProfesionalId ;
   private int[] P002X9_A34DisponibilidadId ;
   private String[] P002X9_A298DisponibilidadTipoCita ;
   private String[] P002X9_A139DisponibilidadEstadoCita ;
   private String[] P002X9_A136DisponibilidadEstado ;
   private String[] P002X9_A71EspecialidadNombre ;
   private String[] P002X9_A140EspecialidadCodigo ;
   private String[] P002X9_A88ProfesionalCOP ;
   private String[] P002X9_A83ProfesionalNombreCompleto ;
   private String[] P002X9_A134DisponibilidadDescription ;
   private String[] P002X9_A133EventId ;
   private int[] P002X9_A138DCitaId ;
   private boolean[] P002X9_n138DCitaId ;
   private String[] P002X9_A84ProfesionalNombres ;
   private String[] P002X9_A85ProfesionalApellidoPaterno ;
   private String[] P002X9_A86ProfesionalApellidoMaterno ;
   private int[] P002X11_A137DisponibilidadUser ;
   private short[] P002X11_A32EspecialidadId ;
   private java.util.Date[] P002X11_A135DisponibilidadHoraFin ;
   private boolean[] P002X11_n135DisponibilidadHoraFin ;
   private java.util.Date[] P002X11_A69DisponibilidadHoraInicio ;
   private boolean[] P002X11_n69DisponibilidadHoraInicio ;
   private java.util.Date[] P002X11_A67DisponibilidadFecha ;
   private boolean[] P002X11_n67DisponibilidadFecha ;
   private int[] P002X11_A31ProfesionalId ;
   private int[] P002X11_A34DisponibilidadId ;
   private String[] P002X11_A298DisponibilidadTipoCita ;
   private String[] P002X11_A139DisponibilidadEstadoCita ;
   private String[] P002X11_A136DisponibilidadEstado ;
   private String[] P002X11_A71EspecialidadNombre ;
   private String[] P002X11_A140EspecialidadCodigo ;
   private String[] P002X11_A88ProfesionalCOP ;
   private String[] P002X11_A83ProfesionalNombreCompleto ;
   private String[] P002X11_A134DisponibilidadDescription ;
   private String[] P002X11_A133EventId ;
   private int[] P002X11_A138DCitaId ;
   private boolean[] P002X11_n138DCitaId ;
   private String[] P002X11_A84ProfesionalNombres ;
   private String[] P002X11_A85ProfesionalApellidoPaterno ;
   private String[] P002X11_A86ProfesionalApellidoMaterno ;
   private int[] P002X13_A137DisponibilidadUser ;
   private short[] P002X13_A32EspecialidadId ;
   private java.util.Date[] P002X13_A135DisponibilidadHoraFin ;
   private boolean[] P002X13_n135DisponibilidadHoraFin ;
   private java.util.Date[] P002X13_A69DisponibilidadHoraInicio ;
   private boolean[] P002X13_n69DisponibilidadHoraInicio ;
   private java.util.Date[] P002X13_A67DisponibilidadFecha ;
   private boolean[] P002X13_n67DisponibilidadFecha ;
   private int[] P002X13_A31ProfesionalId ;
   private int[] P002X13_A34DisponibilidadId ;
   private String[] P002X13_A298DisponibilidadTipoCita ;
   private String[] P002X13_A139DisponibilidadEstadoCita ;
   private String[] P002X13_A136DisponibilidadEstado ;
   private String[] P002X13_A71EspecialidadNombre ;
   private String[] P002X13_A140EspecialidadCodigo ;
   private String[] P002X13_A88ProfesionalCOP ;
   private String[] P002X13_A83ProfesionalNombreCompleto ;
   private String[] P002X13_A134DisponibilidadDescription ;
   private String[] P002X13_A133EventId ;
   private int[] P002X13_A138DCitaId ;
   private boolean[] P002X13_n138DCitaId ;
   private String[] P002X13_A84ProfesionalNombres ;
   private String[] P002X13_A85ProfesionalApellidoPaterno ;
   private String[] P002X13_A86ProfesionalApellidoMaterno ;
   private String[] P002X15_A88ProfesionalCOP ;
   private int[] P002X15_A137DisponibilidadUser ;
   private short[] P002X15_A32EspecialidadId ;
   private java.util.Date[] P002X15_A135DisponibilidadHoraFin ;
   private boolean[] P002X15_n135DisponibilidadHoraFin ;
   private java.util.Date[] P002X15_A69DisponibilidadHoraInicio ;
   private boolean[] P002X15_n69DisponibilidadHoraInicio ;
   private java.util.Date[] P002X15_A67DisponibilidadFecha ;
   private boolean[] P002X15_n67DisponibilidadFecha ;
   private int[] P002X15_A31ProfesionalId ;
   private int[] P002X15_A34DisponibilidadId ;
   private String[] P002X15_A298DisponibilidadTipoCita ;
   private String[] P002X15_A139DisponibilidadEstadoCita ;
   private String[] P002X15_A136DisponibilidadEstado ;
   private String[] P002X15_A71EspecialidadNombre ;
   private String[] P002X15_A140EspecialidadCodigo ;
   private String[] P002X15_A83ProfesionalNombreCompleto ;
   private String[] P002X15_A134DisponibilidadDescription ;
   private String[] P002X15_A133EventId ;
   private int[] P002X15_A138DCitaId ;
   private boolean[] P002X15_n138DCitaId ;
   private String[] P002X15_A84ProfesionalNombres ;
   private String[] P002X15_A85ProfesionalApellidoPaterno ;
   private String[] P002X15_A86ProfesionalApellidoMaterno ;
   private String[] P002X17_A140EspecialidadCodigo ;
   private int[] P002X17_A137DisponibilidadUser ;
   private short[] P002X17_A32EspecialidadId ;
   private java.util.Date[] P002X17_A135DisponibilidadHoraFin ;
   private boolean[] P002X17_n135DisponibilidadHoraFin ;
   private java.util.Date[] P002X17_A69DisponibilidadHoraInicio ;
   private boolean[] P002X17_n69DisponibilidadHoraInicio ;
   private java.util.Date[] P002X17_A67DisponibilidadFecha ;
   private boolean[] P002X17_n67DisponibilidadFecha ;
   private int[] P002X17_A31ProfesionalId ;
   private int[] P002X17_A34DisponibilidadId ;
   private String[] P002X17_A298DisponibilidadTipoCita ;
   private String[] P002X17_A139DisponibilidadEstadoCita ;
   private String[] P002X17_A136DisponibilidadEstado ;
   private String[] P002X17_A71EspecialidadNombre ;
   private String[] P002X17_A88ProfesionalCOP ;
   private String[] P002X17_A83ProfesionalNombreCompleto ;
   private String[] P002X17_A134DisponibilidadDescription ;
   private String[] P002X17_A133EventId ;
   private int[] P002X17_A138DCitaId ;
   private boolean[] P002X17_n138DCitaId ;
   private String[] P002X17_A84ProfesionalNombres ;
   private String[] P002X17_A85ProfesionalApellidoPaterno ;
   private String[] P002X17_A86ProfesionalApellidoMaterno ;
   private String[] P002X19_A71EspecialidadNombre ;
   private int[] P002X19_A137DisponibilidadUser ;
   private short[] P002X19_A32EspecialidadId ;
   private java.util.Date[] P002X19_A135DisponibilidadHoraFin ;
   private boolean[] P002X19_n135DisponibilidadHoraFin ;
   private java.util.Date[] P002X19_A69DisponibilidadHoraInicio ;
   private boolean[] P002X19_n69DisponibilidadHoraInicio ;
   private java.util.Date[] P002X19_A67DisponibilidadFecha ;
   private boolean[] P002X19_n67DisponibilidadFecha ;
   private int[] P002X19_A31ProfesionalId ;
   private int[] P002X19_A34DisponibilidadId ;
   private String[] P002X19_A298DisponibilidadTipoCita ;
   private String[] P002X19_A139DisponibilidadEstadoCita ;
   private String[] P002X19_A136DisponibilidadEstado ;
   private String[] P002X19_A140EspecialidadCodigo ;
   private String[] P002X19_A88ProfesionalCOP ;
   private String[] P002X19_A83ProfesionalNombreCompleto ;
   private String[] P002X19_A134DisponibilidadDescription ;
   private String[] P002X19_A133EventId ;
   private int[] P002X19_A138DCitaId ;
   private boolean[] P002X19_n138DCitaId ;
   private String[] P002X19_A84ProfesionalNombres ;
   private String[] P002X19_A85ProfesionalApellidoPaterno ;
   private String[] P002X19_A86ProfesionalApellidoMaterno ;
   private GXSimpleCollection<String> AV52TFDisponibilidadEstado_Sels ;
   private GXSimpleCollection<String> AV77TFDisponibilidadTipoCita_Sels ;
   private GXSimpleCollection<String> AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels ;
   private GXSimpleCollection<String> AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels ;
   private GXSimpleCollection<String> AV62Options ;
   private GXSimpleCollection<String> AV65OptionsDesc ;
   private GXSimpleCollection<String> AV67OptionIndexes ;
   private GXSimpleCollection<String> AV54TFDisponibilidadEstadoCita_Sels ;
   private GXSimpleCollection<String> AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV72GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV73GridStateFilterValue ;
}

final  class disponibilidadwwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P002X3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A136DisponibilidadEstado ,
                                          GXSimpleCollection<String> AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels ,
                                          String A139DisponibilidadEstadoCita ,
                                          GXSimpleCollection<String> AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels ,
                                          String A298DisponibilidadTipoCita ,
                                          GXSimpleCollection<String> AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels ,
                                          int AV83Disponibilidadwwds_2_tfdisponibilidadid ,
                                          int AV84Disponibilidadwwds_3_tfdisponibilidadid_to ,
                                          String AV86Disponibilidadwwds_5_tfeventid_sel ,
                                          String AV85Disponibilidadwwds_4_tfeventid ,
                                          String AV88Disponibilidadwwds_7_tfdisponibilidaddescription_sel ,
                                          String AV87Disponibilidadwwds_6_tfdisponibilidaddescription ,
                                          int AV89Disponibilidadwwds_8_tfprofesionalid ,
                                          int AV90Disponibilidadwwds_9_tfprofesionalid_to ,
                                          String AV92Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel ,
                                          String AV91Disponibilidadwwds_10_tfprofesionalapellidopaterno ,
                                          String AV94Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel ,
                                          String AV93Disponibilidadwwds_12_tfprofesionalapellidomaterno ,
                                          String AV96Disponibilidadwwds_15_tfprofesionalnombres_sel ,
                                          String AV95Disponibilidadwwds_14_tfprofesionalnombres ,
                                          String AV98Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel ,
                                          String AV97Disponibilidadwwds_16_tfprofesionalnombrecompleto ,
                                          String AV100Disponibilidadwwds_19_tfprofesionalcop_sel ,
                                          String AV99Disponibilidadwwds_18_tfprofesionalcop ,
                                          java.util.Date AV101Disponibilidadwwds_20_tfdisponibilidadfecha ,
                                          java.util.Date AV102Disponibilidadwwds_21_tfdisponibilidadfecha_to ,
                                          java.util.Date AV103Disponibilidadwwds_22_tfdisponibilidadhorainicio ,
                                          java.util.Date AV104Disponibilidadwwds_23_tfdisponibilidadhorainicio_to ,
                                          java.util.Date AV105Disponibilidadwwds_24_tfdisponibilidadhorafin ,
                                          java.util.Date AV106Disponibilidadwwds_25_tfdisponibilidadhorafin_to ,
                                          short AV107Disponibilidadwwds_26_tfespecialidadid ,
                                          short AV108Disponibilidadwwds_27_tfespecialidadid_to ,
                                          String AV110Disponibilidadwwds_29_tfespecialidadcodigo_sel ,
                                          String AV109Disponibilidadwwds_28_tfespecialidadcodigo ,
                                          String AV112Disponibilidadwwds_31_tfespecialidadnombre_sel ,
                                          String AV111Disponibilidadwwds_30_tfespecialidadnombre ,
                                          int AV113Disponibilidadwwds_32_tfdisponibilidaduser ,
                                          int AV114Disponibilidadwwds_33_tfdisponibilidaduser_to ,
                                          int AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels_size ,
                                          int AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels_size ,
                                          int AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels_size ,
                                          int A34DisponibilidadId ,
                                          String A133EventId ,
                                          String A134DisponibilidadDescription ,
                                          int A31ProfesionalId ,
                                          String A85ProfesionalApellidoPaterno ,
                                          String A86ProfesionalApellidoMaterno ,
                                          String A84ProfesionalNombres ,
                                          String A88ProfesionalCOP ,
                                          java.util.Date A67DisponibilidadFecha ,
                                          java.util.Date A69DisponibilidadHoraInicio ,
                                          java.util.Date A135DisponibilidadHoraFin ,
                                          short A32EspecialidadId ,
                                          String A140EspecialidadCodigo ,
                                          String A71EspecialidadNombre ,
                                          int A137DisponibilidadUser ,
                                          String AV82Disponibilidadwwds_1_filterfulltext ,
                                          String A83ProfesionalNombreCompleto ,
                                          int A138DCitaId ,
                                          int AV117Disponibilidadwwds_36_tfdcitaid ,
                                          int AV118Disponibilidadwwds_37_tfdcitaid_to )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[59];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT T1.[EventId], T1.[DisponibilidadUser], T1.[EspecialidadId], T1.[DisponibilidadHoraFin], T1.[DisponibilidadHoraInicio], T1.[DisponibilidadFecha], T1.[ProfesionalId]," ;
      scmdbuf += " T1.[DisponibilidadId], T1.[DisponibilidadTipoCita], T1.[DisponibilidadEstadoCita], T1.[DisponibilidadEstado], T2.[EspecialidadNombre], T2.[EspecialidadCodigo]," ;
      scmdbuf += " T3.[ProfesionalCOP], T3.[ProfesionalNombres] + ' ' + T3.[ProfesionalApellidoPaterno] + ' ' + T3.[ProfesionalApellidoMaterno] AS ProfesionalNombreCompleto, T1.[DisponibilidadDescription]," ;
      scmdbuf += " COALESCE( T4.[DCitaId], 0) AS DCitaId, T3.[ProfesionalNombres], T3.[ProfesionalApellidoPaterno], T3.[ProfesionalApellidoMaterno] FROM ((([Disponibilidad] T1 INNER" ;
      scmdbuf += " JOIN [Especialidad] T2 ON T2.[EspecialidadId] = T1.[EspecialidadId]) INNER JOIN [Profesional] T3 ON T3.[ProfesionalId] = T1.[ProfesionalId]) LEFT JOIN (SELECT MIN(T5.[CitaId])" ;
      scmdbuf += " AS DCitaId, T5.[SGCitaDisponibilidadId] FROM [Cita] T5,  [Disponibilidad] T6 WHERE (T5.[SGCitaDisponibilidadId] = T6.[DisponibilidadId]) AND (T5.[CitaEstado] =" ;
      scmdbuf += " 'A') GROUP BY T5.[SGCitaDisponibilidadId] ) T4 ON T4.[SGCitaDisponibilidadId] = T1.[DisponibilidadId])" ;
      addWhere(sWhereString, "((? = '') or ( ( CONVERT( char(8), CAST(T1.[DisponibilidadId] AS decimal(8,0))) like '%' + ?) or ( T1.[EventId] like '%' + ?) or ( T1.[DisponibilidadDescription] like '%' + ?) or ( CONVERT( char(8), CAST(T1.[ProfesionalId] AS decimal(8,0))) like '%' + ?) or ( T3.[ProfesionalApellidoPaterno] like '%' + ?) or ( T3.[ProfesionalApellidoMaterno] like '%' + ?) or ( T3.[ProfesionalNombres] like '%' + ?) or ( T3.[ProfesionalNombres] + ' ' + T3.[ProfesionalApellidoPaterno] + ' ' + T3.[ProfesionalApellidoMaterno] like '%' + ?) or ( T3.[ProfesionalCOP] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[EspecialidadId] AS decimal(4,0))) like '%' + ?) or ( T2.[EspecialidadCodigo] like '%' + ?) or ( T2.[EspecialidadNombre] like '%' + ?) or ( CONVERT( char(6), CAST(T1.[DisponibilidadUser] AS decimal(6,0))) like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[DisponibilidadEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and T1.[DisponibilidadEstado] = 'I') or ( 'libre' like '%' + LOWER(?) and T1.[DisponibilidadEstadoCita] = 'L') or ( 'ocupado' like '%' + LOWER(?) and T1.[DisponibilidadEstadoCita] = 'O') or ( 'expiró' like '%' + LOWER(?) and T1.[DisponibilidadEstadoCita] = 'E') or ( CONVERT( char(6), CAST(COALESCE( T4.[DCitaId], 0) AS decimal(6,0))) like '%' + ?) or ( 'virtual' like '%' + LOWER(?) and T1.[DisponibilidadTipoCita] = 'V') or ( 'en consultorio' like '%' + LOWER(?) and T1.[DisponibilidadTipoCita] = 'P') or ( 'visita a domicilio' like '%' + LOWER(?) and T1.[DisponibilidadTipoCita] = 'D')))");
      addWhere(sWhereString, "((? = convert(int, 0)) or ( COALESCE( T4.[DCitaId], 0) >= ?))");
      addWhere(sWhereString, "((? = convert(int, 0)) or ( COALESCE( T4.[DCitaId], 0) <= ?))");
      if ( ! (0==AV83Disponibilidadwwds_2_tfdisponibilidadid) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] >= ?)");
      }
      else
      {
         GXv_int4[27] = (byte)(1) ;
      }
      if ( ! (0==AV84Disponibilidadwwds_3_tfdisponibilidadid_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] <= ?)");
      }
      else
      {
         GXv_int4[28] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV86Disponibilidadwwds_5_tfeventid_sel)==0) && ( ! (GXutil.strcmp("", AV85Disponibilidadwwds_4_tfeventid)==0) ) )
      {
         addWhere(sWhereString, "(T1.[EventId] like ?)");
      }
      else
      {
         GXv_int4[29] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV86Disponibilidadwwds_5_tfeventid_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[EventId] = ?)");
      }
      else
      {
         GXv_int4[30] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV88Disponibilidadwwds_7_tfdisponibilidaddescription_sel)==0) && ( ! (GXutil.strcmp("", AV87Disponibilidadwwds_6_tfdisponibilidaddescription)==0) ) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadDescription] like ?)");
      }
      else
      {
         GXv_int4[31] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV88Disponibilidadwwds_7_tfdisponibilidaddescription_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadDescription] = ?)");
      }
      else
      {
         GXv_int4[32] = (byte)(1) ;
      }
      if ( ! (0==AV89Disponibilidadwwds_8_tfprofesionalid) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalId] >= ?)");
      }
      else
      {
         GXv_int4[33] = (byte)(1) ;
      }
      if ( ! (0==AV90Disponibilidadwwds_9_tfprofesionalid_to) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalId] <= ?)");
      }
      else
      {
         GXv_int4[34] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV92Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV91Disponibilidadwwds_10_tfprofesionalapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int4[35] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV92Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int4[36] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV94Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV93Disponibilidadwwds_12_tfprofesionalapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int4[37] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV94Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int4[38] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV96Disponibilidadwwds_15_tfprofesionalnombres_sel)==0) && ( ! (GXutil.strcmp("", AV95Disponibilidadwwds_14_tfprofesionalnombres)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalNombres] like ?)");
      }
      else
      {
         GXv_int4[39] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV96Disponibilidadwwds_15_tfprofesionalnombres_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalNombres] = ?)");
      }
      else
      {
         GXv_int4[40] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV98Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel)==0) && ( ! (GXutil.strcmp("", AV97Disponibilidadwwds_16_tfprofesionalnombrecompleto)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalNombres] + ' ' + T3.[ProfesionalApellidoPaterno] + ' ' + T3.[ProfesionalApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int4[41] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV98Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalNombres] + ' ' + T3.[ProfesionalApellidoPaterno] + ' ' + T3.[ProfesionalApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int4[42] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV100Disponibilidadwwds_19_tfprofesionalcop_sel)==0) && ( ! (GXutil.strcmp("", AV99Disponibilidadwwds_18_tfprofesionalcop)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalCOP] like ?)");
      }
      else
      {
         GXv_int4[43] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV100Disponibilidadwwds_19_tfprofesionalcop_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalCOP] = ?)");
      }
      else
      {
         GXv_int4[44] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV101Disponibilidadwwds_20_tfdisponibilidadfecha)) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadFecha] >= ?)");
      }
      else
      {
         GXv_int4[45] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV102Disponibilidadwwds_21_tfdisponibilidadfecha_to)) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadFecha] <= ?)");
      }
      else
      {
         GXv_int4[46] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV103Disponibilidadwwds_22_tfdisponibilidadhorainicio) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraInicio] >= ?)");
      }
      else
      {
         GXv_int4[47] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV104Disponibilidadwwds_23_tfdisponibilidadhorainicio_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraInicio] <= ?)");
      }
      else
      {
         GXv_int4[48] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV105Disponibilidadwwds_24_tfdisponibilidadhorafin) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraFin] >= ?)");
      }
      else
      {
         GXv_int4[49] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV106Disponibilidadwwds_25_tfdisponibilidadhorafin_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraFin] <= ?)");
      }
      else
      {
         GXv_int4[50] = (byte)(1) ;
      }
      if ( ! (0==AV107Disponibilidadwwds_26_tfespecialidadid) )
      {
         addWhere(sWhereString, "(T1.[EspecialidadId] >= ?)");
      }
      else
      {
         GXv_int4[51] = (byte)(1) ;
      }
      if ( ! (0==AV108Disponibilidadwwds_27_tfespecialidadid_to) )
      {
         addWhere(sWhereString, "(T1.[EspecialidadId] <= ?)");
      }
      else
      {
         GXv_int4[52] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV110Disponibilidadwwds_29_tfespecialidadcodigo_sel)==0) && ( ! (GXutil.strcmp("", AV109Disponibilidadwwds_28_tfespecialidadcodigo)==0) ) )
      {
         addWhere(sWhereString, "(T2.[EspecialidadCodigo] like ?)");
      }
      else
      {
         GXv_int4[53] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV110Disponibilidadwwds_29_tfespecialidadcodigo_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[EspecialidadCodigo] = ?)");
      }
      else
      {
         GXv_int4[54] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV112Disponibilidadwwds_31_tfespecialidadnombre_sel)==0) && ( ! (GXutil.strcmp("", AV111Disponibilidadwwds_30_tfespecialidadnombre)==0) ) )
      {
         addWhere(sWhereString, "(T2.[EspecialidadNombre] like ?)");
      }
      else
      {
         GXv_int4[55] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV112Disponibilidadwwds_31_tfespecialidadnombre_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[EspecialidadNombre] = ?)");
      }
      else
      {
         GXv_int4[56] = (byte)(1) ;
      }
      if ( ! (0==AV113Disponibilidadwwds_32_tfdisponibilidaduser) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadUser] >= ?)");
      }
      else
      {
         GXv_int4[57] = (byte)(1) ;
      }
      if ( ! (0==AV114Disponibilidadwwds_33_tfdisponibilidaduser_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadUser] <= ?)");
      }
      else
      {
         GXv_int4[58] = (byte)(1) ;
      }
      if ( AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels, "T1.[DisponibilidadEstado] IN (", ")")+")");
      }
      if ( AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels, "T1.[DisponibilidadEstadoCita] IN (", ")")+")");
      }
      if ( AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels, "T1.[DisponibilidadTipoCita] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[EventId]" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   protected Object[] conditional_P002X5( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A136DisponibilidadEstado ,
                                          GXSimpleCollection<String> AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels ,
                                          String A139DisponibilidadEstadoCita ,
                                          GXSimpleCollection<String> AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels ,
                                          String A298DisponibilidadTipoCita ,
                                          GXSimpleCollection<String> AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels ,
                                          int AV83Disponibilidadwwds_2_tfdisponibilidadid ,
                                          int AV84Disponibilidadwwds_3_tfdisponibilidadid_to ,
                                          String AV86Disponibilidadwwds_5_tfeventid_sel ,
                                          String AV85Disponibilidadwwds_4_tfeventid ,
                                          String AV88Disponibilidadwwds_7_tfdisponibilidaddescription_sel ,
                                          String AV87Disponibilidadwwds_6_tfdisponibilidaddescription ,
                                          int AV89Disponibilidadwwds_8_tfprofesionalid ,
                                          int AV90Disponibilidadwwds_9_tfprofesionalid_to ,
                                          String AV92Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel ,
                                          String AV91Disponibilidadwwds_10_tfprofesionalapellidopaterno ,
                                          String AV94Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel ,
                                          String AV93Disponibilidadwwds_12_tfprofesionalapellidomaterno ,
                                          String AV96Disponibilidadwwds_15_tfprofesionalnombres_sel ,
                                          String AV95Disponibilidadwwds_14_tfprofesionalnombres ,
                                          String AV98Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel ,
                                          String AV97Disponibilidadwwds_16_tfprofesionalnombrecompleto ,
                                          String AV100Disponibilidadwwds_19_tfprofesionalcop_sel ,
                                          String AV99Disponibilidadwwds_18_tfprofesionalcop ,
                                          java.util.Date AV101Disponibilidadwwds_20_tfdisponibilidadfecha ,
                                          java.util.Date AV102Disponibilidadwwds_21_tfdisponibilidadfecha_to ,
                                          java.util.Date AV103Disponibilidadwwds_22_tfdisponibilidadhorainicio ,
                                          java.util.Date AV104Disponibilidadwwds_23_tfdisponibilidadhorainicio_to ,
                                          java.util.Date AV105Disponibilidadwwds_24_tfdisponibilidadhorafin ,
                                          java.util.Date AV106Disponibilidadwwds_25_tfdisponibilidadhorafin_to ,
                                          short AV107Disponibilidadwwds_26_tfespecialidadid ,
                                          short AV108Disponibilidadwwds_27_tfespecialidadid_to ,
                                          String AV110Disponibilidadwwds_29_tfespecialidadcodigo_sel ,
                                          String AV109Disponibilidadwwds_28_tfespecialidadcodigo ,
                                          String AV112Disponibilidadwwds_31_tfespecialidadnombre_sel ,
                                          String AV111Disponibilidadwwds_30_tfespecialidadnombre ,
                                          int AV113Disponibilidadwwds_32_tfdisponibilidaduser ,
                                          int AV114Disponibilidadwwds_33_tfdisponibilidaduser_to ,
                                          int AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels_size ,
                                          int AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels_size ,
                                          int AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels_size ,
                                          int A34DisponibilidadId ,
                                          String A133EventId ,
                                          String A134DisponibilidadDescription ,
                                          int A31ProfesionalId ,
                                          String A85ProfesionalApellidoPaterno ,
                                          String A86ProfesionalApellidoMaterno ,
                                          String A84ProfesionalNombres ,
                                          String A88ProfesionalCOP ,
                                          java.util.Date A67DisponibilidadFecha ,
                                          java.util.Date A69DisponibilidadHoraInicio ,
                                          java.util.Date A135DisponibilidadHoraFin ,
                                          short A32EspecialidadId ,
                                          String A140EspecialidadCodigo ,
                                          String A71EspecialidadNombre ,
                                          int A137DisponibilidadUser ,
                                          String AV82Disponibilidadwwds_1_filterfulltext ,
                                          String A83ProfesionalNombreCompleto ,
                                          int A138DCitaId ,
                                          int AV117Disponibilidadwwds_36_tfdcitaid ,
                                          int AV118Disponibilidadwwds_37_tfdcitaid_to )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int7 = new byte[59];
      Object[] GXv_Object8 = new Object[2];
      scmdbuf = "SELECT T1.[DisponibilidadDescription], T1.[DisponibilidadUser], T1.[EspecialidadId], T1.[DisponibilidadHoraFin], T1.[DisponibilidadHoraInicio], T1.[DisponibilidadFecha]," ;
      scmdbuf += " T1.[ProfesionalId], T1.[DisponibilidadId], T1.[DisponibilidadTipoCita], T1.[DisponibilidadEstadoCita], T1.[DisponibilidadEstado], T2.[EspecialidadNombre], T2.[EspecialidadCodigo]," ;
      scmdbuf += " T3.[ProfesionalCOP], T3.[ProfesionalNombres] + ' ' + T3.[ProfesionalApellidoPaterno] + ' ' + T3.[ProfesionalApellidoMaterno] AS ProfesionalNombreCompleto, T1.[EventId]," ;
      scmdbuf += " COALESCE( T4.[DCitaId], 0) AS DCitaId, T3.[ProfesionalNombres], T3.[ProfesionalApellidoPaterno], T3.[ProfesionalApellidoMaterno] FROM ((([Disponibilidad] T1 INNER" ;
      scmdbuf += " JOIN [Especialidad] T2 ON T2.[EspecialidadId] = T1.[EspecialidadId]) INNER JOIN [Profesional] T3 ON T3.[ProfesionalId] = T1.[ProfesionalId]) LEFT JOIN (SELECT MIN(T5.[CitaId])" ;
      scmdbuf += " AS DCitaId, T5.[SGCitaDisponibilidadId] FROM [Cita] T5,  [Disponibilidad] T6 WHERE (T5.[SGCitaDisponibilidadId] = T6.[DisponibilidadId]) AND (T5.[CitaEstado] =" ;
      scmdbuf += " 'A') GROUP BY T5.[SGCitaDisponibilidadId] ) T4 ON T4.[SGCitaDisponibilidadId] = T1.[DisponibilidadId])" ;
      addWhere(sWhereString, "((? = '') or ( ( CONVERT( char(8), CAST(T1.[DisponibilidadId] AS decimal(8,0))) like '%' + ?) or ( T1.[EventId] like '%' + ?) or ( T1.[DisponibilidadDescription] like '%' + ?) or ( CONVERT( char(8), CAST(T1.[ProfesionalId] AS decimal(8,0))) like '%' + ?) or ( T3.[ProfesionalApellidoPaterno] like '%' + ?) or ( T3.[ProfesionalApellidoMaterno] like '%' + ?) or ( T3.[ProfesionalNombres] like '%' + ?) or ( T3.[ProfesionalNombres] + ' ' + T3.[ProfesionalApellidoPaterno] + ' ' + T3.[ProfesionalApellidoMaterno] like '%' + ?) or ( T3.[ProfesionalCOP] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[EspecialidadId] AS decimal(4,0))) like '%' + ?) or ( T2.[EspecialidadCodigo] like '%' + ?) or ( T2.[EspecialidadNombre] like '%' + ?) or ( CONVERT( char(6), CAST(T1.[DisponibilidadUser] AS decimal(6,0))) like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[DisponibilidadEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and T1.[DisponibilidadEstado] = 'I') or ( 'libre' like '%' + LOWER(?) and T1.[DisponibilidadEstadoCita] = 'L') or ( 'ocupado' like '%' + LOWER(?) and T1.[DisponibilidadEstadoCita] = 'O') or ( 'expiró' like '%' + LOWER(?) and T1.[DisponibilidadEstadoCita] = 'E') or ( CONVERT( char(6), CAST(COALESCE( T4.[DCitaId], 0) AS decimal(6,0))) like '%' + ?) or ( 'virtual' like '%' + LOWER(?) and T1.[DisponibilidadTipoCita] = 'V') or ( 'en consultorio' like '%' + LOWER(?) and T1.[DisponibilidadTipoCita] = 'P') or ( 'visita a domicilio' like '%' + LOWER(?) and T1.[DisponibilidadTipoCita] = 'D')))");
      addWhere(sWhereString, "((? = convert(int, 0)) or ( COALESCE( T4.[DCitaId], 0) >= ?))");
      addWhere(sWhereString, "((? = convert(int, 0)) or ( COALESCE( T4.[DCitaId], 0) <= ?))");
      if ( ! (0==AV83Disponibilidadwwds_2_tfdisponibilidadid) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] >= ?)");
      }
      else
      {
         GXv_int7[27] = (byte)(1) ;
      }
      if ( ! (0==AV84Disponibilidadwwds_3_tfdisponibilidadid_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] <= ?)");
      }
      else
      {
         GXv_int7[28] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV86Disponibilidadwwds_5_tfeventid_sel)==0) && ( ! (GXutil.strcmp("", AV85Disponibilidadwwds_4_tfeventid)==0) ) )
      {
         addWhere(sWhereString, "(T1.[EventId] like ?)");
      }
      else
      {
         GXv_int7[29] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV86Disponibilidadwwds_5_tfeventid_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[EventId] = ?)");
      }
      else
      {
         GXv_int7[30] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV88Disponibilidadwwds_7_tfdisponibilidaddescription_sel)==0) && ( ! (GXutil.strcmp("", AV87Disponibilidadwwds_6_tfdisponibilidaddescription)==0) ) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadDescription] like ?)");
      }
      else
      {
         GXv_int7[31] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV88Disponibilidadwwds_7_tfdisponibilidaddescription_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadDescription] = ?)");
      }
      else
      {
         GXv_int7[32] = (byte)(1) ;
      }
      if ( ! (0==AV89Disponibilidadwwds_8_tfprofesionalid) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalId] >= ?)");
      }
      else
      {
         GXv_int7[33] = (byte)(1) ;
      }
      if ( ! (0==AV90Disponibilidadwwds_9_tfprofesionalid_to) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalId] <= ?)");
      }
      else
      {
         GXv_int7[34] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV92Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV91Disponibilidadwwds_10_tfprofesionalapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int7[35] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV92Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int7[36] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV94Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV93Disponibilidadwwds_12_tfprofesionalapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int7[37] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV94Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int7[38] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV96Disponibilidadwwds_15_tfprofesionalnombres_sel)==0) && ( ! (GXutil.strcmp("", AV95Disponibilidadwwds_14_tfprofesionalnombres)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalNombres] like ?)");
      }
      else
      {
         GXv_int7[39] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV96Disponibilidadwwds_15_tfprofesionalnombres_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalNombres] = ?)");
      }
      else
      {
         GXv_int7[40] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV98Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel)==0) && ( ! (GXutil.strcmp("", AV97Disponibilidadwwds_16_tfprofesionalnombrecompleto)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalNombres] + ' ' + T3.[ProfesionalApellidoPaterno] + ' ' + T3.[ProfesionalApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int7[41] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV98Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalNombres] + ' ' + T3.[ProfesionalApellidoPaterno] + ' ' + T3.[ProfesionalApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int7[42] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV100Disponibilidadwwds_19_tfprofesionalcop_sel)==0) && ( ! (GXutil.strcmp("", AV99Disponibilidadwwds_18_tfprofesionalcop)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalCOP] like ?)");
      }
      else
      {
         GXv_int7[43] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV100Disponibilidadwwds_19_tfprofesionalcop_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalCOP] = ?)");
      }
      else
      {
         GXv_int7[44] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV101Disponibilidadwwds_20_tfdisponibilidadfecha)) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadFecha] >= ?)");
      }
      else
      {
         GXv_int7[45] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV102Disponibilidadwwds_21_tfdisponibilidadfecha_to)) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadFecha] <= ?)");
      }
      else
      {
         GXv_int7[46] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV103Disponibilidadwwds_22_tfdisponibilidadhorainicio) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraInicio] >= ?)");
      }
      else
      {
         GXv_int7[47] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV104Disponibilidadwwds_23_tfdisponibilidadhorainicio_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraInicio] <= ?)");
      }
      else
      {
         GXv_int7[48] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV105Disponibilidadwwds_24_tfdisponibilidadhorafin) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraFin] >= ?)");
      }
      else
      {
         GXv_int7[49] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV106Disponibilidadwwds_25_tfdisponibilidadhorafin_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraFin] <= ?)");
      }
      else
      {
         GXv_int7[50] = (byte)(1) ;
      }
      if ( ! (0==AV107Disponibilidadwwds_26_tfespecialidadid) )
      {
         addWhere(sWhereString, "(T1.[EspecialidadId] >= ?)");
      }
      else
      {
         GXv_int7[51] = (byte)(1) ;
      }
      if ( ! (0==AV108Disponibilidadwwds_27_tfespecialidadid_to) )
      {
         addWhere(sWhereString, "(T1.[EspecialidadId] <= ?)");
      }
      else
      {
         GXv_int7[52] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV110Disponibilidadwwds_29_tfespecialidadcodigo_sel)==0) && ( ! (GXutil.strcmp("", AV109Disponibilidadwwds_28_tfespecialidadcodigo)==0) ) )
      {
         addWhere(sWhereString, "(T2.[EspecialidadCodigo] like ?)");
      }
      else
      {
         GXv_int7[53] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV110Disponibilidadwwds_29_tfespecialidadcodigo_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[EspecialidadCodigo] = ?)");
      }
      else
      {
         GXv_int7[54] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV112Disponibilidadwwds_31_tfespecialidadnombre_sel)==0) && ( ! (GXutil.strcmp("", AV111Disponibilidadwwds_30_tfespecialidadnombre)==0) ) )
      {
         addWhere(sWhereString, "(T2.[EspecialidadNombre] like ?)");
      }
      else
      {
         GXv_int7[55] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV112Disponibilidadwwds_31_tfespecialidadnombre_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[EspecialidadNombre] = ?)");
      }
      else
      {
         GXv_int7[56] = (byte)(1) ;
      }
      if ( ! (0==AV113Disponibilidadwwds_32_tfdisponibilidaduser) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadUser] >= ?)");
      }
      else
      {
         GXv_int7[57] = (byte)(1) ;
      }
      if ( ! (0==AV114Disponibilidadwwds_33_tfdisponibilidaduser_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadUser] <= ?)");
      }
      else
      {
         GXv_int7[58] = (byte)(1) ;
      }
      if ( AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels, "T1.[DisponibilidadEstado] IN (", ")")+")");
      }
      if ( AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels, "T1.[DisponibilidadEstadoCita] IN (", ")")+")");
      }
      if ( AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels, "T1.[DisponibilidadTipoCita] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[DisponibilidadDescription]" ;
      GXv_Object8[0] = scmdbuf ;
      GXv_Object8[1] = GXv_int7 ;
      return GXv_Object8 ;
   }

   protected Object[] conditional_P002X7( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A136DisponibilidadEstado ,
                                          GXSimpleCollection<String> AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels ,
                                          String A139DisponibilidadEstadoCita ,
                                          GXSimpleCollection<String> AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels ,
                                          String A298DisponibilidadTipoCita ,
                                          GXSimpleCollection<String> AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels ,
                                          int AV83Disponibilidadwwds_2_tfdisponibilidadid ,
                                          int AV84Disponibilidadwwds_3_tfdisponibilidadid_to ,
                                          String AV86Disponibilidadwwds_5_tfeventid_sel ,
                                          String AV85Disponibilidadwwds_4_tfeventid ,
                                          String AV88Disponibilidadwwds_7_tfdisponibilidaddescription_sel ,
                                          String AV87Disponibilidadwwds_6_tfdisponibilidaddescription ,
                                          int AV89Disponibilidadwwds_8_tfprofesionalid ,
                                          int AV90Disponibilidadwwds_9_tfprofesionalid_to ,
                                          String AV92Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel ,
                                          String AV91Disponibilidadwwds_10_tfprofesionalapellidopaterno ,
                                          String AV94Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel ,
                                          String AV93Disponibilidadwwds_12_tfprofesionalapellidomaterno ,
                                          String AV96Disponibilidadwwds_15_tfprofesionalnombres_sel ,
                                          String AV95Disponibilidadwwds_14_tfprofesionalnombres ,
                                          String AV98Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel ,
                                          String AV97Disponibilidadwwds_16_tfprofesionalnombrecompleto ,
                                          String AV100Disponibilidadwwds_19_tfprofesionalcop_sel ,
                                          String AV99Disponibilidadwwds_18_tfprofesionalcop ,
                                          java.util.Date AV101Disponibilidadwwds_20_tfdisponibilidadfecha ,
                                          java.util.Date AV102Disponibilidadwwds_21_tfdisponibilidadfecha_to ,
                                          java.util.Date AV103Disponibilidadwwds_22_tfdisponibilidadhorainicio ,
                                          java.util.Date AV104Disponibilidadwwds_23_tfdisponibilidadhorainicio_to ,
                                          java.util.Date AV105Disponibilidadwwds_24_tfdisponibilidadhorafin ,
                                          java.util.Date AV106Disponibilidadwwds_25_tfdisponibilidadhorafin_to ,
                                          short AV107Disponibilidadwwds_26_tfespecialidadid ,
                                          short AV108Disponibilidadwwds_27_tfespecialidadid_to ,
                                          String AV110Disponibilidadwwds_29_tfespecialidadcodigo_sel ,
                                          String AV109Disponibilidadwwds_28_tfespecialidadcodigo ,
                                          String AV112Disponibilidadwwds_31_tfespecialidadnombre_sel ,
                                          String AV111Disponibilidadwwds_30_tfespecialidadnombre ,
                                          int AV113Disponibilidadwwds_32_tfdisponibilidaduser ,
                                          int AV114Disponibilidadwwds_33_tfdisponibilidaduser_to ,
                                          int AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels_size ,
                                          int AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels_size ,
                                          int AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels_size ,
                                          int A34DisponibilidadId ,
                                          String A133EventId ,
                                          String A134DisponibilidadDescription ,
                                          int A31ProfesionalId ,
                                          String A85ProfesionalApellidoPaterno ,
                                          String A86ProfesionalApellidoMaterno ,
                                          String A84ProfesionalNombres ,
                                          String A88ProfesionalCOP ,
                                          java.util.Date A67DisponibilidadFecha ,
                                          java.util.Date A69DisponibilidadHoraInicio ,
                                          java.util.Date A135DisponibilidadHoraFin ,
                                          short A32EspecialidadId ,
                                          String A140EspecialidadCodigo ,
                                          String A71EspecialidadNombre ,
                                          int A137DisponibilidadUser ,
                                          String AV82Disponibilidadwwds_1_filterfulltext ,
                                          String A83ProfesionalNombreCompleto ,
                                          int A138DCitaId ,
                                          int AV117Disponibilidadwwds_36_tfdcitaid ,
                                          int AV118Disponibilidadwwds_37_tfdcitaid_to )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[59];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT T1.[DisponibilidadUser], T1.[EspecialidadId], T1.[DisponibilidadHoraFin], T1.[DisponibilidadHoraInicio], T1.[DisponibilidadFecha], T1.[ProfesionalId], T1.[DisponibilidadId]," ;
      scmdbuf += " T1.[DisponibilidadTipoCita], T1.[DisponibilidadEstadoCita], T1.[DisponibilidadEstado], T2.[EspecialidadNombre], T2.[EspecialidadCodigo], T3.[ProfesionalCOP], T3.[ProfesionalNombres]" ;
      scmdbuf += " + ' ' + T3.[ProfesionalApellidoPaterno] + ' ' + T3.[ProfesionalApellidoMaterno] AS ProfesionalNombreCompleto, T1.[DisponibilidadDescription], T1.[EventId], COALESCE(" ;
      scmdbuf += " T4.[DCitaId], 0) AS DCitaId, T3.[ProfesionalNombres], T3.[ProfesionalApellidoPaterno], T3.[ProfesionalApellidoMaterno] FROM ((([Disponibilidad] T1 INNER JOIN [Especialidad]" ;
      scmdbuf += " T2 ON T2.[EspecialidadId] = T1.[EspecialidadId]) INNER JOIN [Profesional] T3 ON T3.[ProfesionalId] = T1.[ProfesionalId]) LEFT JOIN (SELECT MIN(T5.[CitaId]) AS DCitaId," ;
      scmdbuf += " T5.[SGCitaDisponibilidadId] FROM [Cita] T5,  [Disponibilidad] T6 WHERE (T5.[SGCitaDisponibilidadId] = T6.[DisponibilidadId]) AND (T5.[CitaEstado] = 'A') GROUP BY" ;
      scmdbuf += " T5.[SGCitaDisponibilidadId] ) T4 ON T4.[SGCitaDisponibilidadId] = T1.[DisponibilidadId])" ;
      addWhere(sWhereString, "((? = '') or ( ( CONVERT( char(8), CAST(T1.[DisponibilidadId] AS decimal(8,0))) like '%' + ?) or ( T1.[EventId] like '%' + ?) or ( T1.[DisponibilidadDescription] like '%' + ?) or ( CONVERT( char(8), CAST(T1.[ProfesionalId] AS decimal(8,0))) like '%' + ?) or ( T3.[ProfesionalApellidoPaterno] like '%' + ?) or ( T3.[ProfesionalApellidoMaterno] like '%' + ?) or ( T3.[ProfesionalNombres] like '%' + ?) or ( T3.[ProfesionalNombres] + ' ' + T3.[ProfesionalApellidoPaterno] + ' ' + T3.[ProfesionalApellidoMaterno] like '%' + ?) or ( T3.[ProfesionalCOP] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[EspecialidadId] AS decimal(4,0))) like '%' + ?) or ( T2.[EspecialidadCodigo] like '%' + ?) or ( T2.[EspecialidadNombre] like '%' + ?) or ( CONVERT( char(6), CAST(T1.[DisponibilidadUser] AS decimal(6,0))) like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[DisponibilidadEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and T1.[DisponibilidadEstado] = 'I') or ( 'libre' like '%' + LOWER(?) and T1.[DisponibilidadEstadoCita] = 'L') or ( 'ocupado' like '%' + LOWER(?) and T1.[DisponibilidadEstadoCita] = 'O') or ( 'expiró' like '%' + LOWER(?) and T1.[DisponibilidadEstadoCita] = 'E') or ( CONVERT( char(6), CAST(COALESCE( T4.[DCitaId], 0) AS decimal(6,0))) like '%' + ?) or ( 'virtual' like '%' + LOWER(?) and T1.[DisponibilidadTipoCita] = 'V') or ( 'en consultorio' like '%' + LOWER(?) and T1.[DisponibilidadTipoCita] = 'P') or ( 'visita a domicilio' like '%' + LOWER(?) and T1.[DisponibilidadTipoCita] = 'D')))");
      addWhere(sWhereString, "((? = convert(int, 0)) or ( COALESCE( T4.[DCitaId], 0) >= ?))");
      addWhere(sWhereString, "((? = convert(int, 0)) or ( COALESCE( T4.[DCitaId], 0) <= ?))");
      if ( ! (0==AV83Disponibilidadwwds_2_tfdisponibilidadid) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] >= ?)");
      }
      else
      {
         GXv_int10[27] = (byte)(1) ;
      }
      if ( ! (0==AV84Disponibilidadwwds_3_tfdisponibilidadid_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] <= ?)");
      }
      else
      {
         GXv_int10[28] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV86Disponibilidadwwds_5_tfeventid_sel)==0) && ( ! (GXutil.strcmp("", AV85Disponibilidadwwds_4_tfeventid)==0) ) )
      {
         addWhere(sWhereString, "(T1.[EventId] like ?)");
      }
      else
      {
         GXv_int10[29] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV86Disponibilidadwwds_5_tfeventid_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[EventId] = ?)");
      }
      else
      {
         GXv_int10[30] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV88Disponibilidadwwds_7_tfdisponibilidaddescription_sel)==0) && ( ! (GXutil.strcmp("", AV87Disponibilidadwwds_6_tfdisponibilidaddescription)==0) ) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadDescription] like ?)");
      }
      else
      {
         GXv_int10[31] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV88Disponibilidadwwds_7_tfdisponibilidaddescription_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadDescription] = ?)");
      }
      else
      {
         GXv_int10[32] = (byte)(1) ;
      }
      if ( ! (0==AV89Disponibilidadwwds_8_tfprofesionalid) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalId] >= ?)");
      }
      else
      {
         GXv_int10[33] = (byte)(1) ;
      }
      if ( ! (0==AV90Disponibilidadwwds_9_tfprofesionalid_to) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalId] <= ?)");
      }
      else
      {
         GXv_int10[34] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV92Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV91Disponibilidadwwds_10_tfprofesionalapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int10[35] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV92Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int10[36] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV94Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV93Disponibilidadwwds_12_tfprofesionalapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int10[37] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV94Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int10[38] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV96Disponibilidadwwds_15_tfprofesionalnombres_sel)==0) && ( ! (GXutil.strcmp("", AV95Disponibilidadwwds_14_tfprofesionalnombres)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalNombres] like ?)");
      }
      else
      {
         GXv_int10[39] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV96Disponibilidadwwds_15_tfprofesionalnombres_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalNombres] = ?)");
      }
      else
      {
         GXv_int10[40] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV98Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel)==0) && ( ! (GXutil.strcmp("", AV97Disponibilidadwwds_16_tfprofesionalnombrecompleto)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalNombres] + ' ' + T3.[ProfesionalApellidoPaterno] + ' ' + T3.[ProfesionalApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int10[41] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV98Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalNombres] + ' ' + T3.[ProfesionalApellidoPaterno] + ' ' + T3.[ProfesionalApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int10[42] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV100Disponibilidadwwds_19_tfprofesionalcop_sel)==0) && ( ! (GXutil.strcmp("", AV99Disponibilidadwwds_18_tfprofesionalcop)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalCOP] like ?)");
      }
      else
      {
         GXv_int10[43] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV100Disponibilidadwwds_19_tfprofesionalcop_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalCOP] = ?)");
      }
      else
      {
         GXv_int10[44] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV101Disponibilidadwwds_20_tfdisponibilidadfecha)) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadFecha] >= ?)");
      }
      else
      {
         GXv_int10[45] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV102Disponibilidadwwds_21_tfdisponibilidadfecha_to)) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadFecha] <= ?)");
      }
      else
      {
         GXv_int10[46] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV103Disponibilidadwwds_22_tfdisponibilidadhorainicio) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraInicio] >= ?)");
      }
      else
      {
         GXv_int10[47] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV104Disponibilidadwwds_23_tfdisponibilidadhorainicio_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraInicio] <= ?)");
      }
      else
      {
         GXv_int10[48] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV105Disponibilidadwwds_24_tfdisponibilidadhorafin) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraFin] >= ?)");
      }
      else
      {
         GXv_int10[49] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV106Disponibilidadwwds_25_tfdisponibilidadhorafin_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraFin] <= ?)");
      }
      else
      {
         GXv_int10[50] = (byte)(1) ;
      }
      if ( ! (0==AV107Disponibilidadwwds_26_tfespecialidadid) )
      {
         addWhere(sWhereString, "(T1.[EspecialidadId] >= ?)");
      }
      else
      {
         GXv_int10[51] = (byte)(1) ;
      }
      if ( ! (0==AV108Disponibilidadwwds_27_tfespecialidadid_to) )
      {
         addWhere(sWhereString, "(T1.[EspecialidadId] <= ?)");
      }
      else
      {
         GXv_int10[52] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV110Disponibilidadwwds_29_tfespecialidadcodigo_sel)==0) && ( ! (GXutil.strcmp("", AV109Disponibilidadwwds_28_tfespecialidadcodigo)==0) ) )
      {
         addWhere(sWhereString, "(T2.[EspecialidadCodigo] like ?)");
      }
      else
      {
         GXv_int10[53] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV110Disponibilidadwwds_29_tfespecialidadcodigo_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[EspecialidadCodigo] = ?)");
      }
      else
      {
         GXv_int10[54] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV112Disponibilidadwwds_31_tfespecialidadnombre_sel)==0) && ( ! (GXutil.strcmp("", AV111Disponibilidadwwds_30_tfespecialidadnombre)==0) ) )
      {
         addWhere(sWhereString, "(T2.[EspecialidadNombre] like ?)");
      }
      else
      {
         GXv_int10[55] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV112Disponibilidadwwds_31_tfespecialidadnombre_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[EspecialidadNombre] = ?)");
      }
      else
      {
         GXv_int10[56] = (byte)(1) ;
      }
      if ( ! (0==AV113Disponibilidadwwds_32_tfdisponibilidaduser) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadUser] >= ?)");
      }
      else
      {
         GXv_int10[57] = (byte)(1) ;
      }
      if ( ! (0==AV114Disponibilidadwwds_33_tfdisponibilidaduser_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadUser] <= ?)");
      }
      else
      {
         GXv_int10[58] = (byte)(1) ;
      }
      if ( AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels, "T1.[DisponibilidadEstado] IN (", ")")+")");
      }
      if ( AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels, "T1.[DisponibilidadEstadoCita] IN (", ")")+")");
      }
      if ( AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels, "T1.[DisponibilidadTipoCita] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T3.[ProfesionalApellidoPaterno]" ;
      GXv_Object11[0] = scmdbuf ;
      GXv_Object11[1] = GXv_int10 ;
      return GXv_Object11 ;
   }

   protected Object[] conditional_P002X9( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A136DisponibilidadEstado ,
                                          GXSimpleCollection<String> AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels ,
                                          String A139DisponibilidadEstadoCita ,
                                          GXSimpleCollection<String> AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels ,
                                          String A298DisponibilidadTipoCita ,
                                          GXSimpleCollection<String> AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels ,
                                          int AV83Disponibilidadwwds_2_tfdisponibilidadid ,
                                          int AV84Disponibilidadwwds_3_tfdisponibilidadid_to ,
                                          String AV86Disponibilidadwwds_5_tfeventid_sel ,
                                          String AV85Disponibilidadwwds_4_tfeventid ,
                                          String AV88Disponibilidadwwds_7_tfdisponibilidaddescription_sel ,
                                          String AV87Disponibilidadwwds_6_tfdisponibilidaddescription ,
                                          int AV89Disponibilidadwwds_8_tfprofesionalid ,
                                          int AV90Disponibilidadwwds_9_tfprofesionalid_to ,
                                          String AV92Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel ,
                                          String AV91Disponibilidadwwds_10_tfprofesionalapellidopaterno ,
                                          String AV94Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel ,
                                          String AV93Disponibilidadwwds_12_tfprofesionalapellidomaterno ,
                                          String AV96Disponibilidadwwds_15_tfprofesionalnombres_sel ,
                                          String AV95Disponibilidadwwds_14_tfprofesionalnombres ,
                                          String AV98Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel ,
                                          String AV97Disponibilidadwwds_16_tfprofesionalnombrecompleto ,
                                          String AV100Disponibilidadwwds_19_tfprofesionalcop_sel ,
                                          String AV99Disponibilidadwwds_18_tfprofesionalcop ,
                                          java.util.Date AV101Disponibilidadwwds_20_tfdisponibilidadfecha ,
                                          java.util.Date AV102Disponibilidadwwds_21_tfdisponibilidadfecha_to ,
                                          java.util.Date AV103Disponibilidadwwds_22_tfdisponibilidadhorainicio ,
                                          java.util.Date AV104Disponibilidadwwds_23_tfdisponibilidadhorainicio_to ,
                                          java.util.Date AV105Disponibilidadwwds_24_tfdisponibilidadhorafin ,
                                          java.util.Date AV106Disponibilidadwwds_25_tfdisponibilidadhorafin_to ,
                                          short AV107Disponibilidadwwds_26_tfespecialidadid ,
                                          short AV108Disponibilidadwwds_27_tfespecialidadid_to ,
                                          String AV110Disponibilidadwwds_29_tfespecialidadcodigo_sel ,
                                          String AV109Disponibilidadwwds_28_tfespecialidadcodigo ,
                                          String AV112Disponibilidadwwds_31_tfespecialidadnombre_sel ,
                                          String AV111Disponibilidadwwds_30_tfespecialidadnombre ,
                                          int AV113Disponibilidadwwds_32_tfdisponibilidaduser ,
                                          int AV114Disponibilidadwwds_33_tfdisponibilidaduser_to ,
                                          int AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels_size ,
                                          int AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels_size ,
                                          int AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels_size ,
                                          int A34DisponibilidadId ,
                                          String A133EventId ,
                                          String A134DisponibilidadDescription ,
                                          int A31ProfesionalId ,
                                          String A85ProfesionalApellidoPaterno ,
                                          String A86ProfesionalApellidoMaterno ,
                                          String A84ProfesionalNombres ,
                                          String A88ProfesionalCOP ,
                                          java.util.Date A67DisponibilidadFecha ,
                                          java.util.Date A69DisponibilidadHoraInicio ,
                                          java.util.Date A135DisponibilidadHoraFin ,
                                          short A32EspecialidadId ,
                                          String A140EspecialidadCodigo ,
                                          String A71EspecialidadNombre ,
                                          int A137DisponibilidadUser ,
                                          String AV82Disponibilidadwwds_1_filterfulltext ,
                                          String A83ProfesionalNombreCompleto ,
                                          int A138DCitaId ,
                                          int AV117Disponibilidadwwds_36_tfdcitaid ,
                                          int AV118Disponibilidadwwds_37_tfdcitaid_to )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int13 = new byte[59];
      Object[] GXv_Object14 = new Object[2];
      scmdbuf = "SELECT T1.[DisponibilidadUser], T1.[EspecialidadId], T1.[DisponibilidadHoraFin], T1.[DisponibilidadHoraInicio], T1.[DisponibilidadFecha], T1.[ProfesionalId], T1.[DisponibilidadId]," ;
      scmdbuf += " T1.[DisponibilidadTipoCita], T1.[DisponibilidadEstadoCita], T1.[DisponibilidadEstado], T2.[EspecialidadNombre], T2.[EspecialidadCodigo], T3.[ProfesionalCOP], T3.[ProfesionalNombres]" ;
      scmdbuf += " + ' ' + T3.[ProfesionalApellidoPaterno] + ' ' + T3.[ProfesionalApellidoMaterno] AS ProfesionalNombreCompleto, T1.[DisponibilidadDescription], T1.[EventId], COALESCE(" ;
      scmdbuf += " T4.[DCitaId], 0) AS DCitaId, T3.[ProfesionalNombres], T3.[ProfesionalApellidoPaterno], T3.[ProfesionalApellidoMaterno] FROM ((([Disponibilidad] T1 INNER JOIN [Especialidad]" ;
      scmdbuf += " T2 ON T2.[EspecialidadId] = T1.[EspecialidadId]) INNER JOIN [Profesional] T3 ON T3.[ProfesionalId] = T1.[ProfesionalId]) LEFT JOIN (SELECT MIN(T5.[CitaId]) AS DCitaId," ;
      scmdbuf += " T5.[SGCitaDisponibilidadId] FROM [Cita] T5,  [Disponibilidad] T6 WHERE (T5.[SGCitaDisponibilidadId] = T6.[DisponibilidadId]) AND (T5.[CitaEstado] = 'A') GROUP BY" ;
      scmdbuf += " T5.[SGCitaDisponibilidadId] ) T4 ON T4.[SGCitaDisponibilidadId] = T1.[DisponibilidadId])" ;
      addWhere(sWhereString, "((? = '') or ( ( CONVERT( char(8), CAST(T1.[DisponibilidadId] AS decimal(8,0))) like '%' + ?) or ( T1.[EventId] like '%' + ?) or ( T1.[DisponibilidadDescription] like '%' + ?) or ( CONVERT( char(8), CAST(T1.[ProfesionalId] AS decimal(8,0))) like '%' + ?) or ( T3.[ProfesionalApellidoPaterno] like '%' + ?) or ( T3.[ProfesionalApellidoMaterno] like '%' + ?) or ( T3.[ProfesionalNombres] like '%' + ?) or ( T3.[ProfesionalNombres] + ' ' + T3.[ProfesionalApellidoPaterno] + ' ' + T3.[ProfesionalApellidoMaterno] like '%' + ?) or ( T3.[ProfesionalCOP] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[EspecialidadId] AS decimal(4,0))) like '%' + ?) or ( T2.[EspecialidadCodigo] like '%' + ?) or ( T2.[EspecialidadNombre] like '%' + ?) or ( CONVERT( char(6), CAST(T1.[DisponibilidadUser] AS decimal(6,0))) like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[DisponibilidadEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and T1.[DisponibilidadEstado] = 'I') or ( 'libre' like '%' + LOWER(?) and T1.[DisponibilidadEstadoCita] = 'L') or ( 'ocupado' like '%' + LOWER(?) and T1.[DisponibilidadEstadoCita] = 'O') or ( 'expiró' like '%' + LOWER(?) and T1.[DisponibilidadEstadoCita] = 'E') or ( CONVERT( char(6), CAST(COALESCE( T4.[DCitaId], 0) AS decimal(6,0))) like '%' + ?) or ( 'virtual' like '%' + LOWER(?) and T1.[DisponibilidadTipoCita] = 'V') or ( 'en consultorio' like '%' + LOWER(?) and T1.[DisponibilidadTipoCita] = 'P') or ( 'visita a domicilio' like '%' + LOWER(?) and T1.[DisponibilidadTipoCita] = 'D')))");
      addWhere(sWhereString, "((? = convert(int, 0)) or ( COALESCE( T4.[DCitaId], 0) >= ?))");
      addWhere(sWhereString, "((? = convert(int, 0)) or ( COALESCE( T4.[DCitaId], 0) <= ?))");
      if ( ! (0==AV83Disponibilidadwwds_2_tfdisponibilidadid) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] >= ?)");
      }
      else
      {
         GXv_int13[27] = (byte)(1) ;
      }
      if ( ! (0==AV84Disponibilidadwwds_3_tfdisponibilidadid_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] <= ?)");
      }
      else
      {
         GXv_int13[28] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV86Disponibilidadwwds_5_tfeventid_sel)==0) && ( ! (GXutil.strcmp("", AV85Disponibilidadwwds_4_tfeventid)==0) ) )
      {
         addWhere(sWhereString, "(T1.[EventId] like ?)");
      }
      else
      {
         GXv_int13[29] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV86Disponibilidadwwds_5_tfeventid_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[EventId] = ?)");
      }
      else
      {
         GXv_int13[30] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV88Disponibilidadwwds_7_tfdisponibilidaddescription_sel)==0) && ( ! (GXutil.strcmp("", AV87Disponibilidadwwds_6_tfdisponibilidaddescription)==0) ) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadDescription] like ?)");
      }
      else
      {
         GXv_int13[31] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV88Disponibilidadwwds_7_tfdisponibilidaddescription_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadDescription] = ?)");
      }
      else
      {
         GXv_int13[32] = (byte)(1) ;
      }
      if ( ! (0==AV89Disponibilidadwwds_8_tfprofesionalid) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalId] >= ?)");
      }
      else
      {
         GXv_int13[33] = (byte)(1) ;
      }
      if ( ! (0==AV90Disponibilidadwwds_9_tfprofesionalid_to) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalId] <= ?)");
      }
      else
      {
         GXv_int13[34] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV92Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV91Disponibilidadwwds_10_tfprofesionalapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int13[35] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV92Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int13[36] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV94Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV93Disponibilidadwwds_12_tfprofesionalapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int13[37] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV94Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int13[38] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV96Disponibilidadwwds_15_tfprofesionalnombres_sel)==0) && ( ! (GXutil.strcmp("", AV95Disponibilidadwwds_14_tfprofesionalnombres)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalNombres] like ?)");
      }
      else
      {
         GXv_int13[39] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV96Disponibilidadwwds_15_tfprofesionalnombres_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalNombres] = ?)");
      }
      else
      {
         GXv_int13[40] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV98Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel)==0) && ( ! (GXutil.strcmp("", AV97Disponibilidadwwds_16_tfprofesionalnombrecompleto)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalNombres] + ' ' + T3.[ProfesionalApellidoPaterno] + ' ' + T3.[ProfesionalApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int13[41] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV98Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalNombres] + ' ' + T3.[ProfesionalApellidoPaterno] + ' ' + T3.[ProfesionalApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int13[42] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV100Disponibilidadwwds_19_tfprofesionalcop_sel)==0) && ( ! (GXutil.strcmp("", AV99Disponibilidadwwds_18_tfprofesionalcop)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalCOP] like ?)");
      }
      else
      {
         GXv_int13[43] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV100Disponibilidadwwds_19_tfprofesionalcop_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalCOP] = ?)");
      }
      else
      {
         GXv_int13[44] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV101Disponibilidadwwds_20_tfdisponibilidadfecha)) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadFecha] >= ?)");
      }
      else
      {
         GXv_int13[45] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV102Disponibilidadwwds_21_tfdisponibilidadfecha_to)) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadFecha] <= ?)");
      }
      else
      {
         GXv_int13[46] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV103Disponibilidadwwds_22_tfdisponibilidadhorainicio) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraInicio] >= ?)");
      }
      else
      {
         GXv_int13[47] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV104Disponibilidadwwds_23_tfdisponibilidadhorainicio_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraInicio] <= ?)");
      }
      else
      {
         GXv_int13[48] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV105Disponibilidadwwds_24_tfdisponibilidadhorafin) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraFin] >= ?)");
      }
      else
      {
         GXv_int13[49] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV106Disponibilidadwwds_25_tfdisponibilidadhorafin_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraFin] <= ?)");
      }
      else
      {
         GXv_int13[50] = (byte)(1) ;
      }
      if ( ! (0==AV107Disponibilidadwwds_26_tfespecialidadid) )
      {
         addWhere(sWhereString, "(T1.[EspecialidadId] >= ?)");
      }
      else
      {
         GXv_int13[51] = (byte)(1) ;
      }
      if ( ! (0==AV108Disponibilidadwwds_27_tfespecialidadid_to) )
      {
         addWhere(sWhereString, "(T1.[EspecialidadId] <= ?)");
      }
      else
      {
         GXv_int13[52] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV110Disponibilidadwwds_29_tfespecialidadcodigo_sel)==0) && ( ! (GXutil.strcmp("", AV109Disponibilidadwwds_28_tfespecialidadcodigo)==0) ) )
      {
         addWhere(sWhereString, "(T2.[EspecialidadCodigo] like ?)");
      }
      else
      {
         GXv_int13[53] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV110Disponibilidadwwds_29_tfespecialidadcodigo_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[EspecialidadCodigo] = ?)");
      }
      else
      {
         GXv_int13[54] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV112Disponibilidadwwds_31_tfespecialidadnombre_sel)==0) && ( ! (GXutil.strcmp("", AV111Disponibilidadwwds_30_tfespecialidadnombre)==0) ) )
      {
         addWhere(sWhereString, "(T2.[EspecialidadNombre] like ?)");
      }
      else
      {
         GXv_int13[55] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV112Disponibilidadwwds_31_tfespecialidadnombre_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[EspecialidadNombre] = ?)");
      }
      else
      {
         GXv_int13[56] = (byte)(1) ;
      }
      if ( ! (0==AV113Disponibilidadwwds_32_tfdisponibilidaduser) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadUser] >= ?)");
      }
      else
      {
         GXv_int13[57] = (byte)(1) ;
      }
      if ( ! (0==AV114Disponibilidadwwds_33_tfdisponibilidaduser_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadUser] <= ?)");
      }
      else
      {
         GXv_int13[58] = (byte)(1) ;
      }
      if ( AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels, "T1.[DisponibilidadEstado] IN (", ")")+")");
      }
      if ( AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels, "T1.[DisponibilidadEstadoCita] IN (", ")")+")");
      }
      if ( AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels, "T1.[DisponibilidadTipoCita] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T3.[ProfesionalApellidoMaterno]" ;
      GXv_Object14[0] = scmdbuf ;
      GXv_Object14[1] = GXv_int13 ;
      return GXv_Object14 ;
   }

   protected Object[] conditional_P002X11( ModelContext context ,
                                           int remoteHandle ,
                                           com.genexus.IHttpContext httpContext ,
                                           String A136DisponibilidadEstado ,
                                           GXSimpleCollection<String> AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels ,
                                           String A139DisponibilidadEstadoCita ,
                                           GXSimpleCollection<String> AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels ,
                                           String A298DisponibilidadTipoCita ,
                                           GXSimpleCollection<String> AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels ,
                                           int AV83Disponibilidadwwds_2_tfdisponibilidadid ,
                                           int AV84Disponibilidadwwds_3_tfdisponibilidadid_to ,
                                           String AV86Disponibilidadwwds_5_tfeventid_sel ,
                                           String AV85Disponibilidadwwds_4_tfeventid ,
                                           String AV88Disponibilidadwwds_7_tfdisponibilidaddescription_sel ,
                                           String AV87Disponibilidadwwds_6_tfdisponibilidaddescription ,
                                           int AV89Disponibilidadwwds_8_tfprofesionalid ,
                                           int AV90Disponibilidadwwds_9_tfprofesionalid_to ,
                                           String AV92Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel ,
                                           String AV91Disponibilidadwwds_10_tfprofesionalapellidopaterno ,
                                           String AV94Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel ,
                                           String AV93Disponibilidadwwds_12_tfprofesionalapellidomaterno ,
                                           String AV96Disponibilidadwwds_15_tfprofesionalnombres_sel ,
                                           String AV95Disponibilidadwwds_14_tfprofesionalnombres ,
                                           String AV98Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel ,
                                           String AV97Disponibilidadwwds_16_tfprofesionalnombrecompleto ,
                                           String AV100Disponibilidadwwds_19_tfprofesionalcop_sel ,
                                           String AV99Disponibilidadwwds_18_tfprofesionalcop ,
                                           java.util.Date AV101Disponibilidadwwds_20_tfdisponibilidadfecha ,
                                           java.util.Date AV102Disponibilidadwwds_21_tfdisponibilidadfecha_to ,
                                           java.util.Date AV103Disponibilidadwwds_22_tfdisponibilidadhorainicio ,
                                           java.util.Date AV104Disponibilidadwwds_23_tfdisponibilidadhorainicio_to ,
                                           java.util.Date AV105Disponibilidadwwds_24_tfdisponibilidadhorafin ,
                                           java.util.Date AV106Disponibilidadwwds_25_tfdisponibilidadhorafin_to ,
                                           short AV107Disponibilidadwwds_26_tfespecialidadid ,
                                           short AV108Disponibilidadwwds_27_tfespecialidadid_to ,
                                           String AV110Disponibilidadwwds_29_tfespecialidadcodigo_sel ,
                                           String AV109Disponibilidadwwds_28_tfespecialidadcodigo ,
                                           String AV112Disponibilidadwwds_31_tfespecialidadnombre_sel ,
                                           String AV111Disponibilidadwwds_30_tfespecialidadnombre ,
                                           int AV113Disponibilidadwwds_32_tfdisponibilidaduser ,
                                           int AV114Disponibilidadwwds_33_tfdisponibilidaduser_to ,
                                           int AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels_size ,
                                           int AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels_size ,
                                           int AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels_size ,
                                           int A34DisponibilidadId ,
                                           String A133EventId ,
                                           String A134DisponibilidadDescription ,
                                           int A31ProfesionalId ,
                                           String A85ProfesionalApellidoPaterno ,
                                           String A86ProfesionalApellidoMaterno ,
                                           String A84ProfesionalNombres ,
                                           String A88ProfesionalCOP ,
                                           java.util.Date A67DisponibilidadFecha ,
                                           java.util.Date A69DisponibilidadHoraInicio ,
                                           java.util.Date A135DisponibilidadHoraFin ,
                                           short A32EspecialidadId ,
                                           String A140EspecialidadCodigo ,
                                           String A71EspecialidadNombre ,
                                           int A137DisponibilidadUser ,
                                           String AV82Disponibilidadwwds_1_filterfulltext ,
                                           String A83ProfesionalNombreCompleto ,
                                           int A138DCitaId ,
                                           int AV117Disponibilidadwwds_36_tfdcitaid ,
                                           int AV118Disponibilidadwwds_37_tfdcitaid_to )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int16 = new byte[59];
      Object[] GXv_Object17 = new Object[2];
      scmdbuf = "SELECT T1.[DisponibilidadUser], T1.[EspecialidadId], T1.[DisponibilidadHoraFin], T1.[DisponibilidadHoraInicio], T1.[DisponibilidadFecha], T1.[ProfesionalId], T1.[DisponibilidadId]," ;
      scmdbuf += " T1.[DisponibilidadTipoCita], T1.[DisponibilidadEstadoCita], T1.[DisponibilidadEstado], T2.[EspecialidadNombre], T2.[EspecialidadCodigo], T3.[ProfesionalCOP], T3.[ProfesionalNombres]" ;
      scmdbuf += " + ' ' + T3.[ProfesionalApellidoPaterno] + ' ' + T3.[ProfesionalApellidoMaterno] AS ProfesionalNombreCompleto, T1.[DisponibilidadDescription], T1.[EventId], COALESCE(" ;
      scmdbuf += " T4.[DCitaId], 0) AS DCitaId, T3.[ProfesionalNombres], T3.[ProfesionalApellidoPaterno], T3.[ProfesionalApellidoMaterno] FROM ((([Disponibilidad] T1 INNER JOIN [Especialidad]" ;
      scmdbuf += " T2 ON T2.[EspecialidadId] = T1.[EspecialidadId]) INNER JOIN [Profesional] T3 ON T3.[ProfesionalId] = T1.[ProfesionalId]) LEFT JOIN (SELECT MIN(T5.[CitaId]) AS DCitaId," ;
      scmdbuf += " T5.[SGCitaDisponibilidadId] FROM [Cita] T5,  [Disponibilidad] T6 WHERE (T5.[SGCitaDisponibilidadId] = T6.[DisponibilidadId]) AND (T5.[CitaEstado] = 'A') GROUP BY" ;
      scmdbuf += " T5.[SGCitaDisponibilidadId] ) T4 ON T4.[SGCitaDisponibilidadId] = T1.[DisponibilidadId])" ;
      addWhere(sWhereString, "((? = '') or ( ( CONVERT( char(8), CAST(T1.[DisponibilidadId] AS decimal(8,0))) like '%' + ?) or ( T1.[EventId] like '%' + ?) or ( T1.[DisponibilidadDescription] like '%' + ?) or ( CONVERT( char(8), CAST(T1.[ProfesionalId] AS decimal(8,0))) like '%' + ?) or ( T3.[ProfesionalApellidoPaterno] like '%' + ?) or ( T3.[ProfesionalApellidoMaterno] like '%' + ?) or ( T3.[ProfesionalNombres] like '%' + ?) or ( T3.[ProfesionalNombres] + ' ' + T3.[ProfesionalApellidoPaterno] + ' ' + T3.[ProfesionalApellidoMaterno] like '%' + ?) or ( T3.[ProfesionalCOP] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[EspecialidadId] AS decimal(4,0))) like '%' + ?) or ( T2.[EspecialidadCodigo] like '%' + ?) or ( T2.[EspecialidadNombre] like '%' + ?) or ( CONVERT( char(6), CAST(T1.[DisponibilidadUser] AS decimal(6,0))) like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[DisponibilidadEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and T1.[DisponibilidadEstado] = 'I') or ( 'libre' like '%' + LOWER(?) and T1.[DisponibilidadEstadoCita] = 'L') or ( 'ocupado' like '%' + LOWER(?) and T1.[DisponibilidadEstadoCita] = 'O') or ( 'expiró' like '%' + LOWER(?) and T1.[DisponibilidadEstadoCita] = 'E') or ( CONVERT( char(6), CAST(COALESCE( T4.[DCitaId], 0) AS decimal(6,0))) like '%' + ?) or ( 'virtual' like '%' + LOWER(?) and T1.[DisponibilidadTipoCita] = 'V') or ( 'en consultorio' like '%' + LOWER(?) and T1.[DisponibilidadTipoCita] = 'P') or ( 'visita a domicilio' like '%' + LOWER(?) and T1.[DisponibilidadTipoCita] = 'D')))");
      addWhere(sWhereString, "((? = convert(int, 0)) or ( COALESCE( T4.[DCitaId], 0) >= ?))");
      addWhere(sWhereString, "((? = convert(int, 0)) or ( COALESCE( T4.[DCitaId], 0) <= ?))");
      if ( ! (0==AV83Disponibilidadwwds_2_tfdisponibilidadid) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] >= ?)");
      }
      else
      {
         GXv_int16[27] = (byte)(1) ;
      }
      if ( ! (0==AV84Disponibilidadwwds_3_tfdisponibilidadid_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] <= ?)");
      }
      else
      {
         GXv_int16[28] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV86Disponibilidadwwds_5_tfeventid_sel)==0) && ( ! (GXutil.strcmp("", AV85Disponibilidadwwds_4_tfeventid)==0) ) )
      {
         addWhere(sWhereString, "(T1.[EventId] like ?)");
      }
      else
      {
         GXv_int16[29] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV86Disponibilidadwwds_5_tfeventid_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[EventId] = ?)");
      }
      else
      {
         GXv_int16[30] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV88Disponibilidadwwds_7_tfdisponibilidaddescription_sel)==0) && ( ! (GXutil.strcmp("", AV87Disponibilidadwwds_6_tfdisponibilidaddescription)==0) ) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadDescription] like ?)");
      }
      else
      {
         GXv_int16[31] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV88Disponibilidadwwds_7_tfdisponibilidaddescription_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadDescription] = ?)");
      }
      else
      {
         GXv_int16[32] = (byte)(1) ;
      }
      if ( ! (0==AV89Disponibilidadwwds_8_tfprofesionalid) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalId] >= ?)");
      }
      else
      {
         GXv_int16[33] = (byte)(1) ;
      }
      if ( ! (0==AV90Disponibilidadwwds_9_tfprofesionalid_to) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalId] <= ?)");
      }
      else
      {
         GXv_int16[34] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV92Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV91Disponibilidadwwds_10_tfprofesionalapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int16[35] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV92Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int16[36] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV94Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV93Disponibilidadwwds_12_tfprofesionalapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int16[37] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV94Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int16[38] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV96Disponibilidadwwds_15_tfprofesionalnombres_sel)==0) && ( ! (GXutil.strcmp("", AV95Disponibilidadwwds_14_tfprofesionalnombres)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalNombres] like ?)");
      }
      else
      {
         GXv_int16[39] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV96Disponibilidadwwds_15_tfprofesionalnombres_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalNombres] = ?)");
      }
      else
      {
         GXv_int16[40] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV98Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel)==0) && ( ! (GXutil.strcmp("", AV97Disponibilidadwwds_16_tfprofesionalnombrecompleto)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalNombres] + ' ' + T3.[ProfesionalApellidoPaterno] + ' ' + T3.[ProfesionalApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int16[41] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV98Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalNombres] + ' ' + T3.[ProfesionalApellidoPaterno] + ' ' + T3.[ProfesionalApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int16[42] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV100Disponibilidadwwds_19_tfprofesionalcop_sel)==0) && ( ! (GXutil.strcmp("", AV99Disponibilidadwwds_18_tfprofesionalcop)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalCOP] like ?)");
      }
      else
      {
         GXv_int16[43] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV100Disponibilidadwwds_19_tfprofesionalcop_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalCOP] = ?)");
      }
      else
      {
         GXv_int16[44] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV101Disponibilidadwwds_20_tfdisponibilidadfecha)) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadFecha] >= ?)");
      }
      else
      {
         GXv_int16[45] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV102Disponibilidadwwds_21_tfdisponibilidadfecha_to)) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadFecha] <= ?)");
      }
      else
      {
         GXv_int16[46] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV103Disponibilidadwwds_22_tfdisponibilidadhorainicio) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraInicio] >= ?)");
      }
      else
      {
         GXv_int16[47] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV104Disponibilidadwwds_23_tfdisponibilidadhorainicio_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraInicio] <= ?)");
      }
      else
      {
         GXv_int16[48] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV105Disponibilidadwwds_24_tfdisponibilidadhorafin) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraFin] >= ?)");
      }
      else
      {
         GXv_int16[49] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV106Disponibilidadwwds_25_tfdisponibilidadhorafin_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraFin] <= ?)");
      }
      else
      {
         GXv_int16[50] = (byte)(1) ;
      }
      if ( ! (0==AV107Disponibilidadwwds_26_tfespecialidadid) )
      {
         addWhere(sWhereString, "(T1.[EspecialidadId] >= ?)");
      }
      else
      {
         GXv_int16[51] = (byte)(1) ;
      }
      if ( ! (0==AV108Disponibilidadwwds_27_tfespecialidadid_to) )
      {
         addWhere(sWhereString, "(T1.[EspecialidadId] <= ?)");
      }
      else
      {
         GXv_int16[52] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV110Disponibilidadwwds_29_tfespecialidadcodigo_sel)==0) && ( ! (GXutil.strcmp("", AV109Disponibilidadwwds_28_tfespecialidadcodigo)==0) ) )
      {
         addWhere(sWhereString, "(T2.[EspecialidadCodigo] like ?)");
      }
      else
      {
         GXv_int16[53] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV110Disponibilidadwwds_29_tfespecialidadcodigo_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[EspecialidadCodigo] = ?)");
      }
      else
      {
         GXv_int16[54] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV112Disponibilidadwwds_31_tfespecialidadnombre_sel)==0) && ( ! (GXutil.strcmp("", AV111Disponibilidadwwds_30_tfespecialidadnombre)==0) ) )
      {
         addWhere(sWhereString, "(T2.[EspecialidadNombre] like ?)");
      }
      else
      {
         GXv_int16[55] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV112Disponibilidadwwds_31_tfespecialidadnombre_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[EspecialidadNombre] = ?)");
      }
      else
      {
         GXv_int16[56] = (byte)(1) ;
      }
      if ( ! (0==AV113Disponibilidadwwds_32_tfdisponibilidaduser) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadUser] >= ?)");
      }
      else
      {
         GXv_int16[57] = (byte)(1) ;
      }
      if ( ! (0==AV114Disponibilidadwwds_33_tfdisponibilidaduser_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadUser] <= ?)");
      }
      else
      {
         GXv_int16[58] = (byte)(1) ;
      }
      if ( AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels, "T1.[DisponibilidadEstado] IN (", ")")+")");
      }
      if ( AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels, "T1.[DisponibilidadEstadoCita] IN (", ")")+")");
      }
      if ( AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels, "T1.[DisponibilidadTipoCita] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T3.[ProfesionalNombres]" ;
      GXv_Object17[0] = scmdbuf ;
      GXv_Object17[1] = GXv_int16 ;
      return GXv_Object17 ;
   }

   protected Object[] conditional_P002X13( ModelContext context ,
                                           int remoteHandle ,
                                           com.genexus.IHttpContext httpContext ,
                                           String A136DisponibilidadEstado ,
                                           GXSimpleCollection<String> AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels ,
                                           String A139DisponibilidadEstadoCita ,
                                           GXSimpleCollection<String> AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels ,
                                           String A298DisponibilidadTipoCita ,
                                           GXSimpleCollection<String> AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels ,
                                           int AV83Disponibilidadwwds_2_tfdisponibilidadid ,
                                           int AV84Disponibilidadwwds_3_tfdisponibilidadid_to ,
                                           String AV86Disponibilidadwwds_5_tfeventid_sel ,
                                           String AV85Disponibilidadwwds_4_tfeventid ,
                                           String AV88Disponibilidadwwds_7_tfdisponibilidaddescription_sel ,
                                           String AV87Disponibilidadwwds_6_tfdisponibilidaddescription ,
                                           int AV89Disponibilidadwwds_8_tfprofesionalid ,
                                           int AV90Disponibilidadwwds_9_tfprofesionalid_to ,
                                           String AV92Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel ,
                                           String AV91Disponibilidadwwds_10_tfprofesionalapellidopaterno ,
                                           String AV94Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel ,
                                           String AV93Disponibilidadwwds_12_tfprofesionalapellidomaterno ,
                                           String AV96Disponibilidadwwds_15_tfprofesionalnombres_sel ,
                                           String AV95Disponibilidadwwds_14_tfprofesionalnombres ,
                                           String AV98Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel ,
                                           String AV97Disponibilidadwwds_16_tfprofesionalnombrecompleto ,
                                           String AV100Disponibilidadwwds_19_tfprofesionalcop_sel ,
                                           String AV99Disponibilidadwwds_18_tfprofesionalcop ,
                                           java.util.Date AV101Disponibilidadwwds_20_tfdisponibilidadfecha ,
                                           java.util.Date AV102Disponibilidadwwds_21_tfdisponibilidadfecha_to ,
                                           java.util.Date AV103Disponibilidadwwds_22_tfdisponibilidadhorainicio ,
                                           java.util.Date AV104Disponibilidadwwds_23_tfdisponibilidadhorainicio_to ,
                                           java.util.Date AV105Disponibilidadwwds_24_tfdisponibilidadhorafin ,
                                           java.util.Date AV106Disponibilidadwwds_25_tfdisponibilidadhorafin_to ,
                                           short AV107Disponibilidadwwds_26_tfespecialidadid ,
                                           short AV108Disponibilidadwwds_27_tfespecialidadid_to ,
                                           String AV110Disponibilidadwwds_29_tfespecialidadcodigo_sel ,
                                           String AV109Disponibilidadwwds_28_tfespecialidadcodigo ,
                                           String AV112Disponibilidadwwds_31_tfespecialidadnombre_sel ,
                                           String AV111Disponibilidadwwds_30_tfespecialidadnombre ,
                                           int AV113Disponibilidadwwds_32_tfdisponibilidaduser ,
                                           int AV114Disponibilidadwwds_33_tfdisponibilidaduser_to ,
                                           int AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels_size ,
                                           int AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels_size ,
                                           int AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels_size ,
                                           int A34DisponibilidadId ,
                                           String A133EventId ,
                                           String A134DisponibilidadDescription ,
                                           int A31ProfesionalId ,
                                           String A85ProfesionalApellidoPaterno ,
                                           String A86ProfesionalApellidoMaterno ,
                                           String A84ProfesionalNombres ,
                                           String A88ProfesionalCOP ,
                                           java.util.Date A67DisponibilidadFecha ,
                                           java.util.Date A69DisponibilidadHoraInicio ,
                                           java.util.Date A135DisponibilidadHoraFin ,
                                           short A32EspecialidadId ,
                                           String A140EspecialidadCodigo ,
                                           String A71EspecialidadNombre ,
                                           int A137DisponibilidadUser ,
                                           String AV82Disponibilidadwwds_1_filterfulltext ,
                                           String A83ProfesionalNombreCompleto ,
                                           int A138DCitaId ,
                                           int AV117Disponibilidadwwds_36_tfdcitaid ,
                                           int AV118Disponibilidadwwds_37_tfdcitaid_to )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int19 = new byte[59];
      Object[] GXv_Object20 = new Object[2];
      scmdbuf = "SELECT T1.[DisponibilidadUser], T1.[EspecialidadId], T1.[DisponibilidadHoraFin], T1.[DisponibilidadHoraInicio], T1.[DisponibilidadFecha], T1.[ProfesionalId], T1.[DisponibilidadId]," ;
      scmdbuf += " T1.[DisponibilidadTipoCita], T1.[DisponibilidadEstadoCita], T1.[DisponibilidadEstado], T2.[EspecialidadNombre], T2.[EspecialidadCodigo], T3.[ProfesionalCOP], T3.[ProfesionalNombres]" ;
      scmdbuf += " + ' ' + T3.[ProfesionalApellidoPaterno] + ' ' + T3.[ProfesionalApellidoMaterno] AS ProfesionalNombreCompleto, T1.[DisponibilidadDescription], T1.[EventId], COALESCE(" ;
      scmdbuf += " T4.[DCitaId], 0) AS DCitaId, T3.[ProfesionalNombres], T3.[ProfesionalApellidoPaterno], T3.[ProfesionalApellidoMaterno] FROM ((([Disponibilidad] T1 INNER JOIN [Especialidad]" ;
      scmdbuf += " T2 ON T2.[EspecialidadId] = T1.[EspecialidadId]) INNER JOIN [Profesional] T3 ON T3.[ProfesionalId] = T1.[ProfesionalId]) LEFT JOIN (SELECT MIN(T5.[CitaId]) AS DCitaId," ;
      scmdbuf += " T5.[SGCitaDisponibilidadId] FROM [Cita] T5,  [Disponibilidad] T6 WHERE (T5.[SGCitaDisponibilidadId] = T6.[DisponibilidadId]) AND (T5.[CitaEstado] = 'A') GROUP BY" ;
      scmdbuf += " T5.[SGCitaDisponibilidadId] ) T4 ON T4.[SGCitaDisponibilidadId] = T1.[DisponibilidadId])" ;
      addWhere(sWhereString, "((? = '') or ( ( CONVERT( char(8), CAST(T1.[DisponibilidadId] AS decimal(8,0))) like '%' + ?) or ( T1.[EventId] like '%' + ?) or ( T1.[DisponibilidadDescription] like '%' + ?) or ( CONVERT( char(8), CAST(T1.[ProfesionalId] AS decimal(8,0))) like '%' + ?) or ( T3.[ProfesionalApellidoPaterno] like '%' + ?) or ( T3.[ProfesionalApellidoMaterno] like '%' + ?) or ( T3.[ProfesionalNombres] like '%' + ?) or ( T3.[ProfesionalNombres] + ' ' + T3.[ProfesionalApellidoPaterno] + ' ' + T3.[ProfesionalApellidoMaterno] like '%' + ?) or ( T3.[ProfesionalCOP] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[EspecialidadId] AS decimal(4,0))) like '%' + ?) or ( T2.[EspecialidadCodigo] like '%' + ?) or ( T2.[EspecialidadNombre] like '%' + ?) or ( CONVERT( char(6), CAST(T1.[DisponibilidadUser] AS decimal(6,0))) like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[DisponibilidadEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and T1.[DisponibilidadEstado] = 'I') or ( 'libre' like '%' + LOWER(?) and T1.[DisponibilidadEstadoCita] = 'L') or ( 'ocupado' like '%' + LOWER(?) and T1.[DisponibilidadEstadoCita] = 'O') or ( 'expiró' like '%' + LOWER(?) and T1.[DisponibilidadEstadoCita] = 'E') or ( CONVERT( char(6), CAST(COALESCE( T4.[DCitaId], 0) AS decimal(6,0))) like '%' + ?) or ( 'virtual' like '%' + LOWER(?) and T1.[DisponibilidadTipoCita] = 'V') or ( 'en consultorio' like '%' + LOWER(?) and T1.[DisponibilidadTipoCita] = 'P') or ( 'visita a domicilio' like '%' + LOWER(?) and T1.[DisponibilidadTipoCita] = 'D')))");
      addWhere(sWhereString, "((? = convert(int, 0)) or ( COALESCE( T4.[DCitaId], 0) >= ?))");
      addWhere(sWhereString, "((? = convert(int, 0)) or ( COALESCE( T4.[DCitaId], 0) <= ?))");
      if ( ! (0==AV83Disponibilidadwwds_2_tfdisponibilidadid) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] >= ?)");
      }
      else
      {
         GXv_int19[27] = (byte)(1) ;
      }
      if ( ! (0==AV84Disponibilidadwwds_3_tfdisponibilidadid_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] <= ?)");
      }
      else
      {
         GXv_int19[28] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV86Disponibilidadwwds_5_tfeventid_sel)==0) && ( ! (GXutil.strcmp("", AV85Disponibilidadwwds_4_tfeventid)==0) ) )
      {
         addWhere(sWhereString, "(T1.[EventId] like ?)");
      }
      else
      {
         GXv_int19[29] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV86Disponibilidadwwds_5_tfeventid_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[EventId] = ?)");
      }
      else
      {
         GXv_int19[30] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV88Disponibilidadwwds_7_tfdisponibilidaddescription_sel)==0) && ( ! (GXutil.strcmp("", AV87Disponibilidadwwds_6_tfdisponibilidaddescription)==0) ) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadDescription] like ?)");
      }
      else
      {
         GXv_int19[31] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV88Disponibilidadwwds_7_tfdisponibilidaddescription_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadDescription] = ?)");
      }
      else
      {
         GXv_int19[32] = (byte)(1) ;
      }
      if ( ! (0==AV89Disponibilidadwwds_8_tfprofesionalid) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalId] >= ?)");
      }
      else
      {
         GXv_int19[33] = (byte)(1) ;
      }
      if ( ! (0==AV90Disponibilidadwwds_9_tfprofesionalid_to) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalId] <= ?)");
      }
      else
      {
         GXv_int19[34] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV92Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV91Disponibilidadwwds_10_tfprofesionalapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int19[35] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV92Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int19[36] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV94Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV93Disponibilidadwwds_12_tfprofesionalapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int19[37] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV94Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int19[38] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV96Disponibilidadwwds_15_tfprofesionalnombres_sel)==0) && ( ! (GXutil.strcmp("", AV95Disponibilidadwwds_14_tfprofesionalnombres)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalNombres] like ?)");
      }
      else
      {
         GXv_int19[39] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV96Disponibilidadwwds_15_tfprofesionalnombres_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalNombres] = ?)");
      }
      else
      {
         GXv_int19[40] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV98Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel)==0) && ( ! (GXutil.strcmp("", AV97Disponibilidadwwds_16_tfprofesionalnombrecompleto)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalNombres] + ' ' + T3.[ProfesionalApellidoPaterno] + ' ' + T3.[ProfesionalApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int19[41] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV98Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalNombres] + ' ' + T3.[ProfesionalApellidoPaterno] + ' ' + T3.[ProfesionalApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int19[42] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV100Disponibilidadwwds_19_tfprofesionalcop_sel)==0) && ( ! (GXutil.strcmp("", AV99Disponibilidadwwds_18_tfprofesionalcop)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalCOP] like ?)");
      }
      else
      {
         GXv_int19[43] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV100Disponibilidadwwds_19_tfprofesionalcop_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalCOP] = ?)");
      }
      else
      {
         GXv_int19[44] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV101Disponibilidadwwds_20_tfdisponibilidadfecha)) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadFecha] >= ?)");
      }
      else
      {
         GXv_int19[45] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV102Disponibilidadwwds_21_tfdisponibilidadfecha_to)) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadFecha] <= ?)");
      }
      else
      {
         GXv_int19[46] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV103Disponibilidadwwds_22_tfdisponibilidadhorainicio) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraInicio] >= ?)");
      }
      else
      {
         GXv_int19[47] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV104Disponibilidadwwds_23_tfdisponibilidadhorainicio_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraInicio] <= ?)");
      }
      else
      {
         GXv_int19[48] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV105Disponibilidadwwds_24_tfdisponibilidadhorafin) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraFin] >= ?)");
      }
      else
      {
         GXv_int19[49] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV106Disponibilidadwwds_25_tfdisponibilidadhorafin_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraFin] <= ?)");
      }
      else
      {
         GXv_int19[50] = (byte)(1) ;
      }
      if ( ! (0==AV107Disponibilidadwwds_26_tfespecialidadid) )
      {
         addWhere(sWhereString, "(T1.[EspecialidadId] >= ?)");
      }
      else
      {
         GXv_int19[51] = (byte)(1) ;
      }
      if ( ! (0==AV108Disponibilidadwwds_27_tfespecialidadid_to) )
      {
         addWhere(sWhereString, "(T1.[EspecialidadId] <= ?)");
      }
      else
      {
         GXv_int19[52] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV110Disponibilidadwwds_29_tfespecialidadcodigo_sel)==0) && ( ! (GXutil.strcmp("", AV109Disponibilidadwwds_28_tfespecialidadcodigo)==0) ) )
      {
         addWhere(sWhereString, "(T2.[EspecialidadCodigo] like ?)");
      }
      else
      {
         GXv_int19[53] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV110Disponibilidadwwds_29_tfespecialidadcodigo_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[EspecialidadCodigo] = ?)");
      }
      else
      {
         GXv_int19[54] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV112Disponibilidadwwds_31_tfespecialidadnombre_sel)==0) && ( ! (GXutil.strcmp("", AV111Disponibilidadwwds_30_tfespecialidadnombre)==0) ) )
      {
         addWhere(sWhereString, "(T2.[EspecialidadNombre] like ?)");
      }
      else
      {
         GXv_int19[55] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV112Disponibilidadwwds_31_tfespecialidadnombre_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[EspecialidadNombre] = ?)");
      }
      else
      {
         GXv_int19[56] = (byte)(1) ;
      }
      if ( ! (0==AV113Disponibilidadwwds_32_tfdisponibilidaduser) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadUser] >= ?)");
      }
      else
      {
         GXv_int19[57] = (byte)(1) ;
      }
      if ( ! (0==AV114Disponibilidadwwds_33_tfdisponibilidaduser_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadUser] <= ?)");
      }
      else
      {
         GXv_int19[58] = (byte)(1) ;
      }
      if ( AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels, "T1.[DisponibilidadEstado] IN (", ")")+")");
      }
      if ( AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels, "T1.[DisponibilidadEstadoCita] IN (", ")")+")");
      }
      if ( AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels, "T1.[DisponibilidadTipoCita] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[DisponibilidadId]" ;
      GXv_Object20[0] = scmdbuf ;
      GXv_Object20[1] = GXv_int19 ;
      return GXv_Object20 ;
   }

   protected Object[] conditional_P002X15( ModelContext context ,
                                           int remoteHandle ,
                                           com.genexus.IHttpContext httpContext ,
                                           String A136DisponibilidadEstado ,
                                           GXSimpleCollection<String> AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels ,
                                           String A139DisponibilidadEstadoCita ,
                                           GXSimpleCollection<String> AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels ,
                                           String A298DisponibilidadTipoCita ,
                                           GXSimpleCollection<String> AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels ,
                                           int AV83Disponibilidadwwds_2_tfdisponibilidadid ,
                                           int AV84Disponibilidadwwds_3_tfdisponibilidadid_to ,
                                           String AV86Disponibilidadwwds_5_tfeventid_sel ,
                                           String AV85Disponibilidadwwds_4_tfeventid ,
                                           String AV88Disponibilidadwwds_7_tfdisponibilidaddescription_sel ,
                                           String AV87Disponibilidadwwds_6_tfdisponibilidaddescription ,
                                           int AV89Disponibilidadwwds_8_tfprofesionalid ,
                                           int AV90Disponibilidadwwds_9_tfprofesionalid_to ,
                                           String AV92Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel ,
                                           String AV91Disponibilidadwwds_10_tfprofesionalapellidopaterno ,
                                           String AV94Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel ,
                                           String AV93Disponibilidadwwds_12_tfprofesionalapellidomaterno ,
                                           String AV96Disponibilidadwwds_15_tfprofesionalnombres_sel ,
                                           String AV95Disponibilidadwwds_14_tfprofesionalnombres ,
                                           String AV98Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel ,
                                           String AV97Disponibilidadwwds_16_tfprofesionalnombrecompleto ,
                                           String AV100Disponibilidadwwds_19_tfprofesionalcop_sel ,
                                           String AV99Disponibilidadwwds_18_tfprofesionalcop ,
                                           java.util.Date AV101Disponibilidadwwds_20_tfdisponibilidadfecha ,
                                           java.util.Date AV102Disponibilidadwwds_21_tfdisponibilidadfecha_to ,
                                           java.util.Date AV103Disponibilidadwwds_22_tfdisponibilidadhorainicio ,
                                           java.util.Date AV104Disponibilidadwwds_23_tfdisponibilidadhorainicio_to ,
                                           java.util.Date AV105Disponibilidadwwds_24_tfdisponibilidadhorafin ,
                                           java.util.Date AV106Disponibilidadwwds_25_tfdisponibilidadhorafin_to ,
                                           short AV107Disponibilidadwwds_26_tfespecialidadid ,
                                           short AV108Disponibilidadwwds_27_tfespecialidadid_to ,
                                           String AV110Disponibilidadwwds_29_tfespecialidadcodigo_sel ,
                                           String AV109Disponibilidadwwds_28_tfespecialidadcodigo ,
                                           String AV112Disponibilidadwwds_31_tfespecialidadnombre_sel ,
                                           String AV111Disponibilidadwwds_30_tfespecialidadnombre ,
                                           int AV113Disponibilidadwwds_32_tfdisponibilidaduser ,
                                           int AV114Disponibilidadwwds_33_tfdisponibilidaduser_to ,
                                           int AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels_size ,
                                           int AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels_size ,
                                           int AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels_size ,
                                           int A34DisponibilidadId ,
                                           String A133EventId ,
                                           String A134DisponibilidadDescription ,
                                           int A31ProfesionalId ,
                                           String A85ProfesionalApellidoPaterno ,
                                           String A86ProfesionalApellidoMaterno ,
                                           String A84ProfesionalNombres ,
                                           String A88ProfesionalCOP ,
                                           java.util.Date A67DisponibilidadFecha ,
                                           java.util.Date A69DisponibilidadHoraInicio ,
                                           java.util.Date A135DisponibilidadHoraFin ,
                                           short A32EspecialidadId ,
                                           String A140EspecialidadCodigo ,
                                           String A71EspecialidadNombre ,
                                           int A137DisponibilidadUser ,
                                           String AV82Disponibilidadwwds_1_filterfulltext ,
                                           String A83ProfesionalNombreCompleto ,
                                           int A138DCitaId ,
                                           int AV117Disponibilidadwwds_36_tfdcitaid ,
                                           int AV118Disponibilidadwwds_37_tfdcitaid_to )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int22 = new byte[59];
      Object[] GXv_Object23 = new Object[2];
      scmdbuf = "SELECT T3.[ProfesionalCOP], T1.[DisponibilidadUser], T1.[EspecialidadId], T1.[DisponibilidadHoraFin], T1.[DisponibilidadHoraInicio], T1.[DisponibilidadFecha], T1.[ProfesionalId]," ;
      scmdbuf += " T1.[DisponibilidadId], T1.[DisponibilidadTipoCita], T1.[DisponibilidadEstadoCita], T1.[DisponibilidadEstado], T2.[EspecialidadNombre], T2.[EspecialidadCodigo]," ;
      scmdbuf += " T3.[ProfesionalNombres] + ' ' + T3.[ProfesionalApellidoPaterno] + ' ' + T3.[ProfesionalApellidoMaterno] AS ProfesionalNombreCompleto, T1.[DisponibilidadDescription]," ;
      scmdbuf += " T1.[EventId], COALESCE( T4.[DCitaId], 0) AS DCitaId, T3.[ProfesionalNombres], T3.[ProfesionalApellidoPaterno], T3.[ProfesionalApellidoMaterno] FROM ((([Disponibilidad]" ;
      scmdbuf += " T1 INNER JOIN [Especialidad] T2 ON T2.[EspecialidadId] = T1.[EspecialidadId]) INNER JOIN [Profesional] T3 ON T3.[ProfesionalId] = T1.[ProfesionalId]) LEFT JOIN" ;
      scmdbuf += " (SELECT MIN(T5.[CitaId]) AS DCitaId, T5.[SGCitaDisponibilidadId] FROM [Cita] T5,  [Disponibilidad] T6 WHERE (T5.[SGCitaDisponibilidadId] = T6.[DisponibilidadId])" ;
      scmdbuf += " AND (T5.[CitaEstado] = 'A') GROUP BY T5.[SGCitaDisponibilidadId] ) T4 ON T4.[SGCitaDisponibilidadId] = T1.[DisponibilidadId])" ;
      addWhere(sWhereString, "((? = '') or ( ( CONVERT( char(8), CAST(T1.[DisponibilidadId] AS decimal(8,0))) like '%' + ?) or ( T1.[EventId] like '%' + ?) or ( T1.[DisponibilidadDescription] like '%' + ?) or ( CONVERT( char(8), CAST(T1.[ProfesionalId] AS decimal(8,0))) like '%' + ?) or ( T3.[ProfesionalApellidoPaterno] like '%' + ?) or ( T3.[ProfesionalApellidoMaterno] like '%' + ?) or ( T3.[ProfesionalNombres] like '%' + ?) or ( T3.[ProfesionalNombres] + ' ' + T3.[ProfesionalApellidoPaterno] + ' ' + T3.[ProfesionalApellidoMaterno] like '%' + ?) or ( T3.[ProfesionalCOP] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[EspecialidadId] AS decimal(4,0))) like '%' + ?) or ( T2.[EspecialidadCodigo] like '%' + ?) or ( T2.[EspecialidadNombre] like '%' + ?) or ( CONVERT( char(6), CAST(T1.[DisponibilidadUser] AS decimal(6,0))) like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[DisponibilidadEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and T1.[DisponibilidadEstado] = 'I') or ( 'libre' like '%' + LOWER(?) and T1.[DisponibilidadEstadoCita] = 'L') or ( 'ocupado' like '%' + LOWER(?) and T1.[DisponibilidadEstadoCita] = 'O') or ( 'expiró' like '%' + LOWER(?) and T1.[DisponibilidadEstadoCita] = 'E') or ( CONVERT( char(6), CAST(COALESCE( T4.[DCitaId], 0) AS decimal(6,0))) like '%' + ?) or ( 'virtual' like '%' + LOWER(?) and T1.[DisponibilidadTipoCita] = 'V') or ( 'en consultorio' like '%' + LOWER(?) and T1.[DisponibilidadTipoCita] = 'P') or ( 'visita a domicilio' like '%' + LOWER(?) and T1.[DisponibilidadTipoCita] = 'D')))");
      addWhere(sWhereString, "((? = convert(int, 0)) or ( COALESCE( T4.[DCitaId], 0) >= ?))");
      addWhere(sWhereString, "((? = convert(int, 0)) or ( COALESCE( T4.[DCitaId], 0) <= ?))");
      if ( ! (0==AV83Disponibilidadwwds_2_tfdisponibilidadid) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] >= ?)");
      }
      else
      {
         GXv_int22[27] = (byte)(1) ;
      }
      if ( ! (0==AV84Disponibilidadwwds_3_tfdisponibilidadid_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] <= ?)");
      }
      else
      {
         GXv_int22[28] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV86Disponibilidadwwds_5_tfeventid_sel)==0) && ( ! (GXutil.strcmp("", AV85Disponibilidadwwds_4_tfeventid)==0) ) )
      {
         addWhere(sWhereString, "(T1.[EventId] like ?)");
      }
      else
      {
         GXv_int22[29] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV86Disponibilidadwwds_5_tfeventid_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[EventId] = ?)");
      }
      else
      {
         GXv_int22[30] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV88Disponibilidadwwds_7_tfdisponibilidaddescription_sel)==0) && ( ! (GXutil.strcmp("", AV87Disponibilidadwwds_6_tfdisponibilidaddescription)==0) ) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadDescription] like ?)");
      }
      else
      {
         GXv_int22[31] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV88Disponibilidadwwds_7_tfdisponibilidaddescription_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadDescription] = ?)");
      }
      else
      {
         GXv_int22[32] = (byte)(1) ;
      }
      if ( ! (0==AV89Disponibilidadwwds_8_tfprofesionalid) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalId] >= ?)");
      }
      else
      {
         GXv_int22[33] = (byte)(1) ;
      }
      if ( ! (0==AV90Disponibilidadwwds_9_tfprofesionalid_to) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalId] <= ?)");
      }
      else
      {
         GXv_int22[34] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV92Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV91Disponibilidadwwds_10_tfprofesionalapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int22[35] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV92Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int22[36] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV94Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV93Disponibilidadwwds_12_tfprofesionalapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int22[37] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV94Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int22[38] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV96Disponibilidadwwds_15_tfprofesionalnombres_sel)==0) && ( ! (GXutil.strcmp("", AV95Disponibilidadwwds_14_tfprofesionalnombres)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalNombres] like ?)");
      }
      else
      {
         GXv_int22[39] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV96Disponibilidadwwds_15_tfprofesionalnombres_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalNombres] = ?)");
      }
      else
      {
         GXv_int22[40] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV98Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel)==0) && ( ! (GXutil.strcmp("", AV97Disponibilidadwwds_16_tfprofesionalnombrecompleto)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalNombres] + ' ' + T3.[ProfesionalApellidoPaterno] + ' ' + T3.[ProfesionalApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int22[41] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV98Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalNombres] + ' ' + T3.[ProfesionalApellidoPaterno] + ' ' + T3.[ProfesionalApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int22[42] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV100Disponibilidadwwds_19_tfprofesionalcop_sel)==0) && ( ! (GXutil.strcmp("", AV99Disponibilidadwwds_18_tfprofesionalcop)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalCOP] like ?)");
      }
      else
      {
         GXv_int22[43] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV100Disponibilidadwwds_19_tfprofesionalcop_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalCOP] = ?)");
      }
      else
      {
         GXv_int22[44] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV101Disponibilidadwwds_20_tfdisponibilidadfecha)) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadFecha] >= ?)");
      }
      else
      {
         GXv_int22[45] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV102Disponibilidadwwds_21_tfdisponibilidadfecha_to)) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadFecha] <= ?)");
      }
      else
      {
         GXv_int22[46] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV103Disponibilidadwwds_22_tfdisponibilidadhorainicio) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraInicio] >= ?)");
      }
      else
      {
         GXv_int22[47] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV104Disponibilidadwwds_23_tfdisponibilidadhorainicio_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraInicio] <= ?)");
      }
      else
      {
         GXv_int22[48] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV105Disponibilidadwwds_24_tfdisponibilidadhorafin) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraFin] >= ?)");
      }
      else
      {
         GXv_int22[49] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV106Disponibilidadwwds_25_tfdisponibilidadhorafin_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraFin] <= ?)");
      }
      else
      {
         GXv_int22[50] = (byte)(1) ;
      }
      if ( ! (0==AV107Disponibilidadwwds_26_tfespecialidadid) )
      {
         addWhere(sWhereString, "(T1.[EspecialidadId] >= ?)");
      }
      else
      {
         GXv_int22[51] = (byte)(1) ;
      }
      if ( ! (0==AV108Disponibilidadwwds_27_tfespecialidadid_to) )
      {
         addWhere(sWhereString, "(T1.[EspecialidadId] <= ?)");
      }
      else
      {
         GXv_int22[52] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV110Disponibilidadwwds_29_tfespecialidadcodigo_sel)==0) && ( ! (GXutil.strcmp("", AV109Disponibilidadwwds_28_tfespecialidadcodigo)==0) ) )
      {
         addWhere(sWhereString, "(T2.[EspecialidadCodigo] like ?)");
      }
      else
      {
         GXv_int22[53] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV110Disponibilidadwwds_29_tfespecialidadcodigo_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[EspecialidadCodigo] = ?)");
      }
      else
      {
         GXv_int22[54] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV112Disponibilidadwwds_31_tfespecialidadnombre_sel)==0) && ( ! (GXutil.strcmp("", AV111Disponibilidadwwds_30_tfespecialidadnombre)==0) ) )
      {
         addWhere(sWhereString, "(T2.[EspecialidadNombre] like ?)");
      }
      else
      {
         GXv_int22[55] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV112Disponibilidadwwds_31_tfespecialidadnombre_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[EspecialidadNombre] = ?)");
      }
      else
      {
         GXv_int22[56] = (byte)(1) ;
      }
      if ( ! (0==AV113Disponibilidadwwds_32_tfdisponibilidaduser) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadUser] >= ?)");
      }
      else
      {
         GXv_int22[57] = (byte)(1) ;
      }
      if ( ! (0==AV114Disponibilidadwwds_33_tfdisponibilidaduser_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadUser] <= ?)");
      }
      else
      {
         GXv_int22[58] = (byte)(1) ;
      }
      if ( AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels, "T1.[DisponibilidadEstado] IN (", ")")+")");
      }
      if ( AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels, "T1.[DisponibilidadEstadoCita] IN (", ")")+")");
      }
      if ( AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels, "T1.[DisponibilidadTipoCita] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T3.[ProfesionalCOP]" ;
      GXv_Object23[0] = scmdbuf ;
      GXv_Object23[1] = GXv_int22 ;
      return GXv_Object23 ;
   }

   protected Object[] conditional_P002X17( ModelContext context ,
                                           int remoteHandle ,
                                           com.genexus.IHttpContext httpContext ,
                                           String A136DisponibilidadEstado ,
                                           GXSimpleCollection<String> AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels ,
                                           String A139DisponibilidadEstadoCita ,
                                           GXSimpleCollection<String> AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels ,
                                           String A298DisponibilidadTipoCita ,
                                           GXSimpleCollection<String> AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels ,
                                           int AV83Disponibilidadwwds_2_tfdisponibilidadid ,
                                           int AV84Disponibilidadwwds_3_tfdisponibilidadid_to ,
                                           String AV86Disponibilidadwwds_5_tfeventid_sel ,
                                           String AV85Disponibilidadwwds_4_tfeventid ,
                                           String AV88Disponibilidadwwds_7_tfdisponibilidaddescription_sel ,
                                           String AV87Disponibilidadwwds_6_tfdisponibilidaddescription ,
                                           int AV89Disponibilidadwwds_8_tfprofesionalid ,
                                           int AV90Disponibilidadwwds_9_tfprofesionalid_to ,
                                           String AV92Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel ,
                                           String AV91Disponibilidadwwds_10_tfprofesionalapellidopaterno ,
                                           String AV94Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel ,
                                           String AV93Disponibilidadwwds_12_tfprofesionalapellidomaterno ,
                                           String AV96Disponibilidadwwds_15_tfprofesionalnombres_sel ,
                                           String AV95Disponibilidadwwds_14_tfprofesionalnombres ,
                                           String AV98Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel ,
                                           String AV97Disponibilidadwwds_16_tfprofesionalnombrecompleto ,
                                           String AV100Disponibilidadwwds_19_tfprofesionalcop_sel ,
                                           String AV99Disponibilidadwwds_18_tfprofesionalcop ,
                                           java.util.Date AV101Disponibilidadwwds_20_tfdisponibilidadfecha ,
                                           java.util.Date AV102Disponibilidadwwds_21_tfdisponibilidadfecha_to ,
                                           java.util.Date AV103Disponibilidadwwds_22_tfdisponibilidadhorainicio ,
                                           java.util.Date AV104Disponibilidadwwds_23_tfdisponibilidadhorainicio_to ,
                                           java.util.Date AV105Disponibilidadwwds_24_tfdisponibilidadhorafin ,
                                           java.util.Date AV106Disponibilidadwwds_25_tfdisponibilidadhorafin_to ,
                                           short AV107Disponibilidadwwds_26_tfespecialidadid ,
                                           short AV108Disponibilidadwwds_27_tfespecialidadid_to ,
                                           String AV110Disponibilidadwwds_29_tfespecialidadcodigo_sel ,
                                           String AV109Disponibilidadwwds_28_tfespecialidadcodigo ,
                                           String AV112Disponibilidadwwds_31_tfespecialidadnombre_sel ,
                                           String AV111Disponibilidadwwds_30_tfespecialidadnombre ,
                                           int AV113Disponibilidadwwds_32_tfdisponibilidaduser ,
                                           int AV114Disponibilidadwwds_33_tfdisponibilidaduser_to ,
                                           int AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels_size ,
                                           int AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels_size ,
                                           int AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels_size ,
                                           int A34DisponibilidadId ,
                                           String A133EventId ,
                                           String A134DisponibilidadDescription ,
                                           int A31ProfesionalId ,
                                           String A85ProfesionalApellidoPaterno ,
                                           String A86ProfesionalApellidoMaterno ,
                                           String A84ProfesionalNombres ,
                                           String A88ProfesionalCOP ,
                                           java.util.Date A67DisponibilidadFecha ,
                                           java.util.Date A69DisponibilidadHoraInicio ,
                                           java.util.Date A135DisponibilidadHoraFin ,
                                           short A32EspecialidadId ,
                                           String A140EspecialidadCodigo ,
                                           String A71EspecialidadNombre ,
                                           int A137DisponibilidadUser ,
                                           String AV82Disponibilidadwwds_1_filterfulltext ,
                                           String A83ProfesionalNombreCompleto ,
                                           int A138DCitaId ,
                                           int AV117Disponibilidadwwds_36_tfdcitaid ,
                                           int AV118Disponibilidadwwds_37_tfdcitaid_to )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int25 = new byte[59];
      Object[] GXv_Object26 = new Object[2];
      scmdbuf = "SELECT T2.[EspecialidadCodigo], T1.[DisponibilidadUser], T1.[EspecialidadId], T1.[DisponibilidadHoraFin], T1.[DisponibilidadHoraInicio], T1.[DisponibilidadFecha]," ;
      scmdbuf += " T1.[ProfesionalId], T1.[DisponibilidadId], T1.[DisponibilidadTipoCita], T1.[DisponibilidadEstadoCita], T1.[DisponibilidadEstado], T2.[EspecialidadNombre], T3.[ProfesionalCOP]," ;
      scmdbuf += " T3.[ProfesionalNombres] + ' ' + T3.[ProfesionalApellidoPaterno] + ' ' + T3.[ProfesionalApellidoMaterno] AS ProfesionalNombreCompleto, T1.[DisponibilidadDescription]," ;
      scmdbuf += " T1.[EventId], COALESCE( T4.[DCitaId], 0) AS DCitaId, T3.[ProfesionalNombres], T3.[ProfesionalApellidoPaterno], T3.[ProfesionalApellidoMaterno] FROM ((([Disponibilidad]" ;
      scmdbuf += " T1 INNER JOIN [Especialidad] T2 ON T2.[EspecialidadId] = T1.[EspecialidadId]) INNER JOIN [Profesional] T3 ON T3.[ProfesionalId] = T1.[ProfesionalId]) LEFT JOIN" ;
      scmdbuf += " (SELECT MIN(T5.[CitaId]) AS DCitaId, T5.[SGCitaDisponibilidadId] FROM [Cita] T5,  [Disponibilidad] T6 WHERE (T5.[SGCitaDisponibilidadId] = T6.[DisponibilidadId])" ;
      scmdbuf += " AND (T5.[CitaEstado] = 'A') GROUP BY T5.[SGCitaDisponibilidadId] ) T4 ON T4.[SGCitaDisponibilidadId] = T1.[DisponibilidadId])" ;
      addWhere(sWhereString, "((? = '') or ( ( CONVERT( char(8), CAST(T1.[DisponibilidadId] AS decimal(8,0))) like '%' + ?) or ( T1.[EventId] like '%' + ?) or ( T1.[DisponibilidadDescription] like '%' + ?) or ( CONVERT( char(8), CAST(T1.[ProfesionalId] AS decimal(8,0))) like '%' + ?) or ( T3.[ProfesionalApellidoPaterno] like '%' + ?) or ( T3.[ProfesionalApellidoMaterno] like '%' + ?) or ( T3.[ProfesionalNombres] like '%' + ?) or ( T3.[ProfesionalNombres] + ' ' + T3.[ProfesionalApellidoPaterno] + ' ' + T3.[ProfesionalApellidoMaterno] like '%' + ?) or ( T3.[ProfesionalCOP] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[EspecialidadId] AS decimal(4,0))) like '%' + ?) or ( T2.[EspecialidadCodigo] like '%' + ?) or ( T2.[EspecialidadNombre] like '%' + ?) or ( CONVERT( char(6), CAST(T1.[DisponibilidadUser] AS decimal(6,0))) like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[DisponibilidadEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and T1.[DisponibilidadEstado] = 'I') or ( 'libre' like '%' + LOWER(?) and T1.[DisponibilidadEstadoCita] = 'L') or ( 'ocupado' like '%' + LOWER(?) and T1.[DisponibilidadEstadoCita] = 'O') or ( 'expiró' like '%' + LOWER(?) and T1.[DisponibilidadEstadoCita] = 'E') or ( CONVERT( char(6), CAST(COALESCE( T4.[DCitaId], 0) AS decimal(6,0))) like '%' + ?) or ( 'virtual' like '%' + LOWER(?) and T1.[DisponibilidadTipoCita] = 'V') or ( 'en consultorio' like '%' + LOWER(?) and T1.[DisponibilidadTipoCita] = 'P') or ( 'visita a domicilio' like '%' + LOWER(?) and T1.[DisponibilidadTipoCita] = 'D')))");
      addWhere(sWhereString, "((? = convert(int, 0)) or ( COALESCE( T4.[DCitaId], 0) >= ?))");
      addWhere(sWhereString, "((? = convert(int, 0)) or ( COALESCE( T4.[DCitaId], 0) <= ?))");
      if ( ! (0==AV83Disponibilidadwwds_2_tfdisponibilidadid) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] >= ?)");
      }
      else
      {
         GXv_int25[27] = (byte)(1) ;
      }
      if ( ! (0==AV84Disponibilidadwwds_3_tfdisponibilidadid_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] <= ?)");
      }
      else
      {
         GXv_int25[28] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV86Disponibilidadwwds_5_tfeventid_sel)==0) && ( ! (GXutil.strcmp("", AV85Disponibilidadwwds_4_tfeventid)==0) ) )
      {
         addWhere(sWhereString, "(T1.[EventId] like ?)");
      }
      else
      {
         GXv_int25[29] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV86Disponibilidadwwds_5_tfeventid_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[EventId] = ?)");
      }
      else
      {
         GXv_int25[30] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV88Disponibilidadwwds_7_tfdisponibilidaddescription_sel)==0) && ( ! (GXutil.strcmp("", AV87Disponibilidadwwds_6_tfdisponibilidaddescription)==0) ) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadDescription] like ?)");
      }
      else
      {
         GXv_int25[31] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV88Disponibilidadwwds_7_tfdisponibilidaddescription_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadDescription] = ?)");
      }
      else
      {
         GXv_int25[32] = (byte)(1) ;
      }
      if ( ! (0==AV89Disponibilidadwwds_8_tfprofesionalid) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalId] >= ?)");
      }
      else
      {
         GXv_int25[33] = (byte)(1) ;
      }
      if ( ! (0==AV90Disponibilidadwwds_9_tfprofesionalid_to) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalId] <= ?)");
      }
      else
      {
         GXv_int25[34] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV92Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV91Disponibilidadwwds_10_tfprofesionalapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int25[35] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV92Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int25[36] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV94Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV93Disponibilidadwwds_12_tfprofesionalapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int25[37] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV94Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int25[38] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV96Disponibilidadwwds_15_tfprofesionalnombres_sel)==0) && ( ! (GXutil.strcmp("", AV95Disponibilidadwwds_14_tfprofesionalnombres)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalNombres] like ?)");
      }
      else
      {
         GXv_int25[39] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV96Disponibilidadwwds_15_tfprofesionalnombres_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalNombres] = ?)");
      }
      else
      {
         GXv_int25[40] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV98Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel)==0) && ( ! (GXutil.strcmp("", AV97Disponibilidadwwds_16_tfprofesionalnombrecompleto)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalNombres] + ' ' + T3.[ProfesionalApellidoPaterno] + ' ' + T3.[ProfesionalApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int25[41] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV98Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalNombres] + ' ' + T3.[ProfesionalApellidoPaterno] + ' ' + T3.[ProfesionalApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int25[42] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV100Disponibilidadwwds_19_tfprofesionalcop_sel)==0) && ( ! (GXutil.strcmp("", AV99Disponibilidadwwds_18_tfprofesionalcop)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalCOP] like ?)");
      }
      else
      {
         GXv_int25[43] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV100Disponibilidadwwds_19_tfprofesionalcop_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalCOP] = ?)");
      }
      else
      {
         GXv_int25[44] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV101Disponibilidadwwds_20_tfdisponibilidadfecha)) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadFecha] >= ?)");
      }
      else
      {
         GXv_int25[45] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV102Disponibilidadwwds_21_tfdisponibilidadfecha_to)) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadFecha] <= ?)");
      }
      else
      {
         GXv_int25[46] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV103Disponibilidadwwds_22_tfdisponibilidadhorainicio) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraInicio] >= ?)");
      }
      else
      {
         GXv_int25[47] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV104Disponibilidadwwds_23_tfdisponibilidadhorainicio_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraInicio] <= ?)");
      }
      else
      {
         GXv_int25[48] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV105Disponibilidadwwds_24_tfdisponibilidadhorafin) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraFin] >= ?)");
      }
      else
      {
         GXv_int25[49] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV106Disponibilidadwwds_25_tfdisponibilidadhorafin_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraFin] <= ?)");
      }
      else
      {
         GXv_int25[50] = (byte)(1) ;
      }
      if ( ! (0==AV107Disponibilidadwwds_26_tfespecialidadid) )
      {
         addWhere(sWhereString, "(T1.[EspecialidadId] >= ?)");
      }
      else
      {
         GXv_int25[51] = (byte)(1) ;
      }
      if ( ! (0==AV108Disponibilidadwwds_27_tfespecialidadid_to) )
      {
         addWhere(sWhereString, "(T1.[EspecialidadId] <= ?)");
      }
      else
      {
         GXv_int25[52] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV110Disponibilidadwwds_29_tfespecialidadcodigo_sel)==0) && ( ! (GXutil.strcmp("", AV109Disponibilidadwwds_28_tfespecialidadcodigo)==0) ) )
      {
         addWhere(sWhereString, "(T2.[EspecialidadCodigo] like ?)");
      }
      else
      {
         GXv_int25[53] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV110Disponibilidadwwds_29_tfespecialidadcodigo_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[EspecialidadCodigo] = ?)");
      }
      else
      {
         GXv_int25[54] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV112Disponibilidadwwds_31_tfespecialidadnombre_sel)==0) && ( ! (GXutil.strcmp("", AV111Disponibilidadwwds_30_tfespecialidadnombre)==0) ) )
      {
         addWhere(sWhereString, "(T2.[EspecialidadNombre] like ?)");
      }
      else
      {
         GXv_int25[55] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV112Disponibilidadwwds_31_tfespecialidadnombre_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[EspecialidadNombre] = ?)");
      }
      else
      {
         GXv_int25[56] = (byte)(1) ;
      }
      if ( ! (0==AV113Disponibilidadwwds_32_tfdisponibilidaduser) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadUser] >= ?)");
      }
      else
      {
         GXv_int25[57] = (byte)(1) ;
      }
      if ( ! (0==AV114Disponibilidadwwds_33_tfdisponibilidaduser_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadUser] <= ?)");
      }
      else
      {
         GXv_int25[58] = (byte)(1) ;
      }
      if ( AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels, "T1.[DisponibilidadEstado] IN (", ")")+")");
      }
      if ( AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels, "T1.[DisponibilidadEstadoCita] IN (", ")")+")");
      }
      if ( AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels, "T1.[DisponibilidadTipoCita] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T2.[EspecialidadCodigo]" ;
      GXv_Object26[0] = scmdbuf ;
      GXv_Object26[1] = GXv_int25 ;
      return GXv_Object26 ;
   }

   protected Object[] conditional_P002X19( ModelContext context ,
                                           int remoteHandle ,
                                           com.genexus.IHttpContext httpContext ,
                                           String A136DisponibilidadEstado ,
                                           GXSimpleCollection<String> AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels ,
                                           String A139DisponibilidadEstadoCita ,
                                           GXSimpleCollection<String> AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels ,
                                           String A298DisponibilidadTipoCita ,
                                           GXSimpleCollection<String> AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels ,
                                           int AV83Disponibilidadwwds_2_tfdisponibilidadid ,
                                           int AV84Disponibilidadwwds_3_tfdisponibilidadid_to ,
                                           String AV86Disponibilidadwwds_5_tfeventid_sel ,
                                           String AV85Disponibilidadwwds_4_tfeventid ,
                                           String AV88Disponibilidadwwds_7_tfdisponibilidaddescription_sel ,
                                           String AV87Disponibilidadwwds_6_tfdisponibilidaddescription ,
                                           int AV89Disponibilidadwwds_8_tfprofesionalid ,
                                           int AV90Disponibilidadwwds_9_tfprofesionalid_to ,
                                           String AV92Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel ,
                                           String AV91Disponibilidadwwds_10_tfprofesionalapellidopaterno ,
                                           String AV94Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel ,
                                           String AV93Disponibilidadwwds_12_tfprofesionalapellidomaterno ,
                                           String AV96Disponibilidadwwds_15_tfprofesionalnombres_sel ,
                                           String AV95Disponibilidadwwds_14_tfprofesionalnombres ,
                                           String AV98Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel ,
                                           String AV97Disponibilidadwwds_16_tfprofesionalnombrecompleto ,
                                           String AV100Disponibilidadwwds_19_tfprofesionalcop_sel ,
                                           String AV99Disponibilidadwwds_18_tfprofesionalcop ,
                                           java.util.Date AV101Disponibilidadwwds_20_tfdisponibilidadfecha ,
                                           java.util.Date AV102Disponibilidadwwds_21_tfdisponibilidadfecha_to ,
                                           java.util.Date AV103Disponibilidadwwds_22_tfdisponibilidadhorainicio ,
                                           java.util.Date AV104Disponibilidadwwds_23_tfdisponibilidadhorainicio_to ,
                                           java.util.Date AV105Disponibilidadwwds_24_tfdisponibilidadhorafin ,
                                           java.util.Date AV106Disponibilidadwwds_25_tfdisponibilidadhorafin_to ,
                                           short AV107Disponibilidadwwds_26_tfespecialidadid ,
                                           short AV108Disponibilidadwwds_27_tfespecialidadid_to ,
                                           String AV110Disponibilidadwwds_29_tfespecialidadcodigo_sel ,
                                           String AV109Disponibilidadwwds_28_tfespecialidadcodigo ,
                                           String AV112Disponibilidadwwds_31_tfespecialidadnombre_sel ,
                                           String AV111Disponibilidadwwds_30_tfespecialidadnombre ,
                                           int AV113Disponibilidadwwds_32_tfdisponibilidaduser ,
                                           int AV114Disponibilidadwwds_33_tfdisponibilidaduser_to ,
                                           int AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels_size ,
                                           int AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels_size ,
                                           int AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels_size ,
                                           int A34DisponibilidadId ,
                                           String A133EventId ,
                                           String A134DisponibilidadDescription ,
                                           int A31ProfesionalId ,
                                           String A85ProfesionalApellidoPaterno ,
                                           String A86ProfesionalApellidoMaterno ,
                                           String A84ProfesionalNombres ,
                                           String A88ProfesionalCOP ,
                                           java.util.Date A67DisponibilidadFecha ,
                                           java.util.Date A69DisponibilidadHoraInicio ,
                                           java.util.Date A135DisponibilidadHoraFin ,
                                           short A32EspecialidadId ,
                                           String A140EspecialidadCodigo ,
                                           String A71EspecialidadNombre ,
                                           int A137DisponibilidadUser ,
                                           String AV82Disponibilidadwwds_1_filterfulltext ,
                                           String A83ProfesionalNombreCompleto ,
                                           int A138DCitaId ,
                                           int AV117Disponibilidadwwds_36_tfdcitaid ,
                                           int AV118Disponibilidadwwds_37_tfdcitaid_to )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int28 = new byte[59];
      Object[] GXv_Object29 = new Object[2];
      scmdbuf = "SELECT T2.[EspecialidadNombre], T1.[DisponibilidadUser], T1.[EspecialidadId], T1.[DisponibilidadHoraFin], T1.[DisponibilidadHoraInicio], T1.[DisponibilidadFecha]," ;
      scmdbuf += " T1.[ProfesionalId], T1.[DisponibilidadId], T1.[DisponibilidadTipoCita], T1.[DisponibilidadEstadoCita], T1.[DisponibilidadEstado], T2.[EspecialidadCodigo], T3.[ProfesionalCOP]," ;
      scmdbuf += " T3.[ProfesionalNombres] + ' ' + T3.[ProfesionalApellidoPaterno] + ' ' + T3.[ProfesionalApellidoMaterno] AS ProfesionalNombreCompleto, T1.[DisponibilidadDescription]," ;
      scmdbuf += " T1.[EventId], COALESCE( T4.[DCitaId], 0) AS DCitaId, T3.[ProfesionalNombres], T3.[ProfesionalApellidoPaterno], T3.[ProfesionalApellidoMaterno] FROM ((([Disponibilidad]" ;
      scmdbuf += " T1 INNER JOIN [Especialidad] T2 ON T2.[EspecialidadId] = T1.[EspecialidadId]) INNER JOIN [Profesional] T3 ON T3.[ProfesionalId] = T1.[ProfesionalId]) LEFT JOIN" ;
      scmdbuf += " (SELECT MIN(T5.[CitaId]) AS DCitaId, T5.[SGCitaDisponibilidadId] FROM [Cita] T5,  [Disponibilidad] T6 WHERE (T5.[SGCitaDisponibilidadId] = T6.[DisponibilidadId])" ;
      scmdbuf += " AND (T5.[CitaEstado] = 'A') GROUP BY T5.[SGCitaDisponibilidadId] ) T4 ON T4.[SGCitaDisponibilidadId] = T1.[DisponibilidadId])" ;
      addWhere(sWhereString, "((? = '') or ( ( CONVERT( char(8), CAST(T1.[DisponibilidadId] AS decimal(8,0))) like '%' + ?) or ( T1.[EventId] like '%' + ?) or ( T1.[DisponibilidadDescription] like '%' + ?) or ( CONVERT( char(8), CAST(T1.[ProfesionalId] AS decimal(8,0))) like '%' + ?) or ( T3.[ProfesionalApellidoPaterno] like '%' + ?) or ( T3.[ProfesionalApellidoMaterno] like '%' + ?) or ( T3.[ProfesionalNombres] like '%' + ?) or ( T3.[ProfesionalNombres] + ' ' + T3.[ProfesionalApellidoPaterno] + ' ' + T3.[ProfesionalApellidoMaterno] like '%' + ?) or ( T3.[ProfesionalCOP] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[EspecialidadId] AS decimal(4,0))) like '%' + ?) or ( T2.[EspecialidadCodigo] like '%' + ?) or ( T2.[EspecialidadNombre] like '%' + ?) or ( CONVERT( char(6), CAST(T1.[DisponibilidadUser] AS decimal(6,0))) like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[DisponibilidadEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and T1.[DisponibilidadEstado] = 'I') or ( 'libre' like '%' + LOWER(?) and T1.[DisponibilidadEstadoCita] = 'L') or ( 'ocupado' like '%' + LOWER(?) and T1.[DisponibilidadEstadoCita] = 'O') or ( 'expiró' like '%' + LOWER(?) and T1.[DisponibilidadEstadoCita] = 'E') or ( CONVERT( char(6), CAST(COALESCE( T4.[DCitaId], 0) AS decimal(6,0))) like '%' + ?) or ( 'virtual' like '%' + LOWER(?) and T1.[DisponibilidadTipoCita] = 'V') or ( 'en consultorio' like '%' + LOWER(?) and T1.[DisponibilidadTipoCita] = 'P') or ( 'visita a domicilio' like '%' + LOWER(?) and T1.[DisponibilidadTipoCita] = 'D')))");
      addWhere(sWhereString, "((? = convert(int, 0)) or ( COALESCE( T4.[DCitaId], 0) >= ?))");
      addWhere(sWhereString, "((? = convert(int, 0)) or ( COALESCE( T4.[DCitaId], 0) <= ?))");
      if ( ! (0==AV83Disponibilidadwwds_2_tfdisponibilidadid) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] >= ?)");
      }
      else
      {
         GXv_int28[27] = (byte)(1) ;
      }
      if ( ! (0==AV84Disponibilidadwwds_3_tfdisponibilidadid_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] <= ?)");
      }
      else
      {
         GXv_int28[28] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV86Disponibilidadwwds_5_tfeventid_sel)==0) && ( ! (GXutil.strcmp("", AV85Disponibilidadwwds_4_tfeventid)==0) ) )
      {
         addWhere(sWhereString, "(T1.[EventId] like ?)");
      }
      else
      {
         GXv_int28[29] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV86Disponibilidadwwds_5_tfeventid_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[EventId] = ?)");
      }
      else
      {
         GXv_int28[30] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV88Disponibilidadwwds_7_tfdisponibilidaddescription_sel)==0) && ( ! (GXutil.strcmp("", AV87Disponibilidadwwds_6_tfdisponibilidaddescription)==0) ) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadDescription] like ?)");
      }
      else
      {
         GXv_int28[31] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV88Disponibilidadwwds_7_tfdisponibilidaddescription_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadDescription] = ?)");
      }
      else
      {
         GXv_int28[32] = (byte)(1) ;
      }
      if ( ! (0==AV89Disponibilidadwwds_8_tfprofesionalid) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalId] >= ?)");
      }
      else
      {
         GXv_int28[33] = (byte)(1) ;
      }
      if ( ! (0==AV90Disponibilidadwwds_9_tfprofesionalid_to) )
      {
         addWhere(sWhereString, "(T1.[ProfesionalId] <= ?)");
      }
      else
      {
         GXv_int28[34] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV92Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV91Disponibilidadwwds_10_tfprofesionalapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int28[35] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV92Disponibilidadwwds_11_tfprofesionalapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int28[36] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV94Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV93Disponibilidadwwds_12_tfprofesionalapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int28[37] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV94Disponibilidadwwds_13_tfprofesionalapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int28[38] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV96Disponibilidadwwds_15_tfprofesionalnombres_sel)==0) && ( ! (GXutil.strcmp("", AV95Disponibilidadwwds_14_tfprofesionalnombres)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalNombres] like ?)");
      }
      else
      {
         GXv_int28[39] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV96Disponibilidadwwds_15_tfprofesionalnombres_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalNombres] = ?)");
      }
      else
      {
         GXv_int28[40] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV98Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel)==0) && ( ! (GXutil.strcmp("", AV97Disponibilidadwwds_16_tfprofesionalnombrecompleto)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalNombres] + ' ' + T3.[ProfesionalApellidoPaterno] + ' ' + T3.[ProfesionalApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int28[41] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV98Disponibilidadwwds_17_tfprofesionalnombrecompleto_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalNombres] + ' ' + T3.[ProfesionalApellidoPaterno] + ' ' + T3.[ProfesionalApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int28[42] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV100Disponibilidadwwds_19_tfprofesionalcop_sel)==0) && ( ! (GXutil.strcmp("", AV99Disponibilidadwwds_18_tfprofesionalcop)==0) ) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalCOP] like ?)");
      }
      else
      {
         GXv_int28[43] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV100Disponibilidadwwds_19_tfprofesionalcop_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[ProfesionalCOP] = ?)");
      }
      else
      {
         GXv_int28[44] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV101Disponibilidadwwds_20_tfdisponibilidadfecha)) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadFecha] >= ?)");
      }
      else
      {
         GXv_int28[45] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV102Disponibilidadwwds_21_tfdisponibilidadfecha_to)) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadFecha] <= ?)");
      }
      else
      {
         GXv_int28[46] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV103Disponibilidadwwds_22_tfdisponibilidadhorainicio) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraInicio] >= ?)");
      }
      else
      {
         GXv_int28[47] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV104Disponibilidadwwds_23_tfdisponibilidadhorainicio_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraInicio] <= ?)");
      }
      else
      {
         GXv_int28[48] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV105Disponibilidadwwds_24_tfdisponibilidadhorafin) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraFin] >= ?)");
      }
      else
      {
         GXv_int28[49] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV106Disponibilidadwwds_25_tfdisponibilidadhorafin_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadHoraFin] <= ?)");
      }
      else
      {
         GXv_int28[50] = (byte)(1) ;
      }
      if ( ! (0==AV107Disponibilidadwwds_26_tfespecialidadid) )
      {
         addWhere(sWhereString, "(T1.[EspecialidadId] >= ?)");
      }
      else
      {
         GXv_int28[51] = (byte)(1) ;
      }
      if ( ! (0==AV108Disponibilidadwwds_27_tfespecialidadid_to) )
      {
         addWhere(sWhereString, "(T1.[EspecialidadId] <= ?)");
      }
      else
      {
         GXv_int28[52] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV110Disponibilidadwwds_29_tfespecialidadcodigo_sel)==0) && ( ! (GXutil.strcmp("", AV109Disponibilidadwwds_28_tfespecialidadcodigo)==0) ) )
      {
         addWhere(sWhereString, "(T2.[EspecialidadCodigo] like ?)");
      }
      else
      {
         GXv_int28[53] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV110Disponibilidadwwds_29_tfespecialidadcodigo_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[EspecialidadCodigo] = ?)");
      }
      else
      {
         GXv_int28[54] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV112Disponibilidadwwds_31_tfespecialidadnombre_sel)==0) && ( ! (GXutil.strcmp("", AV111Disponibilidadwwds_30_tfespecialidadnombre)==0) ) )
      {
         addWhere(sWhereString, "(T2.[EspecialidadNombre] like ?)");
      }
      else
      {
         GXv_int28[55] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV112Disponibilidadwwds_31_tfespecialidadnombre_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[EspecialidadNombre] = ?)");
      }
      else
      {
         GXv_int28[56] = (byte)(1) ;
      }
      if ( ! (0==AV113Disponibilidadwwds_32_tfdisponibilidaduser) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadUser] >= ?)");
      }
      else
      {
         GXv_int28[57] = (byte)(1) ;
      }
      if ( ! (0==AV114Disponibilidadwwds_33_tfdisponibilidaduser_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadUser] <= ?)");
      }
      else
      {
         GXv_int28[58] = (byte)(1) ;
      }
      if ( AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV115Disponibilidadwwds_34_tfdisponibilidadestado_sels, "T1.[DisponibilidadEstado] IN (", ")")+")");
      }
      if ( AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV116Disponibilidadwwds_35_tfdisponibilidadestadocita_sels, "T1.[DisponibilidadEstadoCita] IN (", ")")+")");
      }
      if ( AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV119Disponibilidadwwds_38_tfdisponibilidadtipocita_sels, "T1.[DisponibilidadTipoCita] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T2.[EspecialidadNombre]" ;
      GXv_Object29[0] = scmdbuf ;
      GXv_Object29[1] = GXv_int28 ;
      return GXv_Object29 ;
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
                  return conditional_P002X3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).intValue() , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , (String)dynConstraints[19] , (String)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , (java.util.Date)dynConstraints[24] , (java.util.Date)dynConstraints[25] , (java.util.Date)dynConstraints[26] , (java.util.Date)dynConstraints[27] , (java.util.Date)dynConstraints[28] , (java.util.Date)dynConstraints[29] , ((Number) dynConstraints[30]).shortValue() , ((Number) dynConstraints[31]).shortValue() , (String)dynConstraints[32] , (String)dynConstraints[33] , (String)dynConstraints[34] , (String)dynConstraints[35] , ((Number) dynConstraints[36]).intValue() , ((Number) dynConstraints[37]).intValue() , ((Number) dynConstraints[38]).intValue() , ((Number) dynConstraints[39]).intValue() , ((Number) dynConstraints[40]).intValue() , ((Number) dynConstraints[41]).intValue() , (String)dynConstraints[42] , (String)dynConstraints[43] , ((Number) dynConstraints[44]).intValue() , (String)dynConstraints[45] , (String)dynConstraints[46] , (String)dynConstraints[47] , (String)dynConstraints[48] , (java.util.Date)dynConstraints[49] , (java.util.Date)dynConstraints[50] , (java.util.Date)dynConstraints[51] , ((Number) dynConstraints[52]).shortValue() , (String)dynConstraints[53] , (String)dynConstraints[54] , ((Number) dynConstraints[55]).intValue() , (String)dynConstraints[56] , (String)dynConstraints[57] , ((Number) dynConstraints[58]).intValue() , ((Number) dynConstraints[59]).intValue() , ((Number) dynConstraints[60]).intValue() );
            case 1 :
                  return conditional_P002X5(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).intValue() , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , (String)dynConstraints[19] , (String)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , (java.util.Date)dynConstraints[24] , (java.util.Date)dynConstraints[25] , (java.util.Date)dynConstraints[26] , (java.util.Date)dynConstraints[27] , (java.util.Date)dynConstraints[28] , (java.util.Date)dynConstraints[29] , ((Number) dynConstraints[30]).shortValue() , ((Number) dynConstraints[31]).shortValue() , (String)dynConstraints[32] , (String)dynConstraints[33] , (String)dynConstraints[34] , (String)dynConstraints[35] , ((Number) dynConstraints[36]).intValue() , ((Number) dynConstraints[37]).intValue() , ((Number) dynConstraints[38]).intValue() , ((Number) dynConstraints[39]).intValue() , ((Number) dynConstraints[40]).intValue() , ((Number) dynConstraints[41]).intValue() , (String)dynConstraints[42] , (String)dynConstraints[43] , ((Number) dynConstraints[44]).intValue() , (String)dynConstraints[45] , (String)dynConstraints[46] , (String)dynConstraints[47] , (String)dynConstraints[48] , (java.util.Date)dynConstraints[49] , (java.util.Date)dynConstraints[50] , (java.util.Date)dynConstraints[51] , ((Number) dynConstraints[52]).shortValue() , (String)dynConstraints[53] , (String)dynConstraints[54] , ((Number) dynConstraints[55]).intValue() , (String)dynConstraints[56] , (String)dynConstraints[57] , ((Number) dynConstraints[58]).intValue() , ((Number) dynConstraints[59]).intValue() , ((Number) dynConstraints[60]).intValue() );
            case 2 :
                  return conditional_P002X7(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).intValue() , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , (String)dynConstraints[19] , (String)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , (java.util.Date)dynConstraints[24] , (java.util.Date)dynConstraints[25] , (java.util.Date)dynConstraints[26] , (java.util.Date)dynConstraints[27] , (java.util.Date)dynConstraints[28] , (java.util.Date)dynConstraints[29] , ((Number) dynConstraints[30]).shortValue() , ((Number) dynConstraints[31]).shortValue() , (String)dynConstraints[32] , (String)dynConstraints[33] , (String)dynConstraints[34] , (String)dynConstraints[35] , ((Number) dynConstraints[36]).intValue() , ((Number) dynConstraints[37]).intValue() , ((Number) dynConstraints[38]).intValue() , ((Number) dynConstraints[39]).intValue() , ((Number) dynConstraints[40]).intValue() , ((Number) dynConstraints[41]).intValue() , (String)dynConstraints[42] , (String)dynConstraints[43] , ((Number) dynConstraints[44]).intValue() , (String)dynConstraints[45] , (String)dynConstraints[46] , (String)dynConstraints[47] , (String)dynConstraints[48] , (java.util.Date)dynConstraints[49] , (java.util.Date)dynConstraints[50] , (java.util.Date)dynConstraints[51] , ((Number) dynConstraints[52]).shortValue() , (String)dynConstraints[53] , (String)dynConstraints[54] , ((Number) dynConstraints[55]).intValue() , (String)dynConstraints[56] , (String)dynConstraints[57] , ((Number) dynConstraints[58]).intValue() , ((Number) dynConstraints[59]).intValue() , ((Number) dynConstraints[60]).intValue() );
            case 3 :
                  return conditional_P002X9(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).intValue() , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , (String)dynConstraints[19] , (String)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , (java.util.Date)dynConstraints[24] , (java.util.Date)dynConstraints[25] , (java.util.Date)dynConstraints[26] , (java.util.Date)dynConstraints[27] , (java.util.Date)dynConstraints[28] , (java.util.Date)dynConstraints[29] , ((Number) dynConstraints[30]).shortValue() , ((Number) dynConstraints[31]).shortValue() , (String)dynConstraints[32] , (String)dynConstraints[33] , (String)dynConstraints[34] , (String)dynConstraints[35] , ((Number) dynConstraints[36]).intValue() , ((Number) dynConstraints[37]).intValue() , ((Number) dynConstraints[38]).intValue() , ((Number) dynConstraints[39]).intValue() , ((Number) dynConstraints[40]).intValue() , ((Number) dynConstraints[41]).intValue() , (String)dynConstraints[42] , (String)dynConstraints[43] , ((Number) dynConstraints[44]).intValue() , (String)dynConstraints[45] , (String)dynConstraints[46] , (String)dynConstraints[47] , (String)dynConstraints[48] , (java.util.Date)dynConstraints[49] , (java.util.Date)dynConstraints[50] , (java.util.Date)dynConstraints[51] , ((Number) dynConstraints[52]).shortValue() , (String)dynConstraints[53] , (String)dynConstraints[54] , ((Number) dynConstraints[55]).intValue() , (String)dynConstraints[56] , (String)dynConstraints[57] , ((Number) dynConstraints[58]).intValue() , ((Number) dynConstraints[59]).intValue() , ((Number) dynConstraints[60]).intValue() );
            case 4 :
                  return conditional_P002X11(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).intValue() , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , (String)dynConstraints[19] , (String)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , (java.util.Date)dynConstraints[24] , (java.util.Date)dynConstraints[25] , (java.util.Date)dynConstraints[26] , (java.util.Date)dynConstraints[27] , (java.util.Date)dynConstraints[28] , (java.util.Date)dynConstraints[29] , ((Number) dynConstraints[30]).shortValue() , ((Number) dynConstraints[31]).shortValue() , (String)dynConstraints[32] , (String)dynConstraints[33] , (String)dynConstraints[34] , (String)dynConstraints[35] , ((Number) dynConstraints[36]).intValue() , ((Number) dynConstraints[37]).intValue() , ((Number) dynConstraints[38]).intValue() , ((Number) dynConstraints[39]).intValue() , ((Number) dynConstraints[40]).intValue() , ((Number) dynConstraints[41]).intValue() , (String)dynConstraints[42] , (String)dynConstraints[43] , ((Number) dynConstraints[44]).intValue() , (String)dynConstraints[45] , (String)dynConstraints[46] , (String)dynConstraints[47] , (String)dynConstraints[48] , (java.util.Date)dynConstraints[49] , (java.util.Date)dynConstraints[50] , (java.util.Date)dynConstraints[51] , ((Number) dynConstraints[52]).shortValue() , (String)dynConstraints[53] , (String)dynConstraints[54] , ((Number) dynConstraints[55]).intValue() , (String)dynConstraints[56] , (String)dynConstraints[57] , ((Number) dynConstraints[58]).intValue() , ((Number) dynConstraints[59]).intValue() , ((Number) dynConstraints[60]).intValue() );
            case 5 :
                  return conditional_P002X13(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).intValue() , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , (String)dynConstraints[19] , (String)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , (java.util.Date)dynConstraints[24] , (java.util.Date)dynConstraints[25] , (java.util.Date)dynConstraints[26] , (java.util.Date)dynConstraints[27] , (java.util.Date)dynConstraints[28] , (java.util.Date)dynConstraints[29] , ((Number) dynConstraints[30]).shortValue() , ((Number) dynConstraints[31]).shortValue() , (String)dynConstraints[32] , (String)dynConstraints[33] , (String)dynConstraints[34] , (String)dynConstraints[35] , ((Number) dynConstraints[36]).intValue() , ((Number) dynConstraints[37]).intValue() , ((Number) dynConstraints[38]).intValue() , ((Number) dynConstraints[39]).intValue() , ((Number) dynConstraints[40]).intValue() , ((Number) dynConstraints[41]).intValue() , (String)dynConstraints[42] , (String)dynConstraints[43] , ((Number) dynConstraints[44]).intValue() , (String)dynConstraints[45] , (String)dynConstraints[46] , (String)dynConstraints[47] , (String)dynConstraints[48] , (java.util.Date)dynConstraints[49] , (java.util.Date)dynConstraints[50] , (java.util.Date)dynConstraints[51] , ((Number) dynConstraints[52]).shortValue() , (String)dynConstraints[53] , (String)dynConstraints[54] , ((Number) dynConstraints[55]).intValue() , (String)dynConstraints[56] , (String)dynConstraints[57] , ((Number) dynConstraints[58]).intValue() , ((Number) dynConstraints[59]).intValue() , ((Number) dynConstraints[60]).intValue() );
            case 6 :
                  return conditional_P002X15(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).intValue() , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , (String)dynConstraints[19] , (String)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , (java.util.Date)dynConstraints[24] , (java.util.Date)dynConstraints[25] , (java.util.Date)dynConstraints[26] , (java.util.Date)dynConstraints[27] , (java.util.Date)dynConstraints[28] , (java.util.Date)dynConstraints[29] , ((Number) dynConstraints[30]).shortValue() , ((Number) dynConstraints[31]).shortValue() , (String)dynConstraints[32] , (String)dynConstraints[33] , (String)dynConstraints[34] , (String)dynConstraints[35] , ((Number) dynConstraints[36]).intValue() , ((Number) dynConstraints[37]).intValue() , ((Number) dynConstraints[38]).intValue() , ((Number) dynConstraints[39]).intValue() , ((Number) dynConstraints[40]).intValue() , ((Number) dynConstraints[41]).intValue() , (String)dynConstraints[42] , (String)dynConstraints[43] , ((Number) dynConstraints[44]).intValue() , (String)dynConstraints[45] , (String)dynConstraints[46] , (String)dynConstraints[47] , (String)dynConstraints[48] , (java.util.Date)dynConstraints[49] , (java.util.Date)dynConstraints[50] , (java.util.Date)dynConstraints[51] , ((Number) dynConstraints[52]).shortValue() , (String)dynConstraints[53] , (String)dynConstraints[54] , ((Number) dynConstraints[55]).intValue() , (String)dynConstraints[56] , (String)dynConstraints[57] , ((Number) dynConstraints[58]).intValue() , ((Number) dynConstraints[59]).intValue() , ((Number) dynConstraints[60]).intValue() );
            case 7 :
                  return conditional_P002X17(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).intValue() , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , (String)dynConstraints[19] , (String)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , (java.util.Date)dynConstraints[24] , (java.util.Date)dynConstraints[25] , (java.util.Date)dynConstraints[26] , (java.util.Date)dynConstraints[27] , (java.util.Date)dynConstraints[28] , (java.util.Date)dynConstraints[29] , ((Number) dynConstraints[30]).shortValue() , ((Number) dynConstraints[31]).shortValue() , (String)dynConstraints[32] , (String)dynConstraints[33] , (String)dynConstraints[34] , (String)dynConstraints[35] , ((Number) dynConstraints[36]).intValue() , ((Number) dynConstraints[37]).intValue() , ((Number) dynConstraints[38]).intValue() , ((Number) dynConstraints[39]).intValue() , ((Number) dynConstraints[40]).intValue() , ((Number) dynConstraints[41]).intValue() , (String)dynConstraints[42] , (String)dynConstraints[43] , ((Number) dynConstraints[44]).intValue() , (String)dynConstraints[45] , (String)dynConstraints[46] , (String)dynConstraints[47] , (String)dynConstraints[48] , (java.util.Date)dynConstraints[49] , (java.util.Date)dynConstraints[50] , (java.util.Date)dynConstraints[51] , ((Number) dynConstraints[52]).shortValue() , (String)dynConstraints[53] , (String)dynConstraints[54] , ((Number) dynConstraints[55]).intValue() , (String)dynConstraints[56] , (String)dynConstraints[57] , ((Number) dynConstraints[58]).intValue() , ((Number) dynConstraints[59]).intValue() , ((Number) dynConstraints[60]).intValue() );
            case 8 :
                  return conditional_P002X19(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).intValue() , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , (String)dynConstraints[19] , (String)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , (java.util.Date)dynConstraints[24] , (java.util.Date)dynConstraints[25] , (java.util.Date)dynConstraints[26] , (java.util.Date)dynConstraints[27] , (java.util.Date)dynConstraints[28] , (java.util.Date)dynConstraints[29] , ((Number) dynConstraints[30]).shortValue() , ((Number) dynConstraints[31]).shortValue() , (String)dynConstraints[32] , (String)dynConstraints[33] , (String)dynConstraints[34] , (String)dynConstraints[35] , ((Number) dynConstraints[36]).intValue() , ((Number) dynConstraints[37]).intValue() , ((Number) dynConstraints[38]).intValue() , ((Number) dynConstraints[39]).intValue() , ((Number) dynConstraints[40]).intValue() , ((Number) dynConstraints[41]).intValue() , (String)dynConstraints[42] , (String)dynConstraints[43] , ((Number) dynConstraints[44]).intValue() , (String)dynConstraints[45] , (String)dynConstraints[46] , (String)dynConstraints[47] , (String)dynConstraints[48] , (java.util.Date)dynConstraints[49] , (java.util.Date)dynConstraints[50] , (java.util.Date)dynConstraints[51] , ((Number) dynConstraints[52]).shortValue() , (String)dynConstraints[53] , (String)dynConstraints[54] , ((Number) dynConstraints[55]).intValue() , (String)dynConstraints[56] , (String)dynConstraints[57] , ((Number) dynConstraints[58]).intValue() , ((Number) dynConstraints[59]).intValue() , ((Number) dynConstraints[60]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P002X3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P002X5", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P002X7", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P002X9", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P002X11", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P002X13", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P002X15", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P002X17", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P002X19", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((java.util.Date[]) buf[3])[0] = GXutil.resetDate(rslt.getGXDateTime(4));
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[5])[0] = GXutil.resetDate(rslt.getGXDateTime(5));
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDate(6);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((int[]) buf[9])[0] = rslt.getInt(7);
               ((int[]) buf[10])[0] = rslt.getInt(8);
               ((String[]) buf[11])[0] = rslt.getString(9, 1);
               ((String[]) buf[12])[0] = rslt.getVarchar(10);
               ((String[]) buf[13])[0] = rslt.getString(11, 1);
               ((String[]) buf[14])[0] = rslt.getVarchar(12);
               ((String[]) buf[15])[0] = rslt.getVarchar(13);
               ((String[]) buf[16])[0] = rslt.getVarchar(14);
               ((String[]) buf[17])[0] = rslt.getVarchar(15);
               ((String[]) buf[18])[0] = rslt.getVarchar(16);
               ((int[]) buf[19])[0] = rslt.getInt(17);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((String[]) buf[21])[0] = rslt.getVarchar(18);
               ((String[]) buf[22])[0] = rslt.getVarchar(19);
               ((String[]) buf[23])[0] = rslt.getVarchar(20);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((java.util.Date[]) buf[3])[0] = GXutil.resetDate(rslt.getGXDateTime(4));
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[5])[0] = GXutil.resetDate(rslt.getGXDateTime(5));
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDate(6);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((int[]) buf[9])[0] = rslt.getInt(7);
               ((int[]) buf[10])[0] = rslt.getInt(8);
               ((String[]) buf[11])[0] = rslt.getString(9, 1);
               ((String[]) buf[12])[0] = rslt.getVarchar(10);
               ((String[]) buf[13])[0] = rslt.getString(11, 1);
               ((String[]) buf[14])[0] = rslt.getVarchar(12);
               ((String[]) buf[15])[0] = rslt.getVarchar(13);
               ((String[]) buf[16])[0] = rslt.getVarchar(14);
               ((String[]) buf[17])[0] = rslt.getVarchar(15);
               ((String[]) buf[18])[0] = rslt.getString(16, 20);
               ((int[]) buf[19])[0] = rslt.getInt(17);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((String[]) buf[21])[0] = rslt.getVarchar(18);
               ((String[]) buf[22])[0] = rslt.getVarchar(19);
               ((String[]) buf[23])[0] = rslt.getVarchar(20);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.util.Date[]) buf[2])[0] = GXutil.resetDate(rslt.getGXDateTime(3));
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[4])[0] = GXutil.resetDate(rslt.getGXDateTime(4));
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(5);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((int[]) buf[8])[0] = rslt.getInt(6);
               ((int[]) buf[9])[0] = rslt.getInt(7);
               ((String[]) buf[10])[0] = rslt.getString(8, 1);
               ((String[]) buf[11])[0] = rslt.getVarchar(9);
               ((String[]) buf[12])[0] = rslt.getString(10, 1);
               ((String[]) buf[13])[0] = rslt.getVarchar(11);
               ((String[]) buf[14])[0] = rslt.getVarchar(12);
               ((String[]) buf[15])[0] = rslt.getVarchar(13);
               ((String[]) buf[16])[0] = rslt.getVarchar(14);
               ((String[]) buf[17])[0] = rslt.getVarchar(15);
               ((String[]) buf[18])[0] = rslt.getString(16, 20);
               ((int[]) buf[19])[0] = rslt.getInt(17);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((String[]) buf[21])[0] = rslt.getVarchar(18);
               ((String[]) buf[22])[0] = rslt.getVarchar(19);
               ((String[]) buf[23])[0] = rslt.getVarchar(20);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.util.Date[]) buf[2])[0] = GXutil.resetDate(rslt.getGXDateTime(3));
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[4])[0] = GXutil.resetDate(rslt.getGXDateTime(4));
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(5);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((int[]) buf[8])[0] = rslt.getInt(6);
               ((int[]) buf[9])[0] = rslt.getInt(7);
               ((String[]) buf[10])[0] = rslt.getString(8, 1);
               ((String[]) buf[11])[0] = rslt.getVarchar(9);
               ((String[]) buf[12])[0] = rslt.getString(10, 1);
               ((String[]) buf[13])[0] = rslt.getVarchar(11);
               ((String[]) buf[14])[0] = rslt.getVarchar(12);
               ((String[]) buf[15])[0] = rslt.getVarchar(13);
               ((String[]) buf[16])[0] = rslt.getVarchar(14);
               ((String[]) buf[17])[0] = rslt.getVarchar(15);
               ((String[]) buf[18])[0] = rslt.getString(16, 20);
               ((int[]) buf[19])[0] = rslt.getInt(17);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((String[]) buf[21])[0] = rslt.getVarchar(18);
               ((String[]) buf[22])[0] = rslt.getVarchar(19);
               ((String[]) buf[23])[0] = rslt.getVarchar(20);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.util.Date[]) buf[2])[0] = GXutil.resetDate(rslt.getGXDateTime(3));
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[4])[0] = GXutil.resetDate(rslt.getGXDateTime(4));
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(5);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((int[]) buf[8])[0] = rslt.getInt(6);
               ((int[]) buf[9])[0] = rslt.getInt(7);
               ((String[]) buf[10])[0] = rslt.getString(8, 1);
               ((String[]) buf[11])[0] = rslt.getVarchar(9);
               ((String[]) buf[12])[0] = rslt.getString(10, 1);
               ((String[]) buf[13])[0] = rslt.getVarchar(11);
               ((String[]) buf[14])[0] = rslt.getVarchar(12);
               ((String[]) buf[15])[0] = rslt.getVarchar(13);
               ((String[]) buf[16])[0] = rslt.getVarchar(14);
               ((String[]) buf[17])[0] = rslt.getVarchar(15);
               ((String[]) buf[18])[0] = rslt.getString(16, 20);
               ((int[]) buf[19])[0] = rslt.getInt(17);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((String[]) buf[21])[0] = rslt.getVarchar(18);
               ((String[]) buf[22])[0] = rslt.getVarchar(19);
               ((String[]) buf[23])[0] = rslt.getVarchar(20);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.util.Date[]) buf[2])[0] = GXutil.resetDate(rslt.getGXDateTime(3));
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[4])[0] = GXutil.resetDate(rslt.getGXDateTime(4));
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(5);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((int[]) buf[8])[0] = rslt.getInt(6);
               ((int[]) buf[9])[0] = rslt.getInt(7);
               ((String[]) buf[10])[0] = rslt.getString(8, 1);
               ((String[]) buf[11])[0] = rslt.getVarchar(9);
               ((String[]) buf[12])[0] = rslt.getString(10, 1);
               ((String[]) buf[13])[0] = rslt.getVarchar(11);
               ((String[]) buf[14])[0] = rslt.getVarchar(12);
               ((String[]) buf[15])[0] = rslt.getVarchar(13);
               ((String[]) buf[16])[0] = rslt.getVarchar(14);
               ((String[]) buf[17])[0] = rslt.getVarchar(15);
               ((String[]) buf[18])[0] = rslt.getString(16, 20);
               ((int[]) buf[19])[0] = rslt.getInt(17);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((String[]) buf[21])[0] = rslt.getVarchar(18);
               ((String[]) buf[22])[0] = rslt.getVarchar(19);
               ((String[]) buf[23])[0] = rslt.getVarchar(20);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((java.util.Date[]) buf[3])[0] = GXutil.resetDate(rslt.getGXDateTime(4));
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[5])[0] = GXutil.resetDate(rslt.getGXDateTime(5));
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDate(6);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((int[]) buf[9])[0] = rslt.getInt(7);
               ((int[]) buf[10])[0] = rslt.getInt(8);
               ((String[]) buf[11])[0] = rslt.getString(9, 1);
               ((String[]) buf[12])[0] = rslt.getVarchar(10);
               ((String[]) buf[13])[0] = rslt.getString(11, 1);
               ((String[]) buf[14])[0] = rslt.getVarchar(12);
               ((String[]) buf[15])[0] = rslt.getVarchar(13);
               ((String[]) buf[16])[0] = rslt.getVarchar(14);
               ((String[]) buf[17])[0] = rslt.getVarchar(15);
               ((String[]) buf[18])[0] = rslt.getString(16, 20);
               ((int[]) buf[19])[0] = rslt.getInt(17);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((String[]) buf[21])[0] = rslt.getVarchar(18);
               ((String[]) buf[22])[0] = rslt.getVarchar(19);
               ((String[]) buf[23])[0] = rslt.getVarchar(20);
               return;
            case 7 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((java.util.Date[]) buf[3])[0] = GXutil.resetDate(rslt.getGXDateTime(4));
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[5])[0] = GXutil.resetDate(rslt.getGXDateTime(5));
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDate(6);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((int[]) buf[9])[0] = rslt.getInt(7);
               ((int[]) buf[10])[0] = rslt.getInt(8);
               ((String[]) buf[11])[0] = rslt.getString(9, 1);
               ((String[]) buf[12])[0] = rslt.getVarchar(10);
               ((String[]) buf[13])[0] = rslt.getString(11, 1);
               ((String[]) buf[14])[0] = rslt.getVarchar(12);
               ((String[]) buf[15])[0] = rslt.getVarchar(13);
               ((String[]) buf[16])[0] = rslt.getVarchar(14);
               ((String[]) buf[17])[0] = rslt.getVarchar(15);
               ((String[]) buf[18])[0] = rslt.getString(16, 20);
               ((int[]) buf[19])[0] = rslt.getInt(17);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((String[]) buf[21])[0] = rslt.getVarchar(18);
               ((String[]) buf[22])[0] = rslt.getVarchar(19);
               ((String[]) buf[23])[0] = rslt.getVarchar(20);
               return;
            case 8 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((java.util.Date[]) buf[3])[0] = GXutil.resetDate(rslt.getGXDateTime(4));
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[5])[0] = GXutil.resetDate(rslt.getGXDateTime(5));
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDate(6);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((int[]) buf[9])[0] = rslt.getInt(7);
               ((int[]) buf[10])[0] = rslt.getInt(8);
               ((String[]) buf[11])[0] = rslt.getString(9, 1);
               ((String[]) buf[12])[0] = rslt.getVarchar(10);
               ((String[]) buf[13])[0] = rslt.getString(11, 1);
               ((String[]) buf[14])[0] = rslt.getVarchar(12);
               ((String[]) buf[15])[0] = rslt.getVarchar(13);
               ((String[]) buf[16])[0] = rslt.getVarchar(14);
               ((String[]) buf[17])[0] = rslt.getVarchar(15);
               ((String[]) buf[18])[0] = rslt.getString(16, 20);
               ((int[]) buf[19])[0] = rslt.getInt(17);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((String[]) buf[21])[0] = rslt.getVarchar(18);
               ((String[]) buf[22])[0] = rslt.getVarchar(19);
               ((String[]) buf[23])[0] = rslt.getVarchar(20);
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
                  stmt.setVarchar(sIdx, (String)parms[59], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[62], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[63], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[64], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[65], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[68], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[69], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[73], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[74], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[75], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[76], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[77], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[80], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 100);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[82]).intValue());
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[83]).intValue());
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[84]).intValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[85]).intValue());
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[86]).intValue());
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[87]).intValue());
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[88], 20);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[89], 20);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[90], 100);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[91], 100);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[92]).intValue());
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[93]).intValue());
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[94], 50);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[95], 50);
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[96], 50);
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[97], 50);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[98], 50);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[99], 50);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[100], 100);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[101], 100);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[102], 40);
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[103], 40);
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[104]);
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[105]);
               }
               if ( ((Number) parms[47]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[106], true);
               }
               if ( ((Number) parms[48]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[107], true);
               }
               if ( ((Number) parms[49]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[108], true);
               }
               if ( ((Number) parms[50]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[109], true);
               }
               if ( ((Number) parms[51]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[110]).shortValue());
               }
               if ( ((Number) parms[52]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[111]).shortValue());
               }
               if ( ((Number) parms[53]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[112], 4);
               }
               if ( ((Number) parms[54]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[113], 4);
               }
               if ( ((Number) parms[55]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[114], 40);
               }
               if ( ((Number) parms[56]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[115], 40);
               }
               if ( ((Number) parms[57]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[116]).intValue());
               }
               if ( ((Number) parms[58]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[117]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[59], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[62], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[63], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[64], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[65], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[68], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[69], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[73], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[74], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[75], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[76], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[77], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[80], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 100);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[82]).intValue());
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[83]).intValue());
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[84]).intValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[85]).intValue());
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[86]).intValue());
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[87]).intValue());
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[88], 20);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[89], 20);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[90], 100);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[91], 100);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[92]).intValue());
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[93]).intValue());
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[94], 50);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[95], 50);
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[96], 50);
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[97], 50);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[98], 50);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[99], 50);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[100], 100);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[101], 100);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[102], 40);
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[103], 40);
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[104]);
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[105]);
               }
               if ( ((Number) parms[47]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[106], true);
               }
               if ( ((Number) parms[48]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[107], true);
               }
               if ( ((Number) parms[49]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[108], true);
               }
               if ( ((Number) parms[50]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[109], true);
               }
               if ( ((Number) parms[51]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[110]).shortValue());
               }
               if ( ((Number) parms[52]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[111]).shortValue());
               }
               if ( ((Number) parms[53]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[112], 4);
               }
               if ( ((Number) parms[54]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[113], 4);
               }
               if ( ((Number) parms[55]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[114], 40);
               }
               if ( ((Number) parms[56]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[115], 40);
               }
               if ( ((Number) parms[57]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[116]).intValue());
               }
               if ( ((Number) parms[58]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[117]).intValue());
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[59], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[62], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[63], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[64], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[65], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[68], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[69], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[73], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[74], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[75], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[76], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[77], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[80], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 100);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[82]).intValue());
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[83]).intValue());
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[84]).intValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[85]).intValue());
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[86]).intValue());
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[87]).intValue());
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[88], 20);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[89], 20);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[90], 100);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[91], 100);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[92]).intValue());
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[93]).intValue());
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[94], 50);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[95], 50);
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[96], 50);
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[97], 50);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[98], 50);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[99], 50);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[100], 100);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[101], 100);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[102], 40);
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[103], 40);
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[104]);
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[105]);
               }
               if ( ((Number) parms[47]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[106], true);
               }
               if ( ((Number) parms[48]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[107], true);
               }
               if ( ((Number) parms[49]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[108], true);
               }
               if ( ((Number) parms[50]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[109], true);
               }
               if ( ((Number) parms[51]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[110]).shortValue());
               }
               if ( ((Number) parms[52]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[111]).shortValue());
               }
               if ( ((Number) parms[53]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[112], 4);
               }
               if ( ((Number) parms[54]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[113], 4);
               }
               if ( ((Number) parms[55]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[114], 40);
               }
               if ( ((Number) parms[56]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[115], 40);
               }
               if ( ((Number) parms[57]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[116]).intValue());
               }
               if ( ((Number) parms[58]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[117]).intValue());
               }
               return;
            case 3 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[59], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[62], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[63], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[64], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[65], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[68], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[69], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[73], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[74], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[75], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[76], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[77], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[80], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 100);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[82]).intValue());
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[83]).intValue());
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[84]).intValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[85]).intValue());
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[86]).intValue());
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[87]).intValue());
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[88], 20);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[89], 20);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[90], 100);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[91], 100);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[92]).intValue());
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[93]).intValue());
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[94], 50);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[95], 50);
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[96], 50);
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[97], 50);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[98], 50);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[99], 50);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[100], 100);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[101], 100);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[102], 40);
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[103], 40);
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[104]);
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[105]);
               }
               if ( ((Number) parms[47]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[106], true);
               }
               if ( ((Number) parms[48]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[107], true);
               }
               if ( ((Number) parms[49]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[108], true);
               }
               if ( ((Number) parms[50]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[109], true);
               }
               if ( ((Number) parms[51]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[110]).shortValue());
               }
               if ( ((Number) parms[52]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[111]).shortValue());
               }
               if ( ((Number) parms[53]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[112], 4);
               }
               if ( ((Number) parms[54]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[113], 4);
               }
               if ( ((Number) parms[55]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[114], 40);
               }
               if ( ((Number) parms[56]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[115], 40);
               }
               if ( ((Number) parms[57]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[116]).intValue());
               }
               if ( ((Number) parms[58]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[117]).intValue());
               }
               return;
            case 4 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[59], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[62], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[63], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[64], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[65], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[68], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[69], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[73], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[74], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[75], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[76], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[77], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[80], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 100);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[82]).intValue());
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[83]).intValue());
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[84]).intValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[85]).intValue());
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[86]).intValue());
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[87]).intValue());
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[88], 20);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[89], 20);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[90], 100);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[91], 100);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[92]).intValue());
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[93]).intValue());
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[94], 50);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[95], 50);
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[96], 50);
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[97], 50);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[98], 50);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[99], 50);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[100], 100);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[101], 100);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[102], 40);
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[103], 40);
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[104]);
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[105]);
               }
               if ( ((Number) parms[47]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[106], true);
               }
               if ( ((Number) parms[48]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[107], true);
               }
               if ( ((Number) parms[49]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[108], true);
               }
               if ( ((Number) parms[50]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[109], true);
               }
               if ( ((Number) parms[51]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[110]).shortValue());
               }
               if ( ((Number) parms[52]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[111]).shortValue());
               }
               if ( ((Number) parms[53]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[112], 4);
               }
               if ( ((Number) parms[54]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[113], 4);
               }
               if ( ((Number) parms[55]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[114], 40);
               }
               if ( ((Number) parms[56]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[115], 40);
               }
               if ( ((Number) parms[57]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[116]).intValue());
               }
               if ( ((Number) parms[58]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[117]).intValue());
               }
               return;
            case 5 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[59], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[62], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[63], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[64], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[65], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[68], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[69], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[73], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[74], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[75], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[76], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[77], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[80], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 100);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[82]).intValue());
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[83]).intValue());
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[84]).intValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[85]).intValue());
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[86]).intValue());
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[87]).intValue());
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[88], 20);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[89], 20);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[90], 100);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[91], 100);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[92]).intValue());
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[93]).intValue());
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[94], 50);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[95], 50);
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[96], 50);
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[97], 50);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[98], 50);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[99], 50);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[100], 100);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[101], 100);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[102], 40);
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[103], 40);
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[104]);
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[105]);
               }
               if ( ((Number) parms[47]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[106], true);
               }
               if ( ((Number) parms[48]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[107], true);
               }
               if ( ((Number) parms[49]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[108], true);
               }
               if ( ((Number) parms[50]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[109], true);
               }
               if ( ((Number) parms[51]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[110]).shortValue());
               }
               if ( ((Number) parms[52]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[111]).shortValue());
               }
               if ( ((Number) parms[53]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[112], 4);
               }
               if ( ((Number) parms[54]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[113], 4);
               }
               if ( ((Number) parms[55]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[114], 40);
               }
               if ( ((Number) parms[56]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[115], 40);
               }
               if ( ((Number) parms[57]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[116]).intValue());
               }
               if ( ((Number) parms[58]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[117]).intValue());
               }
               return;
            case 6 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[59], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[62], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[63], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[64], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[65], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[68], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[69], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[73], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[74], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[75], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[76], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[77], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[80], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 100);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[82]).intValue());
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[83]).intValue());
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[84]).intValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[85]).intValue());
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[86]).intValue());
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[87]).intValue());
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[88], 20);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[89], 20);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[90], 100);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[91], 100);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[92]).intValue());
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[93]).intValue());
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[94], 50);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[95], 50);
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[96], 50);
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[97], 50);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[98], 50);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[99], 50);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[100], 100);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[101], 100);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[102], 40);
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[103], 40);
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[104]);
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[105]);
               }
               if ( ((Number) parms[47]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[106], true);
               }
               if ( ((Number) parms[48]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[107], true);
               }
               if ( ((Number) parms[49]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[108], true);
               }
               if ( ((Number) parms[50]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[109], true);
               }
               if ( ((Number) parms[51]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[110]).shortValue());
               }
               if ( ((Number) parms[52]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[111]).shortValue());
               }
               if ( ((Number) parms[53]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[112], 4);
               }
               if ( ((Number) parms[54]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[113], 4);
               }
               if ( ((Number) parms[55]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[114], 40);
               }
               if ( ((Number) parms[56]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[115], 40);
               }
               if ( ((Number) parms[57]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[116]).intValue());
               }
               if ( ((Number) parms[58]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[117]).intValue());
               }
               return;
            case 7 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[59], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[62], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[63], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[64], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[65], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[68], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[69], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[73], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[74], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[75], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[76], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[77], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[80], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 100);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[82]).intValue());
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[83]).intValue());
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[84]).intValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[85]).intValue());
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[86]).intValue());
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[87]).intValue());
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[88], 20);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[89], 20);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[90], 100);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[91], 100);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[92]).intValue());
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[93]).intValue());
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[94], 50);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[95], 50);
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[96], 50);
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[97], 50);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[98], 50);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[99], 50);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[100], 100);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[101], 100);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[102], 40);
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[103], 40);
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[104]);
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[105]);
               }
               if ( ((Number) parms[47]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[106], true);
               }
               if ( ((Number) parms[48]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[107], true);
               }
               if ( ((Number) parms[49]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[108], true);
               }
               if ( ((Number) parms[50]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[109], true);
               }
               if ( ((Number) parms[51]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[110]).shortValue());
               }
               if ( ((Number) parms[52]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[111]).shortValue());
               }
               if ( ((Number) parms[53]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[112], 4);
               }
               if ( ((Number) parms[54]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[113], 4);
               }
               if ( ((Number) parms[55]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[114], 40);
               }
               if ( ((Number) parms[56]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[115], 40);
               }
               if ( ((Number) parms[57]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[116]).intValue());
               }
               if ( ((Number) parms[58]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[117]).intValue());
               }
               return;
            case 8 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[59], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[62], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[63], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[64], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[65], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[68], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[69], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[73], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[74], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[75], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[76], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[77], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[80], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 100);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[82]).intValue());
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[83]).intValue());
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[84]).intValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[85]).intValue());
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[86]).intValue());
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[87]).intValue());
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[88], 20);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[89], 20);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[90], 100);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[91], 100);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[92]).intValue());
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[93]).intValue());
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[94], 50);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[95], 50);
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[96], 50);
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[97], 50);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[98], 50);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[99], 50);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[100], 100);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[101], 100);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[102], 40);
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[103], 40);
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[104]);
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[105]);
               }
               if ( ((Number) parms[47]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[106], true);
               }
               if ( ((Number) parms[48]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[107], true);
               }
               if ( ((Number) parms[49]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[108], true);
               }
               if ( ((Number) parms[50]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[109], true);
               }
               if ( ((Number) parms[51]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[110]).shortValue());
               }
               if ( ((Number) parms[52]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[111]).shortValue());
               }
               if ( ((Number) parms[53]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[112], 4);
               }
               if ( ((Number) parms[54]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[113], 4);
               }
               if ( ((Number) parms[55]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[114], 40);
               }
               if ( ((Number) parms[56]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[115], 40);
               }
               if ( ((Number) parms[57]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[116]).intValue());
               }
               if ( ((Number) parms[58]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[117]).intValue());
               }
               return;
      }
   }

}

