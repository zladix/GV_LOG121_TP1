import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DecodeurChaine{
	private final String REGEX_FORME ="([^<]*?)<([^>]*?)>";
	private final String REGEX_COORD_TROIS ="[^<]*?[^-]*?-([^-]*?)-([^-]*?)-([^-]*?)-([^<]*?)<";
	private final String REGEX_COORD_QUATRE = "[^<]*?[^-]*?-([^-]*?)-([^-]*?)-([^<]*?)<";
	private final int TAILLE_TAB_MAX = 4;
	
	private int numeroSequence;
	private String typeForme;
	private int[] tabCoord;
	
	DecodeurChaine()
	{
		numeroSequence = 0;
		typeForme = "";
		tabCoord = new int[TAILLE_TAB_MAX];
	}
	
	public int getNumeroSequence()
	{
		return numeroSequence;
	}
	
	public String getTypeForme()
	{
		return typeForme;
	}
	
	public int[] getTableauCoordonnee()
	{
		return tabCoord;
	}
	
	//D�code la chaine recu dans le format NumS�quence<FORME>Coordonn�e</FORME>
	public void DecoderChaine(String sChaine)
	{
		Pattern pRegex = Pattern.compile(REGEX_FORME);
		Matcher correspondance = pRegex.matcher(sChaine);
	    if (correspondance.find( ))
	    {
	    	numeroSequence = Integer.parseInt(correspondance.group(0));
	    	typeForme = correspondance.group(1).toUpperCase();
	    	sChaine.replace(" ","-");
	    	switch(typeForme)
	    	{
	    		case "OVALE":
	    			pRegex = Pattern.compile(REGEX_COORD_TROIS);
	    			correspondance = pRegex.matcher(sChaine);
	    			if(correspondance.find())
	    			{
	    				tabCoord[0] = Integer.parseInt(correspondance.group(0));
	    				tabCoord[1] = Integer.parseInt(correspondance.group(1));
	    				tabCoord[2] = Integer.parseInt(correspondance.group(2));
	    			}
	    		break;
	    		default:
	    			pRegex = Pattern.compile(REGEX_COORD_QUATRE);
	    			correspondance = pRegex.matcher(sChaine);
	    			if(correspondance.find())
	    			{
	    				tabCoord[0] = Integer.parseInt(correspondance.group(0));
	    				tabCoord[1] = Integer.parseInt(correspondance.group(1));
	    				tabCoord[2] = Integer.parseInt(correspondance.group(2));
	    				tabCoord[3] = Integer.parseInt(correspondance.group(3));
	    			}
	    		break;
	    	}
	    }
	}
}
