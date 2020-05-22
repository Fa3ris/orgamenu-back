package fr.simplon.orgamenu.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "l'etape n'existe pas")
public class EtapeNotFoundExceptions extends Exception {
}
