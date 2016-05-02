function listenForBasketChanges() {
    $(document).on('click','.product',function(){
        refreshBasket();
    });

}

function refreshBasket() {
    $("#basket").empty();
    $("#submitButton").prop('disabled', true);
    $.each( $(".product"), function( product ) {
        if( $(this).is(':checked') )
        {
            var name = $(this).parent().text().trim();
            $("#basket").append( basketItem( name ) );
            $("#submitButton").prop('disabled', false);
        }
    });
}


function basketItem( product ) {
    return "<li class='list-group-item' id='product-" + product + "' >"
                + "<input type='hidden' name='products' value='"
                + product + "'/>" + product + "</li>";
}