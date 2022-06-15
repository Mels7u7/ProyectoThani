package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getwwptitlesettingsicons extends GXProcedure
{
   public getwwptitlesettingsicons( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getwwptitlesettingsicons.class ), "" );
   }

   public getwwptitlesettingsicons( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons executeUdp( )
   {
      getwwptitlesettingsicons.this.aP0 = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[] {new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[] aP0 )
   {
      getwwptitlesettingsicons.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8TitleSettingsIcons.setgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Default_fi( "fas fa-caret-down CSTitleIcon" );
      AV8TitleSettingsIcons.setgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Filtered_fi( "fas fa-filter CSTitleIcon" );
      AV8TitleSettingsIcons.setgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Sortedasc_fi( "fas fa-long-arrow-alt-up CSTitleIcon" );
      AV8TitleSettingsIcons.setgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Sorteddsc_fi( "fas fa-long-arrow-alt-down CSTitleIcon" );
      AV8TitleSettingsIcons.setgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Filteredsortedasc_fi( "fas fa-long-arrow-alt-up CSTitleIconDanger" );
      AV8TitleSettingsIcons.setgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Filteredsorteddsc_fi( "fas fa-long-arrow-alt-down CSTitleIconDanger" );
      AV8TitleSettingsIcons.setgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optionsortasc_fi( "fas fa-sort-amount-up CSDropDownIcon" );
      AV8TitleSettingsIcons.setgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optionsortdsc_fi( "fas fa-sort-amount-down CSDropDownIcon" );
      AV8TitleSettingsIcons.setgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optionapplyfilter_fi( "fas fa-search" );
      AV8TitleSettingsIcons.setgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optionfilteringdata_fi( "fa fa-spinner fa-pulse fa-fw CSDropDownIcon" );
      AV8TitleSettingsIcons.setgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optioncleanfilters_fi( "fas fa-times CSDropDownIcon" );
      AV8TitleSettingsIcons.setgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Selectedoption_fi( "fas fa-filter CSDropDownFilter" );
      AV8TitleSettingsIcons.setgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Multiseloption_fi( "far fa-square CSDropDownFilter" );
      AV8TitleSettingsIcons.setgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Multiselseloption_fi( "far fa-check-square CSDropDownFilter" );
      AV8TitleSettingsIcons.setgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Treeviewcollapse_fi( "fas fa-angle-down" );
      AV8TitleSettingsIcons.setgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Treeviewexpand_fi( "fas fa-angle-right" );
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = getwwptitlesettingsicons.this.AV8TitleSettingsIcons;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8TitleSettingsIcons = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[] aP0 ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV8TitleSettingsIcons ;
}

