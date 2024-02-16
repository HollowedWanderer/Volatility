advancement revoke @s only volatility:has_book/inventory26

data modify storage volatility:item StoredEnchantments set from entity @s Inventory[{Slot:35b}].tag.StoredEnchantments

function volatility:replace_book/common

execute unless score enchantCount volatility matches 0 run item modify entity @s inventory.26 volatility:remove_from_book
execute if score enchantCount volatility matches 0 run item replace entity @s inventory.26 with minecraft:book