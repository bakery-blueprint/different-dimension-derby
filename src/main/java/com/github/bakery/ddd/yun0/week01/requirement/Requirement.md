- 주재료 준비 / 반죽 / 숙성 3단계
- 주재료 종류는 밀 가루, 아몬드 가루, 메밀 가루, 쌀 가루
- 주재료 블랜딩은 2개까지 허용한다. (비율 정의)
- 반죽물의 온도는 40도 이하
- 반죽의 시간은 최대 15분이다. 주재료 설정값은 다르다.

## Inventory
- Set\<Flour>
- Water

## FlourType
- WheatFlour
- AlmondFlour
- BuckwheatFlour
- RiceFlour

## Flour
- FlourType
- grams

## Water
- milliliters

## ProcessType
1. Preparing
2. Kneading
3. Ripening
4. Baking

## Recipe\<Bread>
- Ingredients prepare(Inventory)
- Dough knead(Ingredients)
- RipenedDough ripen(Dough)
- Bread bake(RipenedDough)
- Bread bakeBread(Inventory)

### Ingredients
- Set\<Flour> : max size 2
- Water

### PreparingCondition
- FlourAmounts
- WaterAmount

### KneadingCondition
- temperature : max 40
- time : max 15

## Process\<T, R>
- R process(T)

## PreparingProcess
- Inventory
- PreparingCondition
- Ingredients process()
    
## KneadingProcess
- Ingredients
- KneadingCondition
- Dough process()

## RipeningProcess
- RipenedDough process()
