import { Pipe, PipeTransform } from '@angular/core';
import { Product } from './model/Product';

@Pipe({
  name: 'filter'
})
export class FilterPipe implements PipeTransform {

  //This method is used for filter the product data based on input
  transform(product:Product[],searchValue:any): Product[] {
    if(!product ||! searchValue)
    {
    return product
    }
    return product.filter(product=>product.brand.toLowerCase().includes(searchValue.toLowerCase())
    ||product.price.toLowerCase().includes(searchValue.toLowerCase())||
    product.productCode.toLowerCase().includes(searchValue.toLowerCase())  || product.date.toLowerCase().includes(searchValue.toLowerCase())
    || product.userName.toLowerCase().includes(searchValue.toLowerCase())
    );
  }

}
