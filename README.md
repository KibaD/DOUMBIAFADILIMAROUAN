# DOUMBIA_FADILI_MAROUAN_Framework

Ce framework est un système simple pour gérer les messages d'erreur. La simplicité de ce framework réside dans le fait qui'il faille qu'un unique nom de classe pour appeller le logger.

Un même message peut avoir plusieurs cibles nous avons dans ce Framework qu'une seule possibilité l'affichage dans le terminal, 
nous avons essayé l'affichage dans les fichiers en vain. Mais ce modèle respecte l'Open close principle.

Notre framework de logging se base sur trois élèments:

-Un logger pour émettre un message
-Un formateur pour personnaliser le contenu
-Et une seule cible pour stocker les messages

Rentrons dans l'aspect pratique:

		logger.setLevel(logLevel.Level); => Permet de définir le niveau de notre logger
		logger.setFormateur(new formateur(""); => Permet a l'utilisateur de formater le message


La difficulté dans ce projet pour mon groupe a été le respect de l'OCP qui s'est fait au
détriment de nombreuses fonctionnalitées.

